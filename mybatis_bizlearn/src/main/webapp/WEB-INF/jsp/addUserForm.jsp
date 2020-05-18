<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<h3>Welcome, Enter The Employee Details</h3>
	<form:form method="POST" action="/addUser" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
                      Address</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>