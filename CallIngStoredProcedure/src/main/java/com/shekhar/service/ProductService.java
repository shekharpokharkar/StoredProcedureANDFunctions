/**
 * 
 */
package com.shekhar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shekhar.repository.ProductRepository;

/**
 * @author shekhar
 */

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void callStoredProcedurewithoutPrameter() {
		System.out.println("before calling stored procedure");
		productRepository.callStoredProcedure1();
		System.out.println("After calling stored procedure");
	}

	@Transactional
	public void callStoredProcedurewithPrameter(String productName, Integer productQuantity) {
		System.out.println("before calling stored procedure");
		productRepository.callStoredProceddureWithParameter(productName, productQuantity);
		System.out.println("After calling stored procedure");
	}

	@Transactional
	public void callStoredProcedurewithPrameterWithException(String productName, Integer productQuantity) {
		System.out.println("before calling stored procedure");
		productRepository.callStoredProceddureWithParameterWithException(productName, productQuantity);
		System.out.println("After calling stored procedure");
	}
}
