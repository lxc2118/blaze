package com.blaze.dao.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ListCdt<T> extends ValueCdt {
	
	private static final long serialVersionUID = 1L;

	public Collection<T> getValues() {
		return values;
	}

	@Override
	public boolean getSingleValue() {
		return false;
	}

	public ListCdt(String col, String op, Collection<T> values) {
		super(col, op);
		this.values = values;
	}

	public ListCdt(String col, Collection<T> values) {
		super(col, "in");
		this.values = values;
	}

	public ListCdt(String col, Object[] values) {
		super(col, "in");
		this.values = (ArrayList) Arrays.asList(values);
	}

	public ListCdt(String col, String op, Object[] values) {
		super(col, op);
		this.values = (ArrayList) Arrays.asList(values);
	}

	private Collection<T> values;
}
