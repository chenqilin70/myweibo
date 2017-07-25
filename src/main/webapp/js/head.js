var contextPah=$("#contextPath").val();
$(".userHead").css("background-image","url("+contextPah+"/imgs/head/"+$("#userImgHidden").val()+")");
$(".searchWeiboBtn").click(function(){
    window.location=contextPah+"/inner/search/"+$(".searchInput").val()+"/1";
    return false;
});
$(".searchUserBtn").click(function(){
    window.location=contextPah+"/inner/search_user/"+$(".searchInput").val()+"/1";
    return false;
});