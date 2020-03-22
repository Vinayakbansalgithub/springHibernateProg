package com.mvc.springHibernateProg;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	ServletConfig config=null;  
	  
	public void init(ServletConfig config){  
	this.config=config;  
	System.out.println("servlet is initialized");  
	}  
	  
	public void service(ServletRequest req,ServletResponse res)  
	throws IOException,ServletException{  
		
		System.out.println("Service method is called");
	  
	res.setContentType("text/html");  
	  
	PrintWriter out=res.getWriter();  
	out.print("<html><body>");  
	out.print("<b>hello simple servlet</b>");  
	out.print("</body></html>");  
	  
	}  
	public void destroy(){System.out.println("servlet is destroyed");}  
	public ServletConfig getServletConfig(){return config;}  
	public String getServletInfo(){return "copyright 2007-1010";}  
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Vinayak Bansal");
	}
	  
	}  