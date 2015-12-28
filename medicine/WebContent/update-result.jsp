<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="index.html"%>
<%@page import="formbean.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改结果</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">

<body>
	<p>&nbsp;</p>
	<div align="center">
		<p>
			<strong> <%
	  String result=(String)request.getAttribute("result");
	  %> <script language='javascript'>alert('<%=result%>');window.location.href='medicine.do?action=searchn';</script>

			</strong>
		</p>

	</div>
</body>
</html>