<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/ebuy_maven/jsp/backstage/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
    <form action="<%=basePath%>/admin/PasswordUpdate" method="post">
    <ul class="forminfo">
    <li><label>旧密码</label><input name="oldpass" type="password" class="dfinput" /></li>
    <li><label>新密码</label><input name="newpass" type="password" class="dfinput" /></li>
    <li><label>确认密码</label><input name="confirm" type="password" class="dfinput"/></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>
    </ul>
    </form>
    </div>
</body>
</html>
