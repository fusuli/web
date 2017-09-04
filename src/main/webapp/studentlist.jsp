<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.test.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function topage(currentpage) {
		var form = document.forms[0];
		form.currentpage.value = currentpage;
		form.submit();
	}
</script>
<style>
a {
	text-decoration: none
}
</style>
</head>

<body>
	<form action="/ServletDemo/pageServlet" method="post">
		<input type="hidden" name="currentpage" /> <input type="submit"
			value="ok">
		<table align="center" style="width: 60%;" border="1">
			<tr>
				<th>学生编号</th>
				<th>学生姓名</th>
				<th>学生年龄</th>
				<th>学生性别</th>
				<th>学生生日</th>
			</tr>
			<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>${list.age }</td>
					<td>${list.sex }</td>
					<td>${list.birth}</td>
				</tr>
			</c:forEach>
		</table>
		<div align="center" style="width: 100%">
			<a href="javascript:topage(${pageView.currentpage}-1)">上一页</a>
			<c:forEach begin="${pageView.startindex}" end="${pageView.endindex}"
				var="wp">
				<c:if test="${pageView.currentpage==wp}">
					<b>[${wp}]</b>
				</c:if>
				<c:if test="${pageView.currentpage!=wp}">
					<a href="javascript:topage('${wp}')">[${wp}]</a>
				</c:if>
			</c:forEach>
			<a
				href="javascript:topage(${pageView.currentpage}+1>${pageView.totalrecordnumber}?${pageView.totalrecordnumber}:${pageView.currentpage}+1)">下一页</a>
			总共${pageView.totalrecordnumber}页<br> 第${pageView.currentpage }页
		</div>
	</form>

</body>
</html>