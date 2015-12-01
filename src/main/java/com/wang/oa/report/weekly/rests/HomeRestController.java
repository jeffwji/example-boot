package com.wang.oa.report.weekly.rests;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.oa.report.weekly.models.DatabaseConfiguration;

@RestController
@ConfigurationProperties(prefix = "app")
public class HomeRestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired DatabaseConfiguration dbConfig;

	@NotNull/*@Value("${app.greeting}")*/private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE })
	public @ResponseBody List<String> greeting() {
		return Arrays.asList(dbConfig.getUsername() + ": " + greeting);
	}
}
