package com.blaze.dao.base;

import java.util.List;

public class InTableCdt extends ComplexCdt {

	@Override
	public String getSuffixSql() {
		return ")";
	}

	public InTableCdt exist(boolean exist) {
		this.exist = exist;
		return this;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public void setMainTableCol(String mainTableCol) {
		this.mainTableCol = mainTableCol;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public void add(SimpleCdt cdt) {
		if (cdt == null)
			return;
		cdt.setNum(cdts.size());
		cdts.add(cdt);

		if (cdt instanceof ValueCdt) {
			((ValueCdt) cdt).setTableName("");
		}
	}

	@Override
	public String getSql() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getMainTableCol());
		sb.append(this.getExistStr());
		sb.append("(select ");
		if (distinct)
			sb.append("distinct ");
		sb.append(col);
		sb.append(" from ");
		sb.append(tableName);
		if (cdts.size() > 0)
			sb.append(" where ");
		return sb.toString();
	}

	@Override
	public String getSeparator() {
		return " and ";
	}

	private String getMainTableCol() {
		if (mainTableCol == null || mainTableCol.equals(""))
			return col;
		return mainTableCol;
	}

	public InTableCdt(String tableName) {
		this.tableName = tableName;
	}

	private String getExistStr() {
		if (exist)
			return " in ";
		return " not in ";
	}

	public InTableCdt in(String column, List value) {
		this.add(CdtUtil.in(column, value));
		return this;
	}

	public InTableCdt in(String column, List objs, String proName) {
		this.add(CdtUtil.in(column, objs, proName));
		return this;
	}

	public InTableCdt noEq(String column, Object value) {
		this.add(CdtUtil.noEq(column, value));
		return this;
	}

	public InTableCdt in(String column, Object[] value) {
		this.add(CdtUtil.in(column, value));
		return this;
	}

	public InTableCdt big(String column, Object value) {
		this.add(CdtUtil.big(column, value));
		return this;
	}

	public InTableCdt less(String column, Object value) {
		this.add(CdtUtil.less(column, value));
		return this;
	}

	public InTableCdt bigAndEqual(String column, Object value) {
		this.add(CdtUtil.bigAndEqual(column, value));
		return this;
	}

	public InTableCdt lessAndEqual(String column, Object value) {
		this.add(CdtUtil.lessAndEqual(column, value));
		return this;
	}

	public InTableCdt like(String column, Object value) {
		this.add(CdtUtil.like(column, value));
		return this;
	}

	public InTableCdt eq(String column, Object value) {
		this.add(CdtUtil.eq(column, value));
		return this;
	}

	public InTableCdt isNull(String col, boolean bnull) {
		this.add(CdtUtil.isNull(col, bnull));
		return this;
	}

	public InTableCdt isNull(String col) {
		this.add(CdtUtil.isNull(col, true));
		return this;
	}

	public InTableCdt notNull(String col) {
		this.add(CdtUtil.isNull(col, false));
		return this;
	}

	public InTableCdt col(String col) {
		this.col = col;
		return this;
	}

	public InTableCdt schCol(String col) {
		this.mainTableCol = col;
		return this;
	}

	private String tableName;
	private boolean distinct;
	private boolean exist = true;
	private String mainTableCol;
	private String col;

}
