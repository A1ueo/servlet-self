<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ empty cartList }">
			<p>장바구니가 비어있습니다.</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="product" items="${ cartList }">
				<p>${ product.code }
				&nbsp ${ product.name }
				&nbsp ${ product.price }</p>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>