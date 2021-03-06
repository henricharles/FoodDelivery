/*<<<<<<< HEAD
package configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller", "domain","dao", "service" })
@EnableJpaRepositories("dao")
@EnableTransactionManagement
public class MvcConfigure extends WebMvcConfigurerAdapter {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "root";
	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost/foodDB?createDatabaseIfNotExist=true";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
	private static final String PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE = "1";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "update";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "domain";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(hibernateProperties());
		em.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);

		return em;
	}
	
	
	

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
		properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO);
		properties.put("connection.pool.size", PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE);
		properties.put("current_session_context_class", "thread");

		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}

	// Resolves views selected for rendering by @Controllers to .jsp resources
	// in the /WEB-INF/views directory
	@Bean
	public InternalResourceViewResolver htmlViewResolver() {
		final InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		//bean.setSuffix(".html");

		return bean;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver(){
	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	    commonsMultipartResolver.setDefaultEncoding("utf-8");
	    commonsMultipartResolver.setMaxUploadSize(50000000);
	    return commonsMultipartResolver;
	}
	
	
	
	// -------------- Serving Resources ----------------------
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	// -- Lets us find resources (.html etc) through the default servlet
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}

=======
//<<<<<<< HEAD
////<<<<<<< HEAD
//////package configuration;
//////
//////import java.util.Properties;
//////
//////import javax.persistence.EntityManagerFactory;
//////import javax.sql.DataSource;
//////
//////import org.springframework.context.annotation.Bean;
//////import org.springframework.context.annotation.ComponentScan;
//////import org.springframework.context.annotation.Configuration;
//////import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//////import org.springframework.jdbc.datasource.DriverManagerDataSource;
//////import org.springframework.orm.jpa.JpaTransactionManager;
//////import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//////import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//////import org.springframework.transaction.annotation.EnableTransactionManagement;
//////import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//////import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//////import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//////import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//////import org.springframework.web.servlet.view.InternalResourceViewResolver;
//////import org.springframework.web.servlet.view.JstlView;
//////
//////
//////
//////@Configuration
//////@EnableWebMvc
//////@ComponentScan(basePackages = {"controller", "domain","dao", "service" })
//////@EnableJpaRepositories("dao")
//////@EnableTransactionManagement
//////public class MvcConfigure extends WebMvcConfigurerAdapter {
//////	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//////	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "";
//////	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost/foodDB?createDatabaseIfNotExist=true";
//////	private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
//////
//////	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
//////	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
//////	private static final String PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE = "1";
//////	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "update";
//////	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "domain";
//////
//////	@Bean
//////	public DataSource dataSource() {
//////		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//////		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
//////		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
//////		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
//////		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
//////
//////		return dataSource;
//////	}
//////
//////	@Bean
//////	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//////		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//////		em.setDataSource(dataSource);
//////		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//////		em.setJpaProperties(hibernateProperties());
//////		em.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
//////
//////		return em;
//////	}
//////
//////	private Properties hibernateProperties() {
//////		Properties properties = new Properties();
//////		properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
//////		properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
//////		properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO);
//////		properties.put("connection.pool.size", PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE);
//////
//////		return properties;
//////	}
//////
//////	@Bean
//////	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//////		JpaTransactionManager transactionManager = new JpaTransactionManager();
//////		transactionManager.setEntityManagerFactory(entityManagerFactory);
//////
//////		return transactionManager;
//////	}
//////
//////	// Resolves views selected for rendering by @Controllers to .jsp resources
//////	// in the /WEB-INF/views directory
//////	@Bean
//////	public InternalResourceViewResolver htmlViewResolver() {
//////		final InternalResourceViewResolver bean = new InternalResourceViewResolver();
//////		bean.setViewClass(JstlView.class);
//////		bean.setPrefix("/WEB-INF/views/");
//////		bean.setSuffix(".jsp");
//////		//bean.setSuffix(".html");
//////
//////		return bean;
//////	}
//////
//////	// -------------- Serving Resources ----------------------
//////	@Override
//////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//////		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//////	}
//////
//////	// -- Lets us find resources (.html etc) through the default servlet
//////	@Override
//////	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//////		configurer.enable();
//////	}
//////
//////}
////=======
////package configuration;
////
////import java.util.Properties;
////
////import javax.persistence.EntityManagerFactory;
////import javax.sql.DataSource;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
////import org.springframework.jdbc.datasource.DriverManagerDataSource;
////import org.springframework.orm.jpa.JpaTransactionManager;
////import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
////import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
////import org.springframework.transaction.annotation.EnableTransactionManagement;
////import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
////import org.springframework.web.servlet.config.annotation.EnableWebMvc;
////import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
////import org.springframework.web.servlet.view.InternalResourceViewResolver;
////import org.springframework.web.servlet.view.JstlView;
////
////
////
////@Configuration
////@EnableWebMvc
////@ComponentScan(basePackages = {"controller", "domain","dao", "service" })
////@EnableJpaRepositories("dao")
////@EnableTransactionManagement
////public class MvcConfigure extends WebMvcConfigurerAdapter {
////	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
////	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "root";
////	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost/foodDB?createDatabaseIfNotExist=true";
////	private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
////
////	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
////	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
////	private static final String PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE = "1";
////	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "update";
////	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "domain";
////
////	@Bean
////	public DataSource dataSource() {
////		DriverManagerDataSource dataSource = new DriverManagerDataSource();
////		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
////		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
////		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
////		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
////
////		return dataSource;
////	}
////
////	@Bean
////	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
////		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
////		em.setDataSource(dataSource);
////		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////		em.setJpaProperties(hibernateProperties());
////		em.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
////
////		return em;
////	}
////
////	private Properties hibernateProperties() {
////		Properties properties = new Properties();
////		properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
////		properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
////		properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO);
////		properties.put("connection.pool.size", PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE);
////		properties.put("current_session_context_class", "thread");
////
////		return properties;
////	}
////
////	@Bean
////	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
////		JpaTransactionManager transactionManager = new JpaTransactionManager();
////		transactionManager.setEntityManagerFactory(entityManagerFactory);
////
////		return transactionManager;
////	}
////
////	// Resolves views selected for rendering by @Controllers to .jsp resources
////	// in the /WEB-INF/views directory
////	@Bean
////	public InternalResourceViewResolver htmlViewResolver() {
////		final InternalResourceViewResolver bean = new InternalResourceViewResolver();
////		bean.setViewClass(JstlView.class);
////		bean.setPrefix("/WEB-INF/views/");
////		bean.setSuffix(".jsp");
////		//bean.setSuffix(".html");
////
////		return bean;
////	}
////
////	// -------------- Serving Resources ----------------------
////	@Override
////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
////	}
////
////	// -- Lets us find resources (.html etc) through the default servlet
////	@Override
////	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
////		configurer.enable();
////	}
////
////}
////>>>>>>> ca1e78d7162da247f4434b59218061587647fbd6
//=======
//package configuration;
//
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"controller", "domain","dao", "service" })
//@EnableJpaRepositories("dao")
//@EnableTransactionManagement
//public class MvcConfigure extends WebMvcConfigurerAdapter {
//	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "root";
//	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost/foodDB?createDatabaseIfNotExist=true";
//	private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
//
//	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
//	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
//	private static final String PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE = "1";
//	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "update";
//	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "domain";
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
//		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
//		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
//		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
//
//		return dataSource;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(dataSource);
//		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		em.setJpaProperties(hibernateProperties());
//		em.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
//
//		return em;
//	}
//
//	private Properties hibernateProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
//		properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
//		properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO);
//		properties.put("connection.pool.size", PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE);
//		properties.put("current_session_context_class", "thread");
//
//		return properties;
//	}
//
//	@Bean
//	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory);
//
//		return transactionManager;
//	}
//
//	// Resolves views selected for rendering by @Controllers to .jsp resources
//	// in the /WEB-INF/views directory
//	@Bean
//	public InternalResourceViewResolver htmlViewResolver() {
//		final InternalResourceViewResolver bean = new InternalResourceViewResolver();
//		bean.setViewClass(JstlView.class);
//		bean.setPrefix("/WEB-INF/views/");
//		bean.setSuffix(".jsp");
//		//bean.setSuffix(".html");
//
//		return bean;
//	}
//
//	@Bean
//	public CommonsMultipartResolver multipartResolver(){
//	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//	    commonsMultipartResolver.setDefaultEncoding("utf-8");
//	    commonsMultipartResolver.setMaxUploadSize(50000000);
//	    return commonsMultipartResolver;
//	}
//	
//	// -------------- Serving Resources ----------------------
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//	}
//
//	// -- Lets us find resources (.html etc) through the default servlet
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//
//}
//
//>>>>>>> c0bfb943b2d00c8dbcbbc5d5d72b10ff3e3e82c9
>>>>>>> 1bfc4fb0b2c06c1905dc8908161c7264452aa346
*/