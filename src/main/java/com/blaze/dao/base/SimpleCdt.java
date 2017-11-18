package com.blaze.dao.base;

public abstract class SimpleCdt extends Condition {
	
	private static final long serialVersionUID = 1L;
	
	private int num;
	
	protected String tableName = "t";

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	protected String getTableName() {
		return tableName;
	}
}
