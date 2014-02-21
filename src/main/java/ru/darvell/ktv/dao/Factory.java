package ru.darvell.ktv.dao;

import ru.darvell.ktv.dao.impl.AbonentDAOImpl;
import ru.darvell.ktv.dao.impl.AbonentDAOImplOne;


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
			abonentDAO = new AbonentDAOImplOne();
		}
		return abonentDAO;
	}



	/*
	public AbonentDAO getAbonentDAO2(){
		if (abonentDAO == null){
			abonentDAO = new AbonentDAOImplOne();
		}
		return abonentDAO;
	}
	*/
}
