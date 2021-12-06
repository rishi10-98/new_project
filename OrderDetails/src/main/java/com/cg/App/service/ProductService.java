package com.cg.App.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.App.model.Product;
import com.cg.App.repository.ProductRepository;



@Service
public class ProductService {
	private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepo;
	//dependency injection of class
	// Get All Employee
	
// pagination added 
	public Page<Product> getallmedicines(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		return productRepo.findAll(page);
	}

     // Add product to stock 
		public Product addMedicine(Product product) {
			return productRepo.save(product);
		}

		public Optional<Product> findwithId(Long id) {
			return productRepo.findById(id);
		}
//remove product
		public Long removeMedicine(Long id) {
			productRepo.deleteById(id);
			return id;
		}
//view all medicine
		public List<Product> getallmedicines() {
			return productRepo.findAll();
		}
//searching the product
		public List<Product> Searchproduct(String keyword){
			LOG.info(keyword);
			if (keyword != null) {
				
				List<Product>result=productRepo.Search(keyword);
				
				return result;
        }
			else
				return productRepo.findAll();
			
			
		}
		

		
}
