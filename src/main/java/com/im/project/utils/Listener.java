package com.im.project.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.im.project.model.ReturnStatus;
@Aspect
@Component
public class Listener{
	
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		Map<String,Object> map=new HashMap<String,Object>();
		HttpServletResponse response = null;
		Object[] o=pjp.getArgs();
		for(Object o1:o){
			if(o1 instanceof HttpServletResponse){
			response=(HttpServletResponse)o1;
			}
		}
		try{
		Object object = pjp.proceed();
		map.put("data",object);
		map.put("msg", "success");
		map.put("status",ReturnStatus.SUCCSS);
		}
		catch(Exception e){
			map.put("data", null);
			map.put("msg", "error");
			map.put("status", ReturnStatus.ERROR);
			e.printStackTrace();
		}
		  JSONUtils.toJSON(map, response);
	}
}
