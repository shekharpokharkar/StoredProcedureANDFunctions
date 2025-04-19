/**
 * 
 */
package com.shekhar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author shekhar
 */

@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "Procedure_Without_Parameter", procedureName = "pr_buy_products"),

		@NamedStoredProcedureQuery(name = "Procedure_With_Parameter", procedureName = "pr_buy_products_with_Parameters", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_product_name", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_quantity", type = Integer.class) }

		),
		@NamedStoredProcedureQuery(name = "Procedure_with_Exception", procedureName = "pr_buy_products_with_Parameters_with_Exception", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_product_name", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_quantity", type = Integer.class)

		}

		)

}

)
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Integer productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productPrice")
	private String productPrice;
	@Column(name = "productRemaining")
	private String productRemaining;
	@Column(name = "productCode")
	private String productCode;
	@Column(name = "quantitySold")
	private Integer quantitySold;

}
