<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
	blackboard.data.course.*" pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - Confirm Email Address Change"
	ctxId="ctx">

<!-- note the breadcrumb href value uses the Context object 
referred to by the variable ctx to get the current course ID 
value -->
	<bbNG:pageHeader>
		<bbNG:breadcrumbBar environment="COURSE"
			navItem="course_plugin_manage" >
			<bbNG:breadcrumb title="Home" href="index.jsp" />
			<bbNG:breadcrumb title="Confirm Email Address Change" />
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar>
			User Information
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>



<bbNG:actionControlBar>

	<bbNG:actionButton url="UpdateEmailAction" title="Confirm Email Change"/>

</bbNG:actionControlBar>




<p>Press the above Confirm Email Change button to make the change to your email address.</p>

<p style="margin-left:10px">Name: ${user.userName} <br /> 
			<b>New Email Address: </b>	 ${user.emailAddress }	
</p>

</bbNG:learningSystemPage>