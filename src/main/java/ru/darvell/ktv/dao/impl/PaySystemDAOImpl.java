package ru.darvell.ktv.dao.impl;


import org.hibernate.Session;
import ru.darvell.ktv.dao.PaySystemDAO;
import ru.darvell.ktv.logic.PaySystem;

import java.sql.SQLException;
import java.util.List;

public class PaySystemDAOImpl implements PaySystemDAO {

	private static Session session;

	@Override
	public void addPaySystem(PaySystem paySystem) throws SQLException {
		session.save(paySystem);
	}

	@Override
	public void updatePaySystem(PaySystem paySystem) throws SQLException {
		session.update(paySystem);
	}

	@Override
	public void saveOrUpdatePaySystem(PaySystem paySystem) throws SQLException {
		session.saveOrUpdate(paySystem);
	}

	@Override
	public PaySystem getPaySystemByID(Long paySystemId) throws SQLException {
		PaySystem paySystem = (PaySystem) session.load(PaySystem.class, paySystemId);
		return paySystem;
	}

	@Override
	public List getAllPaySystems() throws SQLException {
		List paySystems = session.createCriteria(PaySystem.class).list();
		return paySystems;
	}

	@Override
	public void deletePaySystem(PaySystem paySystem) throws SQLException {
		session.delete(paySystem);
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		PaySystemDAOImpl.session = session;
	}
}
