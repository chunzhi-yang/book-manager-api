package com.gzhu.bm.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
//进行对象转换的工具类
public class BeanMapper {
	
	private static DozerBeanMapper mapper = new DozerBeanMapper();
	
	public static <T, V> List<T> mapList(List<V> list,Class<T> clazz){
		List<T> result = new ArrayList<T>();
		for(V ojb:list){
			result.add(mapper.map(ojb, clazz));
		}
		return result;
	}
	public static <T> List<T> mapArray(Object[] list,Class<T> clazz){
		List<T> result = new ArrayList<T>();
		for(Object ojb:list){
			result.add(mapper.map(ojb, clazz));
		}
		return result;
	}
	
	public static <T, V> T  map(V obj,Class<T> clazz){
		if(obj == null){
			return null;
		}
		return mapper.map(obj, clazz);
	}
}
