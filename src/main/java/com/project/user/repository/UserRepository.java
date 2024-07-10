package com.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Integer>{
	public UserEntity findByLoginId(String loginId);
	public UserEntity findByPassword(String password);
}
