<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>微博</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/index.css?time=<%=new Date().getTime()%>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath()%>/js/html5shiv.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
    <div class="jumbotron backgroundJumb" id="particles-js">
        <div class="container">
            <div class="row" align="center">
                <div class="indexWin" align="center">
                    <div class="logo"></div>
                    <div class="slogan">有什么新鲜事想告诉大家</div>
                    <div class="formbox">
                        <ul class="nav nav-tabs">
                            <li role="presentation" class="active"><a href="#" class="loginAction">登录</a></li>
                            <li role="presentation" ><a href="#" class="registerAction">注册</a></li>
                        </ul>
                        <div class="panel panel-default formContent">
                            <div class="panel-body">
                                <form class="loginForm">
                                    <div class="input-group">
                                        <span class="input-group-addon" >
                                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        </span>
                                        <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
                                    </div>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
                                        </span>
                                        <input type="password" class="form-control" placeholder="密码（不少于6位）" aria-describedby="basic-addon1">
                                    </div>
                                    <input type="submit" class="btn btn-success" value="登录"/>
                                </form>
                                <form class="registerForm" action="<%=request.getContextPath()%>/register" method="post">
                                    <div class="errorMessage">${requestScope.registerError_nickname}</div>
                                    <div class="input-group">
                                        <span class="input-group-addon" >
                                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        </span>
                                        <input type="text" class="form-control"
                                               placeholder="用户名/昵称" name="username"
                                               aria-describedby="basic-addon1" id="registerUsername">
                                    </div>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
                                        </span>
                                        <input type="password" class="form-control" placeholder="密码（不少于6位）" name="password" aria-describedby="basic-addon1">
                                    </div>
                                    <div class="errorMessage">${requestScope.registerError_validate }</div>
                                    <div class="input-group">
                                        <span class="input-group-addon validateImgBox">
                                            <i class="validateImg" title="看不清？点击刷新验证码。"></i>
                                        </span>
                                        <input type="text" class="form-control" placeholder="请输入验证码" name="validateCode" aria-describedby="basic-addon1">
                                    </div>
                                    <input type="submit" class="btn btn-success" value="注册"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="linksBox">
            友情链接/使用技术：
            <a target="_blank" href="https://getbootstrap.com/">Bootstrap</a>&nbsp;|&nbsp;<a target="_blank" href="https://spring.io">Spring
            </a>&nbsp;|&nbsp;<a target="_blank" href="https://github.com/spring-projects/spring-mvc-showcase">Spring-MVC
            </a>&nbsp;|&nbsp;<a target="_blank" href="https://github.com/mybatis/mybatis-3">Mybatis
            </a>&nbsp;|&nbsp;<a target="_blank" href="https://redis.io/">Redis
            </a>&nbsp;|&nbsp;<a target="_blank" href="http://jquery.com/">jQuery
            </a>&nbsp;|&nbsp;<a target="_blank" href="https://github.com/VincentGarreau/particles.js">Particles</a>
            <br>
            作者：<a target="_blank"  href="https://github.com/chenqilin70">陈麒麟</a>
            &nbsp;&nbsp;联系方式：18827514070
        </div>
    </div>


<script src="<%=request.getContextPath()%>/js/particles.js" type="text/javascript"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/index.js"></script>
</body>
</html>