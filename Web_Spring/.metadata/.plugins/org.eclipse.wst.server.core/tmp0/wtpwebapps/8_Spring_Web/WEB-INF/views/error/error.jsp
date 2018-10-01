<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error page</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"49631",secure:"49636"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-8" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/views/error/error.jsp">
	<h2 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-8" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/views/error/error.jsp">Error :(</h2>
	<% response.setStatus(200);%>
	예외 발생 -<%=exception%>
</body>
</html>