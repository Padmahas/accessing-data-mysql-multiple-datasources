/**
 * 
 */
package com.example.accessingdatamysql.firstdb;

import com.example.accessingdatamysql.Table_AOld;
/**
 * @author padmahasa
 *
 */
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration(proxyBeanMethods = false)
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "firstDBEntityManagerFactory", transactionManagerRef = "firstDBTransactionManager")
public class FirstDataSource {

//	@Bean
////	@Primary
//	@ConfigurationProperties("app.datasource.first")
//	public DataSourceProperties firstDataSourceProperties() {
//		return new DataSourceProperties();
//	}
//
////	@Bean("firstDS")
//	@Bean
////	@Primary
//	@ConfigurationProperties("app.datasource.first.configuration")
//	public HikariDataSource firstDataSource(DataSourceProperties firstDataSourceProperties) {
//		return firstDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//	}
//
//	@Bean
////	@Primary
//	public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(DataSource firstDataSource,
//			DataSourceProperties firstDataSourceProps) {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//
//		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setDataSource(firstDataSource(firstDataSourceProps));
//		factoryBean.setJpaVendorAdapter(vendorAdapter);
//		factoryBean.setPackagesToScan(FirstDataSource.class.getPackage().getName());
//
//		return factoryBean;
//	}

//	------------------------------------------------------------------------------------------------------------------
	@Bean
	PlatformTransactionManager firstDBTransactionManager(DataSourceProperties firstDataSourceProperties) {
		return new JpaTransactionManager(firstDBEntityManagerFactory(firstDataSourceProperties).getObject());
	}

	@Bean
	@Primary
	LocalContainerEntityManagerFactoryBean firstDBEntityManagerFactory(DataSourceProperties firstDataSourceProperties) {

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(firstDS(firstDataSourceProperties));
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan(FirstDataSource.class.getPackage().getName());

		return factoryBean;
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.first")
	public DataSourceProperties firstDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.first.configuration")
	public HikariDataSource firstDS(DataSourceProperties firstDataSourceProperties) {
		return firstDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	
//	------------------------------------------------------------------------------------------------------------------
	
//	@Bean
//    @ConfigurationProperties("app.jpa.first")
//    public JpaProperties firstJpaProperties() {
//        return new JpaProperties();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(DataSource firstDataSource,
//            JpaProperties firstJpaProperties) {
//        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(firstJpaProperties);
//        return builder.dataSource(firstDataSource).packages(Table_A.class).persistenceUnit("firstDs").build();
//    }
//
//    private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties jpaProperties) {
//        JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(jpaProperties);
//        return new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.getProperties(), null);
//    }
//
//    private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
//        // ... map JPA properties as needed
//    	HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//    	jpaVendorAdapter.setGenerateDdl(true);
//        return jpaVendorAdapter;
//    }

}