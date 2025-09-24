package com.product.service.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.id In :id")
	List<Product> searchById(@Param("id") List<Long> id);
	
	@Query("select p from Product p where p.id In :id")
	Page<Product> getPage(@Param("id") List<Long> id, Pageable page);
}
