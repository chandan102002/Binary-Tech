package com.example.bankProjetc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Long AccountId;
	private Object value;

	public AccountNotFoundException(Long AccountId, Object value) {
		super(String.format("%s not found with %s : '%s'", AccountId, value));

		this.AccountId = AccountId;
		this.value = value;
	}

	public Long getname() {
		return AccountId;
	}

	public Object getvalue() {
		return value;
	}
}
