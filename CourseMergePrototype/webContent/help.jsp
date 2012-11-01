<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"
	import="java.util.*,
				blackboard.data.*,
				blackboard.data.user.*,
				blackboard.platform.plugin.*,
				edu.ku.it.si.b2example.*,
    			blackboard.data.course.*"
%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>



<bbNG:learningSystemPage
	title="Blackboard Course Merge - Help Page" 
	ctxId="ctx">

    <%
    	final String jsUrl = PlugInUtil.getUri(BuildingBlockHelper.VENDOR_ID,BuildingBlockHelper.HANDLE, "script/moreHelp.js");
	%>
	
    <bbNG:jsFile href="<%=jsUrl%>"/>
 
	<bbNG:pageHeader>

		<bbNG:pageTitleBar >
			Course Merge Help Page
		</bbNG:pageTitleBar>
		
	</bbNG:pageHeader>
	



	<h3>Help Instructions</h3>
	
	<p style="margin-bottom:15px">The course you are in will be the parent course and you will select one or more other Blackboard courses to be
	the child course.  The child courses must be Blackboard courses you are teaching in the same term as
	the parent course.</p>
	
	<p style="margin-bottom:15px">If you need more help contact the Blackboard support team at X-XXXX or email xxxx@ku.edu.</p>
	
	<div style="margin-top:15px">
	   <bbNG:button label="Close Window" url="javascript:closeWindow();" />
	</div>


</bbNG:learningSystemPage>