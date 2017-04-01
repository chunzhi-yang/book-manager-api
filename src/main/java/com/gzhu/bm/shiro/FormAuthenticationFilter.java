package com.gzhu.bm.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
    public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
    public static final String DEFAULT_MOBILE_PARAM = "mobileLogin";
    public static final String DEFAULT_MESSAGE_PARAM = "message";

    private String captchaParam = DEFAULT_CAPTCHA_PARAM;
    private String mobileLoginParam = DEFAULT_MOBILE_PARAM;
    private String messageParam = DEFAULT_MESSAGE_PARAM;
    

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        
        String username = getUsername(request);
        String password = getPassword(request);boolean rememberMe = isRememberMe(request);

        String host = request.getRemoteAddr(); 
        UsernamePasswordToken token =  new UsernamePasswordToken(username, password.toCharArray(),rememberMe,host);
        return token;
    }

    public String getCaptchaParam() {
        return captchaParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    public String getMobileLoginParam() {
        return mobileLoginParam;
    }
    
    protected boolean isMobileLogin(ServletRequest request) {
        return WebUtils.isTrue(request, getMobileLoginParam());
    }
    
    public String getMessageParam() {
        return messageParam;
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
//        Principal p = UserUtils.getPrincipal();
//        if (p != null && !p.isMobileLogin()){
             WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
//        }else{
//            super.issueSuccessRedirect(request, response);
//        }
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
        request.setAttribute(getMessageParam(), message);
        return true;
    }
    
} 
