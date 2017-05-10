package com.gzhu.bm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzhu.bm.Constants;
import com.gzhu.bm.exception.BizException;
import com.gzhu.bm.util.FileUtil;

@RestController
@RequestMapping("app")
public class FileReadController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());


	@RequestMapping(value="downloadAvatar", method=RequestMethod.GET)
	public void downloadAvatar(String url,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "attachment;fileName="+ url);
		logger.info("Download avatar, and the url is:"+ url);
        try{              	
        	File avatar = null;
        	avatar = FileUtil.getFile(Constants.IMG_PATH, url);
        	
        	 
        	logger.info("file path is:"+avatar.getPath());
        	InputStream inputStream = new FileInputStream(avatar);
        	OutputStream os = response.getOutputStream();
        	byte[] b = new byte[2048];
            int length=0;
            while ((length = inputStream.read(b)) > 0) {
                 os.write(b, 0, length);
            }  
            os.flush();
            os.close();  
            inputStream.close();
            logger.info("Download  succeed.");
        }catch(Exception e){
        	logger.info("download failed due to:",e);        	
        }               
	}
	
	@RequestMapping(value="downloadFile", method=RequestMethod.GET)
	public void downloadBook(String url,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;fileName="+ url);
		logger.info("Download file, and the url is:"+ url);
        try{              	
        	File file = FileUtil.getFile(Constants.FILE_PATH, url);
        	 
        	logger.info("file path is:"+file.getPath());
        	InputStream inputStream = new FileInputStream(file);
        	OutputStream os = response.getOutputStream();
        	byte[] b = new byte[2048];
            int length=0;
            while ((length = inputStream.read(b)) > 0) {
                 os.write(b, 0, length);
            }  
            os.flush();
            os.close();  
            inputStream.close();
            logger.info("Download  succeed.");
        }catch(Exception e){
        	logger.info("download failed due to:",e);        	
        }               
	}



	@RequestMapping(value = "bookWithChapters", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getChapters(@RequestParam String fileName, @RequestParam String uid)
			throws BizException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = FileUtil.getChaptersByFilePath(fileName, uid);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
}
