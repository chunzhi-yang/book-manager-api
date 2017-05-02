package com.gzhu.bm.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gzhu.bm.Constants;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.util.ResponseEnvelope;
import com.gzhu.bm.vo.UsersVO;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
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

	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<ResponseEnvelope<Integer>> update(@RequestBody UsersVO usersVO) throws Exception{
		ResponseEnvelope<Integer> result = new ResponseEnvelope<>();
		result.setSuccess(true);
		try{ 
			Integer res = usersService.updateByPrimaryKeySelective(usersVO);
			result.setSuccess(true);
		}catch(Exception e){
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			logger.error(e.getMessage(), e);
			throw e;
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public ResponseEntity<String> upload(@RequestBody MultipartFile file) throws Exception{
		String fileName = saveFile(file,Constants.IMG_PATH);  			 
		return new ResponseEntity<>(fileName,HttpStatus.OK);
	}
}
