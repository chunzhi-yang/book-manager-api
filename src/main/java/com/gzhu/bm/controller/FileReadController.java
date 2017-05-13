package com.gzhu.bm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
import com.gzhu.bm.vo.ChapterVO;

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
	
	@RequestMapping(value = "downloadFile", method = RequestMethod.POST)
	public ResponseEntity<String> downloadBook(String fileName) {
		String content = "";
		try {
			content = FileUtil.getOneChapter(fileName);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return new ResponseEntity<String>(content, HttpStatus.OK);
	}



	@RequestMapping(value = "bookWithChapters", method = RequestMethod.POST)
	public ResponseEntity<List<ChapterVO>> getChapters(@RequestParam String fileName)
			throws BizException {
		List<ChapterVO> list = new ArrayList<>();
		try {
			list = FileUtil.getChaptersByFilePath(fileName, "-1");
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "bookWithChaptersUid", method = RequestMethod.POST)
	public ResponseEntity<List<ChapterVO>> getChaptersByUid(@RequestParam String fileName, @RequestParam String uid)
			throws BizException {
		List<ChapterVO> list = new ArrayList<>();
		try {
			list = FileUtil.getChaptersByFilePath(fileName, uid);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "getOneChapter", method = RequestMethod.POST)
	public ResponseEntity<String> getOneChapterByFileName(@RequestParam String fileName)
			throws BizException {
		String content = "";
		try {
			content = FileUtil.getOneChapter(fileName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ResponseEntity<>(content, HttpStatus.OK);
	}
}
