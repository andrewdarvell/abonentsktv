package ru.darvell.ktv.web;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.darvell.ktv.dao.AbonentDAO;
import ru.darvell.ktv.dao.Factory;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.util.HibernateUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class AbonentsSearch extends HttpServlet {

	private static Logger log = Logger.getLogger(AbonentsSearch.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {


			String method = req.getParameter("method");

			if (method.equals("abonents_search")) {
				String item = req.getParameter("selected");
				String value = req.getParameter("value");
				if (!value.equals("")) {
					searchAbonents(item, value, req, resp);
				} else {
					showEmptyForm(req, resp);
				}
			} else if (method.equals("showall")) {
				listAbonents(req, resp);

			} else if (method.equals("empty")) {
				showEmptyForm(req, resp);
			}


		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void showEmptyForm(HttpServletRequest request, HttpServletResponse resp) {
		try {
			request.getRequestDispatcher("abonentsSearch.jsp").forward(request, resp);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void listAbonents(HttpServletRequest request, HttpServletResponse resp) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			AbonentDAO abonentDAO = Factory.getInstance().getAbonentDAO();
			abonentDAO.setSession(session);
			List list = abonentDAO.getAllAbonents();
			request.setAttribute("abonentsList", list);
			request.getRequestDispatcher("abonentsSearch.jsp").forward(request, resp);

		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			session.close();
		}
	}

	public void searchAbonents(String item, String value, HttpServletRequest request, HttpServletResponse resp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List list = new ArrayList();

			if (item.equals("id")) {
				Factory.getInstance().getAbonentDAO().setSession(session);
				Abonent abonent = Factory.getInstance().getAbonentDAO().getAbonentById(Long.decode(value));
				list.add(abonent);
			} else {
				list = session.createCriteria(Abonent.class).add((Restrictions.like(item, "%" + value + "%"))).list();
			}
			request.setAttribute("abonentsList", list);
			request.getRequestDispatcher("abonentsSearch.jsp").forward(request, resp);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.info(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}
}
