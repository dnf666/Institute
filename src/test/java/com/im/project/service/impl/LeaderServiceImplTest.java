package com.im.project.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.im.project.model.Leader;
import com.im.project.service.LeaderService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class LeaderServiceImplTest {
	@Resource
	private LeaderService leaderService;
	@Test
	public final void testModifyLeader() {
		//fail("Not yet implemented");
	}

	@Test
	public final void testFindLeaderByPage() throws Exception {
		//fail("Not yet implemented");
		Map<String ,Object> map1=new HashMap<String,Object >();
		map1.put("pageNow", 1);
		map1.put("pageSize", 3);
		List<Leader> leader=leaderService.findLeaderByPage(map1);
		//System.out.println(leader.size());
		for(Leader l:leader){
			//System.out.println(l.getName());
		}
	}

	@Test
	public final void testFindrecords() throws Exception {
		//fail("Not yet implemented");
	int i=	leaderService.findrecords();
	//System.out.println(i);
	}
	@Test
	public void test() throws Exception{
		//System.out.println(leaderService.findType(1));
	}

}
