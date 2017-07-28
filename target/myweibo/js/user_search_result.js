var contextPath=$("#contextPath").val();
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
        url:contextPath+"/inner/addCare/"+userid,
        type:"get",
        error:function(){
            alert("请检查网络");
        },
        success:function(data){
            if(data){
                var $btn_group=$this.parent().find(".btn-group");
                var btnClass=$btn_group.attr("class");
                $btn_group.attr("class",btnClass.replace(/hidden/,""));
                var thisClass=$this.attr("class");
                $this.attr("class",thisClass+" hidden");
                $(".groupsTable").find("input[isdefault='true']").iCheck('check')
                $("#myModalLabel").text("设置"+nickname+"的分组");
                $("#groupingBtn").attr("userid",userid);
                $('#myModal').modal('toggle');
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
    $(("[type='radio']")).each(function(){
        var $this=$(this);
        if($this[0].checked){
            var groupid=$this.attr("groupid");
            $.ajax({
                url:contextPath+"/inner/grouping",
                data:{
                    groupid:groupid,
                    userid:userid
                },
                error:function(){
                    alert("请检查网络！");
                },
                success:function (data) {
                    if(data){
                        $('#myModal').modal('toggle');
                    }else{
                        alert("请检查网络！");
                    }
                }
            });
        }
    });
});

$(".addGroupBtn").click(function(){
    var $groupInput=$(this).parent().parent().find(".addGroupInput");
    var groupName=$(this).parent().parent().find(".addGroupInput").val();
    if(groupName==""){
        $(".addGroupBtn").tooltip('show')
    }else{
        $.ajax({
            url:contextPath+"/inner/addGroup",
            type:"post",
            data:{
                "groupName":groupName
            },
            error:function () {
                alert("请检查网络!")
            },
            success:function (newGroupId) {
                console.log(newGroupId);
                console.log(typeof newGroupId);
                if(newGroupId!="null"){
                    $groupInput.val("");
                    var $groupsTable=$(".groupsTable");
                    var tdLength=$groupsTable.find("td").length;
                    if(tdLength%3==0){
                        $groupsTable.find("tbody").append("<tr></tr>")
                    }
                    $groupsTable.find("tr:last").append(
                        "<td  align='left' class='groupNameTd'>" +
                            "<input type='radio' name='iCheck' id='group"+newGroupId+"'groupid=''/>"+
                            "<label for='group"+newGroupId+"'>"+groupName+"</label>"+
                        "</td>");
                    var $newCheck=$groupsTable.find("#group"+newGroupId);
                    $newCheck.iCheck({
                        checkboxClass: 'icheckbox_minimal',
                        radioClass: 'iradio_minimal',
                        increaseArea: '20%'
                    });
                    $newCheck.iCheck('check');
                }else{
                    alert("请检查网络！")
                }
            }
        })
    }
});
$(".cancelCare").click(function(){
    var userid=$(this).attr("userid");
    $.ajax({
        url:contextPath+"/inner/cancelCare",
        type:"POST",
        data:{
            "userId":userid
        },
        error:function(){
            alert("请检查网络");
        },
        success:function(data){
            if(data=="true"){
                var $hasCaredBox=$(".hasCaredBox[userid='"+userid+"']");
                console.log("已关注的:"+$hasCaredBox[0])
                var $class=$hasCaredBox.attr("class");
                $hasCaredBox.attr("class",$class+" hidden");

                var $addCareBtn=$(".addCareBtn[userid='"+userid+"']")
                $addCareBtn.attr("class",$addCareBtn.attr("class").replace(/hidden/g,""));
                console.log("加关注的class:"+$addCareBtn.attr("class"))
            }else{
                alert("请检查网络");
            }
        }
    })
    return false;
});
$(".setGroup").click(function(){
    var userid=$(this).attr("userid");
    var nickname=$(this).attr("nickname");
    $.ajax({
        url:contextPath+"/inner/getGroupIdByFans",
        type:"post",
        data:{
            "userId":userid
        },
        error:function(){
            alert("请检查网络！")
        },
        success:function(data){
            var groupid = Number(data);
            if (!isNaN(groupid))
            {
                console.log(groupid);
                $(".groupsTable").find("input[groupid='"+groupid+"']").iCheck('check');
                $("#myModalLabel").text("设置"+nickname+"的分组");
                $("#groupingBtn").attr("userid",userid);
                $('#myModal').modal('toggle');
            }else{
                alert("请检查网络！");
            }
        }
    })
});






































