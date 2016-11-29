package com.testyourskills.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * Spring boot initializer class containing the main method.
 * This class will be used as an alternative to web.xml which
 * will be picked up by the application server on deployment
 */
@SpringBootApplication
public class WebServiceInitializer extends SpringBootServletInitializer implements WebApplicationInitializer {

	    /**
	     * The main method will be invoked initially by Spring boot
	     * @param String[] args
	     * @throws Exception
	     */
	    public static void main(String[] args) {
	        SpringApplication.run(WebServiceInitializer.class, args);
	    }

}
