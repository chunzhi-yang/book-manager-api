package com.gzhu.bm.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.security.interfaces.RSAPrivateKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.security.util.MD5Helper;
import com.gzhu.bm.security.util.RSAUtil;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.vo.RSAPublicKeyVo;
import com.gzhu.bm.vo.UsersVO;

@RestController
@RequestMapping("login") 
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String PRIVATEKEY = "privateKey";
	public static final String PUBLICKEYVO = "publicKeyVo";
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value="signin",method=RequestMethod.POST)
	public ResponseEntity<Integer> login(HttpServletRequest request,String userName,String password,Boolean rememberMe) throws Exception{
		ResponseEntity<Integer> result = new ResponseEntity<Integer>(1, HttpStatus.OK);		 
		
		Subject user = SecurityUtils.getSubject();		
		ServletContext sct = request.getSession().getServletContext();   
	    // 从上下文环境中通过属性名获取属私钥 
		RSAPrivateKey privateKey = (RSAPrivateKey) sct.getAttribute(PRIVATEKEY);
		if(privateKey == null){
			throw new Exception("后台获取私钥操失败，请刷新页面");
		}
		String dencrypedPwd = RSAUtil.decryptByPrivateKey(password, privateKey); //解密后密码
		
		AuthenticationToken token = new UsernamePasswordToken(userName, dencrypedPwd,rememberMe); 		 
		try {
			//会调用 shiroDbRealm 的认证方法 ShiroDbRealm.doGetAuthenticationInfo(AuthenticationToken)
			user.login(token);
		} catch (Exception e) { 
			logger.error(e.getMessage(),e);
			throw e;
		} 
		return result;	
	
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST) 
	public void logout() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		subject.logout(); 
	}
	
	@RequestMapping(value="signup",method=RequestMethod.POST)  
	public ResponseEntity<Integer> signup(String userName,String password,HttpServletRequest request)throws Exception{
		try{ 
			ServletContext sct = request.getSession().getServletContext();   
		    // 从上下文环境中通过属性名获取属私钥 
			RSAPrivateKey privateKey = (RSAPrivateKey) sct.getAttribute(PRIVATEKEY);
			if(privateKey == null){
				throw new Exception("后台获取私钥操失败，请刷新页面");
			}
			String userPassword =RSAUtil.decryptByPrivateKey(password, privateKey);
			UsersVO usersVo = new UsersVO();
			usersVo.setUserName(userName);
			usersVo .setUserPassword(MD5Helper.MD5(userPassword));
			SimpleDateFormat dateFmt = new SimpleDateFormat("YYYYMMddHHmmss"); 
			StringBuffer sb = new StringBuffer();
			sb.append(dateFmt.format(Calendar.getInstance().getTime()))
			.append("00")
			.append((int)Math.random()*100); 
			usersVo.setBirth(new Date(70,01,01));
			usersVo.setUid(sb.toString());
			usersService.createSelective(usersVo); 
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			throw e;
		}
		return new ResponseEntity<>(1,HttpStatus.OK);
	}
	 
	@RequestMapping(value = "/getRSAPublicKey", method = RequestMethod.GET) 
	public RSAPublicKeyVo getRSAPublicKey(HttpServletRequest request) {
		ServletContext sct = request.getSession().getServletContext();   
	    // 从上下文环境中通过属性名获取属性值  
        RSAPublicKeyVo publicKeyVo = (RSAPublicKeyVo) sct.getAttribute(PUBLICKEYVO);
		
		return publicKeyVo;
	}
	 
	@RequestMapping(value = "/getCaptchaS", method = RequestMethod.GET)	
	public void getCaptchaS(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession();
		OutputStream outputStream = response.getOutputStream();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		int width = 125, height = 29;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		
		//框
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, width, height);
		
		//划线
		for (int i = 0; i < 40; i++) {
			g.setColor(getRandColor(i, 200));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		
		//文字
		char fontes[] = new char[62];
		int j = 0;
		// 0~9
		for (int k = 48; k <= 57; j++, k++) {
			fontes[j] = (char) k;
		}
		// A~Z
		for (int l = 65; l <= 90; j++, l++) {
			fontes[j] = (char) l;
		}
		// a~z
		for (int m = 97; m <= 122; j++, m++) {
			fontes[j] = (char) m;
		}
		g.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			int x = random.nextInt(62 - 1);
			String rand = String.valueOf(fontes[x]);
			sRand += rand;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 20 * i + 20, 23);
		}
		// 将认证码存入SESSION 
		session.setAttribute("captcha", sRand.toLowerCase());
		g.dispose();
		ImageIO.write(image, "JPEG", outputStream);
		g.dispose();
		ImageIO.setUseCache(true);
		try {
			ImageIO.write(image, "JPEG", outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		outputStream.flush();
		outputStream.close();
	}
	
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
