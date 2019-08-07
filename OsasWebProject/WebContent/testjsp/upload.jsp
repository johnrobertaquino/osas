<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>Agency Name</th>
		<th>Address</th>
		<th>Contact Person</th>
		<th>Contact Number</th>
	</tr>
	<s:iterator value="agencyList" var="agency">
		<tr>
			<td><s:property value="agencyName" /></td>
			<td><s:property value="address" /></td>
			<td><s:property value="contactPerson" /></td>
			<td><s:property value="contactNumber" /></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>