<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>성적 계산기</h1>
	<form id="scores">
		<label for="kor">국어 : </label>
		<input type="number" id="kor"><br>
		
		<label for="eng">영어 : </label>
		<input type="number" id="eng"><br>
		
		<label for="math">수학 : </label>
		<input type="number" id="math"><br>
		
		<button id="btnPost">계산</button>
	</form>
	
	<div id="resultArea"></div>
	
	<script type="text/javascript">
		$(function() {
			$("#scores").submit(function(e) {
				e.preventDefault();
				const kor = $("#kor").val();
				const eng = $("#eng").val();
				const math = $("#math").val();
				console.log("ajax");
				$.ajax({
					url: "/calcScores",
					type:"post",
					data: {
						kor : kor,
						eng : eng,
						math : math
					},
					success : function(data) {
						console.log("ajax 수신");
						$("#resultArea").html("<p>" + data + "</p>");
					},
					error : function() {
						alert("요청 실패!");
					}
				});
			});
		});
	</script>
</body>
</html>