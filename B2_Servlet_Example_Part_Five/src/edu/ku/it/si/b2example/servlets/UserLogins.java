package edu.ku.it.si.b2example.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Using the start and end dates the user provided
 * get the total number of unique logins.
 */
public class UserLogins extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(UserLogins.class.getName() );
       


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
		
		String startDateStr = request.getParameter("dateRange_start_datetime");
		
		LOGGER.info("User provided start date is " + startDateStr);
		
		request.setAttribute("startDate", startDateStr);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/totalLogins.jsp");
		
		dispatcher.forward(request, response) ;
		
		
	}

}
