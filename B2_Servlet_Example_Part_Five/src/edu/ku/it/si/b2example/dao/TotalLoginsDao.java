package edu.ku.it.si.b2example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.log4j.Logger;

import blackboard.db.BbDatabase;
import blackboard.db.ConnectionManager;
import blackboard.db.ConnectionNotAvailableException;

/**
 * Get total logins from the Blackboard Learn
 * Database.
 * @author bphillips
 *
 */
public class TotalLoginsDao {
	
	private static final Logger LOGGER = Logger.getLogger( TotalLoginsDao.class.getName() );
	
	/**
	 * Get the total of unique logins between the provided
	 * startDate and endDate (not inclusive).
	 * @param startDate
	 * @param endDate
	 * @return total unique logins
	 */
	public int getTotalLogins(Date startDate, Date endDate) {
		
		int totalLogins = 0;
		
		java.sql.Date startDateSql = new java.sql.Date(startDate.getTime());
		
		java.sql.Date endDateSql = new java.sql.Date(endDate.getTime());

		
		ConnectionManager cManager = null;
        Connection conn = null;
        StringBuffer queryString = new StringBuffer("");
        PreparedStatement selectQuery = null;
        
        try {
		
		cManager = BbDatabase.getDefaultInstance().getConnectionManager();
        conn = cManager.getConnection();

        queryString.append("select count(distinct user_pk1) from activity_accumulator ");
        queryString.append("where data = 'Login succeeded.' ");
        queryString.append("and timestamp between ? and ? ");

        selectQuery = conn.prepareStatement(queryString.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        selectQuery.setDate(1, startDateSql);
        selectQuery.setDate(2, endDateSql);
        
        ResultSet rSet = selectQuery.executeQuery();

        while(rSet.next()){
        	
        	totalLogins = rSet.getInt(1);
         
        }
        
        rSet.close();
        
        selectQuery.close();

    } catch (java.sql.SQLException sE){
    	
    	LOGGER.error( sE.getMessage() ) ;
    	
    	throw new IllegalStateException("Unable to query database for total logins.") ;
        
    } catch (ConnectionNotAvailableException cE){
    	
    	LOGGER.error( cE.getMessage() ) ;
    	
    	throw new IllegalStateException("Unable to query database for total logins.") ;
        
    } finally {
    	
        if(conn != null){
            cManager.releaseConnection(conn);
        }
        
    }

		return totalLogins ;
		
		
	}
	

}
