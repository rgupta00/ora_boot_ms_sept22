package com.bankapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.TransactionHistory;
@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Integer>{
	List<TransactionHistory> findByFromAccIdOrToAccId(int accountId, int accountId2);
}
