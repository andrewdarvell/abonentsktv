package ru.darvell.ktv.dao;

import ru.darvell.ktv.dao.impl.AbonentDAOImpl;


public class Factory {
	private static AbonentDAO abonentDAO = null;
	private static Factory instance = null;

	public static synchronized Factory getInstance(){
		if(instance == null){
			instance = new Factory();
		}
		return instance;
	}

	public AbonentDAO getAbonentDAO(){
		if (abonentDAO == null){
			abonentDAO = new AbonentDAOImpl();
		}
		return abonentDAO;
	}
}
