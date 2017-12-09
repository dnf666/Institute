package com.im.project.controller.control;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.im.project.manager.PictureMapper;
import com.im.project.model.Picture;
import com.im.project.service.PictureService;
import com.im.project.utils.JSONUtils;

@Controller("backstagepicture")
@RequestMapping("/control/picture")
public class backstagePictureController {
	@Resource
	private PictureService pictureService;
	@Resource
	private PictureMapper pictureDao;
	@RequestMapping("/loadIndex.do")
	public ModelAndView loadIndex(){
		ModelAndView modelAndView = new ModelAndView("control/index");  
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			map=pictureService.loadIndex();
			modelAndView.addObject("map",map);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return modelAndView;
		}
	@RequestMapping(value="/modifyPicture.do",method=RequestMethod.POST)
	public ModelAndView  modifyPicture(Picture p,HttpServletRequest request,
			HttpServletResponse response,@RequestParam("file")CommonsMultipartFile picture) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		String realPath = request.getSession().getServletContext().getRealPath("")+"\\upload/";
		boolean boo=pictureService.addPicture(picture, map, realPath, p.getId(),null,2);
		if(boo){
			try{
			File oldFile=new File(realPath+p.getLink());
			if(oldFile.exists()){
			File newFile=new File(realPath+p.getLink()+"old");
			oldFile.renameTo(newFile);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		JSONUtils.toJSON(map, response);
		 return getPicture(p.getId()); 
		}
	@RequestMapping("/getPicture.do")
	public ModelAndView getPicture(String id,HttpServletRequest request,
			HttpServletResponse response) {
	
		return getPicture(id); 
	}
public 	ModelAndView getPicture(String id){
	ModelAndView modelAndView = new ModelAndView("control/updatePicture"); 
	try{
		Picture p=pictureService.findPicture(id);
		modelAndView.addObject("picture", p);
	}
	catch(Exception e){
	e.printStackTrace();
	}
	return modelAndView; 
}

}
