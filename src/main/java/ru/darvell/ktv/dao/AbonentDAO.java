package ru.darvell.ktv.dao;


import ru.darvell.ktv.logic.Abonent;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface AbonentDAO {
	public void addAbonent(Abonent abonent) throws SQLException;
	public void updateAbonent(Abonent abonent) throws SQLException;
	public Abonent getAbonentById(Long abonentId) throws SQLException;
	public List getAllAbonents() throws SQLException;
	public void deleteAbonent(Abonent abonent) throws SQLException;
}
