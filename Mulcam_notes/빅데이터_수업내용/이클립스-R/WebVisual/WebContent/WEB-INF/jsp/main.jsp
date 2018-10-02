<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>CCTV 지도 보기</h2>
	<form action="getCctvMap.do" method="get">
		<!-- <input type="radio" value="강북" name="location" checked="checked"/>강북
		<br>
		<input type="radio" value="송파" name="location"/>송파
		<br>-->
		<select name="gu">
			<option value="gangbuk">강북</option>
			<option value="songpa">송파</option>
		</select>
		<input type="submit" value="검색">
	</form>
</body>
</html>