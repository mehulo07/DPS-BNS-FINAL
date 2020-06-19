package com.bns.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.TransactionSeq;
import com.bns.repository.TransactionSeqRepository;

@Service
public class TransactionSeqService {
	
	@Autowired
	private TransactionSeqRepository transactionSeqRepository;
	
	public TransactionSeq getNewTransaction(String seqPrefix) throws ResourceNotFoundException {
		return transactionSeqRepository.getNewTransaction(seqPrefix);
	}
	
	public TransactionSeq checkMasterEntryMonthWise(String ref_prod_cat_id , String catalogNo ,Date from , Date to ) {
		return transactionSeqRepository.checkMasterEntryMonthWise(ref_prod_cat_id, catalogNo, from, to);
	}
	
	
}
