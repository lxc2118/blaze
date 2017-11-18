package com.blaze.dao.base;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;

public class ObjectUtil {
	public static Object get(Object obj,String name){
		if(obj==null || name==null) return null;
		String methodName = buildGetMethod(name);
		Method method = null;
		try {
			method = obj.getClass().getMethod(methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(method==null) return null;
		Object ret = null;
		
		try {
			ret = method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void copy2Map(Object src,Map dest,HashSet<String> ignores){
		if(dest==null || src==null) return;
		 
		Method[] methods = src.getClass().getMethods();
		try{
			for(Method method:methods){
				String methodName = method.getName();
				String name = buildName(methodName);
				if(getterFilter.filte(method,methodName) 
						&& !(ignores!=null && ignores.contains(name))){
					dest.put(name, MethodTrans.trans(method, src));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public String buildGetMethod(String name){
		StringBuffer sb = new StringBuffer();
		sb.append("get")
			.append(name.substring(0,1).toUpperCase())
			.append(name.substring(1));
		return sb.toString();
	}
	
	private static String buildName(String methodName){
		StringBuffer sb = new StringBuffer();
		sb.append(methodName.substring(3,4).toLowerCase())
			.append(methodName.substring(4));
		return sb.toString();
	}
	
	private static MethodFilter getterFilter = new GetMethodFilter();
}
