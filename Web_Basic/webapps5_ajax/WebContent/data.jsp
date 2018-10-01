<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

 <%
 	String name =request.getParameter("name")+" ´Ô";
 	String age =request.getParameter("age")+" »ì";
 	Date now = new Date();
 %>   
 
 {
 	"name" :"<%= name %>",
 	"age" :"<%= age %>" ,
 	"now" :"<%= now %>"
 }