package com.gzhu.bm.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gzhu.bm.entity.BmMenu;
import com.gzhu.bm.entity.BmRole;
import com.gzhu.bm.security.util.MD5Helper;
import com.gzhu.bm.service.BmMenuService;
import com.gzhu.bm.service.BmRoleService;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.vo.UsersVO;

@Component(value="systemAuthorizingRealm")
public class ShiroDbRealm extends AuthorizingRealm  {
 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	UsersService usersService;
	@Resource
	BmMenuService bmMenuService;
	@Resource
	BmRoleService bmRoleService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
				// (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
				if (!SecurityUtils.getSubject().isAuthenticated()) {
					doClearCache(principals);
					SecurityUtils.getSubject().logout();
					return null;
				}
				SimpleAuthorizationInfo sazi = new SimpleAuthorizationInfo();
				
				try {			
//					sazi.addRoles(null);		
//					sazi.addStringPermissions(null);
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}

				return sazi;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String userName = upToken.getUsername();
		String password = new String(upToken.getPassword());
		UsersVO user = usersService.findByAccount(userName);
		String userMd5=null;
		try {
			if(user==null){
				throw new Exception("获取用户失败");
			}
			userMd5=MD5Helper.MD5(password);
			String dbMd5=user.getUserPassword();
			if(!userMd5.equalsIgnoreCase(dbMd5)){
				throw new Exception("账号或密码错误");
			} 
			List<String> menus = new ArrayList<String>();
			List<String> roles = new ArrayList<String>();
			List<BmMenu> userMenus= bmMenuService.selectByUid(user.getUid());
			List<BmRole> userRoles = bmRoleService.selectByUid(user.getUid());
			for(BmMenu m:userMenus){
				menus.add(m.getUrl());
			}
			for(BmRole r:userRoles){
				roles.add(r.getRoleName());
			}
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw  new AuthenticationException(e.getMessage());
		}

		user.setUserPassword(null);
		AuthenticationInfo authinfo = new SimpleAccount(user, userMd5, getName());
		return authinfo;
	
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
		matcher.setHashIterations(1);
		setCredentialsMatcher(matcher);
	}
}
