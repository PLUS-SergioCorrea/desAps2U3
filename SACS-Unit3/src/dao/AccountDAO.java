package dao;

import java.util.List;

import model.Account;

public interface AccountDAO {
	void createAccount(Account account);
	Account readAccount(Long id);
	List<Account> readAllAccounts();
	void updateAccount(Account account);
	void deleteAccount(Long id);
	
}
//