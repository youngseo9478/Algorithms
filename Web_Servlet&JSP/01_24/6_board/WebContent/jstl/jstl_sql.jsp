<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 기반  SQL</title>
</head>
<body>
<sql:setDataSource 
       var="ds" 
       driver="oracle.jdbc.OracleDriver" 
       url="jdbc:oracle:thin:@127.0.0.1:1521:xe" 
       user="java01" 
       password="1234"/>
<sql:query var="rs" dataSource="${ds}">
    select * from users
</sql:query>
<table border="1">
   <tr><td>name</td><td>id</td><td>role</td></tr>
   <c:forEach var="data" items="${rs.rows}">
          <tr>
              <td>${data.name}</td>
              <td>${data.id}</td>
              <td>${data.role}</td>
          </tr>
   </c:forEach>
</table>

</body>
</html>










