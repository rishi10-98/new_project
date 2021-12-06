package com.cg.App.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.App.exception.ResourceNotFoundException;
import com.cg.App.model.Product;
import com.cg.App.repository.ProductRepository;
import com.cg.App.service.ProductService;


//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")


@RestController
public class ProductController {
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
@Autowired
ProductService productService;

//get list of all, medicine
@GetMapping("/")
public void Home() {
	System.out.println("welcome to medstore app");
}

@GetMapping("/getallproduct")
public Page <Product>getAll(@RequestParam int pageSize, @RequestParam(required = false , defaultValue = "0") int pageNumber){
	return productService.getallmedicines(pageNumber,pageSize);
}
//add medicine to database
@PostMapping("/AddProduct")
public Product addProduct(@RequestBody Product product) {
	LOG.info("Add Product");
	return productService.addMedicine(product);
}
// delete product 
@DeleteMapping("/deleteMedicine/{id}")
public Long deleteMedicine (@PathVariable Long id) {
	LOG.info("deleting product");
	return productService.removeMedicine(id);
}

//getproduct by id 
@GetMapping("/getbyid/{id}")
public ResponseEntity<Product> getmedicineById(@PathVariable Long id){
	Product product = productService.findwithId(id)
			.orElseThrow(()->new ResourceNotFoundException("product not found with id :"+id));
	return ResponseEntity.ok(product);
}

//updating Data
@PutMapping("/updateProduct/{id}")
public ResponseEntity<Product> updateMedicine(@PathVariable Long id,@RequestBody Product newProduct) {
	Product currentProduct = productService.findwithId(id)
			.orElseThrow(()->new ResourceNotFoundException("product not found with id :"+id));
	newProduct.setProductId(currentProduct.getProductId());
	//newProduct.setProductId(id);
	//Product updatedProduct = productService.addMedicine(newProduct);
	Product updatedProduct = productService.addMedicine(newProduct);
	return ResponseEntity.ok(updatedProduct);
	
}
@GetMapping("/search")
//searching medicine 
public List<Product> Searchmedicine(String keyword){
	LOG.info("searching keyword");
	return productService.Searchproduct(keyword);
}
}
