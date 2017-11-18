package com.blaze.dao.base;

import java.io.Serializable;

public class TableJoin implements Serializable {
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof TableJoin))
			return false;
		return obj.hashCode()==this.hashCode();
	}


	@Override
	public int hashCode() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getSimpleName());
		sb.append(" ");
		sb.append(this.tableName);
		return sb.toString().hashCode();
	}
	
	
	public String getMainTableCol() {
		if(mainTableCol==null || "".equals(mainTableCol)) return joinTableCol;
		return mainTableCol;
	}
	public void setMainTableCol(String mainTableCol) {
		this.mainTableCol = mainTableCol;
	}
	public String getJoinTableCol() {
		return joinTableCol;
	}
	public void setJoinTableCol(String joinTableCol) {
		this.joinTableCol = joinTableCol;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getSql(){
		StringBuffer sb = new StringBuffer();
		sb.append(" inner join ");
		sb.append(tableName);
		sb.append(" on t.");
		sb.append(this.getMainTableCol());
		sb.append(" = ");
		sb.append(tableName);
		sb.append(".");
		sb.append(getJoinTableCol());
		sb.append(" ");
		return sb.toString();
	}
	
	protected String mainTableCol;
	protected String joinTableCol;
	protected String tableName;
	
}
