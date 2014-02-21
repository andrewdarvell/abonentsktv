package ru.darvell.ktv.dao.impl;


import org.hibernate.Session;
import ru.darvell.ktv.dao.ContractDAO;
import ru.darvell.ktv.logic.Contract;

import java.sql.SQLException;
import java.util.List;

public class ContractDAOImplOne implements ContractDAO{
	private static Session session;

	@Override
	public void addContract(Contract contract) throws SQLException {
		session.beginTransaction();
		session.save(contract);
		session.getTransaction().commit();
	}

	@Override
	public void updateContract(Contract contract) throws SQLException {
		session.beginTransaction();
		session.update(contract);
		session.getTransaction().commit();
	}

	@Override
	public Contract getContractById(Long contractId) throws SQLException {
		return (Contract) session.load(Contract.class,contractId);
	}

	@Override
	public List getAllContracts() throws SQLException {
		List contracts = session.createCriteria(Contract.class).list();
		return contracts;
	}

	@Override
	public void deleteContract(Contract contract) throws SQLException {
		session.beginTransaction();
		session.delete(contract);
		session.getTransaction().commit();
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		ContractDAOImplOne.session = session;
	}
}
