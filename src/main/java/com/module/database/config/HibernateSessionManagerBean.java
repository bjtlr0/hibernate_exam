package com.module.database.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Spring 5, hibernate 5, springboot 2 버전 이상이 필요한 설정방법이다.
 * xml을 이용한 설정을 하지 않고 소스상에서 bean에 등록하여 처리한다.
 * 
 * == Usage ==
 *
 * public abstract class someDao{
 * 		@Autowired
 * 		private SessionFactory sessionFactory;
 * 
 * 		public void someFunc(){
 * 			Session session = sessionFactory.openSession(); // or currentOpenSession	
 * 		}
 * }
 * 
 * */

@Configuration
@EnableTransactionManagement
//@ImportResource({"classpath:ExistPathSomeXmlConfig.xml"}) // <- 이런식으로 설정파일 리소르를 직접 입력할 수도 있다.
public class HibernateSessionManagerBean {
	// FIXME : 이건 에러 안나게 하려고 그냥 작성한것이므로 아무 의미가 없습니다.
	class LocalSessionFactoryBean {
		void setDataSource(DataSource dataSource){
		}
		void setPackagesToScan(String[] args){
		}
		void setHibernateProperties(Properties p){
		}
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){ // LocalSessionFactoryBean은 Hibernate5 에서 사용 가능
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		String[] a = {"some.hibernate.model.package"};
		sessionFactory.setPackagesToScan(a);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/somedatabase");
		dataSource.setUsername("someUser");
		dataSource.setPassword("somePassword");
		return dataSource;
	}
	
	private final Properties hibernateProperties(){
		Properties hibernateProperties = new Properties();
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return hibernateProperties;
	}
}
