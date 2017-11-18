package com.blaze.dao.base;

public abstract class ValueCdt extends SimpleCdt {
	
	/**
	 * 列名
	 */
	private String col;
	
	/**
	 * Operator 操作符
	 */
	private String op;
	
	public abstract boolean getSingleValue();
	
	@Override
	public String getSql() {
		StringBuffer sb = new StringBuffer();
		if(!tableName.equals("")){
			sb.append(tableName);
			sb.append(".");
		}
		sb.append(col);
		sb.append(" ");
		sb.append(op);
		sb.append(" ");
		return sb.toString();
	}

	public ValueCdt(String col, String op) {
		super();
		this.col = col;
		this.op = op;
	}
	
	public boolean getHasValue(){
		return true;
	}

}
