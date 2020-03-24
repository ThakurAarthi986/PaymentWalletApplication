package com.capgemini.pwa.service;
import java.sql.SQLException;

import com.capgemini.pwa.dao.AccountDao;
import com.capgemini.pwa.dao.AccountDaoI;
import com.capgemini.pwa.entities.WalletUser;
import com.capgemini.pwa.entities.WalletAccount;
import com.capgemini.pwa.entities.WalletTransactions;

public class AccountService  implements AccountServiceI{
	AccountDaoI dao = new AccountDao();
	@Override
	public WalletUser addaccount(WalletUser wallet) throws Exception {
		// TODO Auto-generated method stub
		return dao.addaccount(wallet);
	}

	@Override
	public WalletAccount addamount(String username1, String password1, Double balance) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return dao.addamount(username1,password1,balance);
	}

	@Override
	public Double displayBalance(String username2, String password2) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return dao.displayBalance(username2,password2);
	}

	@Override
	public WalletTransactions transferamount(String username3, String password3, Integer uid, Double tramount) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return dao.transferamount(username3,password3, uid,tramount);
	}

	@Override
	public boolean checkcredentials(String username3, String password3) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return dao.checkcredentials(username3,password3);
	}

	@Override
	public boolean checkcredentials1(String username1, String password1) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return dao.checkcredentials1(username1,password1);
	}


}
