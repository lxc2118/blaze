package com.blaze.dao.base;

import java.text.DecimalFormat;

public class FloatTrans implements ValueTrans<Float> {

	@Override
	public String toStr(Float val) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(val);
	}

	@Override
	public Float toObj(String str) {
		return Float.parseFloat(str);
	}

}
