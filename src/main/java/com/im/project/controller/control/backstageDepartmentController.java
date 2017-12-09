package com.im.project.controller.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.model.Department;
import com.im.project.service.DepartmentService;
import com.im.project.service.PictureService;
import com.im.project.utils.JSONUtils;

@Controller("backstageDepartment")
@RequestMapping("/control/department")
public class backstageDepartmentController {
@Resource
private DepartmentService departmentService;
@Resource
private PictureService pictureService;
@RequestMapping("/addDepartment.do")
public ModelAndView addDepartment(Department d,HttpServletRequest request,
		HttpServletResponse response,@RequestParam("file")  CommonsMultipartFile picture) throws Exception{
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/partner"); 
	String fileId=UUID.randomUUID().toString();
	String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
	boolean boo=pictureService.addPicture(picture, map, realPath, fileId,"相关单位",1);
	if(!boo){
		JSONUtils.toJSON(map, response);
		return modelAndView;     
	}
	d.setPictureId(fileId);
	boolean boo1=departmentService.addDepartment(d);
	if(boo1){
		map.put("msg", "success");
	}
	else{
		map.put("msg", "failed");
	}
	JSONUtils.toJSON(map, response);
	return modelAndView;
}
@RequestMapping("/delDepartment.do")
public ModelAndView delDepartment(String pictureId,int id,HttpServletRequest request,
		HttpServletResponse response) throws Exception{
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/partner");  
	try{
	boolean boo=departmentService.delDepartment(id,pictureId);
	if(boo){
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
@RequestMapping("/modifyDepartment.do")
public ModelAndView modifyDepartment(Department d,HttpServletRequest request,
		HttpServletResponse response) throws Exception{
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/partner");  
	try{
	boolean boo=departmentService.modifyDepartment(d);
	if(boo){
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
@RequestMapping("/getDepartments.do")
public ModelAndView getDepartments(HttpServletRequest request,
		HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView("control/partner");  
	try{
		ArrayList<Department> list=(ArrayList<Department>)departmentService.findAllDepartment();
		modelAndView.addObject("list", list);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return modelAndView;
	
}

}
