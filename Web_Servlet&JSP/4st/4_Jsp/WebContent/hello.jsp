<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> WElcome JSP ~~~</h1>
<% Date now = new Date(); %>
<%-- <h3><%= now %></h3> --%>
<!-- <h3><%= now %></h3>  -->
<h3><%= now %></h3>
  
<%  
   request.setCharacterEncoding("utf-8");
   String id = request.getParameter("id");
   String pw = request.getParameter("pw");
   //out.write(id);
   //out.write(pw);
%>  

<table border="1" width="30%">
  <tr> <td colspan="2"> 로그인정보 </td> </tr>
  <tr> <td><%= id %>  </td> <td><%=pw %>   </td> </tr>
</table>





</body>
</html>