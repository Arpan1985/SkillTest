package com.testyourskills.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class is used to configure Hibernate to be used in the application
 */
@Configuration
@EnableTransactionManagement
@PropertySources({
	@PropertySource(value = { ApplicationConstant.DATABASE_PROPERTIES })
})

public class HibernateConfiguration {

    /**
     *The variable to store the Environment instance variable
     */
    @Autowired
    private Environment environment;

    /**
     * Bean definition to configure Hibernate SessionFactory
     * @return LocalSessionFactoryBean
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { ApplicationConstant.PACKAGE_TO_SCAN });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }

    /**
     * Bean definition to configure datasource for Hibernate SessionFactory
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
    	 JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
         String jndi_name = environment.getRequiredProperty(ApplicationConstant.JNDI_NAME);
         jndiObjectFactoryBean.setJndiName(jndi_name);
         JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
         return dataSourceLookup.getDataSource(jndi_name);
    }

    /**
     * This method is used to set the properties for Hibernate configuration
     * @return Properties
     */
    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put(ApplicationConstant.HIBERNATE_DIALECT, environment.getRequiredProperty(ApplicationConstant.HIBERNATE_DIALECT));
        properties.put(ApplicationConstant.HIBERNATE_SHOW_SQL, environment.getRequiredProperty(ApplicationConstant.HIBERNATE_SHOW_SQL));
        properties.put(ApplicationConstant.HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(ApplicationConstant.HIBERNATE_FORMAT_SQL));
        return properties;
    }

	/**
	 * Bean definition to configure Hibernate Transaction manager
	 * @param SessionFactory sessionFactory
	 * @return
	 */
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
       final HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       return txManager;
    }
}

