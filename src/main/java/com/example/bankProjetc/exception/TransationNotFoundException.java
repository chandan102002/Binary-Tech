package com.example.bankProjetc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TransationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Long TransationId;
	private Object value;

	public TransationNotFoundException(Long TransationId, Object value) {
		super(String.format("%s not found with %s : '%s'", TransationId, value));

		this.TransationId = TransationId;
		this.value = value;
	}

	public Long getTransationId() {
		return TransationId;
	}

	public Object getValue() {
		return value;
	}
}
