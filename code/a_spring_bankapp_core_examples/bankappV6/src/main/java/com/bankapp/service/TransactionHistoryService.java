package com.bankapp.service;
import java.util.*;

import com.bankapp.entities.TransactionHistory;
public interface TransactionHistoryService {
	public void addTransactionHistory(TransactionHistory transactionHistory);
	public List<TransactionHistory> getAllTransactionHistory();
	public List<TransactionHistory>  findByAccountId(int accountId);
}
