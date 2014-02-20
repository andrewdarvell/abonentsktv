package ru.darvell.ktv.main;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.darvell.ktv.dao.Factory;
import ru.darvell.ktv.logic.Abonent;


public class Main {

	private static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String args[]){
		try{
			DOMConfigurator.configure("etc/log4j-config.xml");
		}catch(Exception e){
			log.error("problem with log4j config file");
		}
		log.info("Start");

		Abonent abonent = new Abonent();
		abonent.setFirstName("Сидор");
		abonent.setLastName("Сидорович");
		abonent.setMiddleName("Сидорский");
		abonent.setPassSer("4322");
		abonent.setPassNumber("458324");

		try{
			//Factory.getInstance().getAbonentDAO().addAbonent(abonent);
			Abonent abonent1 = Factory.getInstance().getAbonentDAO().getAbonentById(4L);
			log.info(abonent1.getLastName());
			//abonent1.setLastName("Петров");
			//Factory.getInstance().getAbonentDAO().updateAbonent(abonent);
		}catch (Exception e){
			log.error(e.getMessage());
		}

		log.info("Stop");
	}
}
