
package edu.ku.it.si.b2servletexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import blackboard.db.BbDatabase;
import blackboard.db.ConnectionManager;
import blackboard.db.ConnectionNotAvailableException;
import edu.ku.it.si.b2servletexample.model.CourseFavorite;


/**
 * Gets the Blackboard course favorite
 * data from the database.
 * @author bphillips
 *
 */
public class CourseFavoriteLoader {
	
	private static final Logger LOGGER = Logger.getLogger(CourseFavoriteLoader.class.getName() );
	
	/**
	 * Using the provided username get the CourseFavorite
	 * associated with that user.
	 * @param username Blackboard username
	 * @return CourseFavorite object that has the course id 
	 * of the user's favorite course.  If no favorite course
	 * is found then return an empty CourseFavorite object.
	 */
	public CourseFavorite loadCourseFavorite(String username ) {
		
		CourseFavorite courseFavorite = new CourseFavorite();
		
		ConnectionManager cManager = null;
        Connection conn = null;
        StringBuffer queryString = new StringBuffer("");
        PreparedStatement selectQuery = null;
        
        try {
		
		cManager = BbDatabase.getDefaultInstance().getConnectionManager();
        conn = cManager.getConnection();

        queryString.append("SELECT username, courseId ");
        queryString.append("FROM ");
        queryString.append("kuit_userfavoritecourse ");
        queryString.append("WHERE username = ?");
        selectQuery = conn.prepareStatement(queryString.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        selectQuery.setString(1, username);
        ResultSet rSet = selectQuery.executeQuery();

        while(rSet.next()){
        	
        	courseFavorite.setUsername( rSet.getString(1) );
        	courseFavorite.setCourseId(rSet.getString(2) );
         
        }
        
        rSet.close();
        
        selectQuery.close();

    } catch (java.sql.SQLException sE){
    	
    	LOGGER.error( sE.getMessage() ) ;
        
    } catch (ConnectionNotAvailableException cE){
    	
    	LOGGER.error( cE.getMessage() ) ;
        
    } finally {
    	
        if(conn != null){
            cManager.releaseConnection(conn);
        }
        
    }
    
		
		return courseFavorite ;
		
	}

}
