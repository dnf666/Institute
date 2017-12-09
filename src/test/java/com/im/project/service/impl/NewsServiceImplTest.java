package com.im.project.service.impl;

import static org.junit.Assert.*;
import static com.im.project.utils.JSONUtils.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.im.project.model.News;
import com.im.project.model.Picture;
import com.im.project.service.NewsService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class NewsServiceImplTest {
	@Resource
	private NewsService newsService;
	/*	@Test
	public final void testModifyNews() throws Exception {
		//fail("Not yet implemented"); // TODO
		News n =new News();
		Picture pic=new Picture(); 
		pic.setLink("新闻测试");
		pic.setDate("2011-9-1");
		n.setContent("1");
		n.setId(10);
		n.setPicture(pic);
		n.setPictureId(4);
		boolean b=newsService.modifyNews(n);
		assertTrue(b);
		//System.out.println(b);
	}
/*	@Test
	public final void testAddNews() throws Exception {
		News n =new News();
		Picture pic=new Picture(); 
		pic.setLink("新闻测试");
		pic.setDate("2011-9-1");
		n.setContent("1");
		//n.setId(10);
		n.setPicture(pic);
		n.setPictureId(4);
		boolean b=newsService.addNews(n);
		assertTrue(b);
		//fail("Not yet implemented"); // TODO
	}*/
	@Test
	public final void testFindNewsByPrimarykey() throws Exception {
		//fail("Not yet implemented"); // TODO
		 News news=newsService.findNews(41);
		 //System.out.println(toJSONString(news));

	}
	@Test
	public final void testFindNewsIndex() throws Exception {
		//fail("Not yet implemented"); // TODO
		 List<News> newsList=newsService.findNewsIndex();
		 //System.out.println(toJSONString(newsList));
		 for(News n:newsList){
			// //System.out.println(n.getId());
		 }
	}
	
	@Test
	public final void testFindNewsByPage()  throws Exception{
		//fail("Not yet implemented"); // TODO
		Map<String ,Object> map1=new HashMap<String,Object>();
		map1.put("pageNow", 1);
		map1.put("pageSize", 3);
		try{
		 List<News> list=newsService.findNewsByPage(map1);
		 //System.out.println(list.size());
		//System.out.println(toJSONString(list));
		 
		 for(News n:list){
			//System.out.println(n.getTitle());//在获取n的属性时候可能会出现空指针异常
		 }
		 }catch (java.lang.NullPointerException e){
			 //System.out.println("空指针");
			 e.printStackTrace();
		 }
	}

}
