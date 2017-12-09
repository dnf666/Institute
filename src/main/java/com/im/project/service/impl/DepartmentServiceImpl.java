package com.im.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.im.project.manager.DepartmentMapper;
import com.im.project.model.Department;
import com.im.project.service.DepartmentService;
import com.im.project.service.PictureService;

@Service("departService")
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentDao;
	@Resource
	private PictureService   pictureService;
	public Department findDepartment(Integer id) throws Exception {
		Department dep = new Department();
		if (id > 0 && id < Integer.MAX_VALUE) {
			dep = departmentDao.selectByPrimaryKey(id);
		}
		return dep;
	}

	public List<Department> findAllDepartment() throws Exception {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<Department>();
		list = departmentDao.selectAll();

		return list;
	}

	public List<Department> findDepartmentByPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<Department>();

		list = departmentDao.findAll(map);
		return list;
	}

	public boolean addDepartment(Department depart) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (depart != null) {
			int i = departmentDao.insert(depart);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean delDepartment(Integer id,String pictureId) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		boolean boo1=false;
		boolean boo2=false;
		if (id > 0 && id < Integer.MAX_VALUE) {
			int i = departmentDao.deleteByPrimaryKey(id);
			if (i == 1) {
				boo1 = true;
			}
		}
		try{
			boo2=pictureService.delPicture(pictureId);

		}
		catch (Exception e){
			e.printStackTrace();
		}
		if(boo1 && boo2){
			boo=true;
		}
		return boo;
	}

	public boolean modifyDepartment(Department depart) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (depart != null) {
			int i = departmentDao.updateByPrimaryKey(depart);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

}
