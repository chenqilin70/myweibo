<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<input type="hidden" id="pageBean" value="${pageBean}"/>
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
                        <span class="glyphicon glyphicon-heart-empty"  aria-hidden="true"></span>
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


            <c:if test="${fn:length(weibo.likes)>0}">
                <div class="who_like">
                    &nbsp;<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
                    &nbsp;&nbsp;&nbsp;
                    <c:forEach items="${weibo.likes}" var="like" varStatus="status">
                        <a href="#">${like.user.nickName}</a>
                        <c:if test="${!status.last}">
                            、
                        </c:if>
                    </c:forEach>
                </div>
            </c:if>

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
