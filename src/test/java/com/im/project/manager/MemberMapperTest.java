package com.im.project.manager;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.im.project.model.Member;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class MemberMapperTest {
	@Resource
	MemberMapper memberDao;
	@Test
	public void TestInsert(){
		Member m=new Member();
		m.setJianjie("lalal");
		m.setName("kaka");
		m.setXibie("xinguan");
		m.setZhiwu("qiantai");
		m.setGrade("2015");
		int i=memberDao.insert(m);
		if(i!=1){
			fail("insert failed");
		}
	}
	@Test
	public void TestFindAll(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageSize", 3);
		map.put("pageNow", 1);
		List<Member> list=memberDao.findAll(map);
		if(list.size()!=3){
			fail("Find failed");
		}
	}
	@Test
	public void TestSelectAll(){}
	@Test
	public void TestSelectByPrimaryKey(){
		Member d=memberDao.selectByPrimaryKey(2);
		if(d.getName()==null){
			fail("select failed");
		}
	}
	@Test
	public void TestDeleteByPrimaryKey(){
		int i=memberDao.deleteByPrimaryKey(6);
		if(i!=1){
			fail("delete failed");
		}
	}
	@Test
	public void TestUpdateByPrimaryKey(){
		Member m=new Member();
		m.setId(1);
		m.setJianjie("kokokokokok");
		int i=memberDao.updateByPrimaryKey(m);
		if(i!=1){
			fail("update failed");
		}	
	}
	@Test
	public void TestCountRecords(){
		int i=memberDao.countRecords();
		//System.out.println(i);
	}
	
}
