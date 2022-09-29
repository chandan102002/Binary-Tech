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
	private long id;
	private Date openingDate;
	private long currentBalance;
	private String bankaddress;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_account", joinColumns = @JoinColumn(name = "Account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Customer_id", referencedColumnName = "id"))
	private List<Customer> customers = new ArrayList<Customer>();

}
