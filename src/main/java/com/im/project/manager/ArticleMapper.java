package com.im.project.manager;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.im.project.model.Article;
@Repository("articleDao")
public interface ArticleMapper  extends BaseDao<Article, Integer>{
	public List<Article> selectArticleIndex();
	List<String> findTitleByUserName(String userName);
	List<Article> selectAllArticle();
}
