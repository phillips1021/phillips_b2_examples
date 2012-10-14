<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*" pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - User Information">

	<bbNG:pageHeader>
		<bbNG:breadcrumbBar environment="COURSE"
			navItem="course_plugin_manage" >
			<bbNG:breadcrumb title="Home" href="index.jsp" />
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
		<a href="index.jsp">Return home</a>.
	</p>

</bbNG:learningSystemPage>