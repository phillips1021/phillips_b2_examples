<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="/bbNG" prefix="bbNG"%>



<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development Part Five - Total Logins" 
	ctxId="ctx">

<!-- note the breadcrumb href value uses the Context object 
referred to by the variable ctx to get the current course ID 
value -->
	<bbNG:pageHeader>
		<bbNG:breadcrumbBar environment="SYSTEM"
			navItem="system_plugin_manage" >
			<bbNG:breadcrumb title="Home" href="index.jsp" />
			<bbNG:breadcrumb title="Total Logins" />
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar>
			Total Logins
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>


	<p>Total unique logins between <fmt:formatDate type="date" dateStyle="short" value="${startDate}" /> and 
	<fmt:formatDate type="date" dateStyle="short" value="${endDate}" /> (noninclusive) were <b>${totalLogins}</b>.</p>
	


</bbNG:learningSystemPage>