<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단 결과</title>
</head>
<body>
<h2> 구구단 결과 </h2>
<%  ArrayList<String> list = 
      (ArrayList<String>)request.getAttribute("data"); 

    for(String data : list){
%>
      <h3><%= data %></h3>
 <%
    }
%>
</body>
</html>