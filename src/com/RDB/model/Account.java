package com.RDB.model;

import java.util.List;

public class Account {
	private Integer id;
	private Integer nib;
	private Client primary;
	private List<Client> secondary;
	private Double balance;
	private String historyOfOperations;
	
	public Account(Integer nib, Client primary, Double balance) {
		super();
		this.nib = nib;
		this.primary = primary;
		this.balance = balance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNib() {
		return nib;
	}
	public void setNib(Integer nib) {
		this.nib = nib;
	}
	public Client getPrimary() {
		return primary;
	}
	public void setPrimary(Client primary) {
		this.primary = primary;
	}
	public List<Client> getSecondary() {
		return secondary;
	}
	
	public void setSecondary(List<Client> secondary) {
		this.secondary = secondary;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getHistoryOfOperations() {
		return historyOfOperations;
	}
	public void setHistoryOfOperations(String historyOfOperations) {
		this.historyOfOperations = historyOfOperations;
	}
	@Override
	public String toString() {
		return "\nAccount id " + id + "| nib: " + nib + "\n| Owner: " + primary + "\n| Secondary Owner: " + secondary + "\n Balance: "
				+ balance + "\n-----------------------------------------------------------------------------------------------------------------------------------------";
	}


}
