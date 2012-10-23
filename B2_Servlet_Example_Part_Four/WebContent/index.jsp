<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	import="java.util.*,
				blackboard.data.*,
				blackboard.data.user.*,
				blackboard.platform.plugin.*,
				edu.ku.it.si.b2example.util.*,
				blackboard.data.course.*"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>



<bbNG:learningSystemPage
	title="Welcome To Blackboard Building Block Development Part Four - Home Page" 
	ctxId="ctx">

    <%
    	final String jsUrl = PlugInUtil.getUri(ManifestSettings.getVendorId(), ManifestSettings.getHandle(), "script/moreHelp.js");
	%>
    
    <bbNG:jsFile href="<%=jsUrl%>"/>
    
    

	<bbNG:pageHeader>

		<bbNG:pageTitleBar >
			Home Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>

	<bbNG:button id="helpButton"  url="javascript:ShowMoreHelp();"  label="Need Help?" />

	<br />
	<br />

	<p>Welcome to Blackboard Building Block Development Part Four</p>
	
	
	
<bbNG:form action="UpdateEmail" method="post" name="updateEmailForm" >
	
<bbNG:dataCollection>
	<bbNG:step instructions="Use the form below to update your email address" title="Update Email">
	<bbNG:dataElement label="Email Address" isRequired="true" labelFor="email">

		<input type="text" name="email" value="${ctx.user.emailAddress }" />
		
	</bbNG:dataElement>

	</bbNG:step>

	<bbNG:stepSubmit showCancelButton="true"  />
	
</bbNG:dataCollection>

</bbNG:form>

</bbNG:learningSystemPage>