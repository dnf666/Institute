package com.im.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.im.project.model.Article;
import com.im.project.service.ArticleService;
import com.im.project.utils.Page;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("articleController")
@RequestMapping("static/paper")
public class ArticleController {
	@Resource
	private ArticleService articleService;
	
	@RequestMapping(value="/listPaper.do")
	public Map<String, Object> listArticleIndex(Page page, String identify,
												HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Article> articleList=new ArrayList<Article>();
		Map<String,Object> dataMap =new HashMap<String,Object>();
		if(identify.equals("index")){
		articleList=articleService.findArticleIndex();
		}else if(identify.equals("article")){
			Map<String ,Object> pageMap=new HashMap<String,Object>();
			pageMap.put("pageSize", (page.getPageSize()<=0)?0:page.getPageSize());
			pageMap.put("pageNow", (page.getPageNow()<=0)?0:(page.getPageNow()-1)*page.getPageSize());
			articleList=articleService.findArticle(pageMap);
		}
		dataMap.put("paperlist",articleList );
		return dataMap;
	}
	
	@RequestMapping(value="/readpaper.do")
	public Map<String,Object> checkArticle(int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Article art=null;
		Map<String,Object> dataMap =new HashMap<String,Object>();
		if(id>0&&id<Integer.MAX_VALUE){
			art=articleService.findArticle(id);
			dataMap.put("paper", art);
		}
		return dataMap;
	}
	@RequestMapping(value="/listMorePaper.do")
	public Map<String, Object> listMoreArticle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Article> articleList=new ArrayList<Article>();
		Map<String,Object> dataMap =new HashMap<String,Object>();
		articleList = articleService.selectAllArticle();
		dataMap.put("paperlist",articleList );
		return dataMap;
	}
	
	
}
