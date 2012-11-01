<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
	edu.ku.it.si.b2example.*,
	blackboard.platform.plugin.*,
    blackboard.data.course.*"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Blackboard Course Merge - Select Child Courses" ctxId="ctx">
	
	    <%
    	final String jsUrl = PlugInUtil.getUri(BuildingBlockHelper.VENDOR_ID,BuildingBlockHelper.HANDLE, "script/moreHelp.js");
	%>

<bbNG:jsFile href="<%=jsUrl%>"/>

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Course Merge - Select Child Courses
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>

	<bbNG:button id="helpButton"  url="javascript:ShowMoreHelp();"  label="Need Help?" />

	<br />
	<br />
	
	<p style="margin-bottom:15px">Use the form below to select one or more child courses to merge with ${ctx.course.title}.  The Blackboard courses 
	listed below are those courses where you are the instructor during the same term as the parent course. 
	Any courses that are already merged with a parent course are not shown (a course may only have one parent course).</p>
	<p style="margin-bottom:15px">After marking the check box for each course you want to be merged with ${ctx.course.title} click on the
	Make Child Course button.</p>
<form name="mainForm" method="post" action="SelectChildCoursesConfirm?course_id=${ctx.courseId.externalString}">
	<bbNG:inventoryList collection="${allCourses}" objectVar="course"
		className="Course" emptyMsg="No data to display" >


			 
	    <bbNG:listCheckboxElement name="selectedCourseId" value="<%= course.getCourseId() %>" />
	    
	    <bbNG:listActionBar>		 
			<bbNG:listActionItem title="Make Child Course" id="makeChildCourse"
url="javascript:document.mainForm.submit();" contextMenuItemId="selectedCourseId" />	
		</bbNG:listActionBar>	 

		<bbNG:listElement label="Course Id" name="courseId"
			isRowHeader="true">
			
			<%=course.getCourseId()%>
			
		</bbNG:listElement>

		<bbNG:listElement label="Course Name" name="courseName"
			isRowHeader="false">
			
			<%=course.getTitle()%>

		</bbNG:listElement>

	</bbNG:inventoryList>

</form>
</bbNG:learningSystemPage>