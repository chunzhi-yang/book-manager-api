package com.gzhu.bm.controller;

import java.io.File;
import java.security.interfaces.RSAPrivateKey;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.gzhu.bm.Constants;
import com.gzhu.bm.security.util.MD5Helper;
import com.gzhu.bm.security.util.RSAUtil;
import com.gzhu.bm.service.BmImgsService;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.util.ResponseEnvelope;
import com.gzhu.bm.vo.BmImgsVO;
import com.gzhu.bm.vo.UsersVO;

@RestController
@RequestMapping("user") 
public class UserInfoController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
		
	public static final String PRIVATEKEY = "privateKey";
	public static final String PUBLICKEYVO = "publicKeyVo";

	@Autowired 
	UsersService usersService;
	@Autowired
	BmImgsService bmImgsService;
	
	private String saveFile(MultipartFile file,String basePath) throws Exception{
		if(file.isEmpty()){
			return "";
		}
		String fileName = FileUtil.randomFileName()+ FileUtil.getFileType(file.getOriginalFilename());	
		File targetFile = new File(basePath, fileName);
		if(!targetFile.exists()){
			targetFile.createNewFile();
		}
		file.transferTo(targetFile); 
		return fileName;
	}
     //通过账号获取用户信息
	@RequestMapping(value="{account}",method=RequestMethod.POST)
	public ResponseEntity<UsersVO> getByUid(@PathVariable String account){
		return new ResponseEntity<UsersVO>(usersService.findByAccount(account),HttpStatus.OK);
	}
	
	//更新信息
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public ResponseEntity<JSONWrappedObject> update(@RequestBody UsersVO usersVO) {
		Integer res = usersService.updateByPrimaryKeySelective(usersVO);  
		JSONWrappedObject obj = new JSONWrappedObject("", "", res);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	//上传头像
	@RequestMapping(value = "updatePassword", method = RequestMethod.POST)
	public ResponseEntity<ResponseEnvelope<Integer>> updatePassword(HttpServletRequest request,
			@RequestParam String oldPassword, @RequestParam String newPassword) {
		ResponseEnvelope<Integer> result = new ResponseEnvelope<Integer>();
		Subject user = SecurityUtils.getSubject();		
		ServletContext sct = request.getSession().getServletContext();   
	    // 从上下文环境中通过属性名获取属私钥 
		try {
			RSAPrivateKey privateKey = (RSAPrivateKey) sct.getAttribute(PRIVATEKEY);
			if (privateKey == null) {
				throw new Exception("后台获取私钥操失败，请刷新页面");
			}
			String dencrypedPwd = RSAUtil.decryptByPrivateKey(oldPassword, privateKey); // 解密后密码
			String newPwd = RSAUtil.decryptByPrivateKey(newPassword, privateKey);
			UsersVO subject = (UsersVO) SecurityUtils.getSubject().getPrincipal();
			UsersVO userOld = usersService.findByAccountPassword(subject.getUserName(), dencrypedPwd);
			if (userOld != null) {
				userOld.setUserPassword(MD5Helper.MD5(newPwd));
				result.setSuccess(true);
			}
			result.setMessage("密码错误!");
			result.setSuccess(false);
		} catch (Exception e) { 
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.setMessage(e.getMessage());		 
		}  

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public ResponseEntity<JSONWrappedObject> upload(@RequestBody MultipartFile file) throws Exception{
		
		String fileName = saveFile(file,Constants.IMG_PATH);  	
		JSONWrappedObject obj = new JSONWrappedObject("", "", fileName);
		insertBmImgs(fileName);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}

	private void insertBmImgs(String fileName) {
		BmImgsVO bmImgsVO = new BmImgsVO();
		bmImgsVO.setImgPath(fileName);
		bmImgsService.createSelective(bmImgsVO);
	}
	
	
}
