package com.productapp.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_table")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String username;
	private String password;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="user_roles")
	private List<String> roles= new ArrayList<>();

	public UserEntity(String username, String password, List<String> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	
	
	
}
