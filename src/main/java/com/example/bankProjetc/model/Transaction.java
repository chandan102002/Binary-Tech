package com.example.bankProjetc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.bankProjetc.Views.TransactionView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(value = { TransactionView.post.class, TransactionView.get.class})
	private long id;
	
	@JsonView(value = { TransactionView.post.class, TransactionView.get.class})
	private Date date;
	
	@JsonView(value = { TransactionView.post.class, TransactionView.get.class})
	private float amout;
	
	@JsonView(value = { TransactionView.post.class, TransactionView.get.class})
	private String bankaddress;
	
	private boolean isdeleted ;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customers_transactions", joinColumns = @JoinColumn(name = "Customers_Transaction_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Customer_id", referencedColumnName = "id"))
	private List<Customer> customers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getAmout() {
		return amout;
	}

	public void setAmout(float amout) {
		this.amout = amout;
	}

	public String getBankaddress() {
		return bankaddress;
	}

	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	


}
