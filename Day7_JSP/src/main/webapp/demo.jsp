<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<h1>Welcome...!</h1>



	<form action="demo.jsp" method="get">

		Name : <input type="text" name="name" placeholder="Enter UR name...">

	</form>

	<%
	String name = request.getParameter("name");
	for (int i = 0; i <= 50; i++) {
	%>
	<h1>
		<%=name%>
		=
		<%=i%></h1>
	<%
	}
	%>



</body>
</html>