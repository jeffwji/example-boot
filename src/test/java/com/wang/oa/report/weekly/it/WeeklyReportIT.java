package com.wang.oa.report.weekly.it;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.wang.oa.report.weekly.WeeklyReportMainClass;

@SpringApplicationConfiguration(classes = WeeklyReportMainClass.class)
public class WeeklyReportIT extends ITestBase {
	@Test
	public void testHome() throws Exception {
		@SuppressWarnings("rawtypes") ResponseEntity<List> entity = get(
				"http://localhost" + (0 == port ? "" : (":" + port)) + "/", Arrays.asList(MediaType.APPLICATION_XML),
				List.class);

		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
		Assert.assertTrue(entity.getBody().contains("Hello WeeklyReport!"));
	}
}
