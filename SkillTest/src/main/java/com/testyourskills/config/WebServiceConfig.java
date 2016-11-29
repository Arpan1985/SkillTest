package com.testyourskills.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import com.testyourskills.util.ApplicationConstant;


/**
 *This class is used to configure the spring based SOAP web-service.
 *This class is used to hold the configuration otherwise done in web.xml
 *
 */
@EnableWs
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configuration
@ComponentScan(basePackages={ApplicationConstant.BASE_PACKAGE})
public class WebServiceConfig extends WsConfigurerAdapter
{

	/**
	 * This is a Spring bean definition to register the spring SOAP's MessageDispatcherServlet
	 * @param ApplicationContext applicationContext
	 * @return ServletRegistrationBean
	 */
	/*@Bean
	public ServletRegistrationBean messageDispatcherServlet(final ApplicationContext applicationContext) {
		return new ServletRegistrationBean(servlet, ApplicationConstant.URL_MAPPING);
	}*/

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