/**
 * 
 */
package com.im.project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.im.project.manager.ArticleMapper;
import com.im.project.model.Article;
import com.im.project.service.ArticleService;
import com.im.project.service.PictureService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleDao;
	
	@Resource PictureService pictureService;
	public boolean addArticle(Article art) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (art != null) {
			int i = articleDao.insert(art);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public Article findArticle(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Article article = new Article();
		if (id > 0 && id < Integer.MAX_VALUE) {
			Article art = articleDao.selectByPrimaryKey(id);
			if (art != null) {
				article = art;
			}
		}
		return article;
	}

	public boolean modifyArticle(Article art) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (art != null) {
			int i = articleDao.updateByPrimaryKey(art);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean delArticle(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (id > 0 && id < Integer.MAX_VALUE) {
			int i = articleDao.deleteByPrimaryKey(id);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public List<Article> findArticleIndex() throws Exception {
		// TODO Auto-generated method stub
		List<Article> artList = new ArrayList<Article>();
		artList = articleDao.selectArticleIndex();
//		List<String> paperList=pictureService.loadPaperPic();
		if (artList.size()==4 ) {
//			for(int i=0;i<4;i++){
//				artList.get(i).setPicture(paperList.get(i));
//			}
			return artList;
		}
		else{
			return null;
		}
		
	}
	public List<Article> findArticle(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<Article> artList = new ArrayList<Article>();
		artList = articleDao.findAll(map);
		return artList;
	}

	public List<String> findTitleByUserName(String userName) {
		List<String> list=articleDao.findTitleByUserName(userName);
		return list;

	}

	@Override
	public List<Article> selectAllArticle() {
		return articleDao.selectAllArticle();
	}

}
