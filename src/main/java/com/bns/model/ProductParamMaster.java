package com.bns.model;

import java.io.Serializable;
import java.util.List;

public class ProductParamMaster implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 463388155276204593L;

	private String transaction_id;
	private String ref_prod_cat_id;
	private String catalog_Desc;
	private String catalog_no;
	private String updated_by;
	
	private List<ProductParamDetail> productParamDetailBeanList;
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getRef_prod_cat_id() {
		return ref_prod_cat_id;
	}
	public void setRef_prod_cat_id(String ref_prod_cat_id) {
		this.ref_prod_cat_id = ref_prod_cat_id;
	}
	public String getCatalog_no() {
		return catalog_no;
	}
	public void setCatalog_no(String catalog_no) {
		this.catalog_no = catalog_no;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public String getCatalog_Desc() {
		return catalog_Desc;
	}
	public void setCatalog_Desc(String catalog_Desc) {
		this.catalog_Desc = catalog_Desc;
	}
	public List<ProductParamDetail> getProductParamDetailBeanList() {
		return productParamDetailBeanList;
	}
	public void setProductParamDetailBeanList(List<ProductParamDetail> productParamDetailBeanList) {
		this.productParamDetailBeanList = productParamDetailBeanList;
	}

	@Override
	public String toString() {
		return "ProductParamMaster [transaction_id=" + transaction_id + ", ref_prod_cat_id=" + ref_prod_cat_id
				+ ", catalog_Desc=" + catalog_Desc + ", catalog_no=" + catalog_no + ", updated_by=" + updated_by
				+ ", productParamDetailBeanList=" + productParamDetailBeanList + "]";
	}
	
}
