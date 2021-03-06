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
			out.println(PageBuilder.getHeader());
			out.println("Я сервлет!!!!");
			out.println(PageBuilder.getFooter());


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
