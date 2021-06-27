package com.codingdojo.productandcategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/products/new")
		public String newProduct(@ModelAttribute("product") Product product) {
			return "newProduct.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
		public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
			if (result.hasErrors()) {
				return "newProduct.jsp";
			} else {
				productService.createProduct(product);
				return "redirect:/products";
			}
	}
	
	@RequestMapping("/categories/new")
		public String newCategory(@ModelAttribute("category") Category category) {
			return "newCategory.jsp";
	}
	
	@RequestMapping(value="/categories/new",method=RequestMethod.POST)
		public String createCategory(@Valid @ModelAttribute("category") Category category,BindingResult result) {
			if (result.hasErrors()) {
				return "newCategory.jsp";
			} else {
				productService.createCategory(category);
				return "redirect:/categories";
			}
	}
	
	@RequestMapping("/categories")
		public String categories(Model model) {
		List<Category> categ = productService.getAllCategories();
		model.addAttribute("cat",categ);
		return "categories.jsp";
	}
	
	@RequestMapping("/products")
		public String products(Model model) {
		List<Product> prod = productService.getAllProducts();
		model.addAttribute("pro", prod);
		return "products.jsp";
	}
	
	@RequestMapping("/products/{id}")
		public String showProduct(@PathVariable("id") Long id,Model model) {
			model.addAttribute("product", productService.getProduct(id));
			model.addAttribute("category", productService.findCategoriesNotInProduct(productService.getProduct(id)));
			return "showProduct.jsp";
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
		public String createRelation(@PathVariable("id") Long id,Model model, @RequestParam("category_id") Long category_id) {
		Product product = productService.getProduct(id);
		Category category = productService.getCategory(category_id);
		productService.addCategoryToProduct(product, category);
		return "redirect:/products/"+id;
	}
	
	@RequestMapping("/categories/{id}")
		public String showCategory(@PathVariable("id") Long id,Model model) {
			model.addAttribute("category", productService.getCategory(id));
			model.addAttribute("product", productService.findProductsNotInCategory(productService.getCategory(id)));
			return "showCategory.jsp";
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
		public String createMoreRelation(@PathVariable("id") Long id,Model model, @RequestParam("product_id") Long product_id) {
			Category category = productService.getCategory(id);
			Product product = productService.getProduct(product_id);
			productService.addProductToCategory(category, product);
			return "redirect:/categories/"+id;
	}
}
