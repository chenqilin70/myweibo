var contextPath=$("#contextPath").val();
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
    var $weiboid=$(this).attr("weiboid");
    var ue = UE.getEditor('commentEditor'+$weiboid,{
        toolbars:[['emotion']],
        elementPathEnabled:false,
        maximumWords:140,
        wordCount:false,
        initialFrameHeight:50
    });
    $(".commentEditor > .edui-editor").css("width","100%");
    $("#commentDiv"+$weiboid).css("display","block")
});
var replyEditor = UE.getEditor('replyEditor',{
    toolbars:[['emotion']],
    elementPathEnabled:false,
    maximumWords:140,
    wordCount:false,
    initialFrameHeight:50
});
replyEditor.ready(function(){
    $(".replyEditor > .edui-editor").css("width","100%");
    var $emjBtn=$("div[class='edui-box edui-icon edui-default']");
    $emjBtn.click(function(){
        var $edui_fixedlayer=$("#edui_fixedlayer");
        var t1;
        t1=window.setInterval(function(){
            var zIndex=$edui_fixedlayer.css("z-index");
            console.log(zIndex)
            if(zIndex=='1008'){
                $edui_fixedlayer.css("z-index","1500");
                window.clearInterval(t1);
            }
        },100);
    })
})

$(".commentBtn").click(function(){
    var $this=$(this);
    var weiboid=$this.attr("weiboid");
    var content=UE.getEditor('commentEditor'+weiboid).getContent();
    $.ajax({
        url:contextPath+"/inner/addComment",
        type:"post",
        data:{
            "commentContent":content,
            "weibo.weiboId":weiboid
        },
        error:function(){
            alert("请检查网络！")
        },
        success:function(data){
            if(data=="null"){
                alert("请检查网络！")
            }else{
                var commentJson=JSON.parse(data);
                $(".commentBox ul").append(
                    "<li>" +
                        "<a class='user_name'>" +
                            commentJson.user.nickName +
                        "</a>" +
                        ":"+commentJson.commentContent +
                        "<span class='commentTimeSpan'>(<fmt:formatDate value='${comment.commentTime}' pattern='yyyy-MM-dd HH:mm:ss'/>)</span>"+
                        "<hr class='commentHr'>" +
                    "</li>")
            }
        }
    });
});
var $replyModal=$("#replyModal")
$(".replyLink").click(function(){
    var $this=$(this);
    $replyModal.find(".replyTargetNickname").text($this.attr("nickname"));
    $replyModal.find(".targetContent").html($this.parent().find(".targetcontent").html());
    $replyModal.find(".publishReply").attr("touserid",$this.attr("touserid"))
                    .attr("commentid",$this.attr("commentid")).attr("tousernickname",$this.attr("nickname"));
    $replyModal.modal('show');
});
$(".publishReply").click(function(){
    var replyContent=replyEditor.getContent();
    var touserid=$(this).attr("touserid")
    var tousernickname=$(this).attr("tousernickname")
    var commentId=$(this).attr("commentid");
    var $commentLi=$("#commentLi"+commentId);
    $.ajax({
        url:contextPath+"/inner/addReply",
        type:"post",
        dataType:"json",
        data:{
            "replayContent":replyContent,
            "toUser.userId":touserid,
            "comment.commentId":commentId
        },
        error:function(){
            alert("请检查网络！")
        },
        success:function(data){
            console.log(data)
            $commentLi.find(".replyUl").append(
                "<li>" +
                    "<a class='user_name'>"+data.user.nickName+"</a>:@" +
                    "<a class='user_name'>"+tousernickname+"</a>&nbsp;&nbsp;" +
                    data.replayContent+"<a class='replyLink' nickname='"+data.user.nickName+"' touserid='"+data.user.userId+"' commentid='"+commentId+"'>回复</a>" +
                "</li>"
            );
            $replyModal.modal('hide')
        }
    })
});
