package com.gzhu.bm.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gzhu.bm.Constants;
import com.gzhu.bm.service.UsersService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.vo.BooksVO;
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

	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<Integer> update(@RequestParam(value="avatar",required=false) CommonsMultipartFile avatar, UsersVO usersVO) throws Exception{
		if(avatar.isEmpty() || avatar == null){
			
		}else{
			String fileName = saveFile(avatar,Constants.IMG_PATH); 
			usersVO.setImgPath("app/downloadFile/"+fileName);
		}		
		Integer result = usersService.updateByPrimaryKeySelective(usersVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
