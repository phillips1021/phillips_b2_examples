package edu.ku.it.si.b2servletexample.model;

/**
 * Models which Blackboard course
 * is a user's favorite.
 * @author bphillips
 *
 */
public class CourseFavorite {
	
	/**
	 * Blackboard course ID that 
	 * is the user's favorite Blackboard course.
	 */
	private String courseId ;
	
	/**
	 * The blackboard username for
	 * the user.
	 */
	private String username ;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
	
	

}
