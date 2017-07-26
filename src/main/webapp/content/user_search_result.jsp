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
        <div class="addCareBtn">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            加关注
        </div>
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
