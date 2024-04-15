package natureblossom.ims.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import natureblossom.ims.dbtest.CsvDataSetLoader;
import natureblossom.ims.entity.Product;
import natureblossom.ims.entity.ProductBuilder;
import natureblossom.ims.repository.ProductMapper;
import natureblossom.ims.service.ProductService;

@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class
})
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@ExtendWith(SpringExtension.class)
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class ProductRegistrationControllerTest {
	
	@Autowired
    private MockMvc mockmvc;
	
	@Autowired
	private ProductMapper mapper;
	
	@MockBean
	private ProductService service;
	
	private ProductBuilder builder = new ProductBuilder();
	private Product product = builder.buildProduct();
	
	@Autowired
	private Validator validator;
	
	@Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Test
	@Disabled
	void test_getProductRegistration_success() throws Exception {
		this.mockmvc.perform(get("/product-registration"))
        	.andExpect(status().isOk())
        	.andExpect(view().name("product-registration"));
	}
	
	/** test product can be registered */
	@Test
	@Disabled
	@DatabaseSetup(value = "/testData/setup")
	@ExpectedDatabase(value = "/testData/insert",
			table = "product_entity",
			assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void test_noramlity() throws Exception {
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasNoErrors())
				.andExpect(redirectedUrl("/product-list"));			
	}
	
	@Test
	@Disabled
	void test_registerSuccessMessage() throws Exception {
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(MockMvcResultMatchers.flash().attribute("message",
						"The product has been registered."))
				.andExpect(redirectedUrl("/product-list"));			
		}
	
	@Test
	@Disabled
    void test_nameNullCausesError() throws Exception {
		product.setName(null);
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasErrors())
				.andExpect(view().name("product-registration"));
		// assertThat(bindingResult().getFieldError().getObjectName().equals("name"));
		// assertThat(bindingResult.getFieldError().toString()).contains("must not be blank");
	}
	
	@Test
	@Disabled
    void test_nameSize40IsOk() throws Exception {
		product.setName("abcdefghijklmnopqrstuvwxyz12345678901234");
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasNoErrors())
				.andExpect(redirectedUrl("/product-list"));
	}
	
	@Test
	@Disabled
    void test_nameSize41CausesError() throws Exception {
		product.setName("abcdefghijklmnopqrstuvwxyz123456789012341");
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasErrors())
				.andExpect(view().name("product-registration"));
	}
	
	@Test
	@Disabled
    void test_manufacturerSize30IsOk() throws Exception {
		product.setManufacturer("abcdefghijklmnopqrstuvwxyz1234");
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasNoErrors())
				.andExpect(redirectedUrl("/product-list"));
	}
	
	@Test
	@Disabled
    void test_manufacturerSize31CausesError() throws Exception {
		product.setManufacturer("abcdefghijklmnopqrstuvwxyz12345");
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasErrors())
				.andExpect(view().name("product-registration"));
	}
	
	@Test
	@Disabled
    void test_quantity1IsOk() throws Exception {
		product.setQuantity(1);
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasNoErrors())
				.andExpect(redirectedUrl("/product-list"));
	}
	
	@Test
	@Disabled
    void test_quantity0CausesError() throws Exception {
		product.setQuantity(0);
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasErrors())
				.andExpect(view().name("product-registration"));
	}
	
	@Test
	@Disabled
    void test_quantity9999IsOk() throws Exception {
		product.setQuantity(9999);
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasNoErrors())
				.andExpect(redirectedUrl("/product-list"));
	}
	
	@Test
	@Disabled
    void test_quantity10000CausesError() throws Exception {
		product.setQuantity(10000);
		this.mockmvc.perform(post("/product-registration").flashAttr("product", product))
				.andExpect(model().hasErrors())
				.andExpect(view().name("product-registration"));
	}
}
