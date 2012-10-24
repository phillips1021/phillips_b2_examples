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

import edu.ku.it.si.b2example.dao.TotalLoginsDao;

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
		
		String endDateStr = request.getParameter("dateRange_end_datetime");
		
		LOGGER.info("User provided start date is " + startDateStr);
		
		LOGGER.info("User provided end date is " + endDateStr);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			
			Date startDate = sdf1.parse(startDateStr);
			
			Date endDate = sdf1.parse(endDateStr);
			
			LOGGER.info("After converting the start date String to a Date the value is " + startDate.toString() );
			
			LOGGER.info("After converting the end date String to a Date the value is " + endDate.toString() );
			
			TotalLoginsDao totalLoginsDao = new TotalLoginsDao() ;
			
			int totalLogins = totalLoginsDao.getTotalLogins(startDate, endDate);
			
			LOGGER.info("Total unique logins between " + startDate + " and " + endDate + " were " + totalLogins);
			
			request.setAttribute("startDate", startDate);
			
			request.setAttribute("endDate", endDate);
			
			request.setAttribute("totalLogins", totalLogins);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/totalLogins.jsp");
			
			dispatcher.forward(request, response) ;
			
		} catch (ParseException e) {

			LOGGER.error("Unable to create Date object using " + startDateStr + " or using " + endDateStr);
			
			throw new IllegalStateException("Unable to create start and/or end Date objects.");
		}
		

		
	}

}
