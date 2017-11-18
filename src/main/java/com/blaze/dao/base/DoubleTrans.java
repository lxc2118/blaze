package com.blaze.dao.base;

import java.text.DecimalFormat;

public class DoubleTrans implements ValueTrans<Double> {

	@Override
	public String toStr(Double val) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(val);
	}

	@Override
	public Double toObj(String str) {
		return Double.parseDouble(str);
	}

}
