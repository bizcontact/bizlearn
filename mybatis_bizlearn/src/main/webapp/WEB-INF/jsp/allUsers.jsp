<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<h3>All the users</h3>
	<table>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value = "${user.id}"/></td>
				<td><c:out value = "${user.name}"/></td>
				<td><c:out value = "${user.address}"/></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/addUser">Add User</a>
</body>
</html>