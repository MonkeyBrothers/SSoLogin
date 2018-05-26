<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/base.css">
    <title>学习增删改查</title>
    <style>
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px white inset;
            border: 1px solid #CCC!important;
        }

    </style>
</head>
<body>
<!-- 登录页面样式 -->
<div class="login-page">
    <!-- 登录框样式 -->
    <div class="sign-wrap">
        <!-- 欢迎登录字样样式 -->
        <h3 class="sign-wrap-title">欢迎登录</h3>
        <form action="/sso/login" >
            <input type="hidden" name="redirectUrl" value="${redirectUrl}">
            <div><input class="sign-wrap-txt" type="text" name="username" placeholder="请输入账号"></div>
            <div><input class="sign-wrap-txt" type="password" name="password" placeholder="请输入密码"></div>

            <button class="sign-wrap-btn">登录</button>
            <div class="sign-wrap-tip">没有账号？ <a href="reg_toRegister.action">立刻注册</a></div>
        </form>
    </div>
</div>
</body>
</html>
