package com.myapp.api.entities.sql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * 
 * MySQL Entity
 *
 */
@Entity
public class Product {
	@Id
	@Column(name = "store_sku_id")
	private int userId;
	@Column(name = "sku_code")
	private String sku_code;
	@Column(name = "ofc_code")
	private String ofc_code;
	
	public Product() {
		
	}
	
	public Product(int id,String sku_code,String ofc_code) {
		this.userId = id;
		this.sku_code = sku_code;
		this.ofc_code = ofc_code;
	}
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public String getsku_code() {
		return sku_code;
	}
	public void setsku_code(String sku_code) {
		this.sku_code = sku_code;
	}

	public String getofc_code() {
		return ofc_code;
	}

	public void setofc_code(String ofc_code) {
		this.ofc_code = ofc_code;
	}
	
	
	

}
