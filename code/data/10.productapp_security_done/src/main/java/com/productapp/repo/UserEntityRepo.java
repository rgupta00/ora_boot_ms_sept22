package com.productapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.entity.UserEntity;
@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByUsername(String username);
}
