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

import com.example.bankProjetc.Views.AccountView;
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
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@JsonView(value = AccountView.post.class)
	private long id;

	@JsonView(value = AccountView.post.class)
	private Date openingDate;

	@JsonView(value = AccountView.post.class)
	private long currentBalance;

	@JsonView(value = AccountView.post.class)
	private String bankaddress;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_account", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private List<Customer> customers = new ArrayList<Customer>();

}
