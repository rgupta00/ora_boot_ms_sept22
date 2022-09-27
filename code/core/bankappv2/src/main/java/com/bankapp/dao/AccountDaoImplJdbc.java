package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;

// <bean id="accountDao1" class="com.bankapp.dao.AccountDaoImplJdbc"/>
@Repository(value = "accountDao1")
@Primary
//@Profile("test")
public class AccountDaoImplJdbc implements AccountDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountDaoImplJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		return jdbcTemplate.query("select * from account", new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject("select * from account where id=?", new AccountRowMapper(), id);
	}

	@Override
	public void updateAccount(Account account) {
		jdbcTemplate.update("update account set balance=? where id=?", new Object[] {account.getBalance(), account.getId()});
	}

	@Override
	public void addAccount(Account account) {
		jdbcTemplate.update("insert into account(name,balance) values(?,?)", new Object[] {account.getName(), account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update("delete from account where id=?", id);
	}

}
