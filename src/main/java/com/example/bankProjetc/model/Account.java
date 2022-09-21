package com.example.bankProjetc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Account_Id;
	private Date openingDate;
	private long currentBalance;
	
	@ManyToMany
	@JoinTable(name="customer_account",joinColumns = @JoinColumn(name="Account_Id"),
	inverseJoinColumns = @JoinColumn(name="Customer_Id"))
	private List<Customer> customer= new ArrayList<>(); 

}
