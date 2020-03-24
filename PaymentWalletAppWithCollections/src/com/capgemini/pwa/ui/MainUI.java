package com.capgemini.pwa.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.pwa.entities.WalletUser;
import com.capgemini.pwa.entities.WalletAccount;
import com.capgemini.pwa.entities.WalletTransactions;
import com.capgemini.pwa.service.AccountService;
import com.capgemini.pwa.service.AccountServiceI;

public class MainUI {
	static AccountServiceI service = new AccountService();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n         Welcome to Online Wallet Application");
			System.out.println("1.Create/Register/Signup Payment Wallet Account");
			System.out.println("2.Adding amount to Payment Wallet Account");
			System.out.println("3.Show payment wallet account balance");
			System.out.println("4.Transfer funds from one account to another");
			try {
				int num = scanner.nextInt();
				switch (num) {
				case 1:
					Integer userid = 1;
					System.out.println("Enter UserName");
					System.out.println("First letter should be in capitals");
					String username = scanner.next();
					while (!(username.charAt(0) >= 'A' && username.charAt(0) <= 'Z')) {
						System.out.println("Please enter again");
						username = scanner.next();
					}
					System.out.println("Enter Password");
					System.out.println(
							"Password should contain length between 6 and 20 characters which contains uppercase,lowercase,special character and number");
					String password = scanner.next();
					while (!(password.matches(".*[0-9]{1,}.*") && password.matches(".*[@#$]{1,}.*")
							&& password.length() >= 6 && password.length() <= 20 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*"))) {
						System.out.println("Please enter again");
						password = scanner.next();
					}
					System.out.println("Strong password");

					System.out.println("Enter PhoneNumber");
					System.out.println("Phone number length should be 10 and should start with6 or 7 or 8 or 9");
					String phonenumber = scanner.next();
					while (!(phonenumber.length() == 10&& ((phonenumber.charAt(0) == '6')
							|| (phonenumber.charAt(0) == '7') || (phonenumber.charAt(0) == '8')
							|| (phonenumber.charAt(0) == '9')))) {
						System.out.println("Please enter again");
							phonenumber = scanner.next(); 
							}
					System.out.println("Enter LoginName");
					System.out.println("LoginName should be your full name");
					String loginname = scanner.next();
					WalletUser wallet = new WalletUser(userid, username, password, phonenumber, loginname);
					WalletUser result = service.addaccount(wallet);
					if (result != null) {
						System.out.println("Registered Successfully");

						System.out.println("UserId: " + result.getUserId() + "\nUserName: " + result.getUserName()
								+ "\nPassword: " + result.getPassword() + "\nPhone number: " + result.getPhoneNumber()
								+ "\nLoginName: " + result.getLoginName());
					}
					else 
						System.out.println("Registration Failed");
					break;
				case 2:
					System.out.println("Enter UserName");
					String username1 = scanner.next();
					System.out.println("Enter Password");
					String password1 = scanner.next();
					boolean b = service.checkcredentials1(username1, password1);
					while (b == false) {
						System.out.println("Enter correct credentials");
						System.out.println("Enter Username");
						username1 = scanner.next();
						System.out.println("Enter Password");
						password1 = scanner.next();
						b = service.checkcredentials1(username1, password1);
					}
					System.out.println("Enter Balance");
					Double balance = scanner.nextDouble();
					WalletAccount result1 = service.addamount(username1, password1, balance);
					if (result1 != null) {

						System.out.println("updation of balance successfull");
					}
					else

						System.out.println("updation of balance Failed");
					
					break;
				case 3:
					System.out.println("Enter UserName");
					String username2 = scanner.next();
					System.out.println("Enter Password");
					String password2 = scanner.next();
					Double accbal = service.displayBalance(username2, password2);
					if (accbal!= null) {
						System.out.println(accbal);
						System.out.println("Display Successful");
					} else
						System.out.println("Display Failed");
					break;
				case 4:
					System.out.println("Enter UserName");
					String username3 = scanner.next();
					System.out.println("Enter Password");
					String password3 = scanner.next();
					boolean b1 = service.checkcredentials(username3, password3);
					while (b1 == false) {
						System.out.println("Enter correct credentials");
						System.out.println("Enter Username");
						username3 = scanner.next();
						System.out.println("Enter Password");
						password3 = scanner.next();
						b1 = service.checkcredentials(username3, password3);
					}
					System.out.println("Login Successfull \n Welcome to your account");
					System.out.println("Enter the receiver UserId");
					Integer uid = scanner.nextInt();
					System.out.println("Enter the amount to transfer");
					Double tramount = scanner.nextDouble();
					WalletTransactions transferam = service.transferamount(username3, password3, uid, tramount);
					if (transferam != null) {
						System.out.println("Transferred amount: " + transferam.getAmount() + " Successfully to userid: " + uid);
					} else
						System.out.println("Unsuccessful");
					break;
				default:
					System.out.println("Thank you for using the platform");
					scanner.close();
					System.exit(0);
				}
			} catch (InputMismatchException e) {
				System.out.println("you did not select a number from above please run again");
				scanner.close();
				System.exit(0);
			}
		}
	}
}



