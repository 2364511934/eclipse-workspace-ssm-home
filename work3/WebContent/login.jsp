<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	 Cookie[] cookies = request.getCookies();
	 String value = "";
	 if(null != cookies){
		 for(int i =0; i<cookies.length; i++){
			 if(cookies[i].getName().equals("user")){
				 value = cookies[i].getValue();
				 break;
			 }
		 }
	 }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="cooki" method="get">
			用户名:<input type="text" name="user" value="<%=value%>" /><br/>
			密码:<input type="password" name="pwd" /><br/>
			<input type="submit" value="注册">
		</form>
</body>
</html>