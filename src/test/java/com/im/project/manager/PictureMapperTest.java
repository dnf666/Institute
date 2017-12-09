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

import com.im.project.model.Picture;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class PictureMapperTest {
	@Resource
	PictureMapper pictureDao;
	
	@Test
	public void testListPic() {
		List<String> listPic=pictureDao.getLogosUrl();
		/*for(String str:listPic){
			//System.out.println(str);
		}*/
		assertEquals(listPic.size(), 3);
		//fail("Not yet implemented");
	}

	@Test
	public void testSelectByType() {
		/*Map<String,Object> map=new HashMap<String ,Object>();
		map.put("type", 1);
		map.put("pageNow", 1);
		map.put("pageSize", 2);
		List<Picture> listPic=pictureDao.selectByType(map);
		for(Picture str:listPic){
			//System.out.println(str.getLink());
		}
		assertEquals(listPic.size(), 2);*/
		//fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		Picture pic=pictureDao.selectByPrimaryKey("2");
		//System.out.println(pic.getLink());
		//assertEquals(pic.getId(), 2);
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		 int i=pictureDao.deleteByPrimaryKey("s1");
		assertEquals(i,1);
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Picture pic =new Picture();
		pic.setDate("1");
		pic.setId("2");
		pic.setLink("qweqw");
		pic.setType("2");
		
		int i=pictureDao.updateByPrimaryKey(pic);
		assertEquals(i, 1);
		//fail("Not yet implemented");

	}

	@Test
	public void testInsert() {
		Picture pic =new Picture();
		pic.setDate("1");
		pic.setId("2");
		pic.setLink("插入");
		pic.setType("2");
		
		pictureDao.insert(pic);
		//fail("Not yet implemented");
	}

}
