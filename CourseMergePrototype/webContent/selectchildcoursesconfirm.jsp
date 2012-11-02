<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
	edu.ku.it.si.b2example.*,
	blackboard.platform.plugin.*,
    blackboard.data.course.*"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Blackboard Course Merge - Confirm Courses To Merge" ctxId="ctx">
	
	    <%
    	final String jsUrl = PlugInUtil.getUri(BuildingBlockHelper.VENDOR_ID,BuildingBlockHelper.HANDLE, "script/moreHelp.js");
	%>

<bbNG:jsFile href="<%=jsUrl%>"/>

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Course Merge - Confirm Courses To Merge
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

	<bbNG:button id="helpButton"  url="javascript:ShowMoreHelp();"  label="Need Help?" />

	<br />
	<br />
	
	<p style="margin-bottom:15px">Review the information below and confirm the courses you want to merge.</p>
	
	
	<p style="margin-bottom:15px;margin-left:10px">Parent Course: <b>${ctx.course.courseId }  &nbsp; ${ctx.course.title } </b></p>
	
	<p style="margin-bottom:15px">Child Course(s): </p>
	
	<table cellpadding="5" style="margin-bottom:15px;margin-left:10px">
	
		<c:forEach var="course" items="${childCourses}">
		
			<tr><td>${course.courseId}</td><td>${course.title }</td></tr>
		
		</c:forEach>
		
		</table>
	
	
<p style="margin-bottom:15px">The parent course will be the course students will be enrolled into and will see when logging into Blackboard.  You should add all content
to the parent course.</p>

<p style="margin-bottom:15px">Note "un-merging" these courses will require assistance from a Blackboard system administrator.  
Please be sure you want to merge these courses and have the parent
course be the course students use.  If you are sure click on the Confirm Merge Courses button.</p>

<form name="mainForm" method="post" action="SelectChildCoursesAction?course_id=${ctx.courseId.externalString}">

	    <c:forEach var="course" items="${childCourses}">
		
			<input type="hidden" name="childCourseId" value="${course.courseId}" />
		
		</c:forEach>
		
 <p><input type="submit" name="submit" value="Confirm Merge Courses" />
		
	<a href="index.jsp?course_id=${ctx.courseId.externalString}" style="text-decoration: none"><input type="button" name="cancel" value="Cancel" /></a>		
</p>

</form>


</bbNG:learningSystemPage>