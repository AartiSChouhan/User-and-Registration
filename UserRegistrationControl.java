package com.fujitsu.loginAndResgister.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.loginAndRegister.DAO.UserRegistrationDao;
import com.fujitsu.loginAndRegister.model.User;

/**
 * Servlet implementation class UserRegistrationControl
 */
@WebServlet("/userRegistration")
public class UserRegistrationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRegistrationDao dao;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		  int phone=Integer.parseInt(request.getParameter("phone"));
	String address = request.getParameter("address");
	
	//Generating Random userId
	Random random=new Random();
	int userId=random.nextInt(999);
     User newUser= new User(userId,username, password,phone,address);
	
//      //Save user in database
   dao=new UserRegistrationDao();
   boolean result=dao.registerUser(newUser);
   if(result){
	   System.out.println("user registered successfully");
	   response.sendRedirect("welcome.jsp");
   }
   else{
	   System.out.println("Internal server error");
   }
   
//		//System.out.println("New User :"+newUser);
//	
//	
	}

}
