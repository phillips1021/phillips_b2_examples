<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,
				blackboard.data.*,
				blackboard.data.user.*,
				blackboard.platform.plugin.*,
				edu.ku.it.si.b2example.*,
				blackboard.data.course.*"%>
<%@ taglib prefix="bbNG" uri="/bbNG"%>


<bbNG:learningSystemPage ctxId="ctx" >

    <%
    	final String jsUrl = PlugInUtil.getUri(BuildingBlockHelper.VENDOR_ID,BuildingBlockHelper.HANDLE, "script/moreHelp.js");
	%>

<bbNG:jsFile href="<%=jsUrl%>"/>


	<bbNG:pageHeader instructions="Merge two or more blackboard courses by adding one or more child courses to this parent course.">
		<bbNG:breadcrumbBar>
			<bbNG:breadcrumb>Blackboard Course Merge</bbNG:breadcrumb>
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar >Blackboard Course Merge</bbNG:pageTitleBar>
	</bbNG:pageHeader>
	
	<bbNG:button id="helpButton"  url="javascript:ShowMoreHelp();"  label="Need Help?" />

	<br />
	<br />	
	
<h3>Merge Blackboard Courses</h3>	
	
<p>The current course you are viewing, ${ctx.course.title}, will be the parent course for this merge.</p>

<p style="margin-bottom:15px">The next step is to select one or more other Blackboard courses that you are teaching this semester 
to be the child course(s) of this
parent course.</p>

<p style="margin-bottom:15px">After you select the child courses you will then tell Blackboard to merge those courses with this 
parent Blackboard course.  Then all the enrollments for the parent and child courses will show up in the parent course, 
students will only see the content from the parent course, and you should add content to only the parent course.</p>

<p><a href="SelectChildCourses?course_id=${ctx.courseId.externalString}">Select one or more child courses</a> to merge with ${ctx.course.title}.	
	
	
	
</bbNG:learningSystemPage>

