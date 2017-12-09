package com.im.project.controller;

import com.im.project.model.Article;
import com.im.project.utils.LuceneUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by demo on 2017/6/6.
 */
@Controller
@RequestMapping("static/search")
public class SearchController {
    @RequestMapping("/q")
    public  Map<String,List<Article>> search(@RequestParam(value = "q", required = false,defaultValue = "") String q1,
                         HttpServletRequest request,HttpServletResponse response) throws Exception {
//        if(q.equals("")||q==null)
//            return "static/html/index";
        String q=new String(q1.getBytes("iso-8859-1"),"utf-8");
        LuceneUtil luceneIndex = new LuceneUtil() ;
        List<Article> articleList = luceneIndex.searchBlog(q,request);
        //System.out.println(articleList.size());
        Map<String,List<Article>> map=new HashMap<String,List<Article>>();
        /**
         * 关于查询之后的分页我采用的是每次分页发起的请求都是将所有的数据查询出来，
         * 具体是第几页再截取对应页数的数据，典型的拿空间换时间的做法，如果各位有什么
         * 高招欢迎受教。
         */
//        Integer toIndex = userList.size() >= Integer.parseInt(page) * 5 ? Integer.parseInt(page) * 5 : userList.size();
//        List<User> newList = userList.subList((Integer.parseInt(page) - 1) * 5, toIndex);
//        model.addAttribute("artitleList",articleList) ;
//        String s = this.genUpAndDownPageCode(Integer.parseInt(page), userList.size(), q, 5, request.getContextPath()
//                );
//        model.addAttribute("pageHtml",s) ;
//        model.addAttribute("q",q) ;
//        model.addAttribute("resultTotal",articleList.size());
//        model.addAttribute("pageTitle","搜索关键字'" + q + "'结果页面") ;
map.put("articleList",articleList);
        return map;
    }
}
