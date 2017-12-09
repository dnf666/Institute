package com.im.project.service;

import java.util.List;
import java.util.Map;

import com.im.project.model.Project;

public interface ProjectService {
	
	/**
	 * 添加项目		
	 * @param project 项目实体
	 * @return 成功与否
	 */
	public boolean addProject(Project project)throws Exception;
	/**
	 * 通过id查找项目
	 * @param id 项目id
	 * @return 结果集
	 */
	public Project findProject(Integer id)throws Exception;
	/**
	 * 通过id删除项目
	 * @param id 项目id
	 * @return 成功与否
	 */
	public boolean delProject(Integer id)throws Exception;
	/**
	 * 修改项目
	 * @param project 项目实体
	 * @return 成功与否
	 */
	public boolean modifyProject(Project project)throws Exception;
	/**
	 * 根据不同的项目类型分类查找，再组成一个map
	 * @return 结果集
	 */
	
	
	public Map<String, List<Project>> findProjectByType()throws Exception;
	/**
	 * 分页查找未完成的项目
	 * @param projectMap 所要查找的记录条的页参数
	 * @return 结果集
	 */
	public List<Project> findDoingProject(Map<String, Object> projectMap)throws Exception;
	/**
	 * 分页查找已完成的项目
	 * @param projectMap 所要查找的记录条的页参数
	 * @return 结果集
	 */
	public List<Project> findCompletedProject(Map<String, Object> projectMap)throws Exception;

	/**
	 * 不分页全部在研项目
	 * @return
	 */
	List<Project> selectAllDoing();

	/**
	 * 不分页完成项目
	 * @return
	 */
	List<Project> selectAllCompleted();
}
