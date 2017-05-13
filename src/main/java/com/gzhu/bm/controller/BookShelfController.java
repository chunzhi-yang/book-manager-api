package com.gzhu.bm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.gzhu.bm.Constants;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BmFilesService;
import com.gzhu.bm.service.BookShelfService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.vo.BmFilesVO;
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
	public ResponseEntity<JSONWrappedObject> upload(@RequestBody CommonsMultipartFile[] files) throws Exception {
		List<Integer> ids = new ArrayList<Integer>();
		for (CommonsMultipartFile file : files) {
			String fileName = saveFile(file, Constants.FILE_PATH);

			ids.add(insertBmFiles(fileName));
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
	public ResponseEntity<JSONObject> create(@ModelAttribute List<BookShelfVO> BookShelfVOList) {
		Integer result = bookShelfService.createBatch(BookShelfVOList);
		return new ResponseEntity<>(JSONObject.fromObject(result),
				result.intValue() > 0 ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable Long id){
		Integer result = bookShelfService.deleteById(id);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
}
