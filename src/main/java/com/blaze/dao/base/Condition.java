package com.blaze.dao.base;

import java.io.Serializable;

public abstract class Condition implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract String getSql();

	public boolean getHasValue() {
		return false;
	}

	public boolean getSimple() {
		return true;
	}

	public void process(Query query) {
		query.add2List(this);
	}
}
