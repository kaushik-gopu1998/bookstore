package com.app.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.app.bookstore.dto.OrderLines;
import com.app.bookstore.dto.Products;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.exceptions.ProductNotFoundException;
import com.app.bookstore.repo.ProductRepo;

@Service
public class ProductsService {
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ModelMapper modelMapper;

	public void performValidation(BindingResult result) throws InvalidInputException {
		if(result.hasErrors())
		{
			List<String> errors = new ArrayList<>();
		    for(ObjectError error : result.getAllErrors()) {
		    	errors.add(((FieldError) error).getField());
		    }
			throw new InvalidInputException(errors);
		}		
	}

	public Integer generateProductId() {	
		return productRepo.getMaxProductId()+1;
	}
	
	public <S, T> Set<T>  mapList(Set<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toSet());
	}

	public boolean getStatus(Integer unitsInStock) {
		return unitsInStock!=0;
	}

	public void updateProductsQuantity(Set<OrderLines> orderLines) {
		for(OrderLines order : orderLines) {
			Products product = productRepo.findById(order.getProdcutId().getProductId()).get();
			product.setUnitsInStock(getStockLeft(product.getUnitsInStock(),order.getQuantity()));
			product.setUnitsOnSold(order.getQuantity());
			productRepo.save(product);
		}
		
	}

	private Integer getStockLeft(Integer unitsInStock, Integer quantity) {
		return unitsInStock-quantity;
	}

}
