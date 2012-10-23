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
	title="Welcome To Blackboard Building Block Development Part Four - Help Page" 
	ctxId="ctx">

     <%
    	final String jsUrl = PlugInUtil.getUri(ManifestSettings.getVendorId(), ManifestSettings.getHandle(), "script/moreHelp.js");
	%>
    
    <bbNG:jsFile href="<%=jsUrl%>"/>   
    

	<bbNG:pageHeader>

		<bbNG:pageTitleBar >
			Help Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>
	



	<p>Help Instructions</p>
	
	<p>Enter in the text box the new email address and then click the Submit button!</p>
	
	<div style="margin-top:15px">
	   <bbNG:button label="Close Window" url="javascript:closeWindow();" />
	</div>


</bbNG:learningSystemPage>