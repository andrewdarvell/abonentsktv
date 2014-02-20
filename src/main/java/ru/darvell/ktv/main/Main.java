package ru.darvell.ktv.main;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import ru.darvell.ktv.util.HibernateUtil;

public class Main {

	private static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String args[]){
		try{
			DOMConfigurator.configure("etc/log4j-config.xml");
		}catch(Exception e){
			log.error("problem with log4j config file");
		}
		log.info("Start");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.close();

		log.info("Stop");
	}
}
