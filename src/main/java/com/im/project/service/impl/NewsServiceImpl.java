package com.im.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.im.project.manager.NewsMapper;
import com.im.project.model.News;
import com.im.project.service.NewsService;
import com.im.project.service.PictureService;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	@Resource
	private NewsMapper newsDao;
	@Resource
	private PictureService pictureService;
	public News findNews(Integer id) throws Exception {
		// TODO Auto-generated method stub
		News news = new News();
		if (id > 0 && id < Integer.MAX_VALUE) {
			news = newsDao.selectByPrimaryKey(id);
		}
		return news;
	}

	public boolean delNews(Integer id,String pictureId) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		boolean boo1=false;
		boolean boo2=false;
		if (id > 0 && id < Integer.MAX_VALUE) {
			int i = newsDao.deleteByPrimaryKey(id);
			if (i == 1) {
				boo1 = true;
			}
		}
		boo2=pictureService.delPicture(pictureId);
		if(boo1 && boo2){
			boo=true;
		}
		return boo;
	}

	public boolean modifyNews(News news) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (news != null) {
			int i = newsDao.updateByPrimaryKey(news);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean addNews(News news) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (news != null) {
			int i = newsDao.insert(news);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public List<News> findNewsIndex() throws Exception {
		// TODO Auto-generated method stub
		List<News> newsList = new ArrayList<News>();
		newsList = newsDao.selectNewsIndex();
		return newsList;
	}

	public List<News> findNewsByPage(Map<String, Object> map) throws Exception {
		List<News> newsList = new ArrayList<News>();
		if (map != null) {
			newsList = newsDao.findAll(map);
		}
		return newsList;
	}


	public List<News> selectAllNews()throws Exception {
		return newsDao.selectAll();
	}

}
