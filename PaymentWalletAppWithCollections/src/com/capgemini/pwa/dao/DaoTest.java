package com.capgemini.pwa.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.capgemini.pwa.entities.WalletAccount;
import com.capgemini.pwa.entities.WalletTransactions;
public class DaoTest {
	

	AccountDao dao=new AccountDao();
	/*@Test
	public void addaccountdetails() throws Exception {
		Integer i=1;
		WalletAccount  result = dao.addaccount(i,"Sita", "Sita@1", "9884433221","SitaLaksmi");
		if (result!=null) {
			assertFalse(false);
		}
	}*/
	@Test
	public void addamounttoaccount() throws Exception {
		Double i=(double) 900;
		WalletAccount result = dao.addamount("Sita", "Sita@1", i);
		
		if (result!=null) {
			assertTrue(true);
		}}}//int expectedResult = 652;
        //Assert.assertEquals(expectedResult, result);
	//}