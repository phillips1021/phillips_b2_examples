<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	import="java.util.*,
				blackboard.data.*,
				blackboard.data.user.*,
				blackboard.data.course.*"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development Part Two - Home Page" ctxId="ctx">
	
	<%
	//use the Context object to get the Course the user is currently viewing
	Course course = ctx.getCourse();
	
	//Get the course_id value so it can be used as the value for the query string parameter below
	String course_id = course.getId().toExternalString() ;

	%>

	<bbNG:pageHeader>

		<bbNG:pageTitleBar>
			Home Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>

	<p>Welcome to Blackboard Building Block Development Part Two</p>
	
	<p><a href="UserInformation?course_id=<%=course_id%>">Get information</a> about the logged in Blackboard user.</p>

    <!-- see above for how course_id is assigned a value -->
	<p><a href="CourseInformation?course_id=<%=course_id%>">Get information</a> about this course.</p>

	<p><a href="ThrowException">Throw exception</a>.</p>

</bbNG:learningSystemPage>