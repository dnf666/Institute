package com.im.project.manager;

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
public class ProjectMapperTest {
	@Resource
	ProjectMapper projectDao ;
	@Test
	public void testFindAllByType() {
		List<Project> list=projectDao.findAllByType(1);
		for(Project pro:list){
			//System.out.println(pro.getTitle());
		}
		assertEquals(list.size(), 6);
		//fail("Not yet implemented");
	}


	@Test
	public void testFindAllDoing() {
		Map<String,Object> pageMap= new HashMap<String,Object>(); ;
		pageMap.put("pageNow", 0);
		pageMap.put("pageSize", 3);
		List<Project> list=projectDao.findAllDoing(pageMap);
		for(Project pro:list){
			//System.out.println(pro.getTitle());
		}
		assertEquals(list.size(),3);
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAllCompleted() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Project pro=new Project();
		pro.setId(13);
		pro.setContent("213hhhhhaha哈哈");
		pro.setLeader("213");
		//pro.setType(2);
		int i=projectDao.updateByPrimaryKey(pro);
		assertEquals(i, 1);
		//fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		Project pro=new Project();
		//pro.setId(29);
		pro.setContent("213hhhhhaha插入");
		pro.setLeader("213");
		pro.setType(2);
		int i=projectDao.insert(pro);
		assertEquals(i, 1);
		//fail("Not yet implemented");
	}

}
