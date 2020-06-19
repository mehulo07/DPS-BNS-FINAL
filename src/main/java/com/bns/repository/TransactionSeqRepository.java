package com.bns.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.exception.ResourceNotFoundException;
import com.bns.mapper.TransactionSeqMapper;
import com.bns.model.TransactionSeq;
import com.bns.utility.DpsConstant;

@PropertySource(value="classpath:productSetting.properties",ignoreResourceNotFound=true)
@Repository
public class TransactionSeqRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	public TransactionSeq getNewTransaction(String seqPrefix) throws ResourceNotFoundException {
		Optional<TransactionSeq> transactionSeq= Optional.of(jdbcTemplate.queryForObject(propSource.getProperty("getTransactionId"), new Object[] {}, new TransactionSeqMapper()));
		transactionSeq.orElseThrow(()-> new ResourceNotFoundException("Exception while transaction sequence."));
		transactionSeq.get().setTransaction_id(DpsConstant.DPS_COMPANY_PREFIX+ "_" + transactionSeq.get().getTransaction_id());	
		return transactionSeq.get();
	}
	
	public TransactionSeq checkMasterEntryMonthWise(String ref_prod_cat_id , String catalogNo ,Date from , Date to ) {
		TransactionSeq transactionSeq = null;
		if("".equals(catalogNo)) {
			catalogNo= null;
		}
		try {
			transactionSeq = jdbcTemplate.queryForObject(propSource.getProperty("getTransactionIdBasedOnProductAndCategory"), new Object[] { ref_prod_cat_id , catalogNo == null ? "-" : catalogNo  , String.valueOf(from) , String.valueOf(to) }, new TransactionSeqMapper());
		}catch(Exception e) {
		}
		return transactionSeq;
	}
	
	
}
