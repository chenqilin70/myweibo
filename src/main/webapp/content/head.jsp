<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
                        <div class="input-group">
                            <input type="text" class="form-control searchInput" aria-label="..." placeholder="搜索微博/用户">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    搜索&nbsp;<span class="caret search_btn_in_bar"></span></button>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li><a  href="#"  class="searchWeiboBtn">搜微博</a></li>
                                    <li><a href="#" class="searchUserBtn">搜用户</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </div><!-- /input-group -->
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
