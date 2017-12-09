package com.im.project.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.im.project.service.PictureService;

public class CleanPicture implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"classpath:spring-mybatis.xml");
		PictureService pictureService=(PictureService) appContext.getBean("pictureService");
		//System.out.println(pictureService);
		while (true) {
			try {
				Thread.sleep(5*1000*60*60*24*30);
				pictureService.cleanPicture();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
