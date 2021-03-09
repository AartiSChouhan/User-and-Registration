package com.fujitsu.loginAndResgister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("aarti@gmail.com")&&password.equals("aarti")){
			HttpSession session=request.getSession();
			session.setAttribute("user",username);
			response.sendRedirect("welcome.jsp");
			System.out.println("U have logged in");
			}
		else{
			response.sendRedirect("login.jsp");
			System.out.println("not logged");
		}
	}

	
}
