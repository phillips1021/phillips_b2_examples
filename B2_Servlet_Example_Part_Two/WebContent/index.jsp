<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development Part Two - Home Page">

	<bbNG:pageHeader>

		<bbNG:pageTitleBar>
			Home Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>

	<p>Welcome to Blackboard Building Block Development Part Two</p>
	
	<p><a href="UserInformation">Get information</a> about the logged in Blackboard user.</p>

    <!-- 4129-10161 is a course id value in my Blackboard.  I'm hard coding the course id
    for now to test. -->
	<p><a href="CourseInformation?course_id=4129-10161">Get information</a> about this course.</p>

	<p><a href="ThrowException">Throw exception</a>.</p>

</bbNG:learningSystemPage>