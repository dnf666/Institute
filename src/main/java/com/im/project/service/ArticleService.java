package com.im.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.im.project.model.Article;

public interface ArticleService {
	public boolean addArticle(Article art) throws Exception;

	public Article findArticle(Integer id) throws Exception;

	public boolean modifyArticle(Article art) throws Exception;

	public boolean delArticle(Integer id) throws Exception;
	/**
	 * 查找主页所要加载的新闻列表
	 * @return 结果集
	 */
	public List<Article> findArticleIndex() throws Exception;
	/**
	 * 分页查找新闻
	 * @param map
	 * @return
	 */
	public List<Article> findArticle(Map<String ,Object> map) throws Exception;
	/**
	 * 根据姓名查找文章题目
	 * @param userName
	 * @return title
	 */
	List<String> findTitleByUserName(String userName);

	List<Article> selectAllArticle();
	
}
