package com.blaze.dao.inf;

import java.util.List;

public interface ISch<Pojo> {

	public List<Pojo> find(IQuery query);
	public int findCnt(IQuery query);

}
