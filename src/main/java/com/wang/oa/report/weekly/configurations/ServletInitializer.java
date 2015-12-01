package com.wang.oa.report.weekly.configurations;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.wang.oa.report.weekly.WeeklyReportMainClass;

public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeeklyReportMainClass.class);
	}
}
