package com.wang.oa.report.weekly;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

@DirtiesContext
@ContextHierarchy({ @ContextConfiguration(locations = { "classpath:applicationContext-database.xml",
		"classpath:applicationContext-sms.xml", "classpath:applicationContext-security.xml","classpath:applicationContext-test.xml"  }) })
public abstract class ServiceUnitTestBase {}
