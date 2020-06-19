package com.bns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bns.mapper.RoleMasterMapper;
import com.bns.mapper.UserMapper;
import com.bns.model.RoleMaster;
import com.bns.model.User;

@PropertySource(value = "classpath:DPS.properties")
@Repository
public class DPSAuthenticationProvider {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment propSource;
	
	public User authenticate(String username) {
		User user  = null;
			try {
				user  = jdbcTemplate.queryForObject(propSource.getProperty("getUserAuthDetail"),new UserMapper(), username);
			}catch(Exception e) {
				System.out.println("User name or password is invaida");
				e.printStackTrace();
			}
			return user;
	}
	
	public RoleMaster getRoles(String roleId){
		RoleMaster userRole= null;
		userRole = jdbcTemplate.queryForObject(propSource.getProperty("getUserRoleDetail"), new Object[] {roleId} , new RoleMasterMapper());
		return userRole;
	}
}
