package com.blaze.dao.base;

public class IntTrans implements ValueTrans<Integer> {

	@Override
	public String toStr(Integer val) {

		return val + "";
	}

	@Override
	public Integer toObj(String str) {

		return Integer.parseInt(str);
	}

}
