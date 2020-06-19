package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bns.model.UserInfo;
import com.bns.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	public List<UserInfo> getAllUserInfoList() {
		return userInfoRepository.getAllUserInfoList();
	}
	
	public UserInfo getUserInfoById(String userId) {
		return userInfoRepository.getUserInfoById(userId);	
	}
	
	@Transactional
	public boolean addUserInfo(UserInfo userInfo) {
		return userInfoRepository.addUserInfo(userInfo);
	}
	
	@Transactional
	public boolean updateUserInfo(UserInfo userInfo, String userId) {
		return userInfoRepository.updateUserInfo(userInfo, userId);
	}
	
	public List<UserInfo> getUserInfoByDepartment(String deptId){
		return userInfoRepository.getUserInfoByDepartment(deptId);
	}
	
}


  
  
 