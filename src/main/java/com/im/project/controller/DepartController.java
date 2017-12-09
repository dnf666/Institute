package com.im.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.im.project.model.Department;
import com.im.project.service.DepartmentService;

@Controller("departController")
@RequestMapping("static/department")
public class DepartController {
	@Resource
	private DepartmentService departmentService;
	@RequestMapping(value="/listDepartment.do")
	public List<Department> listDepartment(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Department> departmentList =new ArrayList<Department>();
		departmentList=departmentService.findAllDepartment();
		return departmentList;
	}
	
}
