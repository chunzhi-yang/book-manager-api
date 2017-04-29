package com.gzhu.bm.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class BeanMapper {
	
	private static DozerBeanMapper mapper = new DozerBeanMapper();
	
	public static <T, V> List<T> mapList(List<V> list,Class<T> clazz){
		List<T> result = new ArrayList<T>();
		for(V ojb:list){
			result.add(mapper.map(ojb, clazz));
		}
		return result;
	}
	public static <T, V> T  map(V obj,Class<T> clazz){
		return mapper.map(obj, clazz);
	}
}
