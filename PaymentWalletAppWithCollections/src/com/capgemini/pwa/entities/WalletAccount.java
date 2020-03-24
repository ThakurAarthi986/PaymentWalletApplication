package com.capgemini.pwa.entities;

import java.util.List;

public class WalletAccount {
	private Integer AccountId;
	private Double AccountBalance;
	@SuppressWarnings("rawtypes")
	private Enum Status;
	@SuppressWarnings("rawtypes")
	private List TransactionHistory;
	public Integer getAccountId() {
		return AccountId;
	}
	public void setAccountId(Integer accountId) {
		AccountId = accountId;
	}
	public Double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		AccountBalance = accountBalance;
	}
	@SuppressWarnings("rawtypes")
	public Enum getStatus() {
		return Status;
	}
	public void setStatus(@SuppressWarnings("rawtypes") Enum status) {
		Status = status;
	}
	@SuppressWarnings("rawtypes")
	public List getTransactionHistory() {
		return TransactionHistory;
	}
	public void setTransactionHistory(@SuppressWarnings("rawtypes") List transactionHistory) {
		TransactionHistory = transactionHistory;
	}
	@SuppressWarnings("rawtypes")
	public WalletAccount(Integer accountId, Double accountBalance, Enum status, List transactionHistory) {
		super();
		AccountId = accountId;
		AccountBalance = accountBalance;
		Status = status;
		TransactionHistory = transactionHistory;
	}
	@Override
	public String toString() {
		return "WalletAccount [AccountId=" + AccountId + ", AccountBalance=" + AccountBalance + ", Status=" + Status
				+ ", TransactionHistory=" + TransactionHistory + "]";
	}

}