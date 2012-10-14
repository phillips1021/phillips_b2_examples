package edu.ku.it.b2servletexample.servlet;

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

import edu.ku.it.si.b2servletexample.dao.CourseFavoriteLoader;
import edu.ku.it.si.b2servletexample.dao.CourseFavoritePersister;
import edu.ku.it.si.b2servletexample.model.CourseFavorite;

/**
 * Controller for saving the user selected favorite course.
 */
public class SelectFavoriteCourseAction extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(SelectFavoriteCourseAction.class.getName());
	
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
		
		String [] selectedCourseIdArray = request.getParameterValues("selectedCourseId");
		
		String selectedCourseId = selectedCourseIdArray[0];
		
		LOGGER.info("User selected this course id: " + selectedCourseId);
		
		ContextManager contextManager = ContextManagerFactory.getInstance();
		
		Context ctx = contextManager.getContext() ;
		
		User user = ctx.getUser() ;
		
		request.setAttribute("user", user);
		
		CourseFavoritePersister courseFavoritePersister = new CourseFavoritePersister();
		
		courseFavoritePersister.deleteCourseFavorite( user.getUserName() );
	    
	    boolean saveResult = courseFavoritePersister.saveCourseFavorite(user.getUserName(), selectedCourseId) ;
	    

	    
	    if (saveResult == true ) {
	    	
			 CourseFavoriteLoader courseFavoriteLoader = new CourseFavoriteLoader() ;
			    
			 CourseFavorite courseFavorite = courseFavoriteLoader.loadCourseFavorite( user.getUserName() );
			 
			 request.setAttribute("courseFavorite", courseFavorite);
			
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/favoritecourse.jsp");
	    	
	    	dispatcher.forward(request, response) ;
	    	
	    } else {
	    	
	    	LOGGER.error("Unable to save course favorite.");
	    	
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
	    	
	    	dispatcher.forward(request, response) ;
	    	

	    	
	    }
		
   
		   
		
		
		
	}

}
