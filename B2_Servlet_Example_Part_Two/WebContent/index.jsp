<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	import="java.util.*,
				blackboard.data.*,
				blackboard.data.user.*,
				blackboard.data.course.*"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development Part Two - Home Page" 
	ctxId="ctx">

	<bbNG:pageHeader>

		<bbNG:pageTitleBar>
			Home Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>

	<p>Welcome to Blackboard Building Block Development Part Two</p>

    <!-- note the href value uses the Context object 
referred to by the variable ctx to get the current course ID 
value -->	
	<p><a href="UserInformation?course_id=${ctx.courseId.externalString}">Get information</a> about the logged in Blackboard user.</p>

	<p><a href="CourseInformation?course_id=${ctx.courseId.externalString}">Get information</a> about this course.</p>

	<p><a href="ThrowException">Throw exception</a>.</p>

</bbNG:learningSystemPage>