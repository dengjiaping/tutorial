package com.nonobank.common.utils;

import java.util.Map;

import com.google.gson.Gson;

/**
 * 
 * @ClassName: BeanUtils
 * @Description: Map与javabean之前的转换 
 * 				 需要Gson包
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-9-19 下午5:05:34
 * 
 */
public class BeanUtils {
	public static <T> T mapToBean(Map<String, String> map,Class<T> clazz){
		String json = MapUtils.toJson(map);
		return new Gson().fromJson(json, clazz);
		
	}
}
