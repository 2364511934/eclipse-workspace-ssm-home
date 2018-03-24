<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	HttpSession hs = request.getSession();
    String nameValue = null;
	if(null == (nameValue=(String)hs.getAttribute("user"))){
		nameValue ="";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="session" method="get">
			用户名:<input type="text" name="user" value="<%=nameValue%>" /><br/>
			密码:<input type="password" name="pwd" /><br/>
			<input type="submit" value="注册">
			<p><%=(request.getAttribute("msg") == null ? "" : request.getAttribute("msg"))%></p>
		</form>
</body>
</html>