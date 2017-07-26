var contextPah=$("#contextPath").val();
/*判断是否为最外面的元素被移出了*/
function isWrapElement(e, thisElement) {
    $relatedElement = e.relatedTarget;
    if ($relatedElement == null) {
        return true;
    }
    var flag = thisElement.compareDocumentPosition($relatedElement);
    return !(flag == 0 || flag == 20);
}
function registerDefaultMouseAction($doms,over,out){
    $doms.mouseover(function(e){
        if(isWrapElement(e,this)){
            $(this).css(over);
        }
    });
    $doms.mouseout(function(e){
        if(isWrapElement(e,this)){
            $(this).css(out);
        }
    });
}
registerDefaultMouseAction($(".userBox"),{backgroundColor:"#EEEEEE"},{backgroundColor:""});
registerDefaultMouseAction($(".addCareBtn"),{backgroundColor:"#449D44"},{backgroundColor:"#5CB85C"});
$(".addCareBtn").click(function(){
    var userid=$("this").attr("userid");
    $.ajax({
        url:contextPah+"/inner/addCare/"+userid,
        error:function(){
            alert("请检查网络");
        },
        success:function(data){
            if(data=="true"){

            }else{
                alert("请检查网络");
            }
        }
    })
})




































