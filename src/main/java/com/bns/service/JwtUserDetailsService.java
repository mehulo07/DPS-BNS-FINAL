package com.bns.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bns.config.DPSAuthenticationProvider;
import com.bns.exception.ResourceNotFoundException;
import com.bns.model.ApplicationUserDetails;
import com.bns.model.RoleMaster;
import com.bns.model.User;
import com.bns.model.UserAuthDetail;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DPSAuthenticationProvider DPSauthenticationProvider;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
		
		//get username
		User user =DPSauthenticationProvider.authenticate(username);
		Optional<User> checkUser = Optional.of(user);
		checkUser.orElseThrow(()-> new UsernameNotFoundException("Username is invalid"+username));
		
		//get user role
		Optional<RoleMaster> userRole = Optional.of(DPSauthenticationProvider.getRoles(user.getUserRoleId()));
		userRole.orElseThrow(()-> new UsernameNotFoundException("User role not found"+username));
		
		//combine use
		UserAuthDetail simpleAuthDetails = new UserAuthDetail();
		simpleAuthDetails.setUserId(user.getUserId());
		simpleAuthDetails.setUserName(user.getUsername());
		simpleAuthDetails.setPassword(user.getPassword());
		simpleAuthDetails.setActive("active".equalsIgnoreCase(user.getStatus()));
		simpleAuthDetails.setRoles(Arrays.asList(new SimpleGrantedAuthority(userRole.get().getRoleName())));
		Optional<UserAuthDetail> userAuthDetail= Optional.of(simpleAuthDetails);
		
		return userAuthDetail.map(ApplicationUserDetails::new).get();
	}

}