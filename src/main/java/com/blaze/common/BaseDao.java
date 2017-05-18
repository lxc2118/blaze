package com.blaze.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

@SuppressWarnings("deprecation")
public abstract class BaseDao<Pojo> {

	@Resource
	protected volatile SqlSessionTemplate sqlSession;

    private Map<Object, SqlSessionFactory> targetSqlSessionFactorys;
	
	/**
	 * 根据pojo读取一个实例，如果不存在，则增加一条记录
	 * 
	 * @param pojo
	 * @return
	 */
	public Pojo getOrAdd(Pojo pojo) {
		Pojo ret = this.getByIPk((IPk) pojo);
		if (ret == null) {
			ret = pojo;
			try {
				if (ret != null)
					this.doAdd(pojo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public Pojo getByIPk(IPk ipk) {
		return get(ipk.acqPk());
	}

	public Collection<Pojo> getByIds(Object... pks) {
		List<Pojo> ret = new ArrayList<Pojo>();
		if (pks != null) {
			HashSet<Object> set = new HashSet<Object>();
			for (Object obj : pks)
				set.add(obj);
			for (Object pk : set)
				ret.add(get(pk));
		}
		return ret;
	}

	public Pojo get(Object pk) {
		if (pk == null)
			return null;
		Pojo ret = doGet(pk);
		return ret;
	}

	protected Pojo doGet(Object pk) {
		return this.acqSqlSession().selectOne(this.getStatementName("get"), pk);
	}

	protected SqlSessionTemplate acqSqlSession() {
		if (sqlSession == null) {
			sqlSession = S.get(CustomSqlSessionTemplate.class);
		}
		System.out.println(sqlSession.getSqlSessionFactory().getConfiguration().getEnvironment());
		return sqlSession;
	}

	public int findCnt() {
		return (Integer) acqSqlSession().selectOne(this.getStatementName("findCnt"));
	}

	public void add(Pojo pojo) {
		doAdd(pojo);
	}

	protected void doAdd(Pojo pojo) {
		acqSqlSession().insert(this.getStatementName("insert"), pojo);
	}

	public void update(Pojo pojo) {
		doUpdate(pojo);
	}

	protected void doUpdate(Pojo pojo) {
		acqSqlSession().update(this.getStatementName("update"), pojo);
	}

	public int del(Pojo pojo) {
		int ret = doDel(pojo);
		return ret;
	}

	protected int doDel(Pojo pojo) {
		return acqSqlSession().delete(this.getStatementName("delete"), pojo);
	}

	public void delAll(Collection<Pojo> pojos) {
		if (pojos != null) {
			for (Pojo pojo : pojos)
				del(pojo);
		}
	}

	protected String getStatementName(String name) {
		StringBuffer sb = new StringBuffer();
		if (classT != null) {
			sb.append(classT.getName()).append('.');
		}
		sb.append(name);
		return sb.toString();
	}

	public BaseDao() {
		this.initClass();
	}

	protected void initClass() {
		if (needGetClass)
			this.classT = SuperClassHunter.get().acqClass(this);
	}

	public Class getClassT() {
		return classT;
	}

	public void setClassT(Class classT) {
		this.classT = classT;
	}

	public BaseDao(Class t) {

		this.classT = t;
	}

	public void queryForHandle(Query query, ResultHandler resultHandler) {
		/*
		 * this.getSqlSession().queryWithRowHandler(this.getStatementName("find"
		 * ), query, rowHandler);
		 */
		this.acqSqlSession().select(this.getStatementName("find"), query, resultHandler);
	}

	public void handleAll(ResultHandler resultHandler) {
		Query query = new Query();
		this.acqSqlSession().select(this.getStatementName("find"), query, resultHandler);
	}

	public String getClassName() {
		if (classT != null)
			return classT.getSimpleName();
		return null;
	}

	public String getClassNameWithSuffix(String suffix) {
		String className = this.getClassName();
		if (className == null || suffix == null)
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append(className).append(suffix);
		return sb.toString();
	}

	public Map findMap(Query query) {
		return this.acqSqlSession().selectOne(this.getStatementName("findMap"), query);
	}

	public Integer findMapCnt(Query query) {
		Map map = this.findMap(query);
		if (map == null)
			return 0;
		Number val = (Number) map.values().iterator().next();
		return val.intValue();
	}

	protected boolean needGetClass = true;
	protected Class classT;

}
