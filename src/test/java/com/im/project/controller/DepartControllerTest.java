package com.im.project.controller;

import com.im.project.model.Department;
import com.im.project.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by demo on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class DepartControllerTest {
    @Resource
    private DepartmentService departmentService;
    @Test
    public void listDepartment() throws Exception {
        List<Department> departmentList =new ArrayList<Department>();
        departmentList=departmentService.findAllDepartment();
        for (Department d :
                departmentList) {
            //System.out.println(d.toString());

        }

    }

}