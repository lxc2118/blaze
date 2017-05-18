package com.blaze.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuperClassHunter {
	
	private static final SuperClassHunter INSTANCE = new SuperClassHunter();
	
	static public SuperClassHunter get(){
		return INSTANCE;
	}
	
	private SuperClassHunter(){
		
	}
	public Class acqClass(Object obj){
		Class ret = null;
		try {
			Type type = obj.getClass().getGenericSuperclass();
			if(type instanceof ParameterizedType){
				Type[] types = ((ParameterizedType)type).getActualTypeArguments();
				if (types[0] instanceof Class) {
					ret = ((Class) types[0]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
