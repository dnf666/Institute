package com.im.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.im.project.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.im.project.model.News;
import com.im.project.service.NewsService;
import com.im.project.utils.Page;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("newsController")
@RequestMapping("static/news")
public class NewsController {
	@Resource
	private NewsService newsService;

	@RequestMapping("/listnews.do")
	public Map<String, Object> listNews(String identify,Page page, HttpServletRequest request,
										HttpServletResponse response) throws Exception {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<News> newsList = new ArrayList<News>();
		if (identify.equals("index")) {
			newsList = newsService.findNewsIndex();
		} else  if(identify.equals("news")) {
			Map<String, Object> pageMap = new HashMap<String, Object>();
			pageMap.put("pageSize", (page.getPageSize()<=0)?0:page.getPageSize());
			pageMap.put("pageNow", (page.getPageNow()<=0)?0:(page.getPageNow()-1)*page.getPageSize());
			newsList = newsService.findNewsByPage(pageMap);
		}
		dataMap.put("newslist", newsList);
		//System.out.println(dataMap.toString());
		return dataMap;
	}

	@RequestMapping("/checknews.do")
	public Map<String, Object> checkNews(int id,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		News news = newsService.findNews(id);
		dataMap.put("news", news);
		return dataMap;
	}
	@RequestMapping(value="/listMoreNews.do")
	public Map<String, Object> listMoreArticle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<News> newsList=new ArrayList<News>();
		Map<String,Object> dataMap =new HashMap<String,Object>();
		newsList = newsService.selectAllNews();
		dataMap.put("newslist",newsList );
		return dataMap;
	}
}
