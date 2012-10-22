package edu.ku.it.si.b2example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import blackboard.data.user.User;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;

/**
 * Controller for updating the email address in the User object 
 * that is in the Context and then forwarding the user to
 * the confirm email change page.
 */
public class UpdateEmail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger( UpdateEmail.class.getName() ) ;
       
  
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
		
		String newEmailAddress = request.getParameter("email");
		
		LOGGER.info("New email address is " + newEmailAddress);
		
		ContextManager contextManager = ContextManagerFactory.getInstance();
		
		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/platform/context/Context.html
		 */
		Context ctx = contextManager.getContext() ;
		
		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/data/user/User.html
		 */
		User user = ctx.getUser() ;
		
		/*
		 * Note to update a value the bb-manifest.xml must have set permission
		 * for user.personalinfo
		 */
		user.setEmailAddress(newEmailAddress);
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmEmailAddressChange.jsp");
		
		dispatcher.forward(request, response) ;
		
	}

}
