This project is a prototype of a Blackboard Building Block (B2) that 
allows an instructor to add one or more child courses to a parent
course.  The effect is to merge the enrollments of the courses 
and for all students to see the content of the parent course.

The B2's name that will appear in the Course Tools section 
is Course Merge Prototype.

NOTE:  The code that acutally does the merge is NOT implemented.
So running this B2 will NOT merge any courses.  See the TODO
in class SelectChildCoursesAction.java.

This B2 was tested on Blackboard Learn 9.1 Service Pack 9.

The project was created using the Blackboard Building Block
eclipse plugin.  
(see: http://www.brucephillips.name/blog/index.cfm/2012/10/25/How-To-Use-The-Blackboard-Building-Block-Eclipse-Plugin)
That plugin provides a project creation wizard that sets up
the project's classpath and initial bb-manifest.xml file.

The B2 can be "auto-deployed" to a Blackboard development system
by running the Ant target deploy-b2.  For this to work correctly
the Blackboard Starting Building Block must be installed 
on the Blackboard develop system.
(see:   Starting Building Block on the Blackboard development server (see: https://behind.blackboard.com/s/developer/dlc/download.aspx?d=1335))

In the build.xml file you will need to set the URL of your 
Blackboard development system for the deploy-b2 target to 
work successfully.

This B2 is a course tool that is visible to an instructor.  After 
successfully deploying the B2 to Blackboard you will need to 
make the course tool always on for the tool to be visible in 
the course tool section of a Blackboard course.

Whichever Blackboard course the instructor is viewing when using 
this B2 will be the parent course.  The instructor will then have
the ability to select one or more child courses.  The  
courses available to become children follow these business rules:

1.  course must be taught by the instructor
2.  course must be in the same term as the parent course
3.  course cannot be the parent course
4.  course cannot already be a child course to this parent or 
some other parent

See class SelectChildCourses.java for the code that implements 
these rules.

The initial view page is index.jsp.  The application logs to the 
stdout-stderr file in blackboard/logs/tomcat.
