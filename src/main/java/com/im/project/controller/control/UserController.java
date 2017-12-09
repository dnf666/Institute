package com.im.project.controller.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.model.User;
import com.im.project.service.UserService;
import com.im.project.utils.JSONUtils;

@Controller("userController")
@RequestMapping("/control")
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private backstagePictureController   backstagepicture;
	@RequestMapping("/user/login.do")
    public ModelAndView login(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/login"); 
		if(user.getPassword()=="" ||user.getUserName()==""){
			map.put("msg", "有值为空！");
			JSONUtils.toJSON(map, response);
			return modelAndView;
		}
		
		try{
		boolean boo=userService.login(user);
		if(boo){
			request.getSession().setAttribute("username",user.getUserName());
			map.put("msg","success");
			//return backstagepicture.loadIndex();
		}
		else{
			map.put("msg", "用户名或密码不正确");
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
			map.put("msg", "failed");
		}
		JSONUtils.toJSON(map, response);
		return modelAndView;
	 }
	
	@RequestMapping("/signOut.do")
    public ModelAndView signOut(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView("control/login"); 
		String username=(String) request.getSession().getAttribute("username");
		if(username!=null){
			request.getSession().removeAttribute("username");
		}
		return modelAndView;
	 }
	
}
