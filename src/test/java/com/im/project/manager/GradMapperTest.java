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

import com.im.project.model.Grad;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class GradMapperTest {
	@Resource
	GradMapper gradDao;
	@Test
	public void TestInsert(){
		Grad g=new Grad();
		g.setJianjie("hahah");
		g.setName("jsdfhd");
		g.setWhereabout("腾讯");
		g.setXibie("xingan");
		g.setZhiwu("前台");
		int i=gradDao.insert(g);
		if(i!=1){
			fail("insert failed");
		}
	}
	@Test
	public void TestFindAll(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageSize", 3);
		map.put("pageNow", 1);
		List<Grad> list=gradDao.findAll(map);
		//System.out.println(list.get(0).getJianjie());
		if(list.size()!=3){
			fail("Find failed");
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
		Grad d=gradDao.selectByPrimaryKey(2);
		if(d.getName()==null){
			fail("select failed");
		}
	}
	@Test
	public void TestDeleteByPrimaryKey(){
		int i=gradDao.deleteByPrimaryKey(6);
		if(i!=1){
			fail("delete failed");
		}
	}
	@Test
	public void TestUpdateByPrimaryKey(){
		Grad g=new Grad();
		g.setId(2);
		g.setName("zhoujun");
		int i=gradDao.updateByPrimaryKey(g);
		if(i!=1){
			fail("update failed");
		}	
	}
	@Test
	public void TestCountRecords(){
		int i=gradDao.countRecords();
		//System.out.println(i);
	}

	@Test
	public void TestPostGradsAdd(){
		Grad g=new Grad();
		g.setJianjie("hahah");
		g.setName("jsdfhd");
		g.setWhereabout("腾讯");
		g.setXibie("xingan");
		g.setZhiwu("前台");
		g.setDaoshi("王永");
		int i=gradDao.insertPostGrad(g);
		org.junit.Assert.assertEquals(i,1);
	}
	
	
	
	
	
}
