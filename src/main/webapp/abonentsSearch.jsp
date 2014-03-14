<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>KTV servlet</title>
        <link rel="stylesheet" type="text/css" href="resources/css/page.css">
        <link rel="stylesheet" type="text/css" href="resources/css/abonents.css">
    </head>

	<body>
	    <table id="page">

			<tr id="page_header">
			</tr>


			<tr id="page_body">
			    <td id="page_body_menu">Меню
                    <ul>
                        <li><a href="abonsearch?method=empty">Абоненты</a></li>
                        <li>Договора</li>
                    </ul>
		    	</td>

				<td id="page_body_content">

                    <form action = "abonsearch" method = "GET">
                    <input type="hidden" name="method" value="abonents_search" />
                        <table>
                            <tr>
                                <td>
                                    <select name="selected">
                                        <option value ="lastName">Фамилия</option>
                                        <option value ="id">ID</option>
                                    </select>
                                </td>
                                <td><input type = "text" name = "value" value = "" size = "40"/></td>
                            </tr>
                            <tr>
                                <td/>
                                <td>
                                    <input type = "submit" value = "Найти"/>
                                <td>
                            </tr>
                    </table>

                    <c:if test="${not empty abonentsList}">
                        <table id = "abonents_list">
                            <c:forEach items="${abonentsList}" var="abonent">
                                <tr>
                                    <td>${abonent.lastName}</td>
                                    <td>${abonent.firstName}</td>
                                    <td>${abonent.middleName}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>

			    </td>

			</tr>

			<tr id="page_footer">
            </tr>

        </table>
    </body>
</html>