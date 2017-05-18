package com.blaze.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.blaze.common.S;
import com.blaze.dao.inf.ICrud;
import com.blaze.dao.inf.IPk;
import com.blaze.dao.inf.IQuery;


public class BaseDao<Pojo> implements ICrud<Pojo>{
	
	protected volatile SqlSessionTemplate sqlSession;

	@Override
	public List<Pojo> find(IQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCnt(IQuery query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pojo get(Object pk) {
		if (null == pk) {
			return null;
		}
		return doGet(pk);
	}
	
	protected Pojo doGet(Object pk) {
		return this.acqSqlSession().selectOne(this.getStatementName("get"), pk);
	}
	
	@Override
	public int del(Pojo pojo) {
		return this.acqSqlSession().delete("del");
	}

	@Override
	public int update(Pojo pojo) {
		return this.acqSqlSession().update("update");
	}
	
	protected String getStatementName(String name) {
		StringBuffer sb = new StringBuffer();
//		if (classT != null) {
//			sb.append(classT.getName()).append('.');
//		}
//		sb.append(name);
		return sb.toString();
	}
	
	protected SqlSessionTemplate acqSqlSession() {
		if (sqlSession == null) {
			sqlSession = S.get(SqlSessionTemplate.class);
		}
		return sqlSession;
	}

	@Override
	public Pojo getByIPk(IPk ipk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Pojo pojo) {
		// TODO Auto-generated method stub
		
	}



}
