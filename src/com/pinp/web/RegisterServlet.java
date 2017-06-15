package com.pinp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinp.model.User;
import com.pinp.service.UserService;
import com.pinp.utils.AppException;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RegisterServlet");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("rname");
		String password = request.getParameter("rpassword");
		boolean flag = false;
		String message = "";
		try{
			User user = new User("Mu","123456");
			UserService userService = new UserService();
			user.setName(name);
			user.setPassword(password);
			flag = userService.register(user);
			if(flag){
				message = "Succeed in register";
				System.out.println(message);
				request.setAttribute("message", message);
				response.sendRedirect("toLogin");
			}else{
				message = "fail in register";
				System.out.println(message);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			// Redirect to the exception page
			response.sendRedirect("toError");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
}
