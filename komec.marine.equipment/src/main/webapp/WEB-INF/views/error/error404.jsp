<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="" />
<title>Error Page</title>
</head>
<body>
	<div style="margin:0 auto; width:534px;padding-top:220px"><img src="<%=request.getContextPath()%>/images/common/error404.jpg" width="534" height="146" /></div>
</body>
</html>