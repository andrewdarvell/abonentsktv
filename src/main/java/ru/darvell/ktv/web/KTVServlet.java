package ru.darvell.ktv.web;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.darvell.ktv.dao.Factory;
import ru.darvell.ktv.logic.Abonent;
import ru.darvell.ktv.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;

public class KTVServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(KTVServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		try {

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>KTV servlet</title></head><body>");

			out.println("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\">");
			out.println("<tr>");
			out.println("<td id=\"page_menu\" width=\"200\" valign=top>\"Левая колонка\"</td>");
			out.println("<td id=\"page_body\" valign=top>\"Правая колонка\"");


			Session session = HibernateUtil.getSessionFactory().openSession();
			Factory.getInstance().getAbonentDAO().setSession(session);
			ArrayList<Abonent> abonents = (ArrayList<Abonent>) Factory.getInstance().getAbonentDAO().getAllAbonents();
			out.println("<table border=\"1\" cellpadding=\"7\" >");
			for (int i = 0; i < abonents.size(); i++) {
				Abonent abonent = abonents.get(i);
				out.println("<tr>");
				out.println("<td>");
				out.println(abonent.getId());
				out.println("</td>");
				out.println("<td>");
				out.println(abonent.getLastName());
				out.println("</td>");
				out.println("<td>");
				out.println(abonent.getFirstName());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");

			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");

			out.println("</body></html>");

			session.close();
			out.flush();
			out.close();


		} catch (Exception ex) {
			log.error(ex.getMessage());

			if (ServletException.class.isInstance(ex)) {
				throw (ServletException) ex;
			} else {
				throw new ServletException(ex);
			}
		}

	}
}
