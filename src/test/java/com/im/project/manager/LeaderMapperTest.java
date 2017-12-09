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

import com.im.project.model.Leader;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-myBatis.xml" })
public class LeaderMapperTest {
	@Resource
	LeaderMapper leaderDao;
	@Test
	public void TestInsert(){
		Leader l=new Leader();
		l.setJianjie("qewhjq");
		l.setName("lalal");
		l.setZhicheng("jaioshou");
		int i=leaderDao.insert(l);
		if(i!=1){
			fail("insert failed");
		}
	}
	@Test
	public void TestFindAll(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageSize", 3);
		map.put("pageNow", 1);
		List<Leader> list=leaderDao.findAll(map);
//		if(list.size()!=3){
//			fail("Find failed");
//		}
		for(Leader l:list){
			//System.out.println(l.getId()+"-------");
			//l.getPicture().getId();
			l.getPictureId();
		}
	}
	/*@Test
	public void TestSelectAll(){
		
		if(list.size()==0){
	    	fail("select all failed");
	    }
	}*/
	@Test
	public void TestSelectByPrimaryKey(){
		Leader d=leaderDao.selectByPrimaryKey(1);
		if(d.getName()==null){
			fail("select failed");
		}
	}
	@Test
	public void TestDeleteByPrimaryKey(){
		int i=leaderDao.deleteByPrimaryKey(3);
		if(i!=1){
			fail("delete failed");
		}
	}
	@Test
	public void TestUpdateByPrimaryKey(){
		Leader l=new Leader();
		l.setId(1);
		l.setName("zhoujun");
		int i=leaderDao.updateByPrimaryKey(l);
		if(i!=1){
			fail("update failed");
		}	
	}
	@Test
	public void TestCountRecords(){
		int i=leaderDao.countRecords();
		//System.out.println(i);
	}
	
	
	
}
