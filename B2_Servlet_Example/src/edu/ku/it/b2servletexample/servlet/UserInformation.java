package edu.ku.it.b2servletexample.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blackboard.data.user.User;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;

/**
 * Controller for getting information about the logged in user.
 */
public class UserInformation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContextManager contextManager = ContextManagerFactory.getInstance();
		
		Context ctx = contextManager.getContext() ;
		
		User user = ctx.getUser() ;
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userinformation.jsp");
		
		dispatcher.forward(request, response) ;
		
	}

}
