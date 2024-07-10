package com.project.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	
	//로그인
	@PostMapping("/user-sign-in")
	public Map<String,Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password) {
		Map<String, Object> result = new HashMap<>();
		
		UserEntity userInfo = userBO.getUserLoginId(loginId);
		
		if (userInfo.getPassword() == password) {
			result.put("code", 200);
			result.put("result", "성공");	
			return result;
		} else {
			result.put("code", 500);
			result.put("error_message", "일치 하지 않음");	
			return result;
		}
		
	}
	
	
	//회원 가입
	@PostMapping("/sign-up")
	public Map<String,Object> signIn(
			@RequestParam("userId") String userId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email
			,@RequestParam("phoneNumber") String phoneNumber
			,@RequestParam(value = "admin", defaultValue="false") Boolean admin){
		Map<String, Object> result = new HashMap<>();
		
		UserEntity info = userBO.addUser(userId, password, name, email, phoneNumber, admin);
		if(info != null) {
			result.put("code", 200);
			result.put("result", "성공");	
			return result;
		} else {
			result.put("code", 500);
			result.put("error_message", "DB에 넣지 못함");	
			return result;
		}
	}
	
	//식당
	//식당 추가
	
	
	//식당 정보
	
}
