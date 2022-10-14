package com.example.bankProjetc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.example.bankProjetc.Views.AccountView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@JsonView(value = {AccountView.post.class, AccountView.get.class})
	private long id;

	@JsonView(value = {AccountView.post.class, AccountView.get.class})
	private Date openingDate;

	@JsonView(value = {AccountView.post.class, AccountView.get.class})
	private long currentBalance;

	@JsonView(value = {AccountView.post.class, AccountView.get.class})
	private String bankaddress;
	
	private boolean isdeleted ;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customers_account", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private List<Customer> customers = new ArrayList<Customer>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getBankaddress() {
		return bankaddress;
	}

	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	

}
