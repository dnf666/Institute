package com.im.project.manager;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.im.project.model.Project;

@Repository("projectDao")
public interface ProjectMapper extends BaseDao<Project, Integer> {
	/**
	 * 查询所有的已完成项目
	 * 
	 * @return
	 */
	public List<Project> selectAllCompleted();
	
	/**
	 * 查询所有在研项目
	 * @return
	 */
	public List<Project> selectAllDoing();
	
	/**
	 * 分不同类型查询项目
	 * @param type 区分已完成项目和未完成项目
	 * @return
	 */
	public List<Project> findAllByType(Integer type);
	
	/**
	 * 分页查找未完成的研究成果
	 * @param pageMap 
	 * @return 结果集
	 */
	public List<Project> findAllDoing( Map<String, Object> pageMap);
	
	/**
	 * 分页查找已完成的项目
	 * @param projectMap
	 * @return 结果集
	 */
	public List<Project> findAllCompleted( Map<String,Object> projectMap);
	
}
