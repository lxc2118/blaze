package com.blaze.dao.base;

public class StrTrans implements ValueTrans<String> {

	@Override
	public String toStr(String val) {
		return val;
	}

	@Override
	public String toObj(String str) {
		return str;
	}

}
