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

import com.im.project.manager.MemberMapper;
import com.im.project.model.Member;
import com.im.project.service.MemberService;
import com.im.project.service.PictureService;
import com.im.project.utils.JSONUtils;

@Controller("backstageMember")
@RequestMapping("/control/member")
public class backstageMemberController {
	@Resource
	private MemberMapper memberDao;
	@Resource 
	private PictureService pictureService;
	@Resource
	private MemberService memberService;
	@RequestMapping("/addMember.do")
	public ModelAndView addMember(Member m,HttpServletRequest request,
			HttpServletResponse response,@RequestParam("file")  CommonsMultipartFile picture) throws Exception{
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/members");  
	String fileId=UUID.randomUUID().toString();
	String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
	boolean boo1=pictureService.addPicture(picture, map, realPath, fileId,"成员",1);
	if(!boo1){
		JSONUtils.toJSON(map, response);
		return modelAndView;     
	}
	m.setPictureId(fileId);
	 try{
		 boolean boo=memberService.addMember(m);
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
	@RequestMapping("/delMember.do")
	public ModelAndView delMember(String pictureId,int id,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/members");  
		
		 try{
			 boolean boo=memberService.delMember(id, pictureId);
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
	@RequestMapping("/modifyMember.do")
	public ModelAndView modifyMember(Member m,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/members");  
		 try{
			 int i=memberDao.updateByPrimaryKey(m);
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
	@RequestMapping("/getMembers.do")
	public ModelAndView getMembers(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("control/members"); 
		try{
		ArrayList<Member> list=(ArrayList<Member>)memberDao.selectAll();
		 modelAndView.addObject("list", list); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	     return modelAndView;   
		}
	
}
