package com.wang.oa.report.weekly;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public abstract class ControllerTestBase {
	public abstract String getUserName();

	public abstract String getPassword();

	public abstract String[] getAuthorities();

	@Autowired protected WebApplicationContext webApplicationContext;
	@Autowired protected MockHttpSession session;
	//@Autowired protected UserProperties userProperties;

	protected MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		initSecurityContext();
		//initUserProperties();
	}

	protected void initSecurityContext() {
		String[] authorities = getAuthorities();

		// Prepare security context
		User user = new User(getUserName(), getPassword(), AuthorityUtils.createAuthorityList(authorities));
		//TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(user, null);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				user, null);
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

	}

	/*protected void initUserProperties() {
		String[] authorities = getAuthorities();

		// Prepare UserProperties
		Token<String> token = new Token<String>();
		token.setUserName(getUserName());
		userProperties.setCredential(token);

		List<Authority<String, String>> authorityList = new ArrayList<Authority<String, String>>();
		for (String authoryName : authorities) {
			Authority<String, String> authority = new Authority<String, String>();
			authority.setAuthority(authoryName);
			authorityList.add(authority);
		}
		userProperties.setAuthorities(authorityList);
	}*/
}
