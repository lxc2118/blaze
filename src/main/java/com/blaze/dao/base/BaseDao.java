package com.blaze.dao.base;

import java.util.Collection;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DuplicateKeyException;

import com.blaze.common.Paging;
import com.blaze.common.S;
import com.blaze.dao.inf.ICrud;
import com.blaze.dao.inf.IPk;
import com.blaze.dao.inf.IQuery;

public class BaseDao<Pojo> implements ICrud<Pojo>{
	
	protected volatile SqlSessionTemplate sqlSession;
	
	protected Boolean useCache = false;
	
	protected Boolean needGetClass = true;
	
	protected Class clazz;
	
	public Paging<Pojo> getPage(Integer page, Integer pageSize) {
		Query query = new Query().setFirstResult((page-1>=0?page-1:page) * pageSize).setRp(pageSize);
		return Paging.of(this.find(query), this.findCnt(query), page, pageSize);
	}
	
	public Paging<Pojo> getPage(Integer page) {
		return this.getPage(page, Paging.DEFAULT_PAGE_SIZE);
	}
	
	public List<Pojo> findAll() {
		return this.acqSqlSession().selectList (this.getStatementName("findAll"));
	}

	@Override
	public List<Pojo> find(IQuery query) {
		return doFind(query);
	}
	
	public List<Pojo> find(String colName, Object value) {
		Query query = new Query();
		query.eq(colName, value);
		return find(query);
	}
	
	public Pojo get(String colName, Object value) {
		Query query = new Query();
		query.eq(colName, value);
		List<Pojo> list = find(query);
		return list.isEmpty() ? null:list.get(0);
	}
	
	protected List<Pojo> doFind(IQuery query) {
		return this.acqSqlSession().selectList (this.getStatementName("find"), query);
	}

	@Override
	public int findCnt(IQuery query) {
		return (Integer) acqSqlSession().selectOne(this.getStatementName("findCnt"), query);
	}
	
	public Pojo getOrAdd(Pojo pojo) {
		Pojo ret = this.getByIPk((IPk) pojo);
		if (ret == null) {
			ret = pojo;
			try{
				this.doAdd(pojo);
			}catch(DuplicateKeyException e){
				e.printStackTrace();
				ret = this.getByIPk((IPk) pojo);
			}
		}
		return ret;
	}
	
	protected String getStatementName(String name) {
		return name;
//		StringBuffer sb = new StringBuffer();
//		if (classT != null) {
//			sb.append(classT.getName()).append('.');
//		}
//		sb.append(name);
//		return sb.toString();
	}
	
	protected SqlSessionTemplate acqSqlSession() {
		if (sqlSession == null) {
			sqlSession = S.get(SqlSessionTemplate.class);
		}
		return sqlSession;
	}

	@Override
	public Pojo getByIPk(IPk ipk) {
		return get(ipk.acqPk());
	}

	@Override
	public void add(Pojo pojo) {
		this.doAdd(pojo);
	}
	
	protected void doAdd(Pojo pojo) {
		acqSqlSession().insert(this.getStatementName("insert"), pojo);
	}
	
	public void delAll(Collection<Pojo> pojos) {
		if (pojos != null) {
			for (Pojo pojo : pojos)
				del(pojo);
		}
	}
	
	@Override
	public int del(Pojo pojo) {
		return this.doDel(pojo);
	}
	
	protected int doDel(Pojo pojo) {
		return acqSqlSession().delete(this.getStatementName("delete"), pojo);
	}
	
	@Override
	public int update(Pojo pojo) {
		return this.acqSqlSession().update("update");
	}
	
	protected int doUpdate(Pojo pojo) {
		return acqSqlSession().update(this.getStatementName("update"), pojo);
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

}
