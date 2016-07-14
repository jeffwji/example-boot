package net.tinybrick.example;

import org.apache.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import net.tinybrick.database.mybatis.configuration.MyBatisConfiguration;
import net.tinybrick.database.tx.configuration.TransactionManagerConfigure;
import net.tinybrick.security.configure.SecurityConfigure;
import net.tinybrick.web.configure.ApplicationCoreConfigure;

@ComponentScan
@Import(value = { SecurityConfigure.class, ApplicationCoreConfigure.class, MyBatisConfiguration.class,
		TransactionManagerConfigure.class })
public class MainClass {
	static final Logger logger = Logger.getLogger(MainClass.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MainClass.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

		logger.info("Server is running...");
	}

}
