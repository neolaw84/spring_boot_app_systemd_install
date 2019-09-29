package space.qbpo.spring_boot_systemd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import space.qbpo.spring_boot_systemd.MyRestController;
import space.qbpo.spring_boot_systemd.MyRestController.MyResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers= {MyRestController.class})
@ActiveProfiles(profiles = {"web"})
public class MyRestControllerTests {
	@Autowired private MockMvc mvc;
	@Autowired ObjectMapper objectMapper;
	
	@Test
	public void testHello () throws Exception {
		MvcResult result = mvc.perform(get("/api/hello")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
		.andExpect(status().isOk())
		//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
		
		MyResponse myResult = objectMapper.readValue(result.getResponse().getContentAsByteArray(), 
				MyResponse.class);
		assert("Hello".equals(myResult.getFstring()));
	}
	
	@Test
	public void testAfterPropertiesSet () throws Exception {
		MyRestController mrc = new MyRestController();
		mrc.afterPropertiesSet();
	}	
}