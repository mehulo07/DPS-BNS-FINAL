package com.bns.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bns.mapper.TransactionSeqMapper;
import com.bns.model.ProductInfo;
import com.bns.model.ProductParamMaster;
import com.bns.model.TransactionSeq;
import com.bns.utility.DpsConstant;

@PropertySource(value =  "classpath:productSetting.properties")
@Repository
public class StockLevelRepossitory {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;

	@Transactional
	public ProductParamMaster save(ProductParamMaster productParamMaster , List<ProductInfo> productInfo) {
		try {
			
			int[] types1 = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR };
	        Object[] params = new Object[] { productParamMaster.getTransaction_id(), productParamMaster.getRef_prod_cat_id(), 
	        		productParamMaster.getCatalog_no(), productParamMaster.getUpdated_by(),DpsConstant.STATUS_ACTIVE};
	        
			int row = jdbcTemplate.update(propSource.getProperty("insertProductSettingMaster"),params,types1);
			
			if(row>0) {
				int [] batch = jdbcTemplate.batchUpdate(propSource.getProperty("insertProductSettingDetail"),new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, productParamMaster.getTransaction_id());
						ps.setString(2, productParamMaster.getProductParamDetailBeanList().get(i).getStk_cat_id());
						ps.setInt(3, productParamMaster.getProductParamDetailBeanList().get(i).getStk_cat_to());
						ps.setString(4, productParamMaster.getProductParamDetailBeanList().get(i).getUpdated_by());
					}
					
					public int getBatchSize() {
						return productParamMaster.getProductParamDetailBeanList().size();
					}
				});
			}
			
			if(productInfo != null && productInfo.size() == 1) {
				System.out.println("inside if");
				int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR };
				//Update in price matrix
				Object[] pricematrixParam = new Object[] { productInfo.get(0).getNcsoProfitableFlag() , productInfo.get(0).getLeadTime() ,productInfo.get(0).getCatalogNo(), productInfo.get(0).getContract()};
				int pricematrixUpdateCount = jdbcTemplate.update(propSource.getProperty("updateProfitNcsoLeadTime"),pricematrixParam);
			}else {
				System.out.println("inside all :"+productInfo.size());
				int [] batch = jdbcTemplate.batchUpdate(propSource.getProperty("updateProfitNcsoLeadTime"),new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, productInfo.get(i).getNcsoProfitableFlag());
						ps.setString(2, productInfo.get(i).getLeadTime());
						ps.setString(3, productInfo.get(i).getCatalogNo());
						ps.setString(4, productInfo.get(i).getContract());
					}

					public int getBatchSize() {
						return productInfo.size();
					}
				});
			}
			
		}catch (Exception e) {
			System.out.println("EXCEPTION WHILE SAVING DATA");
			e.printStackTrace();
		}
		return productParamMaster;
	}
	
	@Transactional
	public boolean delete(ProductParamMaster productParamMaster) {
		try {
			if(productParamMaster.getTransaction_id()!=null && !"".equalsIgnoreCase(productParamMaster.getTransaction_id())){
				
				String catalogNo =productParamMaster.getCatalog_no();
				String categoryId = productParamMaster.getRef_prod_cat_id(); 
				
				if (catalogNo == null || "".equals(catalogNo)) {
					catalogNo = "-";
				}
				if (categoryId == null || "".equals(categoryId)) {
					categoryId = "-";
				}
				
				int row = jdbcTemplate.update(propSource.getProperty("deleteProductSettingMasterWithTransId"),productParamMaster.getTransaction_id() , categoryId , catalogNo);
			}else {
		        String qry = propSource.getProperty("deleteProductSettingMasterWithOutTransId");
		        	
		        if(productParamMaster.getCatalog_no()!=null && !"".equalsIgnoreCase(productParamMaster.getCatalog_no())) {
		        	qry += " and catalog_no = '" + productParamMaster.getCatalog_no() + "' ";
		        }else {
		        	qry += " and catalog_no is null ";
		        }
				int row = jdbcTemplate.update(qry,productParamMaster.getRef_prod_cat_id());
			}
			
			return jdbcTemplate.update(propSource.getProperty("deleteProductSettingDetailTab")) > 1 ? true : false;
			
		}catch (Exception e) {
			return false;
		}
	}

	public List<TransactionSeq> getTransactionListByCategoryId(Object categoryId , Date firsDay , Date lastDay) {
		List<TransactionSeq> transactionIdList = null;
		try {
			transactionIdList =  jdbcTemplate.query(propSource.getProperty("getTransactionIdByCategory"), new Object[] {categoryId, String.valueOf(firsDay), String.valueOf(lastDay)}, new TransactionSeqMapper());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("exception while retrive transaction list");
		}
		return transactionIdList;
	}
	
}
