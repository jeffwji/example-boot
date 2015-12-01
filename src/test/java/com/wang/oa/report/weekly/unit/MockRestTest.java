package com.wang.oa.report.weekly.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.wang.oa.report.weekly.ControllerTestBase;
import com.wang.oa.report.weekly.WeeklyReportMainClass;

@SpringApplicationConfiguration(classes = WeeklyReportMainClass.class)
public class MockRestTest extends ControllerTestBase {
	//@Autowired HomeRestController homeRest;

	@Override
	public String getUserName() {
		return "someone";
	}

	@Override
	public String getPassword() {
		return "Pa55w0rd";
	}

	@Override
	public String[] getAuthorities() {
		return new String[] { "ANONYMOUS" };
	}

	@Test
	public void TestHomeRest() throws Exception {
		ResultActions resultActions;
		//更新车辆属性信息
		resultActions = mockMvc.perform(get("/").session(session).contentType(MediaType.APPLICATION_XML)
				.accept(MediaType.APPLICATION_XML));
		resultActions.andDo(print()).andExpect(status().isOk());
		return;
	}
}
