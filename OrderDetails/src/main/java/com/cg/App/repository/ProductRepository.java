package com.cg.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.App.model.Product;


public interface ProductRepository extends JpaRepository<Product ,Long>{
//searching query
	@Query(value= "SELECT*FROM product p WHERE p.prod_name LIKE %?1% OR p.mfg_name LIKE %?1%" , nativeQuery = true)
	public List<Product> Search(@Param("keyword") String keyword);
}
