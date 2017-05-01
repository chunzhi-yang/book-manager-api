package com.gzhu.bm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gzhu.bm.Constants;
import com.gzhu.bm.repo.util.PaginationBean;
import com.gzhu.bm.service.BooksService;
import com.gzhu.bm.util.FileUtil;
import com.gzhu.bm.vo.BooksVO;

@RestController
@RequestMapping("books")
public class BooksController {

	@Autowired
	BooksService booksService;
	
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ResponseEntity<PaginationBean<BooksVO>> getList(@ModelAttribute BooksVO booksVO,@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="pageSize",defaultValue="10")int pageSize){
		if(StringUtils.isBlank(booksVO.getBookName())){
			booksVO.setBookName(null);
		}
		int count = booksService.selectCount(booksVO);
		PaginationBean<BooksVO> paginationBean= new PaginationBean<BooksVO>(page,pageSize,count);
	 
		List<BooksVO>  list = new ArrayList<BooksVO>();
		if(count > 0){		
			list = booksService.selectPage(booksVO, paginationBean);
		}
		paginationBean.setData(list);
		return new ResponseEntity<>(paginationBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@RequestParam("img") CommonsMultipartFile img,@RequestParam("book") CommonsMultipartFile book,BooksVO booksVO) throws Exception{
		String fileName = saveFile(book,Constants.FILE_PATH);
		String imgName = saveFile(img,Constants.IMG_PATH);
		booksVO.setFilePath("app/downloadFile/"+fileName);
		booksVO.setImgPath("app/downloadAvatar/"+imgName);
		Integer result = booksService.createSelective(booksVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
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

 

	@RequestMapping(value="update",method=RequestMethod.PUT)
	public ResponseEntity<Integer> update(@RequestParam("book") CommonsMultipartFile book, BooksVO booksVO) throws Exception{
		String fileName = saveFile(book,Constants.FILE_PATH); 
		booksVO.setFilePath("app/downloadFile/"+fileName);
		Integer result = booksService.update(booksVO);
		return new ResponseEntity<>(result,result.intValue()>0?HttpStatus.OK:HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.POST)
	public ResponseEntity<BooksVO> getById(@PathVariable Long id){
		return new ResponseEntity<BooksVO>(booksService.selectById(id),HttpStatus.OK);
	}
}
