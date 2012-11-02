<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
	edu.ku.it.si.b2example.*,
	blackboard.platform.plugin.*,
    blackboard.data.course.*"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Blackboard Course Merge - Courses Merged" ctxId="ctx">
	
	    <%
    	final String jsUrl = PlugInUtil.getUri(BuildingBlockHelper.VENDOR_ID,BuildingBlockHelper.HANDLE, "script/moreHelp.js");
	%>

<bbNG:jsFile href="<%=jsUrl%>"/>

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Course Merge - Courses Merged Successfully
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

	<bbNG:button id="helpButton"  url="javascript:ShowMoreHelp();"  label="Need Help?" />

	<br />
	<br />
	
	<p style="margin-bottom:15px">The courses below were merged successfully.</p>
	
	
	<p style="margin-bottom:15px">Parent Course: <b>${ctx.course.courseId }  &nbsp; ${ctx.course.title } </b></p>
	
	<p style="margin-bottom:15px">Child Course(s): </p>
	
	<table cellspacing="5" style="margin-bottom:15px">
	
		<c:forEach var="course" items="${childCourses}">
		
			<tr><td>${course.courseId}</td><td>${course.title }</td></tr>
		
		</c:forEach>
		
		</table>
	
<p style="margin-bottom:15px">All course content should only be added to the parent course above.  Students are enrolled in and will only see the 
parent course content when using Blackboard.  Students who were only enrolled in the child course 
will see the title of the child course and the content from the parent course.</p>	

<p style="margin-bottom:15px">Note "un-merging" these courses will require assistance a Blackboard system administrator.  
</p>



</bbNG:learningSystemPage>