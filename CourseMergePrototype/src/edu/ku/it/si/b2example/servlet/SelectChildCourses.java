package edu.ku.it.si.b2example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import blackboard.data.course.Course;
import blackboard.data.course.CourseCourseManager;
import blackboard.data.course.CourseCourseManagerFactory;
import blackboard.data.course.CourseMembership.Role;
import blackboard.data.user.User;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.KeyNotFoundException;
import blackboard.persist.PersistenceException;
import blackboard.persist.course.CourseDbLoader;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;
import blackboard.platform.persistence.PersistenceServiceFactory;

/**
 * Get all courses the user is an instructor of (not including 
 * the parent course) and that 
 * are in the same term as the parent course (the parent
 * course is the course the user is currently viewing) 
 * and the course is not already a child of a
 * parent course.
 */
public class SelectChildCourses extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(SelectChildCourses.class.getName() );
       


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
				
				LOGGER.info("Title of parent course retrieved using Context is " + course.getTitle() );
			
			} else {
				
				LOGGER.warn("No course was retrieved using Context.");
				
				throw new IllegalStateException("No course was retrieved using Context. Unable to identify the parent course.");
			}
			
			/*
			 * Get the KU term code (e.g. 4132) for the
			 * parent course.  The term code is the 
			 * first part of the course id (e.g. 4132-12345).
			 * This needed to implement the business rule
			 * that the parent and child must be in the 
			 * same term.
			 */
			String parentCourseId = course.getCourseId();
			
			String parentCourseTerm = parentCourseId.split("-")[0];
			
			LOGGER.info("Term value for parent course is " + parentCourseTerm);
			
			User user = ctx.getUser() ;
			
		   List<Course> allCourses = getCourses(parentCourseId, parentCourseTerm,
				user);
		   
 		   request.setAttribute("allCourses", allCourses) ;

		   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/selectchildcoursesinput.jsp");
		
		   dispatcher.forward(request, response) ;
		   
		} catch (PersistenceException persistenceException) {
			
			LOGGER.error( persistenceException.getMessage() );
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				
			dispatcher.forward(request, response) ;
			
		}
		
	}

	/**
	 * Get those Courses where the provided 
	 * user is the instructor, the course ID
	 * does not match the parent course ID,
	 * and the course term does match
	 * the parent course term and the course 
	 * is not already a child of another 
	 * parent course.
	 * @param parentCourseId 
	 * @param parentCourseTerm (e.g. 4132, 4-digit KU Term code)
	 * @param user Blackboard user
	 * @return Collection of Course objects
	 * @throws PersistenceException
	 * @throws KeyNotFoundException
	 */
	private List<Course> getCourses(String parentCourseId,
			String parentCourseTerm, User user) throws PersistenceException,
			KeyNotFoundException {
		BbPersistenceManager bbPm = PersistenceServiceFactory.getInstance().getDbPersistenceManager();
		
		   CourseDbLoader courseDbLoader = (CourseDbLoader)bbPm.getLoader(CourseDbLoader.TYPE);
		   
		   /*
		    * Get only those Blackboard courses where the user is the instructor.
		    * http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/persist/course/CourseDbLoader.html
		    */
		   List<Course> allCourses = courseDbLoader.loadByUserIdAndCourseMembershipRole(user.getId(), Role.INSTRUCTOR ) ;
		   
		   
		   CourseCourseManager courseCourseManager = CourseCourseManagerFactory.getInstance() ;
		   
		   /*
		    * Create a collection of Course objects that are in the above collection
		    * that do NOT match the KU term code of the parent course and 
		    * do match the parent course's course ID.  Also checks to make sure that the course is
		    * not already a parent or child of another course.  This collection of courses
		    * will be removed from the collection of courses being returned
		    * by the method.
		    */
		   List<Course> coursesNotInParentCourseTerm = new ArrayList<Course>();
		   
		   for (Course aCourse : allCourses) {
			   
			   String aCourseId = aCourse.getCourseId() ;
			   
			   String aCourseTerm = aCourseId.split("-")[0];
			   
			   if ( ! parentCourseTerm.equals(aCourseTerm) || parentCourseId.equals(aCourseId)
					   || courseCourseManager.isCourseCrossListed(aCourse.getId())) {
				   
				   coursesNotInParentCourseTerm.add(aCourse) ;
				   
			   }

		   }
		   
		   allCourses.removeAll(coursesNotInParentCourseTerm);
		   
		   return allCourses;
		   
	}

}
