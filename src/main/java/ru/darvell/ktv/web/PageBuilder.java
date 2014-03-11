package ru.darvell.ktv.web;

public class PageBuilder {

	public static String getHeader() {
		String result = "<html>" +
				"    <head>" +
				"        <title>KTV servlet</title>" +
				"        <link rel=\"stylesheet\" type=\"text/css\" href=\"/AbonentsProjectKTV-1/resources/css/page.css\">" +
				"    </head>" +
				"" +
				"<body>" +
				"    <table id=\"page\">" +
				"" +
				"<tr id=\"page_header\">" +
				"</tr>" +
				"" +
				"" +
				"<tr id=\"page_body\">" +
				"    <td id=\"page_body_menu\">Меню" +
				"                    <ul>" +
				"                        <li><a href=\"/AbonentsProjectKTV-1/ktv/abonents?method=printsearch\">Абоненты</a></li>" +
				"                        <li>Договора</li>" +
				"                    </ul>" +
				"    </td>" +
				"<td id=\"page_body_content\">Контент";
		return result;
	}

	public static String getFooter() {
		String result = "</td>" +
				"" +
				"</tr>" +
				"" +
				"<tr id=\"page_footer\">" +
				"            </tr>" +
				"" +
				"        </table>" +
				"    </body>" +
				"</html>";

		return result;
	}
}
