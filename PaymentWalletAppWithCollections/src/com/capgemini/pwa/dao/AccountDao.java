package com.capgemini.pwa.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.capgemini.pwa.entities.WalletUser;
import com.capgemini.pwa.entities.UserStatus;
import com.capgemini.pwa.entities.WalletAccount;
import com.capgemini.pwa.entities.WalletTransactions;

import java.time.LocalDateTime;
public class AccountDao implements AccountDaoI{

	LocalDateTime mydt = LocalDateTime.now();
	Random random = new Random();
	private Map<Integer, WalletUser> wallets = new HashMap<Integer, WalletUser>();
	private Map<Integer, WalletAccount> wallets1 = new HashMap<Integer, WalletAccount>();
	private Map<Integer, WalletTransactions> wallets2 = new HashMap<Integer, WalletTransactions>();

	@Override
	public WalletUser addaccount(WalletUser wallet) throws Exception {
		// TODO Auto-generated method stub
	

		if (wallets.size() == 0)
			wallets.put(wallet.getUserId(), wallet);
		else {
			WalletUser walletupdated = new WalletUser(wallets.size() + 1, wallet.getUserName(), wallet.getPassword(),
					wallet.getPhoneNumber(), wallet.getLoginName());
			wallets.put(wallets.size() + 1, walletupdated);
			wallet = walletupdated;
		}

		return wallet;

	}

	@Override
	public WalletAccount addamount(String username1, String password1, Double balance) throws Exception {
		// TODO Auto-generated method stub
		Double oldbal = null;
		WalletAccount result = null;

		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {

			if (entry.getValue().getUserName().equals(username1) && entry.getValue().getPassword().equals(password1)) {
				List<String> TransactionHistory = new ArrayList<String>();
				if (wallets2.isEmpty()) {
					TransactionHistory.add("Empty");
				} else {
					oldbal = wallets1.get(entry.getKey()).getAccountBalance();
					balance = oldbal + balance;
				}
				WalletAccount walletupdated1 = new WalletAccount(entry.getKey(), balance, UserStatus.Successfull,
						TransactionHistory);
				wallets1.put(entry.getKey(), walletupdated1);
				result = walletupdated1;
			} else {
				System.out.println("you entered wrong credentials or you dont have an account,"
						+ "\n please run again to create new account or to enter correct credentials");
			}
		}

		return result;
	}

	@Override
	public Double displayBalance(String username2, String password2) throws Exception {
		// TODO Auto-generated method stub
		Double result1 = null;
		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {
			try {
				validatebalance(wallets1.get(entry.getKey()).getAccountBalance());
			} catch (InSufficientBalance e) {

				e.printStackTrace();
			}
			if (entry.getValue().getUserName().equals(username2) && entry.getValue().getPassword().equals(password2)) {
				int key = entry.getKey();
				result1 = wallets1.get(key).getAccountBalance();
			} else {
				System.out.println("you entered wrong credentials or you dont have an account,"
						+ "\n please run again to create new account or to enter correct credentials");
			}
		}
		return result1;
	}

	@Override
	public WalletTransactions transferamount(String username3, String password3, Integer uid, Double tramount)
			throws Exception {
		// TODO Auto-generated method stub
		WalletTransactions result2 = null;
	
		double myaccountbal;
		double traccount;
		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {
			try {
				validatebalance(wallets1.get(entry.getKey()).getAccountBalance());
			} catch (InSufficientBalance e) {

				e.printStackTrace();
			}
			if (entry.getValue().getUserName().equals(username3) && entry.getValue().getPassword().equals(password3)) {
				int key = entry.getKey();
				if (wallets1.get(key).getAccountBalance() < tramount) {
					System.out.println(
							"Sorry you don't have enough balance to transfer" + " \n please recharge and try again");
				} else {
					try {
						validateuser(uid);
					} catch (InCorrectUser e) {

						e.printStackTrace();
					}
					myaccountbal = wallets1.get(key).getAccountBalance() - tramount;
					traccount = wallets1.get(uid).getAccountBalance() + tramount;
					Integer transactionid = key;
					WalletTransactions WalletUpdated2 = new WalletTransactions(transactionid,
							"ammount transfered from +key+ to +uid+", mydt, tramount, myaccountbal);
					wallets2.put(transactionid, WalletUpdated2);
					result2 = WalletUpdated2;
					Integer transactionid1 = uid;
					WalletTransactions WalletUpdated3 = new WalletTransactions(transactionid1,
							"ammount transfered from +key+ to +uid+", mydt, tramount, traccount);
					wallets2.put(transactionid1, WalletUpdated3);
				

					List<String> TransactionHistory = new ArrayList<String>();

					TransactionHistory.add(wallets2.get(key).getDescription() + "/nAmount Sent is: +tramount+");
					TransactionHistory.add("At Time: +wallets2.get(key).getDateOfTransaction()+");
					WalletAccount wc = new WalletAccount(key, myaccountbal, UserStatus.Successfull, TransactionHistory);
					wallets1.put(key, wc);

					TransactionHistory.add(wallets2.get(key).getDescription() + "/nAmount Received is: +tramount+");
					TransactionHistory.add("At Time: +wallets2.get(key).getDateOfTransaction()+");
					WalletAccount wc1 = new WalletAccount(uid, traccount, UserStatus.Successfull, TransactionHistory);
					wallets1.put(uid, wc1);
				}
			}
		}

		return result2;

	}

	@Override
	public boolean checkcredentials(String username3, String password3) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {
			if (entry.getValue().getUserName().equals(username3) && entry.getValue().getPassword().equals(password3))
				b = true;
		}
		return b;
	}

	public void validateuser(int uid) throws Exception {
		if (!wallets.containsKey(uid))
			throw new InCorrectUser("User doesn't exist");
	}

	public void validatebalance(Double balance) throws Exception {
		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {
		if(wallets1.get(entry.getKey()).getAccountBalance()==0)
		throw new InSufficientBalance("You have 0 balance please recharge");
	}}
	
	@Override
	public boolean checkcredentials1(String username1, String password1) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {
			if (entry.getValue().getUserName().equals(username1) && entry.getValue().getPassword().equals(password1))
				b = true;
		}
		return b;
	}

	public void validateuser1(int uid) throws Exception {
		if (!wallets.containsKey(uid))
			throw new InCorrectUser("User doesn't exist");
	}

	public void validatebalance1(Double balance) throws Exception {
		for (Map.Entry<Integer, WalletUser> entry : wallets.entrySet()) {
		if(wallets1.get(entry.getKey()).getAccountBalance()==0)
		throw new InSufficientBalance("You have 0 balance please recharge");
	}}
}
