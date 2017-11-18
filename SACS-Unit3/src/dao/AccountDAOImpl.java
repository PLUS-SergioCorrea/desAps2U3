/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;

/**
 * @author Sergio
 *
 */
public class AccountDAOImpl implements AccountDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	public  AccountDAOImpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "utng", "mexico");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createAccount(Account account) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("INSERT INTO accounts (name,group_account,turn) values(?,?,?);");
				prepareStatement.setString(1, account.getName());
				prepareStatement.setString(2, account.getGroupAccount());
				prepareStatement.setString(3, account.getTurn());
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Account readAccount(Long id) {
		Account account = null;
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM accounts WHERE id=?;");
				prepareStatement.setLong(1, id);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					account = new Account(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}

	@Override
	public List<Account> readAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM accounts;");
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Account account = new Account(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
					accounts.add(account);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accounts;
	}

	@Override
	public void updateAccount(Account account) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("UPDATE accounts  SET name = ?, group_account=?," + " turn=?  WHERE id=?;");
				prepareStatement.setString(1, account.getName());
				prepareStatement.setString(2, account.getGroupAccount());
				prepareStatement.setString(3, account.getTurn());
				prepareStatement.setLong(4, account.getId());
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteAccount(Long id) {
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("DELETE FROM accounts  WHERE id=?;");
				prepareStatement.setLong(1, id);
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
