<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h2> 구구단을 원하는 단을 입력하세요..</h2>
<form action="./calc.do" method="get">
   몇단 ? : <input type="text" name="number">
    <input type="submit" value="계산해주세요"><br>
    <span style="color:red"> ${errorMsg } </span> 
   
</form>
</body>
</html>