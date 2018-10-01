<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   if(session.getAttribute("login") == null){
	   request.setAttribute("errorMsg", "로그인이 필요합니다.");
	   response.sendRedirect("login.html");
	   return;
   }
%>
   <h2>서비스목록</h2>
   <h4>로그인 정보 : <%= session.getAttribute("login") %>  ${login } <br>
                   <a href="./logout.do">  로그아웃</a></h4>
   <a href="input.jsp">구구단 이용</a><br>
   <br>
   login count : <%= application.getAttribute("count") %><br>
   login count : ${count } <br>
   
</body>
</html>




