<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link href="<%=request.getContextPath()%>/css/page.css" rel="stylesheet">
    <%--<link href="http://cdn.bootcss.com/iCheck/1.0.2/skins/all.css" rel="stylesheet">--%>
    <link href="<%=request.getContextPath()%>/css/skins/minimal/_all.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/head.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/search.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/weibo.css" rel="stylesheet">




    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath()%>/js/html5shiv.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js"></script>

    <![endif]-->

</head>
<body>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
<jsp:include page="head.jsp" flush="true" ></jsp:include>
<input type="hidden" class="searchStr" value="${searchStr}">
<div class="container contentContainer">
    <div class="row searchLogoRow">
        <div class="col-md-12" align="center">
            <img class="searchLogo" src="<%=request.getContextPath()%>/imgs/weibo_search.png">
            <div class="searchEn">Search In Weibo</div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="input-group">
                <input type="text" class="form-control searchInput2" value="${searchStr}" aria-label="...">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        搜索 <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="#" class="searchWeiboBtn2">搜微博</a></li>
                        <li><a href="#" class="searchUserBtn2">搜用户</a></li>
                    </ul>
                </div><!-- /btn-group -->
            </div><!-- /input-group -->
        </div><!-- /.col-lg-12 -->
    </div><!-- /.row -->
    <input type="hidden" value="${action }" id="action"/>
    <c:choose>
        <c:when test="${action == 'weibo'}">
            <div class="row">
                <div class="col-md-9" id="result_box">
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default relativeUserPanel">
                        <div class="panel-heading">
                            <h3 class="panel-title">相关用户</h3>
                        </div>
                        <div class="panel-body">
                            <ul class="userUL">
                                <c:forEach items="${user_search_result}" var="user">
                                    <li>
                                        <table class="userTable" cellspacing="0" cellpadding="0" border="0">
                                            <tbody>
                                            <tr>
                                                <td rowspan="2" class="search_user_head_td">
                                                    <div class="search_user_head"
                                                         style="background-image: url(<%=request.getContextPath()%>/imgs/head/${user.headImg})">
                                                    </div>
                                                </td>
                                                <td class="nickNameTd">${user.nickName}</td>
                                            </tr>
                                            <tr>

                                                <td class="introTd">
                                                    <c:if test="${empty user.intro}">
                                                        暂无介绍
                                                    </c:if>
                                                        ${user.intro}
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>

                                    </li>
                                    <hr class="userHr"/>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
        <c:when test="${action == 'user'}">
            <div class="row user_result_row" id="result_box">

            </div>
        </c:when>
    </c:choose>
    <div class="row" >
        <c:if test="${action == 'user'}">
            <div class="col-md-12">
        </c:if>
        <c:if test="${action == 'weibo'}">
            <div class="col-md-9">
        </c:if>

            <div style="text-align: center;margin:20px auto;">
                <div id="pager"  class="pager clearfix"></div>
            </div>
        </div>
    </div>


</div>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/icheck.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.z-pager.js"></script>
<script src="<%=request.getContextPath()%>/js/head.js"></script>
<script src="<%=request.getContextPath()%>/js/search.js"></script>
<script src="<%=request.getContextPath()%>/js/weibo.js"></script>

</body>
</html>