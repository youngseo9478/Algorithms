<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
/* �� �ȿ��� �ڹ��ڵ尡 ���� �� �ִ� */
	String name = request.getParameter("name")+" ��";
	String age = request.getParameter("age")+" ��";
	Date now = new Date();
%>

{
	"name" : "<%=name %>",
	"age" : "<%=age %>",
	"now" : "<%=now %>"
}
