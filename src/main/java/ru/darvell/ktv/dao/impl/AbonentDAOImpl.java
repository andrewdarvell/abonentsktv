package ru.darvell.ktv.dao.impl;

import org.hibernate.Session;
import ru.darvell.ktv.dao.AbonentDAO;
import ru.darvell.ktv.logic.Abonent;

import java.sql.SQLException;
import java.util.List;


public class AbonentDAOImpl implements AbonentDAO {

	private static Session session;

	@Override
	public void addAbonent(Abonent abonent) throws SQLException {
		session.save(abonent);
	}

	@Override
	public void updateAbonent(Abonent abonent) throws SQLException {
		session.update(abonent);
	}

	@Override
	public void saveOrUpdateAbonent(Abonent abonent) throws SQLException {
		session.saveOrUpdate(abonent);
	}

	@Override
	public Abonent getAbonentById(Long abonentId) throws SQLException {
		return (Abonent) session.load(Abonent.class,abonentId);
	}

	@Override
	public List getAllAbonents() throws SQLException {
		List abonens = session.createCriteria(Abonent.class).list();
		return abonens;
	}

	@Override
	public void deleteAbonent(Abonent abonent) throws SQLException {
		session.delete(abonent);
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		AbonentDAOImpl.session = session;
	}
}
