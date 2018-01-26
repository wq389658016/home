<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页-登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/login.css" type="text/css" />
  </head>

  <body>
	<div id=lay01 class=wrap></div>
	<div id=lay02 class=wrap></div>
	<div id=lay03 class=wrap></div>
	<div id=lay04 class=wrap>
	<div id=layform>
	<form method=post name=loginform action=userAction!queryUser>
		<fieldset>
			<input id=input_name tabIndex=1 type=text name=user.username /> 
			<input id=input_pwd tabIndex=2 type=password name=user.password />
				<div id=input_remdiv>
					<input id=input_rem tabIndex=3 value=true type=checkbox name=input_rem/>
					<label for=input_rem>记住登陆</label> 
				</div>
			<input id=input_sub tabIndex=4 value=登录 type=submit name=input_sub/> 
		</fieldset> 
	</form>
	<div  style="color: red">${msg}</div>
	</div></div>
		<div id=lay05 class=wrap></div>
		<div id=lay06 class=wrap></div>
		<div id=lay07 class=wrap></div>
 </body>
</html>
