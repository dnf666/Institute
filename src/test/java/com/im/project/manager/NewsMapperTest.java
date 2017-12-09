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

import com.im.project.model.News;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-myBatis.xml" })
public class NewsMapperTest {
	@Resource
	NewsMapper newsDao;
	
	@Test
	public void TestInsert(){
		News n=new News();
		n.setAuthor("qqqqqqqqq");
		n.setContent("wwwwwwwwwwwww");
		n.setReleaser("eeeeeeeeeeeee");
		n.setTitle("2222222222222222222");
		int i=newsDao.insert(n);
		if(i!=1){
			fail("insert failed");
		}
	}
	@Test
	public void TestFindAll(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageSize",5);
		map.put("pageNow", 2);
		List<News> list=newsDao.findAll(map);
		if(list.size()!=2){
			//fail("Find failed");
			//System.out.println(list.size()+"条记录");
		}
		for(News news:list){
			//System.out.println(news.getAuthor());
		}
	}
	@Test
	public void TestSelectAll(){}
	@Test
	public void TestSelectByPrimaryKey(){
		News i=newsDao.selectByPrimaryKey(15);
		if(i.getAuthor()==null){
			fail("select failed");
		}
	}
	@Test
	public void TestDeleteByPrimaryKey(){
		int i=newsDao.deleteByPrimaryKey(10);
		if(i!=1){
			fail("delete failed");
		}
	}
	@Test
	public void TestUpdateByPrimaryKey(){
		News n=new News();
		n.setId(31);
		n.setTitle("111111111111111111111111111111111111");
		int i=newsDao.updateByPrimaryKey(n);
		if(i!=1){
			fail("update failed");
		}		
		
	}
	public void TestSelectNewsIndex(){
		List<News> list=newsDao.selectNewsIndex();
		if(list.size()!=5){
			fail("selectNewsIndex failed");
		}
		//for
		
		
	
	}
}
