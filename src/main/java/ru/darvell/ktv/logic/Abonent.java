package ru.darvell.ktv.logic;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Abonent {
	private Long id;

	private String firstName;
	private String lastName;
	private String middleName;
	private Date dateBirth;
	private String passSer;
	private String passNumber;
	private Set contracts = new HashSet();

	public Abonent() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getPassSer() {
		return passSer;
	}

	public void setPassSer(String passSer) {
		this.passSer = passSer;
	}

	public String getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(String passNumber) {
		this.passNumber = passNumber;
	}

	public Set getContracts() {
		return contracts;
	}

	public void setContracts(Set contracts) {
		this.contracts = contracts;
	}

	public void addContract(Contract contract){
		this.contracts.add(contract);
	}

	public void delContract(Contract contract){
		this.contracts.remove(contract);
	}
}
