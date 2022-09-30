package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.productapp.entity.UserEntity;
import com.productapp.service.UserService;
@Component
public class SecUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity= userService.findByUsername(username);
		if(userEntity==null)
			throw new UsernameNotFoundException("user not found");
		//convert UserEntity to the user that can be understand by spring security
		
		
		return new SecUser(userEntity);
	}

}
