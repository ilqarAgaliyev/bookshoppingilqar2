 package com.example.bookshoppingilqar.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.example")
@PropertySource("classpath:persistence-mysql.properties")
public class Config implements WebMvcConfigurer{
	
	@Autowired
	Environment env;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**/**").addResourceLocations("classpath:/**/**");
		
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/book-shopping/customLogin").setViewName("book-shopping/home");
		registry.addViewController("/book-shopping/home").setViewName("book-shopping/home");
	}
	@Bean
	public DataSource source() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		return dataSource;
	}
	
	public Properties getHibProperties() {
		
		Properties prop = new Properties();
		
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.show", env.getProperty("hibernate.show"));
		
		return prop;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(source());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.scan"));
		sessionFactory.setHibernateProperties(getHibProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager trManager = new HibernateTransactionManager();
		trManager.setSessionFactory(sessionFactory);
		
		return trManager;
	}
	
}