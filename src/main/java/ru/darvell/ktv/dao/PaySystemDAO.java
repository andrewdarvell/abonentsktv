package ru.darvell.ktv.dao;


import org.hibernate.Session;
import ru.darvell.ktv.logic.PaySystem;

import java.sql.SQLException;
import java.util.List;

public interface PaySystemDAO {
	public void addPaySystem(PaySystem paySystem) throws SQLException;

	public void updatePaySystem(PaySystem paySystem) throws SQLException;

	public void saveOrUpdatePaySystem(PaySystem paySystem) throws SQLException;

	public PaySystem getPaySystemByID(Long paySystemId) throws SQLException;

	public List getAllPaySystems() throws SQLException;

	public void deletePaySystem(PaySystem paySystem) throws SQLException;

	public Session getSession();

	public void setSession(Session session);
}

