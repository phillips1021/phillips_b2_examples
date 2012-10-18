<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
	blackboard.data.course.*" pageEncoding="US-ASCII"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - User Information"
	ctxId="ctx">

<!-- note the breadcrumb href value uses the Context object 
referred to by the variable ctx to get the current course ID 
value -->
	<bbNG:pageHeader>
		<bbNG:breadcrumbBar environment="COURSE"
			navItem="course_plugin_manage" >
			<bbNG:breadcrumb title="Home" href="index.jsp?course_id=${ctx.courseId.externalString}" />
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

<!-- note the href value uses the Context object 
referred to by the variable ctx to get the current course ID 
value -->
<p><a href="index.jsp?course_id=${ctx.courseId.externalString}">Return home</a>.
	</p>

</bbNG:learningSystemPage>