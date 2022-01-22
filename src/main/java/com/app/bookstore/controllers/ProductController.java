package com.app.bookstore.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.VO.ProductsVO;
import com.app.bookstore.dto.Products;
import com.app.bookstore.dto.Users;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.ProductRepo;
import com.app.bookstore.repo.UsersRepo;

@RestController
public class ProductController {

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ModelMapper modelMapper;
		
	boolean PRODUCTSTATUS = true;
	Integer UNITSONSOLD=0;
	@PostMapping("/addProduct/{supplierId}")
	public ResponseEntity<String> addProduct(@RequestBody @Valid Products product, @PathVariable("supplierId") Integer supplierId, BindingResult result) throws UserIdNotFoundException, InvalidInputException{
		performValidation(result);
		
		if(usersRepo.findById(supplierId).isPresent())
		{
		product.setProductId(generateProductId());
		product.setSupplierId(usersRepo.findById(supplierId).get());
		product.setStatus(PRODUCTSTATUS);
		product.setUnitsOnSold(UNITSONSOLD);
		productRepo.save(product);
		return new ResponseEntity<>("product creation successfull!!",HttpStatus.OK);
		}
		else {
			throw new UserIdNotFoundException("Invalid ID!");
		}		
	}
	
	
	@GetMapping("/myProducts/{supplierId}")
	public  Set<ProductsVO> retrieveAllProductsAddedBySupplier(@PathVariable("supplierId") Integer supplierId ) throws UserIdNotFoundException{
		if(usersRepo.findById(supplierId).isPresent())
		{
			//return usersRepo.findById(supplierId).get().getProduct();
			return mapList(usersRepo.findById(supplierId).get().getProduct(),ProductsVO.class);
		}
		else
		throw new UserIdNotFoundException("Invalid ID!");		
	}
		
	private void performValidation(BindingResult result) throws InvalidInputException {
		if(result.hasErrors())
		{
			List<String> errors = new ArrayList<>();
		    for(ObjectError error : result.getAllErrors()) {
		    	errors.add(((FieldError) error).getField());
		    }
			throw new InvalidInputException(errors);
		}		
	}

	private Integer generateProductId() {	
		return productRepo.getMaxProductId()+1;
	}
	
	<S, T> Set<T> mapList(Set<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toSet());
	}
}
