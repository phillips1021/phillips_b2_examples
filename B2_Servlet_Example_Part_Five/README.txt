Blackboard Building Block Example - Part Four

This Building Block project demonstrates a very simple application that can be
deployed to a Blackboard Learn 9.1 application server.  The project demonstrates
how to use the Blackboard date picker tags and how get how many unique users
have logged in during a specified time period.

The project expects a user library named Blackboard to be on the 
project's classpath.  That library should include the jar files
needed by a Blackboard Building Block: (bb-platform.jar, 
bb-cms-admin.jar, bb-taglib.jar, log4j.jar). 

Export the project as a .war file and then install the .war file
in a Blackboard Learn 9.1 application server.  Make the Building
Block available and also set the course tool setting to always
on.

This B2 is a admin tool and will display on the admin Tools menu

See the bb-manifest.xml file for the Building Block's settings.
When you click on this B2 in Blackboard the index.jsp
will be rendered.
