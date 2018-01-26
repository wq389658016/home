<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>照片—图片模糊过滤特效</title>
<style>
.img img{ width:250px; height:350px;}
.img{
	list-style: none;
	margin: 30px auto; padding: 0;
	width: 1056px; /* (250+10+4)x4 */
	font-size: 0; /* fix inline-block spacing */
}
.img li{
	display: inline-block;
	*display: inline;
	zoom: 1;
	width: 250px; height: 350px;
	margin: 2px;
	border: 5px solid #fff;
	-moz-box-shadow: 0 2px 2px rgba(0,0,0,.1);
	-webkit-box-shadow: 0 2px 2px rgba(0,0,0,.1);
	box-shadow: 0 2px 2px rgba(0,0,0,.1);
	-webkit-transition: all .3s ease;
	-moz-transition: all .3s ease;
	-ms-transition: all .3s ease;
	-o-transition: all .3s ease;
	transition: all .3s ease;
}

.img:hover li:not(:hover){
	-webkit-filter: blur(2px) grayscale(1);
	-moz-filter: blur(2px) grayscale(1);
	-o-filter: blur(2px) grayscale(1);
	-ms-filter: blur(2px) grayscale(1);
	filter: blur(2px) grayscale(1);
	opacity: .7; /* fallback */
}

</style>
</head>
<body>
	<marquee onmouseover=stop()  onmouseout=start()  scrollAmount=10  loop=infinite deplay="0"><h1 style="color:gray;">欢迎来到空间相册，祝你生活愉快</h1></MARQUEE>
	<ul class="img">
		<li>
		<img src="/img/login/photo_1.jpg"></li>
		<li>
		<img src="/img/login/photo_2.jpg"></li>
		<li>
		<img src="/img/login/photo_3.jpg"></li>
		<li>
		<img src="/img/login/photo_4.jpg"></li>
		<li>
		<img src="/img/login/photo_5.jpg"></li>
		<li>
		<img src="/img/login/photo_6.jpg"></li>
		<li>
		<img src="/img/login/photo_7.jpg"></li>
		<li>
		<img src="/img/login/photo_8.jpg"></li>
	</ul>
</body>
</html>