package com.im.project.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenWeb implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//System.out.println("web   start");
		new Thread(new CleanPicture()).start();;
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	

}
