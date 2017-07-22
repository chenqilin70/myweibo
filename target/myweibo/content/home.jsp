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
    <link href="<%=request.getContextPath()%>/css/home.css" rel="stylesheet">

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
                    <button type="button" class="navbar-toggle" data-toggle = "collapse"  data-target = "#target-menu">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/index">
                        <img alt="Brand" class="brandIcon" src="<%=request.getContextPath()%>/imgs/logo_white.png">
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="target-menu"   align="center">
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
                        <a href="#" class="navbar-link"><span class="userHead" style=""></span>&nbsp;${sessionScope.user.nickName}</a>
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
                        <a href="#" class="navbar-link indexA"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;首页</a>
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
                    <img src="<%=request.getContextPath()%>/imgs/head/${sessionScope.user.headImg}" class="userHeadProtrait">
                    <div class="numInfo"><span class="num">85</span><br><span class="dataType">微博</span></div>
                    <div class="numInfo"><span class="num">85</span><br><span class="dataType">关注</span></div>
                    <div class="numInfo"><span class="num">85</span><br><span class="dataType">粉丝</span></div>
                </div>
            </div>
            <div id="tree" class="userInfo"></div>
        </div>
        <div class="col-sm-9 col-xs-12 contentCol">
            <button class="publishBtn">发<br>布</button>
            <div class="sendWeiboDiv">
                <!-- 加载编辑器的容器 -->
                <script id="container" name="content" type="text/plain"></script>
                <!-- 配置文件 -->

                <script type="text/javascript" src="<%=request.getContextPath()%>/js/ueditor/ueditor.config.js"></script>
                <!-- 编辑器源码文件 -->
                <script type="text/javascript" src="<%=request.getContextPath()%>/js/ueditor/ueditor.all.js"></script>
                <script type="text/javascript" src="<%=request.getContextPath()%>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
                <!-- 实例化编辑器 -->
                <script type="text/javascript">
                    var ue = UE.getEditor('container',{
                        toolbars:[['emotion']],
                        elementPathEnabled:false,
                        maximumWords:140,
                        wordCount:false
                    });
                </script>
            </div>


            <table class="willSendImgTable" cellspacing="1" cellpadding="0" border="0">
                <tbody>
                <tr>
                    <c:forEach begin="1" end="9" step="1" varStatus="status">
                        <td>
                            <div class="willSendImg" title="点击删除"
                                 index="${status.index}" hasimg="false"
                                 data-toggle="modal" data-target="#myModal"></div>
                        </td>
                    </c:forEach>
                </tr>

                </tbody>
            </table>
            <input type="file" id="imageFile" name="img" multiple="multiple" />
            <hr/>
            <div class="weiboBox">
                <div class="weiboHead" align="center">
                    <img class="user_head" src="<%=request.getContextPath()%>/imgs/head/default.jpg">
                </div>
                <div class="weiboBody">
                    <div class="user_name">陈麒麟</div>
                    <div class="weibo_text">
                        #文澜贴士# 【今日大暑，全年最热的时候来了！】①太阳到达黄经120°时为大暑；②“小暑连大暑，热得无处躲”，大暑时节晴朗时酷热难耐，阴雨时闷得难受；③饮食要多咸少甜，不宜进补；④养生以养“心”为主，心态要平和，睡眠要充足。一年中最热的时候来了，你准备好没？ ​​​​
                    </div>
                    <table class="weibo_img_table" cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <tr>
                                <td rowspan="2" class="mainImgTd">
                                    <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/1.jpg')"></div>
                                </td>
                                <td class="smallImgTd">
                                    <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/2.jpg')"></div>
                                </td>
                                <td class="smallImgTd">
                                    <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/3.jpg')"></div>
                                </td>
                                <td class="smallImgTd">
                                    <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/4.jpg')"></div>
                                </td>
                                <td class="smallImgTd">
                                    <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/5.jpg')"></div>
                                </td>
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
            <!--重复开始-->
            <div class="weiboBox">
                <div class="weiboHead" align="center">
                    <img class="user_head" src="<%=request.getContextPath()%>/imgs/head/default.jpg">
                </div>
                <div class="weiboBody">
                    <div class="user_name">陈麒麟</div>
                    <div class="weibo_text">
                        #文澜贴士# 【今日大暑，全年最热的时候来了！】①太阳到达黄经120°时为大暑；②“小暑连大暑，热得无处躲”，大暑时节晴朗时酷热难耐，阴雨时闷得难受；③饮食要多咸少甜，不宜进补；④养生以养“心”为主，心态要平和，睡眠要充足。一年中最热的时候来了，你准备好没？ ​​​​
                    </div>
                    <table class="weibo_img_table" cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                        <tr>
                            <td rowspan="2" class="mainImgTd">
                                <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/1.jpg')"></div>
                            </td>
                            <td class="smallImgTd">
                                <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/2.jpg')"></div>
                            </td>
                            <td class="smallImgTd">
                                <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/3.jpg')"></div>
                            </td>
                            <td class="smallImgTd">
                                <div  style="background-image: url('<%=request.getContextPath()%>/imgs/test/4.jpg')"></div>
                            </td>
                            <td class="smallImgTd">
                                <div style="background-image: url('<%=request.getContextPath()%>/imgs/test/5.jpg')"></div>
                            </td>
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
            <!--重复结束-->
        </div>
    </div>
    </div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    删除提示
                </h4>
            </div>
            <div class="modal-body">
                是否删除此图片？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default hideModelBtn" data-dismiss="modal">
                    取消
                </button>
                <button type="button" class="btn btn-success deleteImgBtn">
                    确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</div>
<!-- /模态框（Modal）结束 -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-treeview.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>

<script src="<%=request.getContextPath()%>/js/home.js"></script>
</body>
</html>