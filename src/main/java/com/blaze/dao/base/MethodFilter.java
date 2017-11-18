package com.blaze.dao.base;

import java.lang.reflect.Method;

public interface MethodFilter {
	boolean filte(Method method,String methodName);
}
