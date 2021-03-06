Blackboard Building Block Example Using Servlet - Part Two

This Building Block project demonstrates a very simple application that can be
deployed to a Blackboard Learn 9.1 application server.  The project demonstrates
how to use a Java Servlet as a controller and also how to configure the Building 
Block to write to a log file in blackboard/logs/custom folder on the 
Blackboard application server.

The project expects a user library named Blackboard to be on the 
project's classpath.  That library should include the jar files
needed by a Blackboard Building Block: (bb-platform.jar, 
bb-cms-admin.jar, bb-taglib.jar). 

Export the project as a .war file and then install the .war file
in a Blackboard Learn 9.1 application server.  Make the Building
Block available and also set the course tool setting to always
on.

This B2 is a course tool and will display on the Course Tools menu
for any course in Blackboard.

See the bb-manifest.xml file for the Building Block's settings.

When you click on this B2 in Blackboard the index.jsp
will be rendered.

The project demonstrates how to use the Context object to get course and user 
information from within both the JSP and within a Servlet and how to use 
the breadcrumb tag.

The project also demonstrates how to use slf4j and logback frameworks to 
support logging to a file in the [Blackboard Home]/logs/custom folder.