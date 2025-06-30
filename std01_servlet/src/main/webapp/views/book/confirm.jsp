<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String) request.getAttribute("user_name");
	String userPhone = (String) request.getAttribute("user_phone");
	String userEmail = (String) request.getAttribute("user_email");
	String bookName = (String) request.getAttribute("book_name");
	String borrowPeriod = (String) request.getAttribute("borrow_period");
	int price = (int) request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		if (userName != null) {
	%>
			<h1>도서 대출 내역</h1>
			<h4>[고객 정보]</h4>
			<ul>
				<li>고객명: <%= userName %></li>
				<li>전화번호: <%= userPhone %></li>
				<li>이메일: <%= userEmail %></li>
			</ul>
			
			<h4>[대출 정보]</h4>
			<ul>
				<li>도서 제목: <%= bookName %></li>
				<li>대출 기간: <%= borrowPeriod %>일</li>
			</ul>
			
			<h3>대출 금액: <%= price %>원</h3>
	<%
		}
	%>
</body>
</html>