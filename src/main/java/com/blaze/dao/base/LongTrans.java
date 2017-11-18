package com.blaze.dao.base;

public class LongTrans implements ValueTrans<Long> {

	@Override
	public String toStr(Long val) {
		return val + "";
	}

	@Override
	public Long toObj(String str) {
		return Long.parseLong(str);
	}

}
