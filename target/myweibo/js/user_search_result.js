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
    var userid=$(this).attr("userid");
    var nickname=$(this).attr("nickname")
    var $this=$(this);
    $.ajax({
        url:contextPah+"/inner/addCare/"+userid,
        error:function(){
            alert("请检查网络");
        },
        success:function(data){
            if(data){
                var $btn_group=$this.parent().find(".btn-group");
                var btnClass=$btn_group.attr("class");
                $btn_group.attr("class",btnClass.replace(/hidden/,"").replace(/ /,""));
                var thisClass=$this.attr("class");
                $this.attr("class",thisClass+" hidden");
                $("#myModalLabel").text("设置"+nickname+"的分组");
                $("#groupingBtn").attr("userid",userid);
                $('#myModal').modal();
            }else{
                alert("请检查网络");
            }
        }
    })
});
$(("[type='radio']")).iCheck({
    checkboxClass: 'icheckbox_minimal',
    radioClass: 'iradio_minimal',
    increaseArea: '20%' // optional
});
$("#groupingBtn").click(function(){
    var $this=$(this);
    var userid=$this.attr("userid");
    var $checked=$(".groupsTable").find("input[checked]");
    $(("[type='radio']")).each(function(){
        console.log($(this)[0].checked)
    })
    // $.ajax({
    //     url:'',
    //     data:{
    //         ""
    //     }
    // });
});






































