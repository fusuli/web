<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<form action="/ServletDemo/QueryServlet" method="post">

			ID：<input type="text" id="id" name="id" size="18" /> <input
				type="submit" value="提交" />
		</form>

	</div>
	<div align="center">
		<table width="800" border="1">
			<tr>
				<td>URLID</td>
				<td>URL</td>
				<td>STATUS</td>
				<td>UPDATE_TIME</td>
			</tr>
			<c:forEach items="${urlBeans}" var="urlBean">
			<tr>
				<td>${urlBean.urlid }</td>
				<td>${urlBean.url }</td>
				<td>${urlBean.status }</td>
				<td>${urlBean.update_time }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>