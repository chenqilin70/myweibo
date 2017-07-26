/*判断是否为最外面的元素被移出了*/
function isWrapElement(e, thisElement) {
    $relatedElement = e.relatedTarget;
    if ($relatedElement == null) {
        return true;
    }
    var flag = thisElement.compareDocumentPosition($relatedElement);
    return !(flag == 0 || flag == 20);
}
$(".searchWeiboBtn2").click(function(){
    window.location=contextPah+"/inner/search/"+$(".searchInput2").val()+"#1";
    return false;
});
$(".searchUserBtn2").click(function(){
    window.location=contextPah+"/inner/search_user/"+$(".searchInput2").val()+"#1";
    return false;
});

var $pager=$("#pager");
var searchStr=$(".searchStr").val();
var action=$("#action").val();
function myReCall(data){
    $('#result_box').html(data);
    var action=$("#action").val();
    if(action=="weibo"){
        $.getScript(contextPah+"/js/weibo.js");
    }else if (action=="user"){
        $.getScript(contextPah+"/js/user_search_result.js");
    }
}
$pager.zPager({
    pageData:action=="user"?50:20 , //每页数据条数
    url: contextPah+'/inner/'+(action=="user"?"search_user":"search")+'?searchStr='+searchStr, //ajax路由
    ajaxSetData: true
});
