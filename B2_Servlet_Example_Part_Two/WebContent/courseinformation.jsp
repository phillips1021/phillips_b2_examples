<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.course.*" pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - Course Information">

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
		<a href="index.jsp">Return home</a>.
	</p>

</bbNG:learningSystemPage>