package com.blaze.dao.inf;


/**
 * 根据主键查询一条记录
 * @author lxc
 *
 * @param <Pojo>
 */
public interface IGet<Pojo> {
	/**
	 * 根据主键查询
	 * @param pk
	 * @return
	 */
	public Pojo get(Object pk);
	/**
	 * 从ipk中取出主键进行查询
	 * @param ipk
	 * @return
	 */
	public Pojo getByIPk(IPk ipk);
}