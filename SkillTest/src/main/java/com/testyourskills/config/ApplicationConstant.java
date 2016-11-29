package com.testyourskills.config;

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
	public static final String PACKAGE_TO_SCAN="com.wvo.loc.entitybean";
	/**
	 *The variable to store the dialect used by hibernate for database connection
	 */
	public static final String HIBERNATE_DIALECT="hibernate.dialect";
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
	 *The variable to store jndi_name property
	 */
	public static final String JNDI_NAME="jndi_name";
	/**
	 *The variable to store the URL mapping for the Payment Reconciliation web-service
	 */
	public static final String URL_MAPPING ="/ws/*";
	/**
	 *The variable to store the relative path of the WSDL prospect consumption file
	 */
	public static final String PROSPECT_CONSUMPTION_WSDL ="service_definition/ProspectConsumptionMS.wsdl";
	/**
	 *The variable to store the relative path of the WSDL prospect management file 
	 */
	public static final String PROSPECT_MANAGEMENT_WSDL ="service_definition//ProspectManagementMS.wsdl";
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
	
	public static final String BARCLAYS_ERROR_CODE="/properties/barclays_error_code.properties";
	
	public static final String PAYPAL_ERROR_CODE="classpath:properties/paypal_error_code.properties";
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
	public static final String POINTCUT = "(execution(* com.wvo.loc..*.*(..)))";
	
	/**
	 * 
	 */
	public static final int MAX_RESULT = 2000;
	
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
	/**
	 * 
	 */
	public static final String INVALID_CREDIT_APPLICATION = "Invalid Credit application specifed";
	/**
	 * 
	 */
	public static final String INVALID_CREDIT_PRODUCT = "Invalid Credit product type specified";
	/**
	 * 
	 */
	public static final String INVALID_SERVICE_ENTITY = "Invalid service entity specified";
	/**
	 * 
	 */
	public static final String TOKEN_CREATED = "Token Created";
	/**
	 * 
	 */
	public static final String TOKENIZATION_FAILED = "Tokenization failed";
	/**
	 * 
	 */
	public static final String PAYPAL_CREDIT_APP = "PayPal Credit";
	/**
	 * 
	 */
	public static final String WYNDHAM_REWARDS_VISA = "Wyndham Rewards Visa";
	/**
	 * 
	 */
	public static final String PAYPAL_CREDIT = "PAYPAL_CREDIT";
	/**
	 * 
	 */
	public static final String BARCLAYS_WRC = "BARCLAYS_WRC";
	/**
	 * 
	 */
	public static final String MOTHERS_MAIDEN_NAME = "MothersMaidenName";
	/**
	 * 
	 */
	public static final String PAYPAL_ACCOUNT_NUMBER = "paypalAccountNumber";
	/**
	 * 
	 */
	public static final String WYNDHAM_REWARDS_NUMBER = "wyndhamRewardsNumber";
	/**
	 * 
	 */
	public static final String MARRIED_FLAG = "marriedFlag";
	/**
	 * 
	 */
	public static final String EMPLOYER_NAME = "employerName";
	/**
	 * 
	 */
	public static final String YEARLY_HOUSEHOLD_INCOME = "yearlyHouseholdIncome";
	/**
	 * 
	 */
	public static final String SAVINGS_FLAG = "savingsFlag";
	/**
	 * 
	 */
	public static final String CHECKING_FLAG = "checkingFlag";
	/**
	 * 
	 */
	public static final String RESIDENCE_LENGTH = "residenceLength";
	/**
	 * 
	 */
	public static final String RESIDENCE_TYPE = "residenceType";
	/**
	 * 
	 */
	public static final String OCCUPATION = "Occupation";
	/**
	 * 
	 */
	public static final String SUBMITTED = "submitted";
	/**
	 * 
	 */
	public static final String TOUR = "tour";
	/**
	 * 
	 */
	public static final String SINGLE_APPL = "singleAppl";
	/**
	 * 
	 */
	public static final char YES = 'Y';
	/**
	 * 
	 */
	public static final char NO = 'N';
	/**
	 * 
	 */
	public static final String GET_APPL_ID = "select LOC.CRDT_APPL_SEQ.nextval as num from dual";
	/**
	 * 
	 */
	public static final String GET_EVENT_ID = "select LOC.CRDT_APPL_EVNT_SEQ.nextval as num from dual";
	/**
	 * 
	 */
	public static final String GET_CLB_MMBRSHP_ID = "select PROSPECT.CLB_MMBRSHP_SEQ.nextval as num from dual";
	/**
	 * 
	 */
	public static final String GET_PROSPECT_ID = "select PROSPECT.PRSPCT_SEQ.nextval as num from dual";
	/**
	 * 
	 */
	public static final String INVALID_SLS_STR = "Sales store Id is not found based on the given entity and site";
	/**
	 * 
	 */
	public static final String BARCLAYS_EVNT = "Barclaycard";
	/**
	 * 
	 */
	public static final String PAYPAL_EVNT = "PayPal";
	
	
}