<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询树状目录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery.ztree.all-3.5.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <SCRIPT type="text/javascript" >
	var zTreeObj;
	var setting = {//配置对象
		callback:{
			onCheck: closeCurrentWindow
		},
		view: {
			selectedMulti: false,
			expandSpeed: "slow"
		},
		check: {
			enable: true,
			chkStyle: "checkbox",
		},
		data: {
			key: {
				name: "cname"
			},
			simpleData: {
				enable: true,
				idKey: "zid",//节点数据中保存唯一标识的属性名称，[setting.data.simpleData.enable = true 时生效]
				pIdKey: "parentId",//节点数据中保存其父节点唯一标识的属性名称。[setting.data.simpleData.enable = true 时生效]
				rootPId: 0  //用于修正根节点父节点数据，即 pIdKey 指定的属性值。[setting.data.simpleData.enable = true 时生效]
			}
		}
	};
	$(function(){
		$.ajax({
			   type: "POST",
			   url: "ztreeAction!queryByZtree",
			   dataType:"json",
			   success: function(zTreeNodes){
			     zTreeObj = $.fn.zTree.init($("#div1"), setting, zTreeNodes);
			     zTreeObj.expandAll(true);
			     var zid = "${param.zid}";  //zid为po中的主键
			     var node = zTreeObj.getNodeByParam("zid", zid);
			     zTreeObj.checkNode(node,true);
			     
			   }
		});
	});
	function closeCurrentWindow(event, treeId, treeNode) {
	  window.opener.changeCompanyInfo(treeNode.zid,treeNode.zname);
	   window.close();
	};
  </SCRIPT>
  </head>
  
  <body>
    <div id="div1" class="ztree" style="width:230px; overflow:auto;"></div>
  </body>
</html>
