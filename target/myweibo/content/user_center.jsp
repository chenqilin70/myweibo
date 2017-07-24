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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath()%>/js/html5shiv.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#target-menu">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/index">
                        <img alt="Brand" class="brandIcon" src="<%=request.getContextPath()%>/imgs/logo_white.png">
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="target-menu" align="center">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                               role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-tags" aria-hidden="true"></span>
                                &nbsp;全部微博
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">点赞</a></li>
                                <li><a href="#">评论</a></li>
                                <li><a href="#">转发</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left hidden-xs" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="搜索微博/用户">
                        </div>
                        <button type="submit" class="btn btn-success">搜索</button>
                    </form>
                    <p class="navbar-text navbar-right">
                        <input type="hidden" value="${sessionScope.user.headImg}" id="userImgHidden"/>
                        <a href="<%=request.getContextPath()%>/inner/user_center" class="navbar-link">
                            <span class="userHead" style=""></span>
                            &nbsp;${sessionScope.user.nickName}
                        </a>
                    </p>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                                &nbsp;消息<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">点赞</a></li>
                                <li><a href="#">评论</a></li>
                                <li><a href="#">转发</a></li>
                            </ul>
                        </li>
                    </ul>
                    <p class="navbar-text navbar-right">
                        <a href="#" class="navbar-link indexA"><span class="glyphicon glyphicon-home"
                                                                     aria-hidden="true"></span>&nbsp;首页</a>
                    </p>
                </div>


            </div>
        </div>

    </div>
</nav>

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
                <div class="weiboBox">
                    <div class="weiboHead" align="center">
                        <img class="user_head" src="<%=request.getContextPath()%>/imgs/head/default.jpg">
                    </div>
                    <div class="weiboBody">
                        <div class="user_name">${weibo.user.nickName}</div>
                        <div class="weibo_text">
                            ${weibo.weiboContent}
                        </div>
                        <table class="weibo_img_table" cellpadding="0" cellspacing="0" border="0">
                            <tbody>
                            <tr>
                                <c:forEach items="${fn:split(weibo.pics, ',')}" var="pic" varStatus="status">
                                    <c:if test="${status.index==0}">
                                        <td rowspan="2" class="mainImgTd">
                                            <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/1.jpg')"></div>
                                        </td>
                                    </c:if>
                                    <c:if test="${status.index>0}">
                                        <td class="smallImgTd">
                                            <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/2.jpg')"></div>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td class="smallImgTd">
                                    <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/6.jpg')"></div>
                                </td>
                                <td class="smallImgTd">
                                    <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/7.jpg')"></div>
                                </td>
                                <td class="smallImgTd">
                                    <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/8.jpg')"></div>
                                </td>
                                <td class="smallImgTd" >
                                    <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/9.jpg')"></div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="optionBox">
                            <span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
                        </div>
                        <div class="who_like">
                            &nbsp;<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
                            &nbsp;&nbsp;&nbsp;
                            <a href="#">张三</a>、
                            <a href="#">李四</a>、
                            <a href="#">王五</a>
                        </div>
                        <div class="commentBox">
                            <ul>
                                <li>张三：********************
                                    <ul>
                                        <li>李四回复张三：********************</li>
                                        <li>王五回复李四：********************</li>
                                    </ul>
                                </li>
                                <li>张三：********************
                                    <ul>
                                        <li>李四回复张三：********************</li>
                                        <li>王五回复李四：********************</li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <hr/>
            </c:forEach>

        </div>

    </div>
</div>
</div>


<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-treeview.min.js"></script>
<script src="<%=request.getContextPath()%>/js/iconfont.js"></script>
<script src="<%=request.getContextPath()%>/js/user_center.js"></script>
</body>
</html>