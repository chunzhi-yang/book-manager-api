package com.gzhu.bm.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.gzhu.bm.Constants;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.util.ResponseEnvelope;
import com.gzhu.bm.vo.UsersVO;

@RestController
@RequestMapping("user") 
public class UserInfoController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
		
	@Autowired 
	UsersService usersService;
	
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

	@RequestMapping(value="{account}",method=RequestMethod.POST)
	public ResponseEntity<UsersVO> getByUid(@PathVariable String account){
		return new ResponseEntity<UsersVO>(usersService.findByAccount(account),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ResponseEntity<JSONWrappedObject> update(@RequestBody UsersVO usersVO) {
		Integer res = usersService.updateByPrimaryKeySelective(usersVO);  
		JSONWrappedObject obj = new JSONWrappedObject("", "", res);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public ResponseEntity<JSONWrappedObject> upload(@RequestBody MultipartFile file) throws Exception{
		
		String fileName = saveFile(file,Constants.IMG_PATH);  	
		JSONWrappedObject obj = new JSONWrappedObject("", "", fileName);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
}
