package com.gzhu.bm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component(value="systemAuthorizingRealm")
public class ShiroDbRealm extends AuthorizingRealm implements InitializingBean {

	private final Logger log = LoggerFactory.getLogger(ShiroDbRealm.class);
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

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
					log.error(e.getMessage(),e);
				}

				return sazi;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		//认证
		return null;
	}

}
