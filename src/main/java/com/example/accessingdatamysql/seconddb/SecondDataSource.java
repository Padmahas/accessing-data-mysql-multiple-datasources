/**
 * 
 */
package com.example.accessingdatamysql.seconddb;

import com.example.accessingdatamysql.Table_AOld;
/**
 * @author padmahasa
 *
 */
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration(proxyBeanMethods = false)
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "secondDBEntityManagerFactory",
transactionManagerRef = "secondDBTransactionManager")
public class SecondDataSource {

	@Bean
	PlatformTransactionManager secondDBTransactionManager(DataSourceProperties secondDataSourceProperties) {
		return new JpaTransactionManager(secondDBEntityManagerFactory(secondDataSourceProperties).getObject());
	}
	
	@Bean
	@ConfigurationProperties("app.datasource.second")
	public DataSourceProperties secondDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("app.datasource.second.configuration")
	public HikariDataSource secondDS(
			@Qualifier("secondDataSourceProperties") DataSourceProperties secondDataSourceProperties) {
		return secondDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean secondDBEntityManagerFactory(DataSourceProperties secondDataSourceProperties) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(secondDS(secondDataSourceProperties));
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(SecondDataSource.class.getPackage().getName());

		return factoryBean;
	}

}