<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
	blackboard.data.course.*" pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - User Information"
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
			<bbNG:breadcrumb title="Home" href="index.jsp?course_id=<%=course_id%>" />
			<bbNG:breadcrumb title="User Information" />
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar>
			User Information
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

	<p>User Information</p>

	<p>
		Name: ${user.userName} <br /> <span style="left-margin: 10px">Student
			Id: ${user.studentId} </span> <br /> <span style="left-margin: 10px">Batch
			UID: ${user.batchUid}</span> 
			
	</p>

	<p>
		<a href="index.jsp?course_id=<%=course_id%>">Return home</a>.
	</p>

</bbNG:learningSystemPage>