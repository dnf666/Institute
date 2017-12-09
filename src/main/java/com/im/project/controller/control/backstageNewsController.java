package com.im.project.controller.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.manager.NewsMapper;
import com.im.project.manager.UserMapper;
import com.im.project.model.News;
import com.im.project.model.User;
import com.im.project.service.NewsService;
import com.im.project.service.PictureService;
import com.im.project.utils.JSONUtils;

@Controller("backstageNews")
@RequestMapping("/control/news")
public class backstageNewsController {
@Resource
private NewsMapper newsDao;
@Resource
private PictureService pictureService;
@Resource
private NewsService newsService;
@Resource
private UserMapper userDao;
@RequestMapping("/addNews.do")
public ModelAndView addNews(News n,HttpServletRequest request,
		HttpServletResponse response,@RequestParam("file")  CommonsMultipartFile picture) throws Exception{
	//System.out.println(n.getContent()+"lalal");
	ModelAndView modelAndView =new ModelAndView("control/addNews");
	Map<String,Object> map=new HashMap<String,Object>();
	String fileId=UUID.randomUUID().toString();
	String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
	boolean boo1=pictureService.addPicture(picture, map, realPath, fileId,"新闻",1);
	if(!boo1){
		JSONUtils.toJSON(map, response);
		return modelAndView;     
	}
	n.setPictureId(fileId);
	n.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	try{
	boolean boo=newsService.addNews(n);
	if(boo){
		map.put("msg", "success");
	}
	else{
		map.put("msg", "failed");
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	JSONUtils.toJSON(map, response);
	return modelAndView;
}
@RequestMapping("/delNews.do")
public ModelAndView delNews(String pictureId,int id,HttpServletRequest request,
		HttpServletResponse response){
	ModelAndView modelAndView =new ModelAndView("control/addNews");
	Map<String,Object> map=new HashMap<String,Object>();
	try{
		boolean boo=newsService.delNews(id, pictureId);
		if(boo){
			map.put("msg", "success");
		}
		else{
			map.put("msg", "failed");
		}
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("msg", "failed");
		}
	JSONUtils.toJSON(map, response);
	return modelAndView;
}
@RequestMapping("/modifyNews.do")
public ModelAndView updateNews(News n,HttpServletRequest request,
		HttpServletResponse response){
	ModelAndView modelAndView =new ModelAndView("control/updateNews");
	Map<String,Object> map=new HashMap<String,Object>();
	try{
		int i=newsDao.updateByPrimaryKey(n);
		if(i==1){
			map.put("msg", "success");
		}
		else{
			map.put("msg", "failed");
		}
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("msg", "failed");
		}
	JSONUtils.toJSON(map, response);
	return modelAndView;
}
@RequestMapping("/getNews.do")
public ModelAndView getNews(HttpServletRequest request,
		HttpServletResponse response){
	ModelAndView modelAndView =new ModelAndView("/control/news");
	try{
		ArrayList<News> list=(ArrayList<News>)newsDao.selectAll();
		modelAndView.addObject("list",list);
	}
	catch(Exception e){	
		e.printStackTrace();
	}
	return modelAndView;
}
@RequestMapping("/getSingleNews.do")
public ModelAndView getSingleNews(int id,HttpServletRequest request,
		HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView =new ModelAndView("control/updateNews");
	try{
		News news=newsDao.selectByPrimaryKey(id);
		List<User> list=userDao.selectAll();
		map.put("News", news);
		map.put("userList",list);
		modelAndView.addObject("map",map);
		}
	catch(Exception e){	
		e.printStackTrace();
	}
		return modelAndView;
}
@RequestMapping("/enterNews.do")
public ModelAndView addNews(HttpServletRequest request,
		HttpServletResponse response){
	ModelAndView modelAndView =new ModelAndView("control/addNews");
	try{
		List<User> list=userDao.selectAll();
		modelAndView.addObject("list",list);
		}
	catch(Exception e){	
		e.printStackTrace();
	}
		return modelAndView;
}
}



