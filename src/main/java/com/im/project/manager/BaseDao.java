package com.im.project.manager;

import java.util.List;
import java.util.Map;

/**
 * 所有Dao层接口的父类
 * @param 所有子类Dao的Model
 */
public interface BaseDao<T,T1> {

	
	/**
	 * 分页查询所有记录
	 * @return 结果集
	 */
	public List<T> findAll(Map<String, Object> map);
	
	/**
	 * 查询所有记录
	 * @return 结果集
	 */
	public List<T> selectAll();

	/**
	 * 根据主键查找相应 的记录
	 * @param id 主键
	 * @return 相应的结果
	 */
	public T selectByPrimaryKey(T1 id);

	/**
	 * 根据主键删除相应的记录
	 * @param id 主键
	 * @return 操作结果
	 */
	public int deleteByPrimaryKey(T1 id);
	
	/**
	 * 根据主键更新相应的记录
	 * @param obj 主键
	 * @return 操作结果
	 */
	
   public int updateByPrimaryKey(T obj);
	
	/**
	 * 添加记录
	 * @param obj 相应的类
	 * @return 操作结果
	 */
	public int insert(T obj);
	/**
	 * 根据id查找类型
	 * @param id 唯一识别码
	 * @return int 成员类型
	 */
	int selectTypeByPrimaryKey(T1 id);

}
