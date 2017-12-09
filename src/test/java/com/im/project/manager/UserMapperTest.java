package com.im.project.manager;


import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.im.project.manager.UserMapper;
import com.im.project.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class UserMapperTest {
	@Test
	public void TestInsert(){	
	}
	@Test
	public void TestFindAll(){}
	@Test
	public void TestSelectAll(){}
	@Test
	public void TestSelectByPrimaryKey(){}
	@Test
	public void TestDeleteByPrimaryKey(){}
	@Test
	public void TestUpdateByPrimaryKey(){}
	}
	
	
