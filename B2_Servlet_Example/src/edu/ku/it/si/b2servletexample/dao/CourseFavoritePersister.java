
package edu.ku.it.si.b2servletexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import blackboard.db.BbDatabase;
import blackboard.db.ConnectionManager;
import blackboard.db.ConnectionNotAvailableException;

/**
 * Persists to the database the user's
 * favorite Blackboard Course.
 * @author bphillips
 *
 */
public class CourseFavoritePersister {
	
	private static final Logger LOGGER = Logger.getLogger(CourseFavoritePersister.class.getName() );
	
	/**
	 * Save the provided username and courseId into the 
	 * database.
	 * @param username - Blackboard user name
	 * @param courseId - Blackboard course id
	 * @return true if save was successful otherwise return false
	 */
	public boolean saveCourseFavorite(String username, String courseId) {
		
		boolean saveResult = true ;
		StringBuffer queryString = new StringBuffer("");
        ConnectionManager cManager = null;
        Connection conn = null;

        try {
            cManager = BbDatabase.getDefaultInstance().getConnectionManager();
            conn = cManager.getConnection();

            queryString.append("INSERT INTO kuit_userfavoritecourse ");
            queryString.append("(pk1, username, courseId ) ");

            queryString.append(" VALUES (kuit_userfavoritecourse_seq.nextval,?,?) ");


            PreparedStatement insertQuery = conn.prepareStatement(queryString.toString());
            insertQuery.setString(1, username);
            insertQuery.setString(2, courseId);
          

            int insertResult = insertQuery.executeUpdate();
            
            if(insertResult != 1){
            	
            	saveResult = false ;
            	
            }
            insertQuery.close();

        } catch (java.sql.SQLException sE){
        	
        	saveResult = false ;
        	
        	LOGGER.error( sE.getMessage() ) ;

        } catch (ConnectionNotAvailableException cE){
        	
        	saveResult = false ;
        	
        	LOGGER.error( cE.getMessage() ) ;
           
        } finally {
            if(conn != null){
                cManager.releaseConnection(conn);
            }
        }
		
		return saveResult ;
		
	}
	
	
	/**
	 * delete from the tables the record associated
	 * with the provided username.
	 * @param username - Blackboard username
	 * @return
	 */
	public void deleteCourseFavorite(String username) {
		
		
		StringBuffer queryString = new StringBuffer("");
        ConnectionManager cManager = null;
        Connection conn = null;

        try {
            cManager = BbDatabase.getDefaultInstance().getConnectionManager();
            conn = cManager.getConnection();

            queryString.append("delete from kuit_userfavoritecourse ");
            queryString.append("where username = ?");

            PreparedStatement deleteQuery = conn.prepareStatement(queryString.toString());
            
            deleteQuery.setString(1, username);
            
            deleteQuery.executeUpdate();

            deleteQuery.close();

        } catch (java.sql.SQLException sE){
        	

        	
        	LOGGER.error( sE.getMessage() ) ;

        } catch (ConnectionNotAvailableException cE){
        	
        	
        	LOGGER.error( cE.getMessage() ) ;
           
        } finally {
            if(conn != null){
                cManager.releaseConnection(conn);
            }
        }
		

		
	}

}
