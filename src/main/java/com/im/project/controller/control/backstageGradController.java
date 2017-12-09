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

import com.im.project.manager.GradMapper;
import com.im.project.model.Grad;
import com.im.project.service.GradService;
import com.im.project.service.PictureService;
import com.im.project.utils.JSONUtils;

@Controller("backstageGrad")
@RequestMapping("/control/grad")
public class backstageGradController {
	@Resource
	private GradService gradService;
	@Resource
	GradMapper gradDao;
	@Resource
	private PictureService pictureService;
	@RequestMapping("/addGrad.do")
	public ModelAndView addGrad(Grad g,HttpServletRequest request,
			HttpServletResponse response,@RequestParam("file")  CommonsMultipartFile picture) throws Exception{
	Map<String,Object> map=new HashMap<String,Object>();
	ModelAndView modelAndView = new ModelAndView("control/grads");  
	String fileId=UUID.randomUUID().toString();
	String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
	boolean boo1=pictureService.addPicture(picture, map, realPath, fileId,"毕业成员",1);
	if(!boo1){
		JSONUtils.toJSON(map, response);
		return modelAndView;     
	}
	g.setPictureId(fileId);
	 try{
		boolean boo=gradService.addGrad(g);
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
	@RequestMapping("/delGrad.do")
	public ModelAndView delGrad(String pictureId,int id,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/grads");  
		 try{
			 boolean boo=gradService.delGrad(id, pictureId);
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
	@RequestMapping("/modifyGrad.do")
	public ModelAndView modifyGrad(Grad g,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/grads");  
		 try{
			 boolean boo=gradService.modifyGrad(g);
		 if(boo){
			 map.put("msg", "success");  
		 }
		 else{
			 map.put("msg", "failed");   
		 }}
		 catch(Exception e){
			 e.printStackTrace(); 
			 map.put("msg", "failed"); 
		 }
		 JSONUtils.toJSON(map, response);
	     return modelAndView;   
		}
	@RequestMapping("/getGrads.do")
	public ModelAndView getGrads(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("control/grads"); 
		try{
		ArrayList<Grad> list=(ArrayList<Grad>)gradDao.selectAll();
		 modelAndView.addObject("list", list); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	     return modelAndView;   
		}
	@RequestMapping("/getPostGrads.do")
	public ModelAndView getPostGrads(HttpServletRequest request,
								 HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("control/postgrads");
		try{
			ArrayList<Grad> list=(ArrayList<Grad>)gradDao.selectAllPostGrads();
			modelAndView.addObject("list", list);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	@RequestMapping("/addPostGrad.do")
	public ModelAndView addPostGrad(Grad g,HttpServletRequest request,
								HttpServletResponse response,@RequestParam("file")  CommonsMultipartFile picture) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/postgrads");
		String fileId=UUID.randomUUID().toString();
		String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
		boolean boo1=pictureService.addPicture(picture, map, realPath, fileId,"研究生",1);
		if(!boo1){
			JSONUtils.toJSON(map, response);
			return modelAndView;
		}
		g.setPictureId(fileId);
		try{
			boolean boo=gradService.addPostGrad(g);
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
	@RequestMapping("/delPostGrad.do")
	public ModelAndView delPostGrad(String pictureId,int id,HttpServletRequest request,
								HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/postgrads");
		try{
			boolean boo=gradService.delPostGrad(id, pictureId);
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
	@RequestMapping("/modifyPostGrad.do")
	public ModelAndView modifyPostGrad(Grad g,HttpServletRequest request,
								   HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView("control/postgrads");
		try{
			boolean boo=gradService.modifyPostGrad(g);
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
}
