<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
<title>Load Application</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>

<body>
<h2>Top News</h2>
	
	<table>
  <tr>
    <th>Country</th>
    <th>Category</th>
    <th>Keyword</th>
    <th>Title</th>
    <th>Description</th>
    <th>Source</th>
  </tr>
  <c:forEach items="${articles}" var="articles">
  <tr>
    <td>${country}</td>
    <td>${category}</td>
    <td>${keyword}</td>
    <td>${articles.title}</td>
    <td>${articles.description}</td>
    <td>${articles.url}</td>
  </tr>
  </c:forEach>
  
</table>
	
</body>

</html>