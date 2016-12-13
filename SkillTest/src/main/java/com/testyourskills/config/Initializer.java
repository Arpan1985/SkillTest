package com.testyourskills.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Initializer implements ServletContextInitializer {
 
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
	  servletContext.setInitParameter("primefaces.THEME", "bluesky");
      servletContext.setInitParameter(
              "javax.faces.FACELETS_SKIP_COMMENTS", "true");
      servletContext.setInitParameter(
              "com.sun.faces.expressionFactory",
              "com.sun.el.ExpressionFactoryImpl");
      servletContext.setInitParameter("primefaces.UPLOADER",
              "commons");
  }
}
