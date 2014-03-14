package ru.darvell.ktv.main;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import ru.darvell.ktv.dao.Factory;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.logic.Contract;
import ru.darvell.ktv.util.HibernateUtil;

import java.util.Date;


public class Main {

	private static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String args[]) {
		try {
			DOMConfigurator.configure("etc/log4j-config.xml");
		} catch (Exception e) {
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
		Session session = HibernateUtil.getSessionFactory().openSession();

		Contract contract1 = new Contract();
		contract1.setNumber("213213");
		contract1.setDateCreate(new Date(System.currentTimeMillis()));

		//abonent1.addContract(contract);

		//contract.setAbonent(abonent1);

		try {

			Factory.getInstance().getAbonentDAO().setSession(session);

			Factory.getInstance().getContractDAO().setSession(session);
			Factory.getInstance().getPaySystemDAO().setSession(session);
			Factory.getInstance().getPaymentDAO().setSession(session);
			/*
			Contract contract = Factory.getInstance().getContractDAO().getContractById(3L);
			PaySystem paySystem = Factory.getInstance().getPaySystemDAO().getPaySystemByID(1L);

			session.beginTransaction();

			Payment payment = new Payment();
			payment.setPayDate(new Date(System.currentTimeMillis()));
			payment.setPaySystem(paySystem);
			payment.setContract(contract);
			payment.setSumm(new BigDecimal(150.60));

			Factory.getInstance().getPaymentDAO().saveOrUpdatePayment(payment);

			Payment payment2 = new Payment();
			payment2.setPayDate(new Date(System.currentTimeMillis()));
			payment2.setPaySystem(paySystem);
			payment2.setContract(contract);
			payment2.setSumm(new BigDecimal(240.00));

			Factory.getInstance().getPaymentDAO().saveOrUpdatePayment(payment2);


			Abonent abonent2 = Factory.getInstance().getAbonentDAO().getAbonentById(4L);
			log.info(abonent2.getLastName());


			List list = session.createCriteria(Abonent.class).add(Restrictions.like("lastName", "%Ив%")).list();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()){
				Abonent abonent = (Abonent) iterator.next();
				log.info(abonent.getLastName());
			}
			session.getTransaction().commit();
            */
			session.beginTransaction();
			Abonent abonent = Factory.getInstance().getAbonentDAO().getAbonentById(4L);
			log.info(abonent.getLastName());
			//abonent.addContract(contract);
			//ontract.setAbonent(abonent);


			//Abonent abonent = contract1.getAbonent();
			//log.info(abonent.getLastName());
			//Factory.getInstance().getAbonentDAO().saveOrUpdateAbonent(abonent);
			//abonent1.addContract(contract);
			//Factory.getInstance().getContractDAO().saveOrUpdateContract(contract);
			//Set<Contract> contractsTmp = abonent.getContracts();
			//log.info(contractsTmp.size());
			//Iterator iterator = contractsTmp.iterator();
			//while (iterator.hasNext()){
			//	Contract contract1 = (Contract) iterator.next();
			//	log.info(contract.getNumber());
			//}


			//abonent.addContract(contract);
			//Factory.getInstance().getAbonentDAO().updateAbonent(abonent);
			//Factory.getInstance().getContractDAO().addContract(contract);


			//Abonent abonent = Factory.getInstance().getAbonentDAO().getAbonentById(4L);
			//Factory.getInstance().getAbonentDAO2().addAbonent(abonent1);
			//session.getTransaction().commit();
			//session.close();
			//session.flush();
			//log.info(abonent.getLastName());
			//HibernateUtil.getSessionFactory().close();

			//abonent1.setLastName("Петров");
			//Factory.getInstance().getAbonentDAO().updateAbonent(abonent);

			//ArrayList<Abonent> abonents = (ArrayList) Factory.getInstance().getAbonentDAO().getAllAbonents();
			//for (int i = 0; i < abonents.size(); i++){
			//	log.info(abonents.get(i).getLastName());
			//}

		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error(e.getMessage());
		} finally {
			log.info("Close session");
			session.close();

		}

		log.info("Stop");
	}
}
