<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메 인 화 면</title>
<link type="text/css" rel="stylesheet" href="css/my.css">

</head>
<body>
<table border="1" width="100%">
<tr height="100">
     <td align="center" colspan="2">  
          <jsp:include page="header.jsp"/>
     </td>
</tr>
<tr>
      <td>
           <jsp:include page="menu.jsp"/>
      </td>
      <td align="center" id="content">
         <c:choose>
             <c:when test="${!empty content }">
                  <jsp:include page="${content}"/>
             </c:when>      
             <c:when test="${param.content != null }">
                  <jsp:include page="${param.content}"/>
             </c:when>
             <c:otherwise>
                   <jsp:include page="info.html"/>
             </c:otherwise>
         </c:choose>
      </td>
</tr>



<tr height="70">
     <td align="center" colspan="2">
         <jsp:include page="footer.jsp"/>
     </td>
</tr>
</table>
</body>
</html>









