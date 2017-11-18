package com.blaze.dao.base;

public interface ValueTrans<T> {
	
	String toStr(T val);

	T toObj(String str);
}
