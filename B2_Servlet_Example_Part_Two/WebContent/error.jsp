<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
      import="java.io.PrintWriter"
      isErrorPage="true" %>
<%@ taglib uri="/bbNG" prefix="bbNG" %>
<%
	String strException = exception.getMessage();
%>
<bbNG:genericPage title="Error">
  <bbNG:pageHeader>
	<bbNG:pageTitleBar title="Error" />
  </bbNG:pageHeader>
<bbNG:breadcrumbBar/>
<h2>Error:</h2>
<p><%=strException%></p>
<h2>Stack Trace:</h2>
<pre>
<%
	// now display a stack trace of the exception
  PrintWriter pw = new PrintWriter( out );
  exception.printStackTrace( pw );
%>
</pre>

</bbNG:genericPage>