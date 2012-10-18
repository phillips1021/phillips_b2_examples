<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.course.*" pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - Course Information"
	ctxId="ctx">

	<%
	//use the Context object to get the Course the user is currently viewing
	Course course = ctx.getCourse();
	
	//Get the course_id value so it can be used as the value for the query string parameter below
	String course_id = course.getId().toExternalString() ;

	%>

	<bbNG:pageHeader>
		<bbNG:breadcrumbBar environment="COURSE"
			navItem="course_plugin_manage" >
			<bbNG:breadcrumb title="Home" href="index.jsp" />
			<bbNG:breadcrumb title="Course Information" />
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar>
			Course Information
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

	<p>Course Information</p>

	<p style="margin-left:10px">Course Title: ${course.title} <br />
		 Course Id: ${course.courseId} <br />
		 Course	Batch UID: ${course.batchUid} <br />
	     Course Is Available: ${course.isAvailable} 
			
	</p>

	<p>
		<a href="index.jsp?course_id=<%=course_id%>">Return home</a>.
	</p>

</bbNG:learningSystemPage>