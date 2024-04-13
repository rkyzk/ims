package natureblossom.ims.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc//MockMvcの利用
@SpringBootTest
class ProductRegistrationControllerTest {
	
	@Autowired
    private MockMvc mockmvc;

	@Test
	void test_getProductRegistration_success() throws Exception {
		this.mockmvc.perform(get("/product-registration"))
        	.andDo(print())
        	.andExpect(status().isOk());
	}

}
