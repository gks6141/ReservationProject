package com.project.user.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "user")
@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "userId")
	private String userId;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private String phoneNumber;
	
	private Boolean admin;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private LocalDate createdAt;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private LocalDate updatedAt;
}
