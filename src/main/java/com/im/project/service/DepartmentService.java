package com.im.project.service;

import java.util.List;
import java.util.Map;

import com.im.project.model.Department;

public interface DepartmentService {
	/**
	 * 通过主键查找
	 * @param id
	 * @return
	 */
	public Department findDepartment(Integer id)throws Exception;
	/**
	 * 查询出所有的部门
	 * @return 结果集
	 */
	public List<Department> findAllDepartment()throws Exception;
	/**
	 * 分页查询部门
	 * @param map 封装了page参数
	 * @return 结果集
	 */
	public List<Department> findDepartmentByPage(Map<String, Object> map) throws Exception;

	public boolean addDepartment(Department depart) throws Exception;

	public boolean delDepartment(Integer id,String pictureId) throws Exception;

	public boolean modifyDepartment(Department depart) throws Exception;
}
