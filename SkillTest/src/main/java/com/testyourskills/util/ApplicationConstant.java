package com.testyourskills.util;

/**
 * This class is used to store various constants
 * needed for Payment reconciliation application.
 *
 */
public class ApplicationConstant {
	
	private ApplicationConstant(){
		
	}
	
	/**
	 *The variable to store the package value for ClassPath scanning by Hibernate
	 */
	public static final String PACKAGE_TO_SCAN="com.testyourskills.entitybean";
	/**
	 *The variable to store the dialect used by hibernate for database connection
	 */
	public static final String HIBERNATE_DIALECT="hibernate.dialect";
	
	public static final String DRIVER_CLASS="hibernate.connection.driver_class";
	public static final String DB_URL="hibernate.connection.url";
	public static final String USERNAME="hibernate.connection.username";
	public static final String PASSWORD="hibernate.connection.password";
	
	/**
	 *The variable to indicate whether Hibernate should display the SQL queries generated
	 */
	public static final String HIBERNATE_SHOW_SQL="hibernate.show_sql";
	/**
	 *The variable to store the default schema property 
	 */
	public static final String HIBERNATE_DEFAULT_SCHEMA="hibernate.default_schema";
	/**
	 *The variable to indicate whether Hibernate should format the SQL queries generated
	 */
	public static final String HIBERNATE_FORMAT_SQL="hibernate.format_sql";
	/**
	 *The variable to store the URL mapping for the Payment Reconciliation web-service
	 */
	public static final String URL_MAPPING ="/ws/*";
	/**
	 *The variable to store the base package value for ClassPath scanning by spring
	 */
	public static final String BASE_PACKAGE="com.wvo.loc";
	/**
	 *The variable to store the logger name for logback logging
	 */
	public static final String LOGGER_NAME="LOC Micro Service";
	/**
	 *The variable to store the file path which holds the database connection property values
	 */
	public static final String DATABASE_PROPERTIES="classpath:properties/database.properties";
	/**
	 *The variable to store the specified string
	 */
	public static final String METHOD_NAME =" Method: ";
	/**
	 *The variable to store the specified string
	 */
	public static final String CLASS_NAME ="Class: ";
	/**
	 * The variable to store the specified string
	 */
	public static final String EXECUTION_START = "Execution Start : ";
	/**
	 * The variable to store the specified string
	 */
	public static final String EXECUTION_END = "Execution End : ";
	/**
	 * The variable to store the pointcut from spring aop to intercept
	 */
	public static final String POINTCUT = "(execution(* com.testyourskills..*.*(..)))";
	/**
	 * 
	 */
	public static final String SQL_ERROR = "Internal error occured while communicating with DB";
	
	/**
	 * 
	 */
	public static final String INTERNAL_ERROR = "An unexpected error has occurred.";
	/**
	 * 
	 */
	public static final long INTERNAL_ERROR_CD = 1;
	/**
	 * 
	 */
	public static final long SQL_ERROR_CD = 2;
	/**
	 * 
	 */
	public static final String ERROR_OCCURED = "ERROR OCCURED";
	/**
	 * 
	 */
	public static final String BLANK = "";
	
}