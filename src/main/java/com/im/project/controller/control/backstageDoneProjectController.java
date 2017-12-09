package com.im.project.controller.control;

import java.util.ArrayList;
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

@Controller("backstageDoneProject")
@RequestMapping("/control/doneProject")
public class
backstageDoneProjectController {
	@Resource 
	private ProjectMapper projectDao;

	@RequestMapping("/addDoneProject.do")
	public ModelAndView addDoneProject(Project p,HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView=new ModelAndView("control/doneProject");
		Map<String,Object> map=new HashMap<String,Object>();
		p.setType(2);
		try{
		int i=projectDao.insert(p);
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
	@RequestMapping("delDoneProject")
	public ModelAndView delDoneProject(int id,HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView=new ModelAndView("control/doneProject");
		Map<String,Object> map=new HashMap<String,Object>();
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
	@RequestMapping("modifyDoneProject.do")
	public ModelAndView modifyDoneProject(Project p,HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView=new ModelAndView("control/doneProject");
		Map<String,Object> map=new HashMap<String,Object>();
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
			e.printStackTrace();
			map.put("msg", "failed");
		}
		JSONUtils.toJSON(map, response);
		return modelAndView;
		}
	@RequestMapping("getDoneProjects")
	public ModelAndView getDoneProjects(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView=new ModelAndView("/control/doneProject");
		try{
		ArrayList<Project> list=(ArrayList<Project>)projectDao.selectAllCompleted();
		modelAndView.addObject("list", list);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
		}
	
	
	
	
	
}
