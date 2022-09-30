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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonView(value = CustomerView.post.class)
	private long id;
	
	@JsonView(value = CustomerView.post.class)
	private long accountid;
	
	@JsonView(value = CustomerView.post.class)
	private String name;
	
	@JsonView(value = CustomerView.post.class)
	private String address;
	
	@JsonView(value = CustomerView.post.class)
	private long phone;
	
	@JsonView(value = CustomerView.post.class)
	private String email;

	@JsonIgnore
	@ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Account> accounts= new ArrayList<Account>();;
	
}
