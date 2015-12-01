package com.wang.oa.report.weekly;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.wang.database.mybatis.configuration.MyBatisConfiguration;
import com.wang.database.tx.configuration.TransactionManagerConfigure;
import com.wang.security.configure.SecurityConfigure;
import com.wang.web.configure.ApplicationCoreConfigure;

/**
 * Hello world!
 */

@EnableAutoConfiguration
@ComponentScan
@Import(value = { SecurityConfigure.class, ApplicationCoreConfigure.class, TransactionManagerConfigure.class,
		MyBatisConfiguration.class })
@MapperScan("com.wang.oa.report.weekly.dao.mybatis")
public class WeeklyReportMainClass {
	static final Logger logger = Logger.getLogger(WeeklyReportMainClass.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WeeklyReportMainClass.class);
		app.setShowBanner(false);
		app.run(args);

		logger.info("Server is running...");
	}
}
