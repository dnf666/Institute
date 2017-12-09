package com.im.project.manager;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.im.project.model.News;


@Repository("newsDao")
public interface NewsMapper extends BaseDao<News, Integer>{
	public List<News> selectNewsIndex();
}
