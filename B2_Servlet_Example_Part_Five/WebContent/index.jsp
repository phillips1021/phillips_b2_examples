<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	import="java.util.*"
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

<%

 Calendar startDate = new GregorianCalendar();

 startDate.add(Calendar.DAY_OF_MONTH, -3);
 
 Calendar endDate = new GregorianCalendar();

 endDate.add(Calendar.DAY_OF_MONTH, -1);

%>
	
<bbNG:dataCollection>
	<bbNG:step instructions="Use the form below to select the time period" title="Get Total Unique User Logins">
	
		<bbNG:dataElement label="Start and End Dates">
		
			<bbNG:dateRangePicker startCaption="Start Date" startDateTime="<%=startDate %>" endCaption="End Date (noninclusive)" endDateTime="<%=endDate %>" showTime="false" baseFieldName="dateRange" filterFutureYears="true" isRequired="true"/>
		
		</bbNG:dataElement>

		<p style="font-size:-2, font-style:italics">Note: Logins occurring on the end date value are not included in result.  
		For example, if you want to include logins on Oct 20, then the end date should be Oct 21.</p>
	</bbNG:step>

	<bbNG:stepSubmit  />
	
</bbNG:dataCollection>

</bbNG:form>

</bbNG:learningSystemPage>