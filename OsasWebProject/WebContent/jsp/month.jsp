<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<s:set var="selected">${param.selected}</s:set>
<select name="${param.name}" id="${param.id}" class="${param.clazz}">
	<option value="" <s:if test="#selected == ''">selected</s:if>></option>
	<option value="1" <s:if test="#selected == 1">selected</s:if>>January</option>
	<option value="2" <s:if test="#selected == 2">selected</s:if>>February</option>
	<option value="3" <s:if test="#selected == 3">selected</s:if>>March</option>
	<option value="4" <s:if test="#selected == 4">selected</s:if>>April</option>
	<option value="5" <s:if test="#selected == 5">selected</s:if>>May</option>
	<option value="6" <s:if test="#selected == 6">selected</s:if>>June</option>
	<option value="7" <s:if test="#selected == 7">selected</s:if>>July</option>
	<option value="8" <s:if test="#selected == 8">selected</s:if>>August</option>
	<option value="9" <s:if test="#selected == 9">selected</s:if>>September</option>
	<option value="10" <s:if test="#selected == 10">selected</s:if>>October</option>
	<option value="11" <s:if test="#selected == 11">selected</s:if>>November</option>
	<option value="12" <s:if test="#selected == 12">selected</s:if>>December</option>
</select>