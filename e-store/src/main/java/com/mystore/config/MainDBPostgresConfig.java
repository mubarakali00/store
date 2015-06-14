package com.mystore.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories( basePackages = "com.mystore.jpa.main.repository", entityManagerFactoryRef = "mainEntityManager", transactionManagerRef = "transactionManager" )
@Profile( "postgresql" )
public class MainDBPostgresConfig 
{
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource( dataSource() );
        em.setPackagesToScan( new String[] { "com.mystore.jpa.main.entity" } );
        
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter( vendorAdapter );
        em.setJpaProperties( additionalProperties() );

        return em;
	}
	
	@Bean
	public DataSource dataSource() 
	{ 
		
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( ConfigurationHolder.getDbAuthDriver() );
        dataSource.setUrl( ConfigurationHolder.getDbMainUrl() );
        dataSource.setUsername( ConfigurationHolder.getDbMainUsername() );
        dataSource.setPassword( ConfigurationHolder.getDbMainPassword() );
        return dataSource;
		
    }
		   
	final Properties additionalProperties() 
	{
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty( "hibernate.show_sql", ConfigurationHolder.getHibernateShowSql() );
        hibernateProperties.setProperty( "hibernate.dialect", ConfigurationHolder.getHibernateDialect() );
        hibernateProperties.setProperty( "hibernate.hbm2ddl.auto" , ConfigurationHolder.getHibernateHBM2ddlAuto() );
        hibernateProperties.setProperty( "hibernate.format_sql" , ConfigurationHolder.getHibernateFormatSql() );
        hibernateProperties.setProperty( "hibernate.transaction.jta.platform" , "org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform" );
		hibernateProperties.setProperty( "hibernate.transaction.factory_class", "org.hibernate.transaction.CMTTransactionFactory" );
        return hibernateProperties;
    }
	
}
