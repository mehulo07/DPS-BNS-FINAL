package com.bns.model;

import java.io.Serializable;


public class ProductParamDetail implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = -6766447528122248234L;
	
	private String transaction_id;
	private String stk_cat_id;
	private String stk_cat_name;
	private int stk_cat_to;
	private String updated_by;
	
	public ProductParamDetail()
	{
	}
	
	public ProductParamDetail(String transaction_id, String stk_cat_id, String stk_cat_name, int stk_cat_from,
			int stk_cat_to, String updated_by) {
		
		this.transaction_id = transaction_id;
		this.stk_cat_id = stk_cat_id;
		this.stk_cat_name = stk_cat_name;
		this.stk_cat_to = stk_cat_to;
		this.updated_by = updated_by;
		
	}
	
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getStk_cat_id() {
		return stk_cat_id;
	}
	public void setStk_cat_id(String stk_cat_id) {
		this.stk_cat_id = stk_cat_id;
	}
	public String getStk_cat_name() {
		return stk_cat_name;
	}
	public void setStk_cat_name(String stk_cat_name) {
		this.stk_cat_name = stk_cat_name;
	}
	public int getStk_cat_to() {
		return stk_cat_to;
	}
	public void setStk_cat_to(int stk_cat_to) {
		this.stk_cat_to = stk_cat_to;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	@Override
	public String toString() {
		return "ProductParamDetail [transaction_id=" + transaction_id + ", stk_cat_id=" + stk_cat_id + ", stk_cat_name="
				+ stk_cat_name + ", stk_cat_to=" + stk_cat_to + ", updated_by=" + updated_by + "]";
	}

}
