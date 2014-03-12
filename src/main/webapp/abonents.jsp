<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			    <td id="page_body_menu">Меню
                    <ul>
                        <li><a href="${approot}/abonents.jsp">Абоненты</a></li>
                        <li>Договора</li>
                    </ul>
		    	</td>

				<td id="page_body_content">
				    <form action = "abonents_search" method = "GET">
                        <table>
                            <tr>
                                <td>Фамилия</td>
                                <td><input type = "text" name = "first_name" value = "" size = "40"/></td>
                            </tr>
                            <tr>
                                <td/>
                                <td>
                                    <input type = "submit" value = "Найти"/>
                                <td>
                            </tr>
                        </table>
				    </form>

                    <table>
                        <c:forEach items="${abonents}" var="abonent">
                            <tr>
                                <td>${abonent.getLastName}</td>
                                <td>${abonent.getLastName}</td>
                                <td>${abonent.getLastName}</td>
                            </tr>
                        </c:forEach>
                    </table>

			    </td>

			</tr>

			<tr id="page_footer">
            </tr>

        </table>
    </body>
</html>