package com.gzhu.bm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gzhu.bm.Constants;
import com.gzhu.bm.exception.BizException;
import com.gzhu.bm.vo.ChapterVO;


public final class FileUtil {
	
	private final static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	public static File getFile(String folderPath,String fileName) throws IOException{
		File file = new File(folderPath);
		if(file.isDirectory()){
			String[] filelist = file.list();
			for(String path : filelist){
				File tmp = new File(folderPath+"\\"+path);
				if(tmp.isFile() && tmp.getName().equals(fileName)){
					return tmp;
				}
			}
		}
		return null;
	}
	
	public static boolean isImageFile(String fileName){	
		try{
		String fileType = fileName.substring(fileName.indexOf(".")+1).toLowerCase();	
		switch(fileType){
			case "jpg":
			case "png":
			case "ico":
				return true;
			default:
				return false;
		}
		}catch(Exception e){
			return false;
		}
	}
	
	public static String getFileType(String fileName){
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	public static String getFileTypeWithoutPoint(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	
	public static String randomFileName(){
		String randomName = UUID.randomUUID().toString().replaceAll("-","");
		return randomName;
	}
	
	public static void deleteFile(String baseDir,String fileName){
		File file = new File(baseDir,fileName);
		if(file.isDirectory()){
			return;
		}
		if(file.exists()){
			file.delete();
		}
	}
	
	public static List<ChapterVO> getChaptersByFilePath(String fileName,String uid) throws BizException{
		List<ChapterVO> list = new ArrayList<>();
		BufferedReader  reader = null;
		try {
			File file = new File(Constants.FILE_PATH+File.separator+uid +File.separator + fileName);
			 
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String temp = null;
			while((temp = reader.readLine()) != null){				
				double process = (double)temp.length()/(double)file.getTotalSpace();
				list.addAll(processContent(temp,process));
			}
			
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
		}
		return list;
		
	}

	private static List<ChapterVO> processContent(String values,double process) {
		List<ChapterVO> list = new ArrayList<>();
		List<Pattern> chapterPattern = Constants.CHAPTER_PATTERN;
		
		String[] valueArr = values.split(System.getProperty("line.separator"));
		int length = valueArr.length;
		for(Pattern pattern: chapterPattern){			
			for(int i=0;i <= length -1;i++){
				String value=valueArr[i];
				if(pattern.matcher(value).matches()){
					ChapterVO vo = new ChapterVO();
					vo.setChapterName(value);
					double gap = 0;
					int lastLength=0;
					for(int j=length-1;j > i;j--){
						lastLength += valueArr[j].length();
					}
					if(lastLength>0){
						gap = lastLength/value.length();
					}
					vo.setProcess(process-gap);
					list.add(vo);
				}
			}			
		}
		return list;
	}
}
