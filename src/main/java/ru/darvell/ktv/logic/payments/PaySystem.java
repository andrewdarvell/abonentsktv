package ru.darvell.ktv.logic.payments;


public class PaySystem {
	private Long id;
	private String description;

	public PaySystem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
