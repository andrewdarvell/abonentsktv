package ru.darvell.ktv.web;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.darvell.ktv.dao.AbonentDAO;
import ru.darvell.ktv.dao.Factory;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.util.HibernateUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


public class Abonents extends HttpServlet {

	private static Logger log = Logger.getLogger(Abonents.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			/*
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(PageBuilder.getHeader());

			Enumeration en = req.getParameterNames();
            String method = req.getParameter("method");

			out.println("<a href=\"/AbonentsProjectKTV-1/ktv/abonents?method=showall\">Показать всех абонентов</a>");

			out.println(printSearchForm());
              */
			//if (method.equals("printsearch")) {
			//	out.println(printSearchForm());
			//}

			String method = req.getParameter("method");

			if (method.equals("search")) {

			}
			;

			if (method.equals("showall")) {
				listAbonents2(req, resp);
			}
			/*
			out.println(PageBuilder.getFooter());

			out.flush();
			out.close();
            */
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public String printSearchForm() {
		String result = "<form action = \"abonents_search\" method = \"GET\">" +
				"<table>" +
				"<tr>" +
				"<td>Фамилия</td>" +
				"<td><input type = \"text\" name = \"first_name\" value = \"\" size = \"40\"/></td>" +
				"</tr>" +
				"<tr>" +
				"<td/>" +
				"<td>" +
				"<input type = \"submit\" value = \"Найти\"/>" +
				"<td>" +
				"</tr>" +
				"</table>" +
				"</form>";

		return result;
	}

	public void listAbonents(PrintWriter out) {
		out.println("<table id=\"abonents_list\">");
		out.println("<tr>");
		out.println("<td>Фамилия</td>");
		out.println("<td>Имя</td>");
		out.println("<td>Отчество</td>");
		out.println("</tr>");
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			AbonentDAO abonentDAO = Factory.getInstance().getAbonentDAO();
			abonentDAO.setSession(session);
			List list = abonentDAO.getAllAbonents();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				Abonent abonent = (Abonent) iterator.next();
				out.println("<tr>");
				out.println("<td>" + abonent.getLastName() + "</td>");
				out.println("<td>" + abonent.getFirstName() + "</td>");
				out.println("<td>" + abonent.getMiddleName() + "</td>");
				out.println("</tr>");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			session.close();
		}

		out.println("<tr>");
		out.println("</tr>");

		out.println("</table>");
	}

	public void listAbonents2(HttpServletRequest request, HttpServletResponse resp) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			AbonentDAO abonentDAO = Factory.getInstance().getAbonentDAO();
			abonentDAO.setSession(session);
			List list = abonentDAO.getAllAbonents();
			request.setAttribute("abonents", list);
			request.getRequestDispatcher("abonents.jsp").forward(request, resp);

		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			session.close();
		}
	}

}
