package com.mystore.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ConfigurationHolder {

private static final String APPLICATION_PROPERTIES = "database.properties";
    
    private static final String DB_AUTH_DRIVER = "db.auth.driver";
    private static final String DB_AUTH_URL = "db.auth.url";
    private static final String DB_AUTH_USERNAME = "db.auth.username";
    private static final String DB_AUTH_PASSWORD = "db.auth.password";
    
    private static final String DB_MAIN_DRIVER = "db.main.driver";
    private static final String DB_MAIN_URL = "db.main.url";
    private static final String DB_MAIN_USERNAME = "db.main.username";
    private static final String DB_MAIN_PASSWORD = "db.main.password";
    
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    
    private static final String DATABASE = "db.name";
    
    private static String dbAuthDriver;
    private static String dbAuthUrl;
    private static String dbAuthUsername;
    private static String dbAuthPassword;
    
    private static String dbMainDriver;
    private static String dbMainUrl;
    private static String dbMainUsername;
    private static String dbMainPassword;
    
    private static String hibernateDialect;
    private static String hibernateShowSql;
    private static String hibernateHBM2ddlAuto; 
    
    private static String database;
    
    static {
    	
    	initData();
    }
    
    private static void initData() {
    	
    	if( dbAuthUrl == null || dbMainUrl == null ) {
    		
    		try {
    			
				Properties properties = PropertiesLoaderUtils.loadAllProperties( APPLICATION_PROPERTIES );
				
				setDbAuthDriver( properties.getProperty( DB_AUTH_DRIVER ).trim() );
				setDbAuthUrl( properties.getProperty( DB_AUTH_URL ).trim() );
				setDbAuthUsername( properties.getProperty( DB_AUTH_USERNAME ).trim() );
				setDbAuthPassword( properties.getProperty( DB_AUTH_PASSWORD ).trim() );
				
				setDbMainDriver( properties.getProperty( DB_MAIN_DRIVER ).trim() );
				setDbMainUrl( properties.getProperty( DB_MAIN_URL ).trim() );
				setDbMainUsername( properties.getProperty( DB_MAIN_USERNAME ).trim() );
				setDbMainPassword( properties.getProperty( DB_MAIN_PASSWORD ).trim() );
				
				setHibernateDialect( properties.getProperty( HIBERNATE_DIALECT ) );
				setHibernateShowSql( properties.getProperty( HIBERNATE_SHOW_SQL ) );
				setHibernateHBM2ddlAuto( properties.getProperty( HIBERNATE_HBM2DDL_AUTO ) );
				
				setDatabase( properties.getProperty( DATABASE ).trim() );
			} 
    		catch (IOException e) {

				e.printStackTrace();
				throw new RuntimeException( "error in loading the file database.properties :", e );
			}
    	}
    }


	public static String getDbAuthDriver() {
		return dbAuthDriver;
	}


	public static void setDbAuthDriver(String dbAuthDriver) {
		ConfigurationHolder.dbAuthDriver = dbAuthDriver;
	}


	public static String getDbAuthUrl() {
		return dbAuthUrl;
	}


	public static void setDbAuthUrl(String dbAuthUrl) {
		ConfigurationHolder.dbAuthUrl = dbAuthUrl;
	}


	public static String getDbAuthUsername() {
		return dbAuthUsername;
	}


	public static void setDbAuthUsername(String dbAuthUsername) {
		ConfigurationHolder.dbAuthUsername = dbAuthUsername;
	}


	public static String getDbAuthPassword() {
		return dbAuthPassword;
	}


	public static void setDbAuthPassword(String dbAuthPassword) {
		ConfigurationHolder.dbAuthPassword = dbAuthPassword;
	}


	public static String getDbMainDriver() {
		return dbMainDriver;
	}


	public static void setDbMainDriver(String dbMainDriver) {
		ConfigurationHolder.dbMainDriver = dbMainDriver;
	}


	public static String getDbMainUrl() {
		return dbMainUrl;
	}


	public static void setDbMainUrl(String dbMainUrl) {
		ConfigurationHolder.dbMainUrl = dbMainUrl;
	}


	public static String getDbMainUsername() {
		return dbMainUsername;
	}


	public static void setDbMainUsername(String dbMainUsername) {
		ConfigurationHolder.dbMainUsername = dbMainUsername;
	}


	public static String getDbMainPassword() {
		return dbMainPassword;
	}


	public static void setDbMainPassword(String dbMainPassword) {
		ConfigurationHolder.dbMainPassword = dbMainPassword;
	}


	public static String getDatabase() {
		return database;
	}


	public static void setDatabase(String database) {
		ConfigurationHolder.database = database;
	}


	public static String getHibernateDialect() {
		return hibernateDialect;
	}


	public static void setHibernateDialect(String hibernateDialect) {
		ConfigurationHolder.hibernateDialect = hibernateDialect;
	}


	public static String getHibernateShowSql() {
		return hibernateShowSql;
	}


	public static void setHibernateShowSql(String hibernateShowSql) {
		ConfigurationHolder.hibernateShowSql = hibernateShowSql;
	}


	public static String getHibernateHBM2ddlAuto() {
		return hibernateHBM2ddlAuto;
	}


	public static void setHibernateHBM2ddlAuto(String hibernateHBM2ddlAuto) {
		ConfigurationHolder.hibernateHBM2ddlAuto = hibernateHBM2ddlAuto;
	}
    
    
}
