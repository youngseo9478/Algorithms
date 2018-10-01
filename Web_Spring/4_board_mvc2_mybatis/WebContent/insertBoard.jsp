<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글올리기</title>
</head>
<body>
<div align="center">
  <h3>새글 등록하기</h3>
  <hr>
<form action="addBoard.do" method="get">
<input type="hidden" name="writer" value="${login.id }">
  <table border="1">
    <tr>
       <td>제 목</td>
       <td><input type="text" name="title"/> </td>
    </tr>
    <tr>
       <td>작성자</td>
       <td>${login.id}</td>
    </tr>
    <tr>
       <td>내용</td>
       <td>
          <textarea name="content" rows="10" cols="40">
          
          </textarea>
       </td>
    </tr>
    <tr>
       <td colspan="2" align="center">
        <input type="submit" value="글올리기">
       </td>
    </tr>
  </table>
</form>
</div> 

</body>
</html>