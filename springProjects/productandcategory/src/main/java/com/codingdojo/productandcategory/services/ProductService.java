package com.codingdojo.productandcategory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.CategoryProduct;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.repositories.CategoryProductRepository;
import com.codingdojo.productandcategory.repositories.CategoryRepository;
import com.codingdojo.productandcategory.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final CategoryProductRepository categoryProductRepository;

	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository,CategoryProductRepository categoryProductRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.categoryProductRepository = categoryProductRepository;
	}
	
	public Product getProduct (Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product b) {
		return productRepository.save(b);
	}
	
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}
	
	public CategoryProduct createCategoryProduct(CategoryProduct b) {
		return categoryProductRepository.save(b);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public List<Product> findProductsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public Product addProduct (Product p ) {
		return productRepository.save(p);
	}
	
	public Category addCategory (Category p) {
		return categoryRepository.save(p);
	}
	
	public CategoryProduct add(CategoryProduct p ) {
		return categoryProductRepository.save(p);
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		product.getCategories().add(category);
		productRepository.save(product);
	}
	
	public void addProductToCategory(Category category, Product product) {
		category.getProducts().add(product);
		categoryRepository.save(category);
	}
}
