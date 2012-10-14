<%@ page language="java" contentType="text/html; charset=US-ASCII"
    import="blackboard.data.user.*,
    edu.ku.it.si.b2servletexample.model.*"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development - Favorite Course">

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Favorite Course
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>


<c:if test="${!empty courseFavorite.courseId}">

	<p>The favorite course of ${user.userName} is ${courseFavorite.courseId}.</p>
	
	<p><a href="SelectFavoriteCourseInput">Change your favorite course</a>.</p>
	
</c:if>

<c:if test="${empty courseFavorite.courseId}">

	<p>You have not selected a favorite course. <a href="SelectFavoriteCourseInput">Select a favorite course.</a></p>
	
</c:if>

</bbNG:learningSystemPage>