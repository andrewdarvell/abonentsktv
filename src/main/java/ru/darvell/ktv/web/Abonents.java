package ru.darvell.ktv.web;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Abonents extends HttpServlet {

	private static Logger log = Logger.getLogger(Abonents.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(PageBuilder.getHeader());

			Enumeration en = req.getParameterNames();

			String method = req.getParameter("method");
			if (method.equals("printsearch")) {
				out.println(printSearchForm());
			}

			out.println(PageBuilder.getFooter());

			out.flush();
			out.close();

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public String printSearchForm() {
		String result = "<form action = \"abonents_search\" method = \"GET\">" +
				"<table>" +
				"	<tr>" +
				"                                <td>Фамилия</td>" +
				"                                <td><input type = \"text\" name = \"first_name\" value = \"\" size = \"40\"/></td>" +
				"                            </tr>" +
				"                            <tr>" +
				"                                <td/>" +
				"                                <td>" +
				"                                    <input type = \"submit\" value = \"Найти\"/>" +
				"                                <td>" +
				"                            </tr>" +
				"                        </table>" +
				"    </form>";

		return result;
	}
}
