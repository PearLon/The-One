<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="index.html"%>
<%
         session.invalidate();
 out.println("<script>parent.location.href='login.jsp';</script>");
%>

