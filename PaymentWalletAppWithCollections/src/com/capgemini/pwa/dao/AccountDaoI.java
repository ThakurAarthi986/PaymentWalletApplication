package com.capgemini.pwa.dao;

import com.capgemini.pwa.entities.WalletUser;
import com.capgemini.pwa.entities.WalletAccount;
import com.capgemini.pwa.entities.WalletTransactions;

public interface AccountDaoI {

	public WalletUser addaccount(WalletUser wallet) throws Exception;

	WalletAccount addamount(String username1, String password1, Double balance ) throws Exception;

	Double displayBalance(String username2, String password2) throws Exception;

	WalletTransactions transferamount(String username3, String password3, Integer uid, Double tramount) throws Exception;

	public boolean checkcredentials(String username3, String password3) throws Exception;

	boolean checkcredentials1(String username1, String password1) throws Exception;

}