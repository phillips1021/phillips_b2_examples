package edu.ku.it.si.b2example.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			
			Date date = sdf1.parse(startDateStr);
			
			LOGGER.info("After converting the String to a Date the value is " + date.toString() );
			
		} catch (ParseException e) {

			LOGGER.error("Unable to create Date object using: " + startDateStr);
			
			throw new IllegalStateException("Unable to create Date object.");
		}
		
		request.setAttribute("startDate", startDateStr);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/totalLogins.jsp");
		
		dispatcher.forward(request, response) ;
		
		
	}

}
