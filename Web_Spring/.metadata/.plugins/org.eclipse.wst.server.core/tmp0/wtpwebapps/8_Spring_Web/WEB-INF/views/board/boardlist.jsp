<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board list </title>
<script type="text/javascript">
   function remove(){
	   if(confirm("삭제하시겠습니까?")){
		   return true;
	   }
	   return false;
   }

</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"49631",secure:"49636"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-7" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/views/board/boardlist.jsp">
<div align="center" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-7" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/views/board/boardlist.jsp">

<h2>글 목 록</h2>
<div >
  login 정보 : ${login.id} 님   <a href="logout.do">로그아웃</a>
</div>
<form action="searchBoard.do" method="post">
   <table border="1" width="80%">
      <tr>
         <td align="right">
           <select name="condition">
              <option value="title">제목</option>
              <option value="content">내용</option>
              <option value="writer">글쓴이</option>
           </select>
           <input name="keyword" type="text">
           <input type="submit" value="검색">
         </td>
      </tr>
   </table>
</form>
<hr>
<form action="deleteBoard.do">

   <table border="1" width="80%">
      <tr>
          <td>번호</td><td>제목</td><td>작성자</td>
          <td>등록일</td><td>조회수</td>
          <td><input type="submit" value="삭제" 
                       onclick="return remove()"> </td>
      </tr>
      <c:forEach var="data" items="${list}">
       <tr>
          <td>${data.seq}</td>
          <td><a href="getBoard.do?seq=${data.seq}"> ${data.title}</a> </td>
          <td>${data.writer}</td>
          <td>${data.regdate}</td>
          <td>${data.cnt}</td>
          <td><input type="checkbox" name="seq" value="${data.seq}"> </td>
      </tr>
      </c:forEach>
   </table>
</form>
<br>
<a href="<%=request.getContextPath()%>/insertBoard.html">새글등록</a>
<a href="./insertBoard.html">새글등록 </a>
<a href="/insertBoard.html">새글등록</a><!-- context경로가 빠져서 문제발생!! /만 붙이면 안된다! -->

</div>
</body>
</html>