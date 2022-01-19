package com.myapp.api.model;

import java.util.List;

public class ProductModel {
	private int Id;
	private String sku_code;
	private String ofc_code;
	private List<DetailsModel> vars;
	public int getstore_sku_id() {
		return Id;
	}
	public void setstore_sku_id(int id) {
		this.Id = id;
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
	public List<DetailsModel> getdetails() {
		return vars;
	}
	public void setdetails(List<DetailsModel> vars) {
		this.vars = vars;
	}
	

}
