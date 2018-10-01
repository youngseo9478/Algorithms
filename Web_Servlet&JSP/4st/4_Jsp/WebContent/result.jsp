<%@page import="com.my.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page  errorPage="error.jsp"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result.jsp</title>
</head>
<body>
<h2><%= request.getParameter("name") %> 회원님</h2>
<h2>${param.name }  회원님</h2>
<h2>회원 가입이 완료 되었습니다.</h2>

<h3> 회원 가입 정보</h3>
<%  UserInfo data = (UserInfo)request.getAttribute("data");  %>
<table bgcolor="gray" border="1">
<tr><td>name</td><td>id</td><td>role</td> </tr>
<tr><td><%= data.getName() %></td>
    <td><%= data.getId()%></td>
    <td><%= data.getRole()%></td> 
</tr>
</table>
<br>
로그인을 원하면  <a href="./login.html">여기</a> 를 클릭하세요.
<br>
<table bgcolor="green" border="1">
<tr><td>name</td><td>id</td><td>role</td> </tr>
<tr><td>${data.name } </td>
    <td>${data.id }</td>
    <td>${data.role }</td> 
</tr>
</table>
<br>
email : ${data } <br>
list : ${list } <br>
</body>
</html>













