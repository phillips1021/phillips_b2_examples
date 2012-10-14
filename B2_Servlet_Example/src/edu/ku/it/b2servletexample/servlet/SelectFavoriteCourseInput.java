package edu.ku.it.b2servletexample.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import blackboard.data.course.Course;
import blackboard.data.user.User;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.persist.course.CourseDbLoader;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;
import blackboard.platform.persistence.PersistenceServiceFactory;


/**
 * Controller for getting all the user's courses so the user
 * can select which course is the favorite.
 */
public class SelectFavoriteCourseInput extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(SelectFavoriteCourseInput.class.getName());
	
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
		
		
		try {
			
			ContextManager contextManager = ContextManagerFactory.getInstance();
			
			Context ctx = contextManager.getContext() ;
			
			User user = ctx.getUser() ;
			
		   BbPersistenceManager bbPm = PersistenceServiceFactory.getInstance().getDbPersistenceManager();
		
		   CourseDbLoader courseDbLoader = (CourseDbLoader)bbPm.getLoader(CourseDbLoader.TYPE);
		   
		   List<Course> allCourses = courseDbLoader.loadByUserId( user.getId() ) ;
		   
		   request.setAttribute("allCourses", allCourses) ;

		   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/selectfavoritecourseinput.jsp");
		
		   dispatcher.forward(request, response) ;
		   
		} catch (PersistenceException persistenceException) {
			
			LOGGER.error( persistenceException.getMessage() );
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				
			dispatcher.forward(request, response) ;
			
		}
		
		
	}

}
