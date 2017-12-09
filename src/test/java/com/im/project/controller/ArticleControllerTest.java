package com.im.project.controller;

import com.im.project.model.Article;
import com.im.project.service.ArticleService;
import com.im.project.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by demo on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ArticleControllerTest {
    @Resource
    private ArticleService articleService;
    @Test
    public void listArticleIndex() throws Exception {
        Page page=new Page();
        page.setPageNow(0);
        page.setPageSize(1);
        String identify= "index";
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
          List<Article> article = (ArrayList) dataMap.get("paperlist");
          for (Article a:article)
          {
              //System.out.println(a.toString());
          }
    }

    @Test
    public void checkArticle() throws Exception {
    }

}