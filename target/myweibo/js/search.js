$(".searchWeiboBtn2").click(function(){
    window.location=contextPah+"/inner/search/"+$(".searchInput").val()+"/1";
    return false;
});
$(".searchUserBtn2").click(function(){
    window.location=contextPah+"/inner/search_user/"+$(".searchInput").val()+"/1";
    return false;
});