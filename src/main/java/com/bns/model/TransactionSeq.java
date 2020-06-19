package com.bns.model;

import java.io.Serializable;

public class TransactionSeq implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = -9028213786306371287L;

	
	private String transaction_id;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	@Override
	public String toString() {
		return "TransactionSeqBean [transaction_id=" + transaction_id + "]";
	} 
	
}
