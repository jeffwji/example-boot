package com.wang.oa.report.weekly.it;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wang.oa.report.weekly.WeeklyReportMainClass;
import com.wang.security.authentication.filter.EnhancedBasicAuthenticationFilter.IEncryptionManager;
import com.wang.web.it.IntegrationTestBase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WeeklyReportMainClass.class)
@WebAppConfiguration
@IntegrationTest({ "server.port:0", "authentication.filter.captcha:false",
		"authentication.filter.captcha.minAcceptedWordLength:1",
		"authentication.filter.captcha.maxAcceptedWordLength:1", "authentication.filter.captcha.randomWords:0" })
@DirtiesContext
public class WeeklyReportIT extends IntegrationTestBase {
	@Override
	public String getUsername() {
		return "user";
	}

	@Override
	public String getPassword() {
		return "user";
	}

	@Value("${local.server.port}") private int port;
	@Autowired(required = false) IEncryptionManager encryptionManager;
	@Value("${authentication.filter.enhanced_basic:true}") boolean enhancedBasic;

	@Test
	public void testHome() throws Exception {
		TestRestTemplate testRestTemplate = null;
		HttpHeaders headers = new HttpHeaders();

		if (enhancedBasic) {
			testRestTemplate = getRestTemplate(null, null);
			headers.add("Authorization", "Basic " + encryptionManager.encrypt(getUsername() + ":" + getPassword()));
		}
		else {
			testRestTemplate = getRestTemplate();
		}

		ResponseEntity<String> entity = testRestTemplate.exchange("http://localhost:" + this.port + "/",
				HttpMethod.GET, new HttpEntity<Void>(headers), String.class);

		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
		Assert.assertTrue(entity.getBody().contains("Hello WeeklyReport!"));
	}
}
