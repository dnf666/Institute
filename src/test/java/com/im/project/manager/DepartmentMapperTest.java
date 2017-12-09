package com.im.project.manager;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.im.project.model.Department;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class DepartmentMapperTest {
	@Resource
    DepartmentMapper departmentDao; 
	@Test
	public void TestInsert(){	
		Department d=new Department();
		d.setName("lalal");
		d.setUrl("/lolo");
		int i=departmentDao.insert(d);
		if(i!=1){
			fail("insert failed");
		}
		
	}
	@Test
	public void TestFindAll(){}
	@Test
	public void TestSelectAll(){
		List<Department> list=departmentDao.selectAll();
		//System.out.println(list.size());
	    if(list.size()==0){
	    	fail("select all failed");
	    }
	}
	@Test
	public void TestSelectByPrimaryKey(){
		Department d=departmentDao.selectByPrimaryKey(3);
		if(d.getName()==null){
			fail("select failed");
		}
	}
	@Test
	public void TestDeleteByPrimaryKey(){
		int i=departmentDao.deleteByPrimaryKey(7);
		if(i!=1){
			fail("delete failed");
		}
	}
	@Test
	public void TestUpdateByPrimaryKey(){
		Department d=new Department();
		d.setId(6);
		d.setUrl("update");
		int i=departmentDao.updateByPrimaryKey(d);
		if(i!=1){
			fail("update failed");
		}	
	}
}
