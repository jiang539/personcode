package com.cxkh.demo.esdsmo.persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.cxkh.demo.esdsmo.beans.Account;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AccountTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	AccountMapper accountMapper;

	@Test
	public void insertAccount() {
		Account account = new Account();
		account.setAddress1("tt");
		account.setAddress2("add2");
		account.setCity("city");
		account.setCountry("country");
		account.setEmail("tt@tt.tt");
		account.setFirstName("firstName");
		account.setLastName("lastName");
		account.setPhone("phone");
		account.setState("state");
		account.setStatus("s");
		account.setUsername("username");
		account.setZip("zip");

		accountMapper.insertAccount(account);
	}

	@Test
	public void getAccountByUsername() {
		Account account = accountMapper.getAccountByUsername("username");
		if (account != null && account.getUsername() != null) {
			System.out.println(account.getUsername());
		}
	}
}
