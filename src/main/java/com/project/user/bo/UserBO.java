package com.project.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.UserEntity;
import com.project.user.repository.UserRepository;

@Service
public class UserBO {
	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	public List<UserEntity> getUserByUserIdAndPassword(String userId, String password) {
		return userRepository.findByUserIdAndPassword(userId, password);
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
	
//	public int deleteUserById(int id) {
//		return userRepository.deleteUserById(id);
//	}
}
