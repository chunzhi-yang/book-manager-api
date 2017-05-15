package com.gzhu.bm.base;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.gzhu.bm.controller.LoginController;
import com.gzhu.bm.security.util.RSAUtil;
import com.gzhu.bm.vo.RSAPublicKeyVo;

public class SelfContextLoaderListener extends ContextLoaderListener {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			// 生成登录密码asr公钥和密钥
			HashMap<String, Object> map = RSAUtil.getKeys();
			//生成公钥和私钥    
			RSAPublicKey publicKey = (RSAPublicKey) map.get("public");    
			RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
			
			ServletContext sct = event.getServletContext();
			
			//公钥信息保存在页面，用于加密  
			String publicKeyExponent = publicKey.getPublicExponent().toString(16); //16进制
			String publicKeyModulus = publicKey.getModulus().toString(16); //16进制
			RSAPublicKeyVo publicKeyVo = new RSAPublicKeyVo();
			publicKeyVo.setPublicKeyExponent(publicKeyExponent);
			publicKeyVo.setPublicKeyModulus(publicKeyModulus);
			if(privateKey == null){
				logger.error("生成公钥和私钥失败！privateKey：" + privateKey + "，publicKeyExponent：" + publicKeyExponent + "，publicKeyModulus：" + publicKeyModulus);
			}
			sct.setAttribute(LoginController.PRIVATEKEY, privateKey); //私钥保存在ServletContext中，用于登录密码解密  
			sct.setAttribute(LoginController.PUBLICKEYVO, publicKeyVo); //公钥保存在ServletContext中，用于登录密码加密  
		} catch (NoSuchAlgorithmException e) {
			logger.error("生成公钥和私钥失败！" + e.getMessage(), e);
		}   
		super.contextInitialized(event);
	}

}
