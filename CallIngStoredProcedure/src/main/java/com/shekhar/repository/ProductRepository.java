/**
 * 
 */
package com.shekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import com.shekhar.entity.Product;

/**
 * @author shekhar
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	/*
	 * This is the way you can call procedure in springboot
	 */
	@Transactional
	@Modifying
	@Procedure(name = "Procedure_Without_Parameter")
	public void callStoredProcedure1();

	@Transactional
	@Modifying
	@Procedure(name = "Procedure_With_Parameter")
	public void callStoredProceddureWithParameter(String p_product_name, Integer p_quantity);

	@Transactional
	@Modifying
	@Procedure(name = "Procedure_with_Exception")
	public void callStoredProceddureWithParameterWithException(String p_product_name, Integer p_quantity);

	/*
	 * This is the way you can call functions in springboot
	 */
	@Query(value = "Select Function_Count_By_Department_Name(:Name)", nativeQuery = true)
	public Integer callFunctionFromDatabase(String DepartmentName);
}
