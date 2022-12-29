package com.peazy.customer.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "defaultEntityManagerFactory", transactionManagerRef = "defaultTransactionManager", basePackages = {
		"com.peazy.customer.repository"  })
public class DefaultDbConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariConfig defaultHikariConfig() {
		return new HikariConfig();
	}

	@Primary
	@Bean(name = "defaultDataSource")
	@ConfigurationProperties("spring.datasource")
	public DataSource defaultDataSource(HikariConfig defaultHikariConfig) {
		HikariDataSource ds = new HikariDataSource(defaultHikariConfig);
		return ds;
	}

	@Primary
	@Bean(name = "defaultEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("defaultDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.peazy.customer.model.entity").persistenceUnit("defaultDb")
				.build();
	}

	@Primary
	@Bean(name = "defaultTransactionManager")
	public PlatformTransactionManager defaultTransactionManager(
			@Qualifier("defaultEntityManagerFactory") EntityManagerFactory defaultEntityManagerFactory) {
		return new JpaTransactionManager(defaultEntityManagerFactory);
	}
}
