<%@ page language="java" contentType="text/html; charset=US-ASCII"
	import="blackboard.data.user.*,
    blackboard.data.course.*,
    edu.ku.it.si.b2servletexample.model.*"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - Select Favorite Course Input">

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Select Favorite Course Input
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>


	<p>Use the form below to select your favorite course.</p>
<form name="mainForm" method="post" action="SelectFavoriteCourseAction">
	<bbNG:inventoryList collection="${allCourses}" objectVar="course"
		className="Course" emptyMsg="No data to display">


			 
	    <bbNG:listRadioElement name="selectedCourseId" value="<%= course.getCourseId() %>" />
	    
	    <bbNG:listActionBar>		 
			<bbNG:listActionItem title="Make Favorite" id="makeFavorite"
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