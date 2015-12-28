<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="index.html"%>
<%@page import="formbean.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会员登录结果</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">

<body>
	<p>&nbsp;</p>
	<div align="center">
		<p>
			<strong> <%if(request.getAttribute("result")==null){
       userform user=(userform)request.getAttribute("user");
       session.setAttribute("user",user);
    %>
				<meta http-equiv="refresh"
					content="0;URL=medicine.do?action=searchn"> <%}else{%> <%
	  String result=(String)request.getAttribute("result");
	  %> <script language='javascript'>alert('<%=result%>');history.go(-1);</script>

				<%}%>
			</strong>
		</p>

	</div>
</body>
</html>
