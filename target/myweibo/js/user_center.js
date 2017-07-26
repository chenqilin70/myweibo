var contextPah=$("#contextPath").val();
var $userInfo=$(".userInfo");
var $num=$(".num");
var $dataType=$(".dataType");
var $user_head=$(".user_head");
var $imgTd=$(".mainImgTd , .smallImgTd");
window.onresize=function(){
    changeWidth(window.innerWidth);
}
changeWidth(window.innerWidth);
function changeWidth(winWidth){
    if(winWidth<768){//手机
        console.log("手机:");
    }else if(winWidth<992){//平板
        $userInfo.css("width","160px");
        $num.css("font-size","22px");
        $dataType.css("font-size","15px");
        console.log("平板:")
    }else if(winWidth<1200){//普通电脑
        $userInfo.css("width","212px");
        $num.css("font-size","25px");
        $dataType.css("font-size","15px");
        console.log("普通电脑:")
    }else{//大屏幕
        $userInfo.css("width","260px");
        $num.css("font-size","30px");
        $dataType.css("font-size","18px");
        console.log("大屏幕:")
    }
    $imgTd.each(function(){
        $(this).css("height",this.offsetWidth+"px")
    });
    if($user_head.length>0){
        $user_head.css("width","70%").css("height",$user_head[0].offsetWidth);
    }

}
/*判断是否为最外面的元素被移出了*/
function isWrapElement(e, thisElement) {
    $relatedElement = e.relatedTarget;
    if ($relatedElement == null) {
        return true;
    }
    var flag = thisElement.compareDocumentPosition($relatedElement);
    return !(flag == 0 || flag == 20);
}
var $pager=$("#pager");
function myReCall(data){
    console.log(data)
    $('#result_box').html(data);
    $.getScript(contextPah+"/js/weibo.js");
}
$pager.zPager({
    pageData:15 , //每页数据条数
    url: contextPah+'/inner/user_center_weibo', //ajax路由
    ajaxSetData: true
});
