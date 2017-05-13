package com.gzhu.bm.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
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

	/**
	 * 
	 * @param fileName
	 * @param uid不是个人云盘传-1，否则传uid
	 * @return
	 * @throws BizException
	 */
	public static List<ChapterVO> getChaptersByFilePath(String fileName, String uid) throws BizException {
		List<ChapterVO> list = new ArrayList<>();
		BufferedReader  reader = null;
		try {
			File file = null;
			if (uid.equals("-1")) {
				file = new File(Constants.FILE_PATH + File.separator + fileName);
			} else {
				file = new File(Constants.FILE_PATH + File.separator + uid + File.separator + fileName);
			}
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			StringBuffer content = new StringBuffer();
			String temp = null;
			while((temp = reader.readLine()) != null){				
				double process = (double) temp.length() / (double) file.getTotalSpace();
				list.addAll(processContent(temp,process));
				content.append(temp + "\n");
			}
			list = processFiles(list, new String(content), fileName);
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

	private static List<ChapterVO> processFiles(List<ChapterVO> chapters, String content, String fileName)
			throws IOException {
		String[] valueArr = content.split("\n");
		List<Integer> idxList = new ArrayList<Integer>();
		for(ChapterVO vo:chapters){
			
			for(int i=0;i<valueArr.length;i++){
				if(vo.getChapterName().equals(valueArr[i])){
					idxList.add(i);
				}
			}
		}

		for (int i = 0; i <= idxList.size() - 1; i++) {
			ChapterVO vo = chapters.get(i); 
			StringBuffer chapterContent = new StringBuffer("<h5>"+vo.getChapterName()+"</h5>");
			for (int j = idxList.get(i); i != idxList.size() - 1 && j < idxList.get(i + 1); j++) {
				if(!valueArr[j].equals(vo.getChapterName())){
					chapterContent.append("<p>"+valueArr[j]+"</p>"); 
				}
			}
			vo.setFileName(fileName.substring(0, fileName.lastIndexOf(".")) + "_" + i + getFileType(fileName));
			addContentToFile(chapterContent, fileName + "_" + i);
		}
		return chapters;
	}

	private static void addContentToFile(StringBuffer chapterContent, String fileName) {
		File file = new File(Constants.FILE_PATH + File.separator + fileName);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(new String(chapterContent));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}

		}
	}

	private static List<ChapterVO> processContent(String values,double process) {
		List<ChapterVO> list = new ArrayList<>();
		List<Pattern> chapterPattern = Constants.CHAPTER_PATTERN;
		
		String[] valueArr = values.split(System.getProperty("line.separator"));
		int length = valueArr.length;
		for (int i = 0; i <= length - 1; i++) {
			for (Pattern pattern : chapterPattern) {
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

	public static String getOneChapter(String fileName) throws IOException {
		StringBuffer content = new StringBuffer();
		String temp = null;
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File(Constants.FILE_PATH + File.separator + fileName)));
			while (StringUtils.isNotBlank(temp = reader.readLine())) {
				content.append(temp);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		return new String(content);
	}
}
