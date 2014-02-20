package ru.darvell.ktv.dao;


import ru.darvell.ktv.logic.Abonent;

import java.sql.SQLException;
import java.util.Collection;

public interface AbonentDAO {
	public void addAbonent(Abonent abonent) throws SQLException;
	public void updateAbonent(Abonent abonent) throws SQLException;
	public void getAbonentById(Long abonentId) throws SQLException;
	public Collection getAllAbonents() throws SQLException;
	public void deleteAbonent(Abonent abonent) throws SQLException;
}
