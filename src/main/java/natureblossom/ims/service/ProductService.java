package natureblossom.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import natureblossom.ims.entity.Product;
import natureblossom.ims.repository.ProductMapper;


/**
 * Carry out DB transactions.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * Insert product
	 * 
	 * @param product
	 */
	@Transactional
	public void insertProduct(Product product) {
		productMapper.insertProduct(product);
	}
	
	
	public List<Product> getProductList() {
		return productMapper.getProductList();
	}
}