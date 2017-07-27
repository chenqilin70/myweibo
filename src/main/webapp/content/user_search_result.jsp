<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<input type="hidden" id="pageBean" value="${pageBean}"/>
<c:forEach items="${user_search_result}" var="user" varStatus="status">
    <div class="col-md-4 col-sm-6 col-xs-12 userBox">
    <table class="user_result_table" cellpadding="0" cellspacing="0" border="0">
    <tbody>
    <tr>
    <td class="user_resultTd">
        <div class="user_result_head"
             style="background-image: url(<%=request.getContextPath()%>/imgs/head/${user.headImg})"></div>

            <c:if test="${user.isCared}">
                <div class="btn-group">
                    <div class="hasCaredBtn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        已关注 <span class="caret"></span>
                    </div>
                    <ul class="dropdown-menu">
                        <li><a href="#">取消关注</a></li>
                        <li><a href="#">设置分组</a></li>
                    </ul>
                </div>
                <div class="addCareBtn hidden" userid="${user.userId}" nickname="${user.nickName}">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    加关注
                </div>
            </c:if>
            <c:if test="${!user.isCared}">
                <div class="btn-group hidden">
                    <div class="hasCaredBtn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        已关注 <span class="caret"></span>
                    </div>
                    <ul class="dropdown-menu">
                        <li><a href="#">取消关注</a></li>
                        <li><a href="#">设置分组</a></li>
                    </ul>
                </div>
                <div class="addCareBtn" userid="${user.userId}" nickname="${user.nickName}">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        加关注
                </div>
            </c:if>

    </td>
    <td>
    <div class="user_result_info_box">
    <ul>
    <li class="nickNameLi">${user.nickName}</li>
    <li>
        <c:choose>
            <c:when test="${empty user.sex}">
                <i class="sexIcon unknownsex"></i>
            </c:when>
            <c:when test="${user.sex}">
                <i class="sexIcon manIcon"></i>
            </c:when>
            <c:when test="${!user.sex}">
                <i class="sexIcon womanIcon"></i>
            </c:when>
        </c:choose>
        &nbsp;|&nbsp;
        <c:if test="${empty user.address}">
            暂无地址信息
        </c:if>
            ${user.address}
    </li>
    <li>
    <span class="info_item">生日：</span>&nbsp;
    <c:choose>
        <c:when test="${empty user.birthday}">
            暂无生日信息
        </c:when>
        <c:otherwise>
            <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate>
    </c:otherwise>
</c:choose>
</li>
<li>
    <p>
        <span class="info_item">简介：</span>&nbsp;
        <c:if test="${empty user.intro}">
            暂无简介信息
        </c:if>
        ${user.intro}
    </p>
</li>
</ul>
</div>
</td>
</tr>
</tbody>
</table>
</div>
</c:forEach>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                    <table cellspacing="0" cellpadding="0" border="0" class="groupsTable">
                        <tr>
                            <c:forEach items="${groups}" var="group" varStatus="status">
                                <c:if test="${status.index%3==0 and status.index!=0}">
                                    </tr><tr>
                                </c:if>
                                <td  align="left" class="groupNameTd">
                                    <input type="radio" name="iCheck" id="group${group['GROUP_ID']}" groupid="${group['GROUP_ID']}">
                                    <label for="group${group['GROUP_ID']}">${group['GROUP_NAME']}</label>
                                </td>
                            </c:forEach>
                        </tr>
                    </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-success" id="groupingBtn" userid="">确定</button>
            </div>
        </div>
    </div>
</div>
