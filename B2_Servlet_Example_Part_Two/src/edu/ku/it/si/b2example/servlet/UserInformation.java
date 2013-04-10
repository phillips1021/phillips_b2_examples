package edu.ku.it.si.b2example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blackboard.data.user.User;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;

/**
 * Controller for getting information about
 * the logged in user.
 */
public class UserInformation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger( UserInformation.class );
       
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
		
		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/platform/context/Context.html
		 */
		Context ctx = contextManager.getContext() ;
		
		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/data/user/User.html
		 */
		User user = ctx.getUser() ;
		
		LOGGER.info("User is " + user.getGivenName() + " " + user.getFamilyName() );
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userinformation.jsp");
		
		dispatcher.forward(request, response) ;
		
	}

}
