package com.product.service.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.product.service.model.Product;
import com.product.service.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Async
	public CompletableFuture<List<Product>> getAllProducts() {
		return CompletableFuture.completedFuture(productRepository.findAll());
	}

	@Async
	public CompletableFuture<Optional<Product>> getProductById(Long id) {
		return CompletableFuture.completedFuture(productRepository.findById(id));
	}

	@Async
	public CompletableFuture<Product> saveProduct(Product product) {
		return CompletableFuture.completedFuture(productRepository.save(product));
	}

	@Async
	public CompletableFuture<Void> deleteProduct(Long id) {
		productRepository.deleteById(id);
		return CompletableFuture.completedFuture(null);
	}
}
