package com.blaze.dao.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTrans implements ValueTrans<Date> {

	@Override
	public String toStr(Date val) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(val);
	}

	@Override
	public Date toObj(String str) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

}
