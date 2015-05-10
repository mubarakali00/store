//package com.mystore.config;
//
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan( { "com.bigledger.ws.jpa", "com.bigledger.server.jpa" } )
//@Profile( "oracle" )
//public class JPAOracleConfig 
//{
//	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
//	{
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource( dataSource() );
//        em.setPackagesToScan( new String[] { "com.bigledger.ws.jpa.entity", "com.bigledger.server.jpa.entity" } );
//        
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter( vendorAdapter );
//        em.setJpaProperties( additionalProperties() );
//
//        return em;
//	}
//	
//	@Bean
//	public DataSource dataSource() 
//	{ 
//		
//		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName( CommonConfigurationHolder.getDbTxnDriver() );
//        dataSource.setUrl( CommonConfigurationHolder.getDbTxnUrl() );
//        dataSource.setUsername( CommonConfigurationHolder.getDbTxnUsername() );
//        dataSource.setPassword( CommonConfigurationHolder.getDbTxnPassword() );
//        return dataSource;
//		
//    }
//	
//	@Bean
//    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) 
//	{
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() 
//    {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//	   
//	final Properties additionalProperties() 
//	{
//        final Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty( "hibernate.show_sql", "true" );
//        hibernateProperties.setProperty( "hibernate.dialect", "com.bigledger.ws.jpa.entity.JsonStringOracleDialect" );
//        
//        return hibernateProperties;
//    }
//	
//	@Bean
//	public PersistenceAnnotationBeanPostProcessor processor()
//	{
//		return new PersistenceAnnotationBeanPostProcessor();
//	}
//	
//}
