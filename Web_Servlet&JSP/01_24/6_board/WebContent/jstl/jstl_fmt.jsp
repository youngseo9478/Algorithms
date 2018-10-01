<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl_fmt</title>
</head>
<body>

<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
now : ${now} <br>

now : <fmt:formatDate value="${now}" type="date" dateStyle="short" />
<br><br>
now : <fmt:formatDate value="${now}" type="date" dateStyle="full" />
<br><br>
<fmt:setLocale value="en-US"/>
now : <fmt:formatDate value="${now}" type="date" dateStyle="full" />

</body>
</html>





