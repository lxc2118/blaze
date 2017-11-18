package com.blaze.dao.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

public class MethodTrans {
	private static HashMap<Class, ValueTrans> map = new HashMap<Class, ValueTrans>();
	static {
		map.put(Double.class, new DoubleTrans());
		map.put(Date.class, new DateTrans());
		map.put(Float.class, new FloatTrans());
		map.put(Integer.class, new IntTrans());
		map.put(Long.class, new LongTrans());
		map.put(String.class, new StrTrans());
	}

	public static Object trans(Method method, Object src) {
		ValueTrans trans = null;
		Object ret = null;
		try {
			ret = method.invoke(src);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if (ret == null)
			return null;
		Trans annotation = method.getAnnotation(Trans.class);
		if (annotation != null) {
			Class clazz = annotation.clazz();
			if (clazz != null)
				try {
					trans = (ValueTrans) clazz.newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
		}
		if (trans == null) {
			trans = map.get(ret.getClass());
		}
		if (trans != null)
			return trans.toStr(ret);
		else
			return ret;
	}
}
