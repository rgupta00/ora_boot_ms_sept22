package com.productapp.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.productapp.entity.UserEntity;

public class SecUser implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserEntity userEntity;
	
	
	
	public SecUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public SecUser() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles= userEntity.getRoles();
		String rolesNames[]=roles.toArray(new String[roles.size()]);
		return AuthorityUtils.createAuthorityList(rolesNames);
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
