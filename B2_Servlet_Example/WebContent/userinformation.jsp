<%@ page language="java" contentType="text/html; charset=US-ASCII"
    import="blackboard.data.user.*"
	pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - User Information">

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			User Information
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

	<p>User Information</p>
	
	<p>Name: ${user.userName} </p>

</bbNG:learningSystemPage>