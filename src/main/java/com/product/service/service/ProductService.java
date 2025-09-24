package com.product.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Async("taskExecutor")
	public CompletableFuture<List<Product>> getAllProducts() {
		return CompletableFuture.completedFuture(productRepository.findAll());
	}

	@Async("taskExecutor")
	public CompletableFuture<Optional<Product>> getProductById(Long id) {
		return CompletableFuture.completedFuture(productRepository.findById(id));
	}

	@Async("taskExecutor")
	public CompletableFuture<Product> saveProduct(Product product) {

		for (int i = 25602; i < 100000; i++) {
			Product p = new Product();
			p.setName(product.getName() + " " + i);
			p.setPrice(product.getPrice() + i);
			productRepository.save(p);
		}

		return CompletableFuture.completedFuture(productRepository.save(product));
	}

	@Async("taskExecutor")
	public CompletableFuture<Void> deleteProduct(Long id) {
		productRepository.deleteById(id);
		return CompletableFuture.completedFuture(null);
	}

	public List<Product> getBundleData() {
		List<Long> list = new ArrayList<>();
		for (long i = 1; i < 15000; i++) {
			list.add(i);
		}
		return productRepository.searchById(list);
	}

	public Page<Product> getPage(/* int page, int size */) {
		/* Pageable pageable = PageRequest.of(page, size); */
		List<Long> list = new ArrayList<>();
		for (long i = 1; i < 15000; i++) {
			list.add(i);
		}
		return productRepository.getPage(list, Pageable.unpaged(Sort.by("id").descending()));
	}
}
