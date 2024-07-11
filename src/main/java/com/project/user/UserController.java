package com.project.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.user.bo.UserBO;
import com.project.user.entity.UserEntity;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
	
	@GetMapping("/login-view")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/signup-view")
	public String signupView() {
		return "user/signUp";
	}
	
	
	//로그인
	@ResponseBody
	@PostMapping("/login")
	public Map<String,Object> signIn(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password) {
		Map<String, Object> result = new HashMap<>();
		List<UserEntity> userInfo = userBO.getUserByUserIdAndPassword(userId,password);
		if ( userInfo.size() == 0) {
			result.put("code", 500);
			result.put("error_message", "일치 하지 않음");	
			return result;
		} else {
			result.put("code", 200);
			result.put("success", "성공");	
			return result;
		}
		
	}
	
	
	//회원 가입
	@ResponseBody
	@PostMapping("/create")
	public Map<String,Object> signup(
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
	
	//아이디 중복확인
	@ResponseBody
	@PostMapping("/is-duplicated-id")
	public Map<String,Object> isDuplicatedId(
			@RequestParam("userId") String userId){
		Map<String, Object> result = new HashMap<>();
		List<UserEntity> userInfo = userBO.getUserByUserId(userId);
		if ( userInfo.size() != 0) {
			result.put("code", 200);
			result.put("is_duplicated_id", true);
			return result;
		} else if(userInfo.size() > 0) {
			result.put("code", 200);
			result.put("is_duplicated_id", false);	
			return result;
		} else{
			result.put("code", 500);
			result.put("error_message", "에러 발생");	
			return result;
		}
	}
	
	//아이디 수정
//	@ResponseBody
//	@PutMapping("/update")
//	public Map<String , Object> userUpdate(
//			@RequestParam(value="password" ,defaultValue="defaultValue") String password
//			,@RequestParam(value="email", defaultValue="defaultValue") String email
//			,@RequestParam(value="phoneNumber", defaultValue="defaultValue") String phoneNumber){
//		Map<String, Object> result = new HashMap<>();
//		UserEntity info = userBO.addUser(password,email, phoneNumber);
//		if(info != null) {
//			result.put("code", 200);
//			result.put("result", "성공");	
//			return result;
//		} else {
//			result.put("code", 500);
//			result.put("error_message", "DB에 넣지 못함");	
//			return result;
//		}
//		
//	}
	
	
	//아이디 삭제
//	@ResponseBody
//	@DeleteMapping("/delete")
//	public Map<String , Object> userUpdate(
//			@RequestParam("id") int id){
//		userBO.deleteUserById(id);
//		return
//	}
	
	//식당 정보
	
}
