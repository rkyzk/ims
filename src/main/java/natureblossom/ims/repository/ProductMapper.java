package natureblossom.ims.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import natureblossom.ims.entity.Product;


@Mapper
public interface ProductMapper {
	/** insert product */
	public void insertProduct(Product product);
	/** get product list */
	public List<Product> getProductList();
	/** get product by id */
	public Product getProduct(int id);
	/** update product by id */
	public int updateProduct(Product product);
}