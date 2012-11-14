package edu.ku.it.si.b2example.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/**
 * This Servlet will be run when the 
 * Building Block is deployed by Blackboard and it ensures
 *  the directory for the log file exists.
 * Based on OSCELOT project Grade Tool
 *
 */
public class InitServletListener implements ServletContextListener {
	
	
	private static final Log LOG = LogFactory.getLog(InitServletListener.class);

	
	public void contextInitialized(final ServletContextEvent event) {
		
		try { // application initialization
			
			final File webroot = new File(event.getServletContext().getRealPath("/"));
			
			try { // initialize the logging
				
				// load in the configuration
				final File log4jConfig = new File(webroot, "WEB-INF/classes/log4j.properties");
				final Properties log4jProps = new Properties();
				log4jProps.load(new FileInputStream(log4jConfig));
				
				// create any directories as needed
				for(Object obj : log4jProps.keySet()) {
					String key = (String) obj;
					if(key == null) {
						continue;
					}
					
					key = key.toLowerCase().trim();
					if (key.startsWith("log4j.appender.") && key.endsWith(".file")) {
						final String value = log4jProps.getProperty((String) obj);
						
						final File dir = (new File(value)).getParentFile();
						if(!dir.exists()) {
							dir.mkdirs();
						}
					}
				}

				
			} catch(Exception e) {
				// log failed to initialize
				e.printStackTrace();
				throw e;
			}
			
			LOG.info("Initializing  module.");
			
		
			
		} catch(Exception e) {
			// log failed to initialize
			LOG.fatal("Failed to initialize  module", e);
			throw new RuntimeException("Failed to initialize application", e);
		}
		
	
		
	}
	
	
	public void contextDestroyed(final ServletContextEvent arg0) {
		
		LOG.info("contextDestroyed  module.");
		
		
		
	}
	
	
	
		
		
	
	
}

