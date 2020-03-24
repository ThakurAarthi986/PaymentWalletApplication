package com.capgemini.pwa.entities;

import java.time.LocalDateTime;


public class WalletTransactions{
	private Integer TransactionId;
	private String Description;
	private LocalDateTime dateOfTransaction;
	private Double Amount;
	private Double AccountBalance;
	public Integer getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(Integer transactionId) {
		TransactionId = transactionId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public Double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		AccountBalance = accountBalance;
	}

	public WalletTransactions(Integer transactionId, String description, LocalDateTime dateOfTransaction, Double amount,
			Double accountBalance) {
		super();
		TransactionId = transactionId;
		Description = description;
		this.dateOfTransaction = dateOfTransaction;
		Amount = amount;
		AccountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "WalletTransactions [TransactionId=" + TransactionId + ", Description=" + Description + ", dateOfTransaction=" + dateOfTransaction
				+ ", Amount=" + Amount + ", AccountBalance=" + AccountBalance + "]";
	}
	
}
