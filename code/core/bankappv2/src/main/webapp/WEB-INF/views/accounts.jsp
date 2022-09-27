<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oracle Bank app</title>
</head>
<body>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>accout id</th>
				<th>account holder name</th>
				<th>account balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accountsList}" var="account">
				<tr>
					<td>${account.id}</td>
					<td>${account.name}</td>
					<td>${account.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="transfer">transfer request</a> <br/>
	<a href="deposit">deposit request</a> <br/>
	<a href="withdraw">withdraw request</a>  <br/>
</body>
</body>
</html>