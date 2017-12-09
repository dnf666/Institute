package com.im.project.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.im.project.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class ProjectServiceTest {
	@Resource
	ProjectService projectService;
	@Test
	public void testAddProject() {
		//fail("Not yet implemented");
		Project pro=new Project();
		pro.setContent("测试");
		pro.setId(33);
		pro.setLeader("liuq");
		pro.setTitle("和");
		pro.setType(2);
		boolean boo = false;
		try {
			boo = projectService.addProject(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(boo, true);
	}

	@Test
	public void testFindProject() throws Exception {
		//fail("Not yet implemented");
		Project p=projectService.findProject(1);
		int i=p.getId();
		assertEquals(i, 1);
	}

	@Test
	public void testDelProject() throws Exception {
		//fail("Not yet implemented");
		boolean boo=projectService.delProject(2);
		assertEquals(boo, true);
	}

	@Test
	public void testModifyProject() throws Exception {
		//fail("Not yet implemented");
		Project pro=new Project();
		pro.setContent("修改");
		pro.setId(33);
		pro.setLeader("哈哈哈哈");
		pro.setTitle("和");
		pro.setType(2);
		boolean boo=projectService.addProject(pro);
		assertEquals(boo, true);
	}

	@Test
	public void testFindProjectByType() throws Exception {
		//fail("Not yet implemented");

		Map<String, List<Project>> map=projectService.findProjectByType();
		//System.out.println(map.size());
	}

	@Test
	public void testFindDoingProject() throws Exception {
		//fail("Not yet implemented");
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("pageNow",1);
		map.put("pageSize", 2);
		List<Project> list=projectService.findDoingProject(map);
		//System.out.println(list.size());
	}

	@Test
	public void testFindCompletedProject() throws Exception {
		//fail("Not yet implemented");
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("pageNow",1);
		map.put("pageSize", 2);
		List<Project> list=projectService.findCompletedProject(map);
		//System.out.println("hhhhhhhh"+list.size());
	}

}
