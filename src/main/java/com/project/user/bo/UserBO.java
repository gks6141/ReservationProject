package com.project.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.user.entity.UserEntity;
import com.project.user.repository.UserRepository;

@Service
public class UserBO {
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity getUserLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	public UserEntity getUserPassword(String password) {
		return userRepository.findByPassword(password);
	}
	
	public UserEntity addUser(String userId,String password,String name,String email
			,String phoneNumber,Boolean admin) {
		return userRepository.save(UserEntity.builder()
									.userId(userId)
									.password(password)
									.name(name)
									.email(email)
									.phoneNumber(phoneNumber)
									.admin(admin)
									.build());	
	}
}
