package com.gzhu.bm.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public final class FileUtil {
	
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
}
