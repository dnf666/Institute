package com.im.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.im.project.manager.ProjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.im.project.model.Project;
import com.im.project.service.ProjectService;
import com.im.project.utils.Page;

@Controller("projectController")
@RequestMapping("static/project")
public class ProjectController {
	@Resource
	private ProjectService projectService;
	@Resource
	private ProjectMapper projectMapper;
	@RequestMapping("/listAllProject.do")
	public Map<String, List<Project>> listProject(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, List<Project>> dataMap = new HashMap<String, List<Project>>();
		dataMap = projectService.findProjectByType();
		return dataMap;
	}

	@RequestMapping("/listNotCompleted.do")
	public Map<String, Object> listDoingProject( HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Project> projectList = new ArrayList<Project>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		/*Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("pageSize", (page.getPageSize()<=0)?0:page.getPageSize());
		pageMap.put("pageNow", (page.getPageNow()<=0)?0:(page.getPageNow()-1)*page.getPageSize());*/
		projectList = projectService.selectAllDoing();
		dataMap.put("doingachieve", projectList);
		return dataMap;
	}

	@RequestMapping("/listCompletedAchieve.do")
	public Map<String, Object> listCompletedProject(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Project> projectList = new ArrayList<Project>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
//		Map<String, Object> pageMap = new HashMap<String, Object>();
//		pageMap.put("pageSize", (page.getPageSize()<=0)?0:page.getPageSize());
//		pageMap.put("pageNow", (page.getPageNow()<=0)?0:(page.getPageNow()-1)*page.getPageSize());
//		projectList = projectService.findCompletedProject(pageMap);
		projectList =projectService.selectAllCompleted();
		dataMap.put("completedachieve", projectList);
		return dataMap;
	}

}
