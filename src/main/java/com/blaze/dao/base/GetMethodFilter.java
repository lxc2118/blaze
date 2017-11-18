package com.blaze.dao.base;

import java.lang.reflect.Method;

public class GetMethodFilter implements MethodFilter {

	@Override
	public boolean filte(Method method, String methodName) {
		
		return methodName.startsWith("get") 
				&& method.getParameterTypes().length==0
				&& !methodName.equals("getClass");
	}

}
