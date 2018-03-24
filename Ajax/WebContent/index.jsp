<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js">
	
</script>

<script type="text/javascript">
	function baidu() {
		var val = document.getElementById("content").value;
		var oDiv = document.getElementById("div1");
		//借助于Ajax
		//1.创建xhr对象
		var xhr = new XMLHttpRequest();
		//2.打开连接
		xhr.open("GET", "ajax?key=" + val); //请求方式   请求路径   是否异步
		//3.发送请求     请求体
		xhr.send(null);
		//4.监听状态并且接收响应
		xhr.onreadystatechange = function() {
			//获取请求状态   0-4                 请求正确时获取
			if (xhr.readyState == 4 && xhr.status == 200) {
				oDiv.innerHTML = xhr.responseText;
			}
		}

	}
</script>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function baidujquery(){
		/* $.get("test?key="+$("#content").val(),function(data){
			$("#div1").html(data);
		}); */
		$.ajax({
			url:"ajax",
			type:"get",
			data:"key="+$("#content").val(),
			dataType:"text",
			success:function(data){
				$("#div1").html(data);
			}
		});
		
	}
</script>

<style type="text/css">
div {
	width: 200px;
	height: 200px;
	background: #ccc;
}
</style>
</head>
<body>
	<img alt="" src="img/bd_logo1.png" />
	<br />
	<input type="text" id="content" />
	<!-- <input type="button" name="" value="百度一下" onclick="baidu()" /> -->
	<input type="button" name="" value="百度一下" onclick="baidujquery()" />
	<div id="div1"></div>
</body>
</html>