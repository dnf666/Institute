package com.im.project.service;

import java.util.List;
import java.util.Map;

import com.im.project.model.News;

public interface NewsService {
	public News findNews(Integer id) throws Exception;

	public boolean delNews(Integer id,String pictureId) throws Exception;

	public boolean modifyNews(News news) throws Exception;

	public boolean addNews(News news) throws Exception;

	public List<News> findNewsIndex() throws Exception;

	public List<News> findNewsByPage(Map<String, Object> map) throws Exception;

    List<News> selectAllNews()throws Exception;
}
