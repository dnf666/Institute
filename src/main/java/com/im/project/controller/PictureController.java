package com.im.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.im.project.service.PictureService;

@Controller("picture")
@RequestMapping("static/picture")
public class PictureController {
	@Resource
	private PictureService pictureService;
	
	@RequestMapping("/loadBigPic.do")
	public Map<String,Object> loadBigPic(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		List<String> logoList=pictureService.loadBigPic();
		map.put("data",logoList);
		return map;
	}
}
