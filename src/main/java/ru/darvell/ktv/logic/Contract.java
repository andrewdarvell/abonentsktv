package ru.darvell.ktv.logic;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Contract {

	private Long id;
	private Date dateStart;
	private Date dateStop;
	private Date dateCreate;
	private String number;
	private Abonent abonent = new Abonent();
	private Set payments = new HashSet();

	public Contract() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateStop() {
		return dateStop;
	}

	public void setDateStop(Date dateStop) {
		this.dateStop = dateStop;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Abonent getAbonent() {
		return abonent;
	}

	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}

	public Set getPayments() {
		return payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}
}
