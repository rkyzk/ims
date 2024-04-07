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
	 * Insert product.
	 * 
	 * @param product
	 */
	@Transactional
	public void insertProduct(Product product) {
		productMapper.insertProduct(product);
	}
	
	/**
	 * Get product list.
	 * 
	 * @return List<Product>
	 */
	public List<Product> getProductList() {
		return productMapper.getProductList();
	}

	/**
	 * Get product
	 * 
	 * @param id
	 * @return product
	 */
	public Product getProduct(int id) {
		return productMapper.getProduct(id);
	}

	/**
	 * Update product
	 * 
	 * @param id
	 * @return product
	 */
	@Transactional
	public int updateProduct(Product product) {
		return productMapper.updateProduct(product);
	}
	
	/**
	 * Delete product
	 * 
	 * @param id
	 * @return product
	 */
	@Transactional
	public int deleteProduct(int id) {
		return productMapper.deleteProduct(id);
	}
}