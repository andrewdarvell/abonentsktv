<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
    String redirectURL = "http://localhost:8080/AbonentsProjectKTV-1/ktv";
    response.sendRedirect(redirectURL);
%>





<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
    <head>
        <title>KTV servlet</title>
        <link rel="stylesheet" type="text/css" href="resources/css/page.css">
    </head>

	<body>
	    <table id="page">

			<tr id="page_header">
			</tr>


			<tr id="page_body">
			    <td id="page_body_menu">
                    <ul>
                        <li><a href="/abonents?method=showall">Абоненты</a></li>
                        <li>Договора</li>
                    </ul>
		    	</td>

				<td id="page_body_content">
			    </td>

			</tr>

			<tr id="page_footer">
            </tr>

        </table>
    </body>
</html>
