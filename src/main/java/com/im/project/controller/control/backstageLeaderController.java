package com.im.project.controller.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.manager.LeaderMapper;
import com.im.project.model.Leader;
import com.im.project.service.LeaderService;
import com.im.project.service.PictureService;
import com.im.project.utils.JSONUtils;

@Controller("backstageLeader")
@RequestMapping("/control/leader")
public class backstageLeaderController {
	@Resource
	private LeaderMapper leaderDao;
	@Resource
	private PictureService pictureService;
	@Resource
	private LeaderService leaderService;
	@RequestMapping("/addLeader.do")
	public ModelAndView addLeader(Leader l,HttpServletRequest request,
			HttpServletResponse response,@RequestParam("file")  CommonsMultipartFile picture) throws Exception{
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/leader");  
	String fileId=UUID.randomUUID().toString();
	String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
	boolean boo1=pictureService.addPicture(picture, map, realPath, fileId,"带头人",1);
	if(!boo1){
		JSONUtils.toJSON(map, response);
		return modelAndView;     
	}
	l.setPictureId(fileId);
	 try{
		 boolean boo=leaderService.addLeader(l);
		 if(boo){
			 map.put("msg", "success");  
		 }
		 else{
			 map.put("msg", "failed");   
		 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 map.put("msg", "failed");   
		 }
	 JSONUtils.toJSON(map, response);
     return modelAndView;   
	}
	@RequestMapping("/delLeader.do")
	public ModelAndView delLeader(String pictureId,int id,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/leader");  
		 try{
			 boolean boo=leaderService.delLeader(id, pictureId);
			 if(boo){
				 map.put("msg", "success");  
			 }
			 else{
				 map.put("msg", "failed");   
			 }
			 }
			 catch(Exception e){
				 e.printStackTrace();
				 map.put("msg", "failed");   
			 }
		 JSONUtils.toJSON(map, response);
	     return modelAndView;   
		}
	@RequestMapping("/modifyLeader.do")
	public ModelAndView modifyLeader(Leader l,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/leader");  
		 try{
			int i=leaderDao.updateByPrimaryKey(l);
		 if(i==1){
			 map.put("msg", "success");  
		 }
		 else{
			 map.put("msg", "failed");   
		 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 map.put("msg", "failed");   
		 }
		 JSONUtils.toJSON(map, response);
	     return modelAndView;   
		}
	@RequestMapping("/getLeaders.do")
	public ModelAndView getLeaders(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("control/leader"); 
		try{
		ArrayList<Leader> list=(ArrayList<Leader>)leaderDao.selectAll();
		 modelAndView.addObject("list", list); 
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	     return modelAndView;   
		}
}
	
