package ru.darvell.ktv.dao;

import org.hibernate.Session;
import ru.darvell.ktv.logic.Payment;

import java.sql.SQLException;
import java.util.List;


public interface PaymentDAO {
	public void addPayment(Payment payment) throws SQLException;

	public void updatePayment(Payment payment) throws SQLException;

	public void saveOrUpdatePayment(Payment payment) throws SQLException;

	public Payment getPaymentByID(Long paymentId) throws SQLException;

	public List getAllPayments() throws SQLException;

	public void deletePayment(Payment payment) throws SQLException;

	public Session getSession();

	public void setSession(Session session);
}
