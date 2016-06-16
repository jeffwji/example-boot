package net.tinybrick.example.controllers.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.ResultActions;

import net.tinybrick.database.mybatis.configuration.MyBatisConfiguration;
import net.tinybrick.database.tx.configuration.TransactionManagerConfigure;
import net.tinybrick.example.configuration.ApplicationConfigure;
import net.tinybrick.security.configure.SecurityConfigure;
import net.tinybrick.web.configure.ApplicationCoreConfigure;
import net.tinybrick.web.unit.ControllerTestBase;

@TestPropertySource(locations = "classpath:config/example.properties")
@SpringApplicationConfiguration(classes = { MyBatisConfiguration.class, TransactionManagerConfigure.class,
		ApplicationConfigure.class, SecurityConfigure.class, ApplicationCoreConfigure.class, })
public class FooControllerTest extends ControllerTestBase {

	@Test
	public void TestFooRest() throws Exception {
		ResultActions resultActions;

		resultActions = mockMvc.perform(get("/foo").session(session).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		resultActions.andDo(print()).andExpect(status().isOk());
	}
}
