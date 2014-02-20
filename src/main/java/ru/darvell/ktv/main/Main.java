package ru.darvell.ktv.main;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import ru.darvell.ktv.dao.Factory;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;


public class Main {

	private static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String args[]){
		try{
			DOMConfigurator.configure("etc/log4j-config.xml");
		}catch(Exception e){
			log.error("problem with log4j config file");
		}
		log.info("Start");

		HibernateUtil.getSessionFactory().openSession();

		Abonent abonent1 = new Abonent();
		abonent1.setFirstName("Сидор");
		abonent1.setLastName("Сидорович");
		abonent1.setMiddleName("Сидорский");
		abonent1.setPassSer("4322");
		abonent1.setPassNumber("458324");

		try{
			//Factory.getInstance().getAbonentDAO().addAbonent(abonent);
			//Abonent abonent1 = Factory.getInstance().getAbonentDAO().getAbonentById(4L);

			//log.info(abonent1.getLastName());
			//session.close();
			//abonent1.setLastName("Петров");
			//Factory.getInstance().getAbonentDAO().updateAbonent(abonent);

			ArrayList<Abonent> abonents = (ArrayList) Factory.getInstance().getAbonentDAO().getAllAbonents();
			for (int i = 0; i < abonents.size(); i++){
				log.info(abonents.get(i).getLastName());
			}

		}catch (Exception e){
			log.error(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();
		log.info("Stop");
	}
}
