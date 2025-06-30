<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product, java.util.List" %>
<% List<Product> list = (List) session.getAttribute("productList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/addToCart" method="post">
		<select name="product">
			<%
				for (Product p : list) {
			%>
				<option value=<%= p.getCode() %>><%= p.getName() %></option>
			<%
				}
			%>
		</select>
		<button>장바구니 추가</button>
	</form>
	<a href="/cartList">장바구니 보기</a>
</body>
</html>