package com.example.bankProjetc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.bankProjetc.Views.CustomerView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonView(value = {CustomerView.post.class, CustomerView.get.class})
	private long id;
	
	@JsonView(value = {CustomerView.post.class, CustomerView.get.class})
	private long accountid;
	
	@JsonView(value = {CustomerView.post.class,CustomerView.get.class})
	private String name;
	
	@JsonView(value = {CustomerView.post.class, CustomerView.get.class})
	private String address;
	
	@JsonView(value = {CustomerView.post.class, CustomerView.get.class})
	private long phone;
	
	@JsonView(value = {CustomerView.post.class, CustomerView.get.class})
	private String email;
	
	private boolean isdeleted = Boolean.FALSE;


	@JsonIgnore
	@ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Account> accounts= new ArrayList<Account>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountid() {
		return accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	
	
	
}
