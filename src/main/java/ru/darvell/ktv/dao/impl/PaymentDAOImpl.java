package ru.darvell.ktv.dao.impl;


import org.hibernate.Session;
import ru.darvell.ktv.dao.PaymentDAO;
import ru.darvell.ktv.logic.Payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

	private static Session session;

	@Override
	public void addPayment(Payment payment) throws SQLException {
		session.save(payment);
	}

	@Override
	public void updatePayment(Payment payment) throws SQLException {
		session.update(payment);
	}

	@Override
	public void saveOrUpdatePayment(Payment payment) throws SQLException {
		session.saveOrUpdate(payment);
	}

	@Override
	public Payment getPaymentByID(Long paymentId) throws SQLException {
		return (Payment) session.load(Payment.class, paymentId);
	}

	@Override
	public List getAllPayments() throws SQLException {
		List payments = session.createCriteria(Payment.class).list();
		return payments;
	}

	@Override
	public void deletePayment(Payment payment) throws SQLException {
		session.delete(payment);
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		PaymentDAOImpl.session = session;
	}
}
