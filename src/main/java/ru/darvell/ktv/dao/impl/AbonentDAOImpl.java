package ru.darvell.ktv.dao.impl;


import org.hibernate.Session;
import ru.darvell.ktv.dao.AbonentDAO;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class AbonentDAOImpl implements AbonentDAO{
	@Override
	public void addAbonent(Abonent abonent) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(abonent);
		session.getTransaction().commit();
	}

	@Override
	public void updateAbonent(Abonent abonent) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(abonent);
		session.getTransaction().commit();
	}

	@Override
	public Abonent getAbonentById(Long abonentId) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Abonent abonent = (Abonent) session.load(Abonent.class,abonentId);
		session.getTransaction().commit();
		return abonent;
	}

	@Override
	public Collection getAllAbonents() throws SQLException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List abonens = session.createCriteria(Abonent.class).list();
		session.getTransaction().commit();
		return abonens;
	}

	@Override
	public void deleteAbonent(Abonent abonent) throws SQLException {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
