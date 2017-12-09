package com.im.project.controller.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.manager.ArticleMapper;
import com.im.project.model.Article;
import com.im.project.utils.JSONUtils;

@Controller("backstageArticle")
@RequestMapping("/control/article")
public class backstageArticleController {
	@Resource
	private ArticleMapper articleDao;
	@RequestMapping("/addArticle.do")
	public ModelAndView addArticle(Article a,HttpServletRequest request,
			HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/addPaper"); 
	try{
	a.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	 int i=articleDao.insert(a);
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
	@RequestMapping("/delArticle.do")
	public ModelAndView delArticle(int id,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/papers");  
		
		 try{
			 int i=articleDao.deleteByPrimaryKey(id);
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
	@RequestMapping("/modifyArticle.do")
	public ModelAndView modifyArticle(Article a,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("/control/updatePapers");  
		 
		 try{
			 int i=articleDao.updateByPrimaryKey(a);
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
	@RequestMapping("/getArticles.do")
	public ModelAndView getArticles(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("/control/papers"); 
		try{
		ArrayList<Article> list=(ArrayList<Article>)articleDao.selectAll();
		 modelAndView.addObject("list", list); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	     return modelAndView;   
		}
	@RequestMapping("/getArticle.do")
	public ModelAndView selectArticle(int id,HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("/control/updatePapers"); 
		try{
		Article a=articleDao.selectByPrimaryKey(id);
		 modelAndView.addObject("article", a); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	     return modelAndView;   
		}
}
