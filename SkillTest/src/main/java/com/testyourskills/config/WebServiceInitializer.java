package com.testyourskills.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletContextInitializer;
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
@ComponentScan(basePackages={"com.testyourskills"})
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
	        return application.sources(new Class[] { WebServiceInitializer.class});
	    }
	    
	  /*  @Bean
	    public FilterRegistrationBean fileUploadFilter() {
	       FileUploadFilter fileUploadFilter = new FileUploadFilter();
	       FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(fileUploadFilter);
	       filterRegistrationBean.setName("PrimeFaces FileUpload Filter");
			return filterRegistrationBean;
	    }*/
	    @Bean
	    public Filter addFilter(){
	    	 FileUploadFilter fileUploadFilter = new FileUploadFilter();
	    	 return  fileUploadFilter;
	    }
	    @Bean
	    public ServletRegistrationBean servletRegistrationBean(MultipartConfigElement conf) {
	        FacesServlet servlet = new FacesServlet();
	        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
	        servletRegistrationBean.setName("Faces Servlet");servletRegistrationBean.setMultipartConfig(conf);

			return servletRegistrationBean;
	    }
	    @Bean
	    public ServletContextInitializer initializer() {
	        return new ServletContextInitializer() {
	            @Override
	            public void onStartup(ServletContext servletContext)
	                    throws ServletException {
	                servletContext.setInitParameter("primefaces.THEME", "bluesky");
	                servletContext.setInitParameter(
	                        "javax.faces.FACELETS_SKIP_COMMENTS", "true");
	                servletContext.setInitParameter(
	                        "com.sun.faces.expressionFactory",
	                        "com.sun.el.ExpressionFactoryImpl");
	                servletContext.setInitParameter("primefaces.UPLOADER",
	                        "commons");
	            }
	        };
	    }
	    @Bean
	    public FilterRegistrationBean contextFilterRegistrationBean() {

	        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	        FileUploadFilter fileUploadFilter = new FileUploadFilter();
	        registrationBean.setFilter(fileUploadFilter);
	        registrationBean.addUrlPatterns("*.jsf");
	    return registrationBean;
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
