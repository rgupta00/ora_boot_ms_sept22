package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.entity.UserEntity;
import com.productapp.repo.UserEntityRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEntityRepo entityRepo;
	
	@Override
	public UserEntity findByUsername(String username) {
		return entityRepo.findByUsername(username);
	}

	@Override
	public void addUserEntity(UserEntity userEntity) {
		entityRepo.save(userEntity);
	}

}
