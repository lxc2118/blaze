package com.blaze.dao.base;

import java.util.List;

public class CdtUtil {
	
	public static SimpleCdt noMatch() {
		return NotMatch.get();
	}

	public static SimpleCdt eq(String column, Object value) {
		return new SingleCdt(column, "=", value);
	}

	public static SimpleCdt big(String column, Object value) {
		return new SingleCdt(column, ">", value);
	}

	public static SimpleCdt less(String column, Object value) {
		return new SingleCdt(column, "<", value);
	}

	public static SimpleCdt bigAndEqual(String column, Object value) {
		return new SingleCdt(column, ">=", value);
	}

	public static SimpleCdt lessAndEqual(String column, Object value) {
		return new SingleCdt(column, "<=", value);
	}

	public static SimpleCdt like(String column, Object value) {
		return new SingleCdt(column, "like", value);
	}

	public static SimpleCdt in(String column, Object[] value) {
		if (value != null && value.length == 0)
			return NotMatch.get();
		return new ListCdt(column, "in", value);
	}

	public static SimpleCdt in(String column, List<?> value) {
		if (value != null && value.size() == 0)
			return NotMatch.get();
		return new ListCdt(column, "in", value);
	}

	public static SimpleCdt in(String column, List<?> objs, String proName) {
		if (objs != null && objs.size() == 0)
			return NotMatch.get();
		Object[] value = new Object[objs.size()];
		for (int i = 0; i < objs.size(); i++) {
			value[i] = ObjectUtil.get(objs.get(i), proName);
		}
		return new ListCdt(column, "in", value);
	}

	public static SimpleCdt notIn(String column, List<?> objs, String proName) {
		if (objs != null && objs.size() == 0)
			return null;
		Object[] value = new Object[objs.size()];
		for (int i = 0; i < objs.size(); i++) {
			value[i] = ObjectUtil.get(objs.get(i), proName);
		}
		return new ListCdt(column, "not in", value);
	}

	public static SimpleCdt in(String column, List<?> objs, String proName, boolean exist) {
		if (exist)
			return in(column, objs, proName);
		else
			return notIn(column, objs, proName);
	}

	public static SimpleCdt notIn(String column, Object[] value) {
		if (value == null || value.length == 0)
			return null;
		return new ListCdt(column, "not in", value);
	}

	public static SimpleCdt notIn(String column, List value) {
		if (value == null || value.size() == 0)
			return null;
		return new ListCdt(column, "not in", value);
	}

	public static SimpleCdt noEq(String column, Object value) {
		return new SingleCdt(column, "<>", value);
	}

	public static InTableCdt inTable(String name) {
		InTableCdt ret = new InTableCdt(name);

		return ret;
	}

	public static SimpleCdt sql(String sql) {
		if (sql != null)
			return new SqlCdt(sql);
		return null;
	}

	public static SimpleCdt isNull(String col, boolean bnull) {
		StringBuffer sb = new StringBuffer();
		sb.append(col);
		sb.append(" ");
		if (bnull) {
			sb.append("is null ");
		} else {
			sb.append("is not null");
		}
		return new SqlCdt(sb.toString());
	}

	public static SimpleCdt isNull(String col) {
		return isNull(col, true);
	}

	public static SimpleCdt notNull(String col) {
		return isNull(col, false);
	}

	/**
	 * 构建查询字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String likeStr(String str) {
		if (str == null || str.equals(""))
			return null;
		StringBuffer buffer = new StringBuffer();
		buffer.append("%").append(str).append("%");
		return buffer.toString();
	}

	/**
	 * 构建前缀的查询
	 * 
	 * @param str
	 * @return
	 */
	public static String halfLikeStr(String str) {
		if (str == null || str.equals(""))
			return null;
		StringBuffer buffer = new StringBuffer();
		buffer.append(str).append("%");
		return buffer.toString();
	}
}
