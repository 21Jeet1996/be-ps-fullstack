package com.product.service.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.model.Product;
import com.product.service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	// @Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public CompletableFuture<List<Product>> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public CompletableFuture<Optional<Product>> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public CompletableFuture<Product> createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public CompletableFuture<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		return productService.saveProduct(product);
	}

	@DeleteMapping("/{id}")
	public CompletableFuture<Void> deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
}
