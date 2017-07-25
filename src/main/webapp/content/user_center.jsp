<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link href="<%=request.getContextPath()%>/css/user_center.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/head.css" rel="stylesheet">
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
<jsp:include page="head.jsp" flush="true"></jsp:include>

<div class="container contentContainer">
    <div class="row">
        <div class="col-sm-3 hidden-xs affix">
            <div class="panel panel-success  userInfo">
                <div class="panel-body">
                    <img src="<%=request.getContextPath()%>/imgs/head/${sessionScope.user.headImg}"
                         class="userHeadProtrait">
                    <div class="numInfo"><span class="num">85</span><br><span class="dataType">微博</span></div>
                    <div class="numInfo"><span class="num">85</span><br><span class="dataType">关注</span></div>
                    <div class="numInfo"><span class="num">85</span><br><span class="dataType">粉丝</span></div>
                    <br/>
                    <hr/>
                    <div class="infoItem firstItem">
                        <span class="glyphicon glyphicon-user nicknameIcon" aria-hidden="true"></span>
                        &nbsp;&nbsp;&nbsp;
                        <c:if test="${empty sessionScope.user.nickName}">暂无</c:if>
                        <c:if test="${!empty sessionScope.user.nickName}">
                            ${sessionScope.user.nickName}
                        </c:if>
                    </div>
                    <div class="infoItem">
                        <svg class="icon sexIcon" aria-hidden="true">
                            <use xlink:href="#icon-sex"></use>
                        </svg>
                        &nbsp;&nbsp;&nbsp;
                        <c:choose>
                            <c:when test="${empty sessionScope.user.sex}">
                                暂无
                            </c:when>
                            <c:when test="${sessionScope.user.sex}">
                                男
                            </c:when>
                            <c:otherwise>
                                女
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="infoItem">
                        <svg class="icon birthIcon" aria-hidden="true">
                            <use xlink:href="#icon-birthday"></use>
                        </svg>
                        &nbsp;&nbsp;&nbsp;
                        <c:if test="${empty sessionScope.user.birthday}">暂无</c:if>
                        <c:if test="${!empty sessionScope.user.birthday}">
                            <fmt:formatDate value="${sessionScope.user.birthday}"
                                            pattern="yyyy-MM-dd"/>
                        </c:if>
                    </div>

                    <div class="infoItem">
                        <svg class="icon addressIcon" aria-hidden="true">
                            <use xlink:href="#icon-dizhi"></use>
                        </svg>
                        &nbsp;&nbsp;&nbsp;
                        <c:if test="${empty sessionScope.user.address}">暂无</c:if>
                        <c:if test="${!empty sessionScope.user.address}">
                            ${sessionScope.user.address}
                        </c:if>
                    </div>

                    <div class="infoItem">
                        <svg class="icon introIcon" aria-hidden="true">
                            <use xlink:href="#icon-jieshao"></use>
                        </svg>
                        &nbsp;&nbsp;&nbsp;
                        <c:if test="${empty sessionScope.user.intro}">暂无</c:if>
                        <c:if test="${!empty sessionScope.user.intro}">
                            ${sessionScope.user.intro}
                        </c:if>
                    </div>
                </div>
            </div>
            <div id="tree" class="userInfo"></div>
        </div>
        <div class="col-sm-9 col-xs-12 contentCol">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="#">微博</a></li>
                <li role="presentation"><a href="#">关注</a></li>
                <li role="presentation"><a href="#">粉丝</a></li>
                <li role="presentation"><a href="#">赞</a></li>
                <li role="presentation"><a href="#">评</a></li>
                <li role="presentation"><a href="#">转</a></li>
            </ul>
            <hr/>
            <c:forEach items="${myWeiboList}" var="weibo">
                <%@include file="weibo.jsp" %>
            </c:forEach>

        </div>

    </div>
</div>
</div>


<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-treeview.min.js"></script>
<script src="<%=request.getContextPath()%>/js/iconfont.js"></script>
<script src="<%=request.getContextPath()%>/js/head.js"></script>
<script src="<%=request.getContextPath()%>/js/user_center.js"></script>
<script src="<%=request.getContextPath()%>/js/weibo.js"></script>
</body>
</html>