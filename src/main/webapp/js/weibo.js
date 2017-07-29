var contextPah=$("#contextPath").val();
var $imgTd=$(".mainImgTd , .smallImgTd");
var $user_head=$(".user_head");
window.onresize=function(){
    changeWidth();
}
changeWidth();
function changeWidth(){
    $imgTd.each(function(){
        $(this).css("height",this.offsetWidth+"px")
    });
    if($user_head.length>0){
        $user_head.css("width","70%").css("height",$user_head[0].offsetWidth);
    }
}
$(".weiboBox").each(function(){
    var $this=$(this);
    var picsStr=$this.find(".picsVal").val();
    if(picsStr!=undefined && picsStr!=""){
        var picsArr=picsStr.split(",");
        for(var i=1;i<=picsArr.length;i++){
            $this.find(".weiboImg[img_order='"+i+"']")
                .css("background-image","url("+contextPah+"/imgs/weibo/"+picsArr[i-1]+")");
        }
    }
});
$(".likeLi").click(function(){
    var weiboid=$(this).attr("weiboid");
    var $icon=$(this).find("span");
    $.ajax({
        url:contextPah+"/inner/like",
        type:"get",
        data:{
            weiboid:weiboid
        },
        error:function(){
            alert("请检查网络！");
        },
        success:function(data){
            if(data=="true"){
                $icon.attr("class","glyphicon glyphicon-heart");
            }else{
                alert("请检查网络！");
            }
        }
    })
    return false;
});
$(".commentLi").click(function(){
    var $weiboid=$(this).attr("weiboid")
    var ue = UE.getEditor('commentEditor'+$weiboid,{
        toolbars:[['emotion']],
        elementPathEnabled:false,
        maximumWords:140,
        wordCount:false,
        initialFrameHeight:50
    });
});
