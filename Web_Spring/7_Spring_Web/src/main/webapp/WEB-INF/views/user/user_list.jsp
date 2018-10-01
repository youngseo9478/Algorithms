<%@ page   contentType="text/html; charset=utf-8"     %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta   charset=utf-8">
<title>user_list.jsp(사용자 관리)</title> 
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<center>
<h3><spring:message code="message.userlist.title1"/></h3><hr>
<form action="searchuser.do" method="get">
<table>
<tr><td>
<select name="searchCondition">
	<c:forEach items="${userCondition}" var="searchType">
		<option value="${searchType.code}">${searchType.name}</option>
	</c:forEach>
</select>
<input type="text" name="searchKeyword">
<input type="submit" value="검색">
</td>
</tr>
</table>
</form>

</center>
<!-- <h5>회원 검색</h5>
<form action="search.do" method="post">
    <table>
        <tr>
           <td>
              <select name="condition">
                  <option value="name">이름</option>
                  <option value="id">아이디</option>
              </select>
              <input type="text" name="keyword">
              <input type="submit" value="검색">
           </td>
        </tr>
    </table>
</form> -->

<br><br>



<form name="f" method="get" action="./adduser.do">
<table width=780 border=0 cellpadding=0 cellspacing=0>
<tr>
	<td width="20"></td>
	<td>
	  	<!--contents-->
	  	<table width=590 border=0 cellpadding=0 cellspacing=0>
		  	<tr>
				<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b><spring:message code="message.userlist.title2"/></b></td>
		  	</tr>
	  	</table>  
	  	<br>
	  
	  	<!-- list -->
	  	<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  	<tr>
				<td width=190 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
				<td width=200 align=center bgcolor="E6ECDE">이름</td>
				<td width=200 align=center bgcolor="E6ECDE">권한정보</td>
		  	</tr>
 
 	<!-- 사용자 리스트를 클라이언트에게 보여주기 위하여 출력. -->
	  	<c:forEach var="user" items="${users}" >
		  	<tr>
				<td width=190 align=center bgcolor="ffffff" height="20">
					${user.id}
				</td>
				<td width=200 bgcolor="ffffff" style="padding-left:10">
					<a href="./userview.do?id=${user.id}" >
						 ${user.name}
					</a>
				</td>
				<td width=200 align=center bgcolor="ffffff">
					${user.role}
				</td>
		  	</tr>
		  	
	  	</c:forEach>
	  	</table>
	  	<!-- /list -->	 

		<br>
		<!-- button -->
	  	<table border="0" cellpadding="0" cellspacing="1" width="590">
			<tr>
				<td align="right">
					<input type="submit" value="사용자 추가"/>
				</td>
			</tr>
		</table>		
	</td>
</tr>
</table>  
</form>
</body>
</body>
</html>


