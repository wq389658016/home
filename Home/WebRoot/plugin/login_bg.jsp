<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>星系</title><base target="_blank" />
<script type="text/javascript"> 
window.onload = function () {
	C = Math.cos; 
	S = Math.sin;
    U = 0;
	w = window; 
	j = document; 
	d = j.getElementById("block"); 
	c = d.getContext("2d");
	W = d.width = w.innerWidth;
    H = d.height = w.innerHeight; 
	c.fillRect(0, 0, W, H); 
	c.globalCompositeOperation = "lighter"; 
	c.lineWidth = 0.2; c.lineCap = "round"; 
	var bool = 0, t = 0;
	d.onmousemove = function (e) {
	if (window.T) {
			if (D == 9) { 
					D = Math.random() * 15;
					 f(1);
				 }
	clearTimeout(T);
	}
	X = e.pageX;
	Y = e.pageY; 
	a = 0; b = 0; 
	A = X, B = Y; 
	R = (e.pageX / W * 999 >> 0) / 999;
	r = (e.pageY / H * 999 >> 0) / 999; 
	U = e.pageX / H * 360 >> 0;
	D = 9; 
	g = 360 * Math.PI / 180;
	T = setInterval(f = function (e) {
		c.save(); 
		c.globalCompositeOperation = "source-over"; 
		if (e != 1) { 
					c.fillStyle = "rgba(0,0,0,0.02)"; c.fillRect(0, 0, W, H);
				 }
				c.restore(); i = 25; while (i--) {
				c.beginPath(); if (D > 450 || bool) {
			if (!bool) { bool = 1; }
			if (D < 0.1) { bool = 0; }
				t -= g; D -= 0.1;
				}
			if (!bool) { t += g; D += 0.1; }
				q = (R / r - 1) * t; x = (R - r) * C(t) + D * C(q) + (A + (X - A) * (i / 25)) + (r - R); y = (R - r) * S(t) - D * S(q) + (B + (Y - B) * (i / 25)); if (a) { c.moveTo(a, b); c.lineTo(x, y) }
				c.strokeStyle = "hsla(" + (U % 360) + ",100%,50%,0.75)"; c.stroke(); a = x; b = y;
				}
			U -= 0.5; A = X; B = Y;
			}, 16);
	}
	j.onkeydown = function (e) { a = b = 0; R += 0.05 }
	d.onmousemove({ pageX: 300, pageY: 290 })
}</script>
<style>
body{margin:0;overflow:hidden}
a{color:#ccf}
a:hover{color:red}</style>

</head>
<body>
	<canvas id="block"></canvas>
</body>
</html>