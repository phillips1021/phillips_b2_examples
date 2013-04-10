package edu.ku.it.si.b2example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blackboard.data.course.Course;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;

/**
 * Controller for getting information about
 * the logged in user.
 */
public class CourseInformation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseInformation.class);
       
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
		
		String course_id = request.getParameter("course_id");
		
		LOGGER.info("course_id value is " + course_id);
		
		ContextManager contextManager = ContextManagerFactory.getInstance();
		
		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/platform/context/Context.html
		 */
		Context ctx = contextManager.getContext() ;
		
		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/data/course/Course.html
		 */
		Course course = ctx.getCourse() ;
		
		if (course != null) {
			
			LOGGER.info("Title of course retrieved using Context is " + course.getTitle() );
		
		} else{
			
			LOGGER.warn("No course was retrieved using Context.");
			
			throw new IllegalStateException("No course was retrieved using Context.");
		}
		
		request.setAttribute("course", course);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/courseinformation.jsp");
		
		dispatcher.forward(request, response) ;
		
	}

}
