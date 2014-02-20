package ru.darvell.ktv.dao;

import ru.darvell.ktv.dao.impl.AbonentDAOImpl;

/**
 * Created with IntelliJ IDEA.
 * User: darvell
 * Date: 20.02.14
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class Factory {
	private static AbonentDAO abonentDAO = null;
	private static Factory instance = null;

	public Factory getInstance(){
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
