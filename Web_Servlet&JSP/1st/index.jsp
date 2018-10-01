<%@page import="com.my.util.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<h2>Hello World!</h2>
<%
  Connection con = JDBCUtil.getConnection();
%>
 Connection INFO :  <%= con %>
<% JDBCUtil.close(null, null, con); %>
</body>
</html>
