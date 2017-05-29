package models;

public class Account {
	
	private int accountId;
	
	private int partyId;
	
	private double balance;
	
	private int bankId;

	public int getAccountId() {
		return accountId;
	}

	public Account(int accountId, int partyId, double balance, int bankId) {
		super();
		this.accountId = accountId;
		this.partyId = partyId;
		this.balance = balance;
		this.bankId = bankId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(int accountId, int partyId, double balance) {
		super();
		this.accountId = accountId;
		this.partyId = partyId;
		this.balance = balance;
	}

}
