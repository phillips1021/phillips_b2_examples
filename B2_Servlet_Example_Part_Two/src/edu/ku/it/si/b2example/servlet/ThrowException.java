package edu.ku.it.si.b2example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Controller for demonstrating result of an 
 * unhandled exception.
 */
public class ThrowException extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = LoggerFactory.getLogger(ThrowException.class );

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
		
		LOGGER.error("About to throw exception...");
		
		throw new NullPointerException("Oh no! A null pointer excepton was thrown.") ;

	}

}
