package com.im.project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.im.project.manager.ProjectMapper;
import com.im.project.model.Project;
import com.im.project.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Resource
	private ProjectMapper projectDao;

	public boolean addProject(Project project) throws Exception {
		if (project != null) {
			int i = projectDao.insert(project);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public Project findProject(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Project pro = new Project();
		if (id > 0 && id < Integer.MAX_VALUE) {
			pro = projectDao.selectByPrimaryKey(id);
		}
		return pro;
	}

	public boolean delProject(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (id > 0 && id < Integer.MAX_VALUE) {
			int i = projectDao.deleteByPrimaryKey(id);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean modifyProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (project != null) {
			int i = projectDao.updateByPrimaryKey(project);
			if (i == 1) {
				boo = true;
			}
		}

		return boo;
	}

	/**
	 * 将执行两次查询，并将两次查询结果添加到map中返回
	 */
	public Map<String, List<Project>> findProjectByType() throws Exception {
		// TODO Auto-generated method stub
		Map<String, List<Project>> twoTypeList = new HashMap<String, List<Project>>();
		List<Project> doingProList = new ArrayList<Project>();
		List<Project> completedProList = new ArrayList<Project>();
		doingProList = projectDao.findAllByType(1);
		completedProList = projectDao.findAllByType(2);
		twoTypeList.put("completedachieve", completedProList);
		twoTypeList.put("doingachieve", doingProList);
		return twoTypeList;

	}

	public List<Project> findDoingProject(Map<String, Object> projectMap) throws Exception {
		// TODO Auto-generated method stub
		List<Project> proList = new ArrayList<Project>();
		if (projectMap != null) {
			proList = projectDao.findAllDoing(projectMap);
		}
		return proList;
	}

	public List<Project> findCompletedProject(Map<String, Object> projectMap) throws Exception {
		// TODO Auto-generated method stub
		List<Project> proList = new ArrayList<Project>();
		if (projectMap != null) {
			
			proList = projectDao.findAllCompleted(projectMap);
		}
		return proList;
	}

	@Override
	public List<Project> selectAllDoing() {
		return projectDao.selectAllDoing();
	}

	@Override
	public List<Project> selectAllCompleted() {
		return projectDao.selectAllCompleted();
	}

}
