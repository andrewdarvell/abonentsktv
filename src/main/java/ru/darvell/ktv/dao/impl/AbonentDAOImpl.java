package ru.darvell.ktv.dao.impl;


import org.hibernate.Session;
import ru.darvell.ktv.dao.AbonentDAO;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;

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
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void getAbonentById(Long abonentId) throws SQLException {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Collection getAllAbonents() throws SQLException {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void deleteAbonent(Abonent abonent) throws SQLException {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
