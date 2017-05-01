package com.gzhu.bm.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component; 
@Component("formAuthenticationFilter")
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	private final Logger log = LoggerFactory.getLogger(getClass());  

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response,Object mappedValue) throws Exception {
		 
		HttpSession session = ((HttpServletRequest)request).getSession();

         //页面输入的验证码

         String randomcode = request.getParameter("randomcode");
         if(randomcode == null){
        	 return true;
         }
         //从session中取出验证码

         String validateCode = (String) session.getAttribute("validateCode");

         if (!randomcode.equals(validateCode)) {

                // randomCodeError表示验证码错误

                request.setAttribute("shiroLoginFailure", "randomCodeError");

                //拒绝访问，不再校验账号和密码

                return true;

         } 
         return super.onAccessDenied(request, response, mappedValue); 
  
	}	



	@Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        
        String username = getUsername(request);
        String password = getPassword(request);
        boolean rememberMe = isRememberMe(request);
        String host = request.getRemoteAddr(); 
        UsernamePasswordToken token =  new UsernamePasswordToken(username, password.toCharArray(),rememberMe,host);
        return token;
    }

 
 
 
 
    /**
     * 登录成功之后跳转URL
     */
    @Override
    public String getSuccessUrl() {
        return super.getSuccessUrl();
    }
    
    @Override
    protected void issueSuccessRedirect(ServletRequest request,
            ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
    }

    /**
     * 登录失败调用事件
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
            AuthenticationException e, ServletRequest request, ServletResponse response) {
        String className = e.getClass().getName(), message = "";
        if (IncorrectCredentialsException.class.getName().equals(className)
                || UnknownAccountException.class.getName().equals(className)){
            message = "用户名或密码错误！";
        }
        else if (e.getMessage() != null && StringUtils.startsWith(e.getMessage(), "msg:")){
            message = StringUtils.replace(e.getMessage(), "msg:", "");
        }
        else{
            message = "系统异常，请稍后再试！";
            log.error(e.getMessage(), e);
        }
        request.setAttribute(getFailureKeyAttribute(), className); 
        return true;
    }
  
} 
