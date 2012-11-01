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
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.KeyNotFoundException;
import blackboard.persist.PersistenceException;
import blackboard.persist.course.CourseDbLoader;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;
import blackboard.platform.persistence.PersistenceServiceFactory;

/**
 * Get the child course(s) the user selected on the view page and forward user
 * to the confirm view page.
 */
public class SelectChildCoursesConfirm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger
			.getLogger(SelectChildCoursesConfirm.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			ContextManager contextManager = ContextManagerFactory.getInstance();

			/*
			 * See:
			 * http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d
			 * 7ea0a17c/blackboard/platform/context/Context.html
			 */
			Context ctx = contextManager.getContext();

			/*
			 * See:
			 * http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d
			 * 7ea0a17c/blackboard/data/course/Course.html
			 */
			Course course = ctx.getCourse();

			if (course != null) {

				LOGGER.info("Title of parent course retrieved using Context is "
						+ course.getTitle());

			} else {

				LOGGER.warn("No course was retrieved using Context.");

				throw new IllegalStateException(
						"No course was retrieved using Context. Unable to identify the parent course.");
			}

			List<Course> childCourseList = getChildCourses(request, course);

			request.setAttribute("childCourses", childCourseList);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/selectchildcoursesconfirm.jsp");

			dispatcher.forward(request, response);

		} catch (PersistenceException ex) {

			LOGGER.error(ex.getMessage());

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/error.jsp");

			dispatcher.forward(request, response);

		}

	}

	
	/**
	 * Get a collection of Course objects that represent
	 * the Blackboard courses selected by the user
	 * to merge with the parent course.
	 * @param request - HTTPServletRequest - holds the selected course IDs.
	 * @param course - Parent course
	 * @return Collection of Course objects that represent the child Courses
	 * to merge with the parent course.
	 * @throws PersistenceException
	 * @throws KeyNotFoundException
	 */
	private List<Course> getChildCourses(HttpServletRequest request,
			Course course) throws PersistenceException, KeyNotFoundException {
		
		BbPersistenceManager bbPm = PersistenceServiceFactory.getInstance()
				.getDbPersistenceManager();

		CourseDbLoader courseDbLoader = (CourseDbLoader) bbPm
				.getLoader(CourseDbLoader.TYPE);

		String[] selectedCourseIdArray = request
				.getParameterValues("selectedCourseId");

		List<Course> childCourseList = new ArrayList<Course>();

		for (String courseId : selectedCourseIdArray) {

			LOGGER.info("User selected " + courseId
					+ " as a child course to merge with parent course "
					+ course.getCourseId());

			Course aCourse = courseDbLoader.loadByCourseId(courseId);

			childCourseList.add(aCourse);

		}
		return childCourseList;
	}

}
