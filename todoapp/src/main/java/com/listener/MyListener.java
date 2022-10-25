package com.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entities.Todo;

public class MyListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
	
	}

	public void contextInitialized(ServletContextEvent arg0) {
	System.out.println("Context created");
	List<Todo> list = new ArrayList<Todo>();
	ServletContext context = arg0.getServletContext();
	context.setAttribute("list",list);
	
	}

}
