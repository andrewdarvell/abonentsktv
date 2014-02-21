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
		session.save(contract);
	}

	@Override
	public void updateContract(Contract contract) throws SQLException {
		session.update(contract);
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
		session.delete(contract);
	}

	@Override
	public void saveOrUpdateContract(Contract contract) throws SQLException {
		session.saveOrUpdate(contract);
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		ContractDAOImplOne.session = session;
	}
}
