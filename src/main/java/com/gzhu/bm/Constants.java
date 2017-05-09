package com.gzhu.bm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Constants {
	
	public static String FILE_PATH = "E:\\bm43\\file";
	

	public static String IMG_PATH = "E:\\bm43\\img";


	public static List<Pattern> CHAPTER_PATTERN = new ArrayList<>();
	
	static{
		CHAPTER_PATTERN.add(Pattern.compile(".*第.*章.*")); 
	}
	 
	
}
