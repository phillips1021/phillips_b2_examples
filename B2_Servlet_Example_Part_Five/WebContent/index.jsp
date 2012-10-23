<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>



<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development Part Five - Home Page" 
	ctxId="ctx">

    

	<bbNG:pageHeader>

		<bbNG:pageTitleBar >
			Home Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>


	<p>Welcome to Blackboard Building Block Development Part Five</p>
	
<bbNG:form action="UserLogins" method="post" name="userLoginsForm" >
	
<bbNG:dataCollection>
	<bbNG:step instructions="Use the form below to select the time period" title="Get Total Unique User Logins">
	
		<bbNG:dataElement label="Start and End Dates">
		
			<bbNG:dateRangePicker startCaption="Start Date" endCaption="End Date" showTime="false" baseFieldName="dateRange" filterFutureYears="true" isRequired="true"/>
		
		</bbNG:dataElement>


	</bbNG:step>

	<bbNG:stepSubmit showCancelButton="true"  />
	
</bbNG:dataCollection>

</bbNG:form>

</bbNG:learningSystemPage>