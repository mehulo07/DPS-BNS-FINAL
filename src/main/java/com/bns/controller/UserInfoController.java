package com.bns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.config.DPSAuthenticationProvider;
import com.bns.model.User;
import com.bns.model.UserInfo;
import com.bns.service.UserInfoService;

import io.swagger.annotations.ApiModelProperty;
import net.sf.json.JSONObject;

@RestController
@CrossOrigin()
@RequestMapping(value = "DPS/V1/userInfo")
public class UserInfoController {
		
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private DPSAuthenticationProvider dPSAuthenticationProvider;
	
	@GetMapping("/")
	@ApiModelProperty(value = "Get All user info",notes = "Retrive all active user info list to client.")
	public List<UserInfo> getAllUserInfo() {
		return userInfoService.getAllUserInfoList();
	}
	
	/*@PostMapping("/{id}")
	public UserInfo getUserInfoById(@PathVariable(value="id") String userId ) {
		return userInfoService.getUserInfoById(userId);
	}*/
	
	@PostMapping("department/{id}")
	public List<UserInfo> getUserInfoByDepartment(@PathVariable(value="id") String deptId ) {
		return userInfoService.getUserInfoByDepartment(deptId);
	}
	
	@PostMapping("/{name}")
	public JSONObject getUserInfoByName(@PathVariable(value="name") String username ) {
		UserInfo userInfo = null;
		JSONObject returnObj = new JSONObject();
		try {
			User user = dPSAuthenticationProvider.authenticate(username);
			System.out.println("useris :"+user);
			userInfo = userInfoService.getUserInfoById(user.getUserId());
			if(userInfo!=null) {
				returnObj.put("Message", "Ok");
				returnObj.put("Status Code", 200);
				returnObj.put("Data",userInfo);
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			returnObj.put("Message", "Error");
			returnObj.put("Status Code", ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR));
			returnObj.put("Data",null);
		}
		return returnObj;
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addUserInfo(@RequestBody UserInfo userInfo) {
		if(userInfoService.addUserInfo(userInfo)) 
			return ResponseEntity.ok().body("New user info added to list");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("New user info is not addded to List.");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUserInfo(@PathVariable(value="id") String userId  , @RequestBody UserInfo userInfo) {
		if(userInfoService.updateUserInfo(userInfo,userId)) 
			return ResponseEntity.ok().body("User info updated with new value");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception while update User info.");
	}
	
}
