package com.wang.oa.report.weekly.configurations;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wang.oa.report.weekly.models.DatabaseConfiguration;

//@EnableWebMvc
@Configuration
@EnableConfigurationProperties({ PropertySourcesPlaceholderConfigurer.class })
@PropertySource(value = { "classpath:config/application.properties" }, ignoreResourceNotFound = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter/* implements ApplicationContextAware*/{
	final Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@ConfigurationProperties(prefix = "database.connection")
	@Bean
	public DatabaseConfiguration getDatabaseConfiguration() {
		return new DatabaseConfiguration();
	}

	@ConfigurationProperties("database.connection")
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
