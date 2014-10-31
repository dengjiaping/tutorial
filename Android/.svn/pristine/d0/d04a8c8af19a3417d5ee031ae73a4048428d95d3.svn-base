package com.nonobank.factory;

import java.io.IOException;
import java.util.Properties;

import com.nonobank.constant.NetConstantValue;

 

public class BeanFactory {
	private static Properties properties;
	private static String propertiesName=NetConstantValue.propertiseName;
	
	static{
		properties=new Properties();
		try {
			properties.load(BeanFactory.class.getClassLoader().getResourceAsStream(propertiesName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	* @Description: 获取某Engine的实例
	* @param 		@param target
	* @param 		@return    设定文件 
	* @return 		T    返回类型 
	* @throws
	 */
	public static<T> T getImpl(Class<T> target){
		String key = target.getSimpleName();
		String className = properties.getProperty(key);
		try {
			return (T) Class.forName(className).newInstance(); //通过反射得到实例; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
