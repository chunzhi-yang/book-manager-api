package com.gzhu.bm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.gzhu.bm.Constants;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmFilesService;
import com.gzhu.bm.service.BookShelfService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.vo.BmFilesVO;
import com.gzhu.bm.vo.BookShelfListVO;
import com.gzhu.bm.vo.BookShelfVO;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("bookShelf")
public class BookShelfController {

	@Autowired
	BookShelfService bookShelfService;
	@Autowired
	BmFilesService bmFileService;
	
	@RequestMapping(value="list/{uid}",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BookShelfVO>> getList(@PathVariable String uid,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		
		int count = bookShelfService.selectCount(uid);
		PaginationBean<BookShelfVO> paginationBean = new PaginationBean<BookShelfVO>(page, pageSize, count);
	 
		List<BookShelfVO> list = new ArrayList<BookShelfVO>();
		if(count > 0){		
			list = bookShelfService.selectByUid(uid, paginationBean);
		}
		paginationBean.setData(list);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ResponseEntity<JSONWrappedObject> upload(HttpServletRequest request,HttpServletResponse resp) throws Exception {
		 CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
		 List<Integer> ids = new ArrayList<Integer>();
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				String fileName = saveFile(file, Constants.FILE_PATH);
				ids.add(insertBmFiles(fileName));
			}
		}
		 
		JSONWrappedObject obj = new JSONWrappedObject("", "", ids);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	private String saveFile(MultipartFile file, String basePath) throws Exception {
		if (file.isEmpty()) {
			return "";
		}
		String fileName = FileUtil.randomFileName() + FileUtil.getFileType(file.getOriginalFilename());
		File targetFile = new File(basePath, fileName);
		if (!targetFile.exists()) {
			targetFile.createNewFile();
		}
		file.transferTo(targetFile);
		return fileName;
	}
	
	private int insertBmFiles(String fileName) {
		BmFilesVO bmFilesVO = new BmFilesVO();
		bmFilesVO.setFilePath(fileName);
		return bmFileService.createSelective(bmFilesVO);
	}

	@RequestMapping(value="createBatch",method=RequestMethod.POST)
	public ResponseEntity<JSONWrappedObject> create(@RequestBody BookShelfListVO vo) {
		List<BookShelfVO> list = vo.getData();
		for(BookShelfVO b:list){
			b.setCreatedTime(new Date());
			b.setUpdatedTime(new Date());
		}
		Integer result = bookShelfService.createBatch(vo.getData());
		JSONWrappedObject obj = new JSONWrappedObject("", "", result);
		return new ResponseEntity<>(obj,
				result.intValue() > 0 ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable Long id){
		Integer result = bookShelfService.deleteById(id);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
