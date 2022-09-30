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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(value =TransactionView.post.class)
	private long id;
	
	@JsonView(value =TransactionView.post.class)
	private Date date;
	
	@JsonView(value =TransactionView.post.class)
	private float amout;
	
	@JsonView(value =TransactionView.post.class)
	private String bankaddress;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customers_transactions", joinColumns = @JoinColumn(name = "Customers_Transaction_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Customer_id", referencedColumnName = "id"))
	private List<Customer> customers;

}
