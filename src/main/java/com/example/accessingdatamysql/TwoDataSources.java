/**
 * 
 */
package com.example.accessingdatamysql;

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
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration(proxyBeanMethods = false)
public class TwoDataSources {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first.configuration")
    public HikariDataSource firstDataSource(DataSourceProperties firstDataSourceProperties) {
        return firstDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(DataSource firstDataSource) {
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		DataSourceProperties firstDataSourceProps = firstDataSourceProperties();
		factoryBean.setDataSource(firstDataSource(firstDataSourceProps));
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(TwoDataSources.class.getPackage().getName());

		return factoryBean;
    }

    @Bean
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second.configuration")
    public HikariDataSource secondDataSource(
            @Qualifier("secondDataSourceProperties") DataSourceProperties secondDataSourceProperties) {
        return secondDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(DataSource secondDataSource) {
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		DataSourceProperties secondDataSourceProps = secondDataSourceProperties();
		factoryBean.setDataSource(firstDataSource(secondDataSourceProps));
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(TwoDataSources.class.getPackage().getName());

		return factoryBean;
    }

}