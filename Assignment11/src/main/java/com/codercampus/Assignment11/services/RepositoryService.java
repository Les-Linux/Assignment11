package com.codercampus.Assignment11.services;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositoryService {
    public List<Transaction> getAllTransactions() {
        TransactionRepository transactionRepository = new TransactionRepository();

        try {
            List<Transaction> transactions = transactionRepository.findAll();
            transactions.sort(Comparator.comparing(o -> o.getDate()));
            return transactions;
        } catch (Exception e) {
            System.out.println("Exception Caught - [class]:RepositoryService [message]:" + e.getMessage());
        }
        return null;
    }

    public Transaction findById(Integer id) {
        TransactionRepository transactionRepository = new TransactionRepository();

        try {
            List<Transaction> transaction = transactionRepository.findAll().stream()
                    .filter(filter -> filter.getId()
                            .intValue() == id)
                    .collect(Collectors.toList());

            if (!(transaction.isEmpty())) {
                return transaction.get(0);
            }
        } catch (Exception e) {
            System.out.println("Exception Caught - [class]:RepositoryService [message]:" + e.getMessage());
        }
        return null;
    }
}
