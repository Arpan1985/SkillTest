package com.testyourskills.config;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot initializer class containing the main method.
 * This class will be used as an alternative to web.xml which
 * will be picked up by the application server on deployment
 */
@SpringBootApplication
@ComponentScan(basePackages={""})
@EnableAutoConfiguration
public class WebServiceInitializer extends SpringBootServletInitializer {

	    /**
	     * The main method will be invoked initially by Spring boot
	     * @param String[] args
	     * @throws Exception
	     */
	    public static void main(String[] args) {
	        SpringApplication.run(WebServiceInitializer.class, args);
	    }
	    
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(new Class[] { WebServiceInitializer.class, Initializer.class});
	    }

	    @Bean
	    public ServletRegistrationBean servletRegistrationBean() {
	        FacesServlet servlet = new FacesServlet();
	        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
			return servletRegistrationBean;
	    }
	    
	    /**
		 * This spring bean definition is used as part of Spring AOP Aspect configuration
		 * so that Spring CGLIB proxy (enabling autoproxy) can be used.
		 * @return LoggerAspect
		 */
	/*	@Bean
		public LoggerAspect loggerAspect(){
			return new LoggerAspect();
		}*/
}
