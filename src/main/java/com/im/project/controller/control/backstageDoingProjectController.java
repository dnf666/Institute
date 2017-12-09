package com.im.project.controller.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.manager.ProjectMapper;
import com.im.project.model.Project;
import com.im.project.utils.JSONUtils;

@Controller("backstageDoingProject")
@RequestMapping("/control/doingProject")

public class backstageDoingProjectController {
@Resource 
private ProjectMapper projectDao;
@Resource
private backstageDoneProjectController backstageDoneProject;
@RequestMapping("/addDoingProject.do")
public ModelAndView addDoingProject(Project p,HttpServletRequest request,
		HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView=new ModelAndView("control/doingProject");
	p.setType(1);
	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	p.setStartline(sf.format(new Date()));
	try{
	projectDao.insert(p);
	map.put("msg", "success");
	}
	catch(Exception e){
		map.put("msg", "failed");
		e.printStackTrace();
	}
	 JSONUtils.toJSON(map, response);
	return modelAndView;
	}
@RequestMapping("/delDoingProject.do")
public ModelAndView delDoingProject(int id,HttpServletRequest request,
		HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView=new ModelAndView("control/doingProject");
	try{
	int i=projectDao.deleteByPrimaryKey(id);
	if(i==1){
		map.put("msg", "success");
	}
	else{
		map.put("msg", "failed");
	}
	}
	catch(Exception e){
		e.printStackTrace();
		map.put("msg", "failed");
	}
	JSONUtils.toJSON(map, response);
	return modelAndView;
	}
@RequestMapping("/modifyDoingProject.do")
public ModelAndView modifyDoingProject(Project p,HttpServletRequest request,
		HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView=new ModelAndView("control/doingProject");
	try{
	int i=projectDao.updateByPrimaryKey(p);
	if(i==1){
		map.put("msg", "success");
	}
	else{
		map.put("msg", "failed");
	}
	}
	catch(Exception e){
		map.put("msg", "failed");
		e.printStackTrace();
	}
	JSONUtils.toJSON(map, response);
	return modelAndView;
	}
@RequestMapping("/getDoingProjects.do")
public ModelAndView getDoingProjects(HttpServletRequest request,
		HttpServletResponse response){
	//Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView=new ModelAndView("control/doingProject");
	try{
	ArrayList<Project> list=(ArrayList<Project>)projectDao.selectAllDoing();
	modelAndView.addObject("list", list);
	}
	catch(Exception e){
	e.printStackTrace();
	}
	return modelAndView;
	}@RequestMapping("/validate.do")
public ModelAndView validate(Project p,HttpServletRequest request,
		HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView=new ModelAndView("control/doingProject");
	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	p.setDeadline((sf.format(new Date())));
	try{
		int i=projectDao.updateByPrimaryKey(p);
		if(i==1){
			map.put("msg", "success");
		}
		else{
			map.put("msg", "failed");
		}
		}
		catch(Exception e){
			map.put("msg", "failed");
			e.printStackTrace();
		}
		JSONUtils.toJSON(map, response);
		return modelAndView;
	}

}
