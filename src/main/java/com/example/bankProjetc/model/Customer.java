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

import com.example.bankProjetc.Views.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Bank_Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonView(value = Views.CustomerView.post.class)
	private long id;
	
	@JsonView(value = Views.CustomerView.post.class)
	private long accountID;
	
	@JsonView(value = Views.CustomerView.post.class)
	private String name;
	
	@JsonView(value = Views.CustomerView.post.class)
	private String address;
	
	@JsonView(value = Views.CustomerView.post.class)
	private long phone;
	
	@JsonView(value = Views.CustomerView.post.class)
	private String email;

	@JsonIgnore
	@ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Account> accounts= new ArrayList<Account>();;
	
//	@ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//	private List<Transation> transation= new ArrayList<Transation>();

}
