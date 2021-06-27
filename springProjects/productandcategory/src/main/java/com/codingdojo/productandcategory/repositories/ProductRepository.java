package com.codingdojo.productandcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
