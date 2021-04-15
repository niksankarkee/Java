package com.niksan;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServerException, ServletException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<h1>Welcome to register Servlet</h1>");
		
		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		String email = req.getParameter("user_email");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");
		String checked = req.getParameter("checked");
		
		///
		///JDBC
		///
		
		// Saved to db
		RequestDispatcher rd = req.getRequestDispatcher("success");
		
		rd.forward(req, res);
		
		if(checked != null) {
			out.println("<h2>Your Name is: </h2>" + "<h3>" + name + "</h3>");
			out.println("<h2>Your Password is: </h2>" + "<h3>" + password + "</h3>");
			out.println("<h2>Your Email is: </h2>" + "<h3>" + email + "</h3>");
			out.println("<h2>Your Gender is: </h2>" + "<h3>" + gender + "</h3>");
			out.println("<h2>Your Course is: </h2>" + "<h3>" + course + "</h3>");

		}else {
			out.println("<h3>You didn't agreed with our terms and condition please check terms & conditions</h3>");
//			include output of index.html
			
//			get the object of RequestDispatcher
			
			 rd = req.getRequestDispatcher("index.html");
			
//			include
			rd.include(req, res);
		}
		
	}

}
