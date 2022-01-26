package com.app.bookstore.controllers;

import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.VO.ProductsVO;
import com.app.bookstore.dto.Products;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.exceptions.ProductNotFoundException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.ProductRepo;
import com.app.bookstore.repo.UsersRepo;
import com.app.bookstore.service.ProductsService;

@RestController
public class ProductController {

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ProductsService productsService;

		
	boolean PRODUCT_STATUS = true;
	Integer UNITS_ON_SOLD=0;
	@PostMapping("/addProduct/{supplierId}")
	public ResponseEntity<String> addProduct(@RequestBody @Valid Products product, @PathVariable("supplierId") Integer supplierId, BindingResult result) throws UserIdNotFoundException, InvalidInputException{
		productsService.performValidation(result);
		product.setProductId(productsService.generateProductId());
		product.setSupplierId(usersRepo.findById(supplierId).orElseThrow(()->new UserIdNotFoundException("Invalid ID!")));
		product.setStatus(PRODUCT_STATUS);
		product.setUnitsOnSold(UNITS_ON_SOLD);
		productRepo.save(product);
		return new ResponseEntity<>("product creation successfull!!",HttpStatus.OK);	
	}
	
	
	@GetMapping("/myProducts/{supplierId}")
	public  Set<ProductsVO> retrieveAllProductsAddedBySupplier(@PathVariable("supplierId") Integer supplierId ) throws UserIdNotFoundException{
			return productsService.mapList(usersRepo.findById(supplierId).orElseThrow(()->new UserIdNotFoundException("Invalid ID!")).getProduct(),ProductsVO.class);	
	}
	
	@PutMapping("/editProduct")
	public ResponseEntity<String> updateProductInformation(@RequestBody @Valid ProductsVO productsVO, BindingResult result) throws ProductNotFoundException, InvalidInputException{
		productsService.performValidation(result);
		Products product = productRepo.findById(productsVO.getProductId()).orElseThrow(()->new ProductNotFoundException("Invalid Product Info"));
		product.setName(productsVO.getName());
		product.setDescription(productsVO.getDescription());
		product.setPrice(productsVO.getPrice());
		product.setUnitsInStock(productsVO.getUnitsInStock());
		product.setStatus(productsService.getStatus(productsVO.getUnitsInStock()));
		productRepo.save(product);
		return new ResponseEntity<>("product details updated successfully!!",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/removeProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId){
		productRepo.deleteById(productId);
		return new ResponseEntity<>("product deletion successfull!!",HttpStatus.OK);
	}
		
}
