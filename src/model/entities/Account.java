package model.entities;

import model.exceptions.DomainException;


public class Account {
	private Integer number;
	private String holder;
	private Double balance, withDrawLimit;
	
	public Account() {
		
	}
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	private void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit(Double amount) {
		setBalance(getBalance() + amount);
	}
	public void withDraw(Double amount) {
		if(amount > getWithDrawLimit()) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit"); 
		}
		else if(amount > getBalance()){
			throw new DomainException("Withdraw error: Not enough balance");
		}
		else {
			setBalance(getBalance() - amount);
		}
	}
	
}
