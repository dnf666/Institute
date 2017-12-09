package com.im.project.manager;

import org.springframework.stereotype.Repository;

import com.im.project.model.Department;
@Repository("departmentDao")
public interface DepartmentMapper extends BaseDao<Department,Integer>{

}
