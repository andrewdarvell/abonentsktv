package ru.darvell.ktv.web;


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class KTVServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(KTVServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		try {

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>KTV servlet</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/page.css\">");

			out.println("</head>");
			out.println("<body>");
			out.println("<table id=\"page\">");

			//Заголовок страницы
			out.println("<tr id=\"page_header\">");
			out.println("</tr>");

			//Тело страницы
			out.println("<tr id=\"page_body\">");

			//Меню страницы
			out.println("<td id=\"page_body_menu\">\"Левая колонка\"");

			out.println("</td>");

			//Контент
			out.println("<td id=\"page_body_content\">\"Правая колонка\"");
			out.println("");

			out.println("</table>");

			out.println("</td>");
			out.println("</tr>");

			out.println("</tr>");

			out.println("<tr id=\"page_footer\">");
			out.println("</tr>");

			out.println("</table>");

			out.println("</body></html>");

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
