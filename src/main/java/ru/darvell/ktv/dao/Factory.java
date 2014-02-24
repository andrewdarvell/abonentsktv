package ru.darvell.ktv.dao;


import ru.darvell.ktv.dao.impl.AbonentDAOImpl;
import ru.darvell.ktv.dao.impl.ContractDAOImpl;
import ru.darvell.ktv.dao.impl.PaySystemDAOImpl;
import ru.darvell.ktv.dao.impl.PaymentDAOImpl;


public class Factory {
	private static AbonentDAO abonentDAO = null;
	private static ContractDAO contractDAO = null;
	private static PaymentDAO paymentDAO = null;
	private static PaySystemDAO paySystemDAO = null;
	private static Factory instance = null;


	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public PaySystemDAO getPaySystemDAO() {
		if (paySystemDAO == null) {
			paySystemDAO = new PaySystemDAOImpl();
		}
		return paySystemDAO;
	}

	public PaymentDAO getPaymentDAO() {
		if (paymentDAO == null) {
			paymentDAO = new PaymentDAOImpl();
		}
		return paymentDAO;
	}

	public AbonentDAO getAbonentDAO() {
		if (abonentDAO == null) {
			abonentDAO = new AbonentDAOImpl();
		}
		return abonentDAO;
	}

	public ContractDAO getContractDAO() {
		if (contractDAO == null) {
			contractDAO = new ContractDAOImpl();
		}
		return contractDAO;
	}



	/*
	public AbonentDAO getAbonentDAO2(){
		if (abonentDAO == null){
			abonentDAO = new AbonentDAOImpl();
		}
		return abonentDAO;
	}
	*/
}
