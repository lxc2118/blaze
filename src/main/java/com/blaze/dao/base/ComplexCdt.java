package com.blaze.dao.base;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplexCdt extends Condition {
	public String getSuffixSql(){
		return "";
	}
	public List<SimpleCdt> getCdts() {
		return cdts;
	}
	abstract public String getSeparator(); 
	@Override
	public boolean getSimple(){
		return false;
	}
	public String getSql(){
		return "";
	}
	public void add(SimpleCdt cdt){
		cdt.setNum(cdts.size());
		cdts.add(cdt);
		
	}
	protected List<SimpleCdt> cdts = new ArrayList<SimpleCdt>();
	
	
}
