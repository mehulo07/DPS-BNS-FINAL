package com.bns.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.bns.mapper.ColorMasterMapper;
import com.bns.mapper.UserInfoMapper;
import com.bns.model.ColorMaster;
import com.bns.model.UserInfo;

@PropertySource(value = "classpath:UserInfo.properties")
@Repository
public class UserInfoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	public List<UserInfo> getAllUserInfoList(){
		return jdbcTemplate.query(propSource.getProperty("getAllUserInfo"), new UserInfoMapper());
	}
	
	public UserInfo getUserInfoById(String userId) {
		return jdbcTemplate.queryForObject(propSource.getProperty("getUserById"), new Object[] { userId },
				new UserInfoMapper());
	}

	public boolean addUserInfo(UserInfo userInfo) {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		
		return jdbcTemplate.update(propSource.getProperty("addUserInfo"),userInfo.getUserId() , userInfo.getFirstName(),
				userInfo.getLastName(), userInfo.getAddress(), userInfo.getPhoneNo(),userInfo.getDeptId(),
				authentication.getName()) > 0;
	}
	
	public boolean updateUserInfo(UserInfo userInfo, String userId) {
		Authentication  authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		
		return jdbcTemplate.update(propSource.getProperty("updateUserInfo"), userInfo.getFirstName(),
				userInfo.getLastName(), userInfo.getAddress(), userInfo.getPhoneNo() , userInfo.getDeptId() ,authentication.getName(), userId) > 0;
	}

	public List<UserInfo> getUserInfoByDepartment(String deptId){
		return jdbcTemplate.query(propSource.getProperty("getUserByDept"), new Object[] {deptId},new UserInfoMapper());
	}
	
}
