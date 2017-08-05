<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<input type="hidden" id="pageBean" value="${pageBean}"/>
<input type="hidden" id="loginedUserId" value="${sessionScope.user.userId}" />
<input type="hidden" id="loginedUserNickname" value="${sessionScope.user.nickName}" />
<c:forEach items="${weibo_search_result}" var="weibo">
    <div class="weiboBox" weiboid="${weibo.weiboId}">
        <div class="weiboHead" align="center">
            <img class="user_head" src="<%=request.getContextPath()%>/imgs/head/default.jpg">
        </div>
        <div class="weiboBody">
            <div><a  class="user_name">${weibo.user.nickName}</a></div>
            <div class="weibo_text">
                ${weibo.weiboContent}
            </div>
            <input type="hidden" value="${weibo.pics}" class="picsVal"/>
            <c:if test="${!empty weibo.pics}" >
                <table class="weibo_img_table" cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                    <tr>
                        <td rowspan="2" class="mainImgTd">
                            <div img_order="1" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd" >
                            <div  img_order="2" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd">
                            <div  img_order="4" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd">
                            <div  img_order="6" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd" >
                            <div  img_order="8" class="weiboImg" ></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="smallImgTd">
                            <div  img_order="3" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd">
                            <div  img_order="5" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd">
                            <div  img_order="7" class="weiboImg" ></div>
                        </td>
                        <td class="smallImgTd" >
                            <div  img_order="9" class="weiboImg" ></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </c:if>

            <div class="optionBox">
                <ul>
                    <li class="likeLi" weiboid="${weibo.weiboId}">

                        <c:set var="flag" value="false" scope="page"></c:set>
                        <c:forEach items="${weibo.likes}" var="like" varStatus="status">
                            <c:choose>
                                <c:when test="${like.user.userId==sessionScope.user.userId}">
                                    <span class="glyphicon glyphicon-heart"  aria-hidden="true"></span>
                                    <c:set var="flag" value="true" scope="page"></c:set>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${!flag}">
                            <span class="glyphicon glyphicon-heart-empty"  aria-hidden="true"></span>
                        </c:if>
                    </li>
                    <li class="commentLi" weibohost="${weibo.user.nickName}" weiboid="${weibo.weiboId}">

                        <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
                    </li>
                    <li class="repostLi"><span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span></li>
                </ul>
            </div>
            <div id="commentDiv${weibo.weiboId}" class="commentDiv">
                <div class="ueditorBox">
                    <script id="commentEditor${weibo.weiboId}" class="commentEditor" name="content" type="text/plain"></script>
                </div>
                <div class="commentBtn" weiboid="${weibo.weiboId}">评论</div>
            </div>



                <div class="who_like" weiboid="${weibo.weiboId}">
                    &nbsp;<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
                    &nbsp;&nbsp;&nbsp;
                    <c:if test="${fn:length(weibo.likes)>0}">
                        <c:forEach items="${weibo.likes}" var="like" varStatus="status">
                            <!--此处修改后weibo.js中的也要修改-->
                            <a href="#" userid="${like.user.userId}" >${like.user.nickName}</a>
                            <c:if test="${!status.last}">
                                、
                            </c:if>
                        </c:forEach>
                    </c:if>
                </div>


            <div class="commentBox">
                <ul><!--如果需要对此ul内的代码进行修改，需要同步对weibo.js内的代码修改-->
                    <c:forEach items="${weibo.comments}" var="comment">
                        <li id="commentLi${comment.commentId}">
                            <a class="user_name">${comment.user.nickName}</a>
                            :<span class="targetcontent">${comment.commentContent}</span>
                            <span class="commentTimeSpan">(<fmt:formatDate value="${comment.commentTime}" pattern="yyyy-MM-dd HH:mm:ss"/>)</span>
                            <a class="replyLink" nickname="${comment.user.nickName}" touserid="${comment.user.userId}" commentid="${comment.commentId}">回复</a>

                            <ul class="replyUl">
                                <c:forEach items="${comment.replays}" var="replay">
                                    <li>
                                        <a class="user_name">${replay.user.nickName}</a>:
                                        <a class="user_name">@${replay.toUser.nickName}</a>&nbsp;&nbsp;
                                        <span class='targetcontent'>${replay.replayContent}</span>
                                        <a class="replyLink" nickname="${replay.user.nickName}" touserid="${replay.user.userId}" commentid="${comment.commentId}">回复</a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <hr class="commentHr">
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <hr/>
</c:forEach>
<!-- Modal -->
<div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-labelledby="replyModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header replyModalHeader">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

            </div>
            <div class="modal-body replyModalBody">
                <h4 class="modal-title" id="replyModalLabel">
                    回复<span class="replyTargetNickname"></span>的评论
                </h4>
                <div class="targetContent"></div>
                <script id="replyEditor" class="replyEditor" name="content" type="text/plain"></script>
            </div>
            <div class="modal-footer replyModalFooter">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary publishReply">回复</button>
            </div>
        </div>
    </div>
</div>
