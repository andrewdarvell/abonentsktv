package ru.darvell.ktv.dao.impl;

import org.hibernate.Session;
import ru.darvell.ktv.dao.AbonentDAO;
import ru.darvell.ktv.logic.Abonent;

import java.sql.SQLException;
import java.util.List;


public class AbonentDAOImplOne implements AbonentDAO {

	private static Session session;

	@Override
	public void addAbonent(Abonent abonent) throws SQLException {
		session.beginTransaction();
		session.save(abonent);
		session.getTransaction().commit();
	}

	@Override
	public void updateAbonent(Abonent abonent) throws SQLException {
		session.beginTransaction();
		session.update(abonent);
		session.getTransaction().commit();
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
		session.beginTransaction();
		session.delete(abonent);
		session.getTransaction().commit();
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		AbonentDAOImplOne.session = session;
	}
}
