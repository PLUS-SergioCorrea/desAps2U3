/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author usuario
 *
 */
public class Account implements Serializable{
	private Long id;
	private String name;
	private String groupAccount;
	private String turn;
	
	public Account (Long id, String name, String groupAccount, String turn) {
		super();
		this.id = id;
		this.name = name;
		this.groupAccount = groupAccount;
		this.turn = turn;
	}
	
	public Account() {
		this(0L, "", "","");
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the groupAccount
	 */
	public String getGroupAccount() {
		return groupAccount;
	}

	/**
	 * @param groupAccount the groupAccount to set
	 */
	public void setGroupAccount(String groupAccount) {
		this.groupAccount = groupAccount;
	}

	/**
	 * @return the turn
	 */
	public String getTurn() {
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public void setTurn(String turn) {
		this.turn = turn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", groupAccount=" + groupAccount + ", turn=" + turn + "]";
	}
	
	
	
}
