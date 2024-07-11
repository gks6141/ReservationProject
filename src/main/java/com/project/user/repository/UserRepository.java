package com.project.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Integer>{
	public List<UserEntity> findByUserId(String userId);
	public List<UserEntity> findByUserIdAndPassword(String userId, String password);
//	public int
}
