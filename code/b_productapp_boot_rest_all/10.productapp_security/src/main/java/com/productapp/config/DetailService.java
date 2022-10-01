package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productapp.entity.UserEntity;
import com.productapp.service.UserService;
//spring sec will use this code to decide whether user is valid or not
@Service
public class DetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userService.findByUsername(username);
		if(userEntity==null)
			throw new UsernameNotFoundException("user not found");
		
		//now i need to covert this user to user that spring sec understand
		return new SecUser(userEntity);
	}

}
