package com.im.project.utils;
	import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	  
	public class MyFilter implements Filter {  
	  
	    public void destroy() {  
	        //System.out.println("销毁代码");
	    }  
	    public void doFilter(ServletRequest request, ServletResponse response,  
	            FilterChain chain) throws IOException, ServletException {  
	    	Map<String,Object>  map=new HashMap<String,Object>();
	    	try{
	        //System.out.println("执行过滤");
	        HttpServletRequest re = (HttpServletRequest)request;
	        HttpServletResponse res=(HttpServletResponse)response;
	        chain.doFilter(re, res);  //调用下一个Filter，如果有的话  
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }  
	    public void init(FilterConfig arg0) throws ServletException {  
	        //System.out.println("初始化代码");
	    }  
	}  

