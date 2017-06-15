package com.pinp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pinp.service.UserService;

import com.pinp.utils.AppException;

import com.pinp.model.User;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+password);
		int userId = -1;
		String message = "";
		try {
			UserService userService = new UserService();
			userId = userService.login(name, password);
			System.out.println(userId);
			if (userId >= 0){
				HttpSession session = null;
				session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("userName", name);
				int type = userService.getRole(userId);
				if(type == 1){
					response.sendRedirect("toAdmin");
				}else{
					response.sendRedirect("toOperator");
				}
			}else{
				message = "Incorrect user name or password!";
				request.setAttribute("message", message);
				request.setAttribute("userName", name);	
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			// Redirect to exception page
			response.sendRedirect("toError");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
}
