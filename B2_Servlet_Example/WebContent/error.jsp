<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" isErrorPage="true" %>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - Error Page">

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Error Page
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

<p style="color:red">There was an error processing your request.</p>

<p>Please contact the Blackboard System Administrator.</p>

<p>The error may be logged in blackboard/logs/tomcat/stdout-stderr-XXXXXXXX.log 
on your Blackboard application server.</p>

</bbNG:learningSystemPage>