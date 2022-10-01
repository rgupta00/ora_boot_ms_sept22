package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.TransactionHistory;
import com.bankapp.repository.TransactionHistoryRepo;

@Service
@Transactional
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	private TransactionHistoryRepo transactionHistoryRepo;

	@Autowired
	public TransactionHistoryServiceImpl(TransactionHistoryRepo transactionHistoryRepo) {
		this.transactionHistoryRepo = transactionHistoryRepo;
	}

	@Override
	public List<TransactionHistory> getAllTransactionHistory() {
		return transactionHistoryRepo.findAll();
	}

	@Override
	public List<TransactionHistory> findByAccountId(int accountId) {
		return transactionHistoryRepo.findByFromAccIdOrToAccId(accountId ,accountId);
	}

	@Override
	public void addTransactionHistory(TransactionHistory transactionHistory) {
		transactionHistoryRepo.save(transactionHistory);
	}

}
