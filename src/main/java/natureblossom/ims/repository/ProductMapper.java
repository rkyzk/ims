package natureblossom.ims.repository;

import org.apache.ibatis.annotations.Mapper;

import natureblossom.ims.entity.Product;


@Mapper
public interface ProductMapper {
	// insert product
	public void insertProduct(Product product);
}