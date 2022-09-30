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

import com.example.bankProjetc.Views.Views;
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
@Table(name = "Transation_details")
public class Transation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(value = Views.TransactionView.post.class)
	private long transation_id;
	
	@JsonView(value = Views.TransactionView.post.class)
	private Date transation_date;
	
	@JsonView(value = Views.TransactionView.post.class)
	private float amout_of_transation;
	
	@JsonView(value = Views.TransactionView.post.class)
	private String bankaddress;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customers_transations", joinColumns = @JoinColumn(name = "Customers_Transation_id", referencedColumnName = "transation_id"), inverseJoinColumns = @JoinColumn(name = "Customer_id", referencedColumnName = "id"))
	private List<Customer> customers;

}
