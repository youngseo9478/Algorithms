<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic jsp test</title>
</head>
<body>
<%!  
    public final static int NUM = 9;

    public int sum(int a , int b){
	    return a+b;
    }
    
%>
<h2>basic jsp test</h2>
합계처리  <%= sum(11,88) %>
<br>

<%  for(int i=0;i<NUM ; i++){ %>
     <h3> hello world </h3>
<%} %>
</body>
</html>









