/**
 * 
 */
package com.shekhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shekhar.service.ProductService;

/**
 * @author shekhar
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public ResponseEntity<String> callStoredProcedure() {
		System.out.println("Inside callStoredProcedure Without Parameters");
		productService.callStoredProcedurewithoutPrameter();
		return ResponseEntity.ok("Called Stored Procedure Successfully");
	}

	@GetMapping("/withparameter")
	public ResponseEntity<String> callStoredProcedureWithParamter(@RequestParam("name") String productname,
			@RequestParam("quantity") Integer productQuantity

	) {
		System.out.println("Inside callStoredProcedure With Parameters");
		productService.callStoredProcedurewithPrameter(productname, productQuantity);
		return ResponseEntity.ok("Called Stored Procedure Successfully");
	}

	@GetMapping("/withparameterwithException")
	public ResponseEntity<String> callStoredProcedureWithParamterWithException(@RequestParam("name") String productname,
			@RequestParam("quantity") Integer productQuantity

	) {
		System.out.println("Inside callStoredProcedurewithException With Parameters");
		productService.callStoredProcedurewithPrameterWithException(productname, productQuantity);
		return ResponseEntity.ok("Called Stored Procedure Successfully");
	}

}
