package com.wang.oa.report.weekly.controllers;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wang.oa.report.weekly.dao.mybatis.TestDao;

@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired TestDao testDao;

	@RequestMapping("/home")
	public String home(Map<String, Object> model) {
		model.put("message", "Hello World");
		model.put("title", "Hello Home");
		model.put("date", new Date());
		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "jsp/index";
	}
}
