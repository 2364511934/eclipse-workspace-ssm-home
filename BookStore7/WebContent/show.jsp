<%@page import="bean.Book"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<Book> books = (List<Book>) request.getSession().getAttribute("books");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 欢迎您<%=request.getSession().getAttribute("user")%> --%>
	<table border="1" cellspacing="0" cellpadding="0" width="230px"
		height="15px">
		<tr>
			<td>序号</td>
			<td>书名</td>
			<td>作者</td>
			<td>价格</td>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.bid}</td>
				<td>${book.bname}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>