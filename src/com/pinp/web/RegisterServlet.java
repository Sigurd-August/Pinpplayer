package com.pinp.web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinp.model.User;
import com.pinp.service.UserService;
import com.pinp.utils.AppException;

import com.pinp.utils.MailUtil;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RegisterServlet");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("rname");
		String password = request.getParameter("rpassword");
		String email = request.getParameter("email");
		boolean flag = false;
		String message = "";
		try{
			User user = new User();
			UserService userService = new UserService();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user = MailUtil.activateMail(user);
			// Call business logic layer for user registration 
			userService.register(user);
			flag = true;	
			if(flag){
				message = "Please go to your emailbox to check the activated mail!";
				request.setAttribute("message", message); // Save prompt message into request 
				// Forward to the registration page
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}else{
				message = "Registration failed";
				request.setAttribute("message", message); // Save prompt message into request 
				// Forward to the registration page
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			// Redirect to the exception page
			response.sendRedirect("toError");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
}
