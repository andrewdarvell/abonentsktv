package ru.darvell.ktv.logic;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
	private long id;
	private BigDecimal summ;
	private String comment;
	private PaySystem paySystem;
	private Contract contract;
	private Date payDate;

	public Payment() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getSumm() {
		return summ;
	}

	public void setSumm(BigDecimal summ) {
		this.summ = summ;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PaySystem getPaySystem() {
		return paySystem;
	}

	public void setPaySystem(PaySystem paySystem) {
		this.paySystem = paySystem;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
}
