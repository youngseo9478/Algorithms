<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>CCTV ���� ����</h2>
	<form action="getCctvMap.do" method="get">
		<!-- <input type="radio" value="����" name="location" checked="checked"/>����
		<br>
		<input type="radio" value="����" name="location"/>����
		<br>-->
		<select name="gu">
			<option value="gangbuk">����</option>
			<option value="songpa">����</option>
		</select>
		<input type="submit" value="�˻�">
	</form>
</body>
</html>