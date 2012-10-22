package edu.ku.it.si.b2example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import blackboard.data.ValidationException;
import blackboard.data.user.User;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.persist.user.UserDbPersister;
import blackboard.platform.context.Context;
import blackboard.platform.context.ContextManager;
import blackboard.platform.context.ContextManagerFactory;
import blackboard.platform.persistence.PersistenceServiceFactory;

/**
 * Controller that persists the User object that has the new email address to
 * the Blackboard database.
 */
public class UpdateEmailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger
			.getLogger(UpdateEmailAction.class.getName());

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

		ContextManager contextManager = ContextManagerFactory.getInstance();

		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/platform/context/Context.html
		 */
		Context ctx = contextManager.getContext();

		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/data/user/User.html
		 */
		User user = ctx.getUser();

		/*
		 * See: http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/persist/BbPersistenceManager.html
		 */
		BbPersistenceManager pm = PersistenceServiceFactory.getInstance()
				.getDbPersistenceManager();

		try {

			/*
			 * See:
			 * http://library.blackboard.com/ref/598135ae-501e-46f6-9910-190d7ea0a17c/blackboard/persist/user/UserDbPersister.html
			 */
			UserDbPersister persister = (UserDbPersister) pm
					.getPersister(UserDbPersister.TYPE);

			/*
			 * See all the permission settings in bb-manifest.xml for what
			 * permissions are needed in order to persist a user.
			 */
			persister.persist(user);

		} catch (PersistenceException e) {

			LOGGER.error(e.getMessage());

			throw new IllegalStateException("Unable to save new email address.");

		} catch (ValidationException e) {

			LOGGER.error(e.getMessage());

			throw new IllegalStateException("Unable to save new email address.");
		}

		LOGGER.info("Email address changed to " + user.getEmailAddress());

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/index.jsp");

		dispatcher.forward(request, response);

	}

}
