This Blackboard building block example demonstrates how to configure a 
B2 to create a database table in your Blackboard Learn schema
as described here:  http://www.edugarage.com/display/BBDN/Creating+Database+Objects+with+Building+Blocks.

This building block should work with Bb Learn 9.1 SP 1 and higher.  It was tested on Bb Learn 9.1
Service Pack 9 with Oracle 11 database.

This B2 will create a table named kuit_usercoursefavorite and insert one record into that table.
The schema for the table is in WEB-INF/schema/favoritecourse/schema.xml.  The record that it 
will insert is in a tab-delimited file: WEB-INF/schema/favoritecourse/datatemplates/kuit_userfavoritecourse.txt

NOTE also there is a file named main_templates.lst (that is a lower case L) in the same 
directory as kuit_userfavoritecourse.txt.  The purpose and structure of that file 
are detailed on your blackboard application server in blackboard/system/database/vi/as_core/datatemplates.
In that folder is a main_templates.lst file that describes the purpose of that file and 
how it should be structured.

This project's classpath expects the Blackboard jars to be in a user defined library named Blackboard
which points to /apps/blackboard/lib.  Other jars on the classpath of the project are expected to
be in /apps/blackboard/lib also.  After you import this project into Eclipse you may need to 
change the configuration of the libraries in the project properties.

NOTE:  In Blackboard a system administrator will need to allow the Building Block to create 
tables.  This change must be made BEFORE uploading the .war file to Blackboard.  
Click on the System Admin tab - Building Blocks - Installed Tools - Global Settings (this is for
Bb Learn 9.1 SP 9).
