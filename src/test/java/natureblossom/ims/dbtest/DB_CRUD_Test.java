package natureblossom.ims.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import natureblossom.ims.service.ProductService;

@SpringBootTest
@Transactional
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@TestExecutionListeners({
      DependencyInjectionTestExecutionListener.class,
      TransactionDbUnitTestExecutionListener.class
    })
public class DB_CRUD_Test {
	@Autowired
    private ProductService service;

	
}
