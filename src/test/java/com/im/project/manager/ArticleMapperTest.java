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

import com.im.project.model.Article;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class ArticleMapperTest {
	@Resource
	ArticleMapper articleDao;
	@Test
	public void TestInsert(){	
		Article a=new Article();
		a.setAuthor("eqwe");
		a.setContent("dsdf");
		a.setDate("2015-4-1");
		a.setKeyword("vd");
		a.setSummary("cfdxfv");
		a.setTitle("ds");
		int i=articleDao.insert(a);
		if(i!=1){
			fail("insert failed");
		}
	}
	@Test
	public void TestSelectAll(){
		
		
	}
	@Test
	public void TestFindAll(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageNow",1);
		map.put("pageSize",5);
	
		List<Article> list=articleDao.findAll(map);
		//System.out.println(list.size());
		if(list.size()!=5){
			fail("Find failed");
		}
			}
	@Test
	public void TestSelectByPrimaryKey(){
		Article i=articleDao.selectByPrimaryKey(22);
		
		if(i.getAuthor()==null){
			fail("select failed");
		}
	}
	@Test
	public void TestDeleteByPrimaryKey(){
		int i=articleDao.deleteByPrimaryKey(28);
		if(i!=1){
			fail("delete failed");
		}
	}
	@Test
	public void TestUpdateByPrimaryKey(){
		Article a=new Article();
		a.setId(22);
		a.setAuthor("lalal");
		int i=articleDao.updateByPrimaryKey(a);
		if(i!=1){
			fail("update failed");
		}		
		
	}
	@Test
	public void TestSelectArticleIndex(){
		List<Article> list=articleDao.selectArticleIndex();
		//System.out.println(list.size());
		if(list.size()!=4){
			fail("SelectArticleInde failed");
		}
	}
}
