var contextPah=$("#contextPath").val();
$(".userHead").css("background-image","url("+contextPah+"/imgs/head/"+$("#userImgHidden").val()+")");
var isChanged=true;
var $innerDiv=$(".willSendImgTable td div");
var $userInfo=$(".userInfo");
var $num=$(".num");
var $dataType=$(".dataType");
var $publishBtn=$(".publishBtn")
window.onresize=function(){
    if(isChanged){
        $("#edui1").css("width","auto");
        isChanged=false;
    }
     changeWidth(window.innerWidth);

}
var $user_head=$(".user_head");
var $imgTd=$(".mainImgTd , .smallImgTd");
changeWidth(window.innerWidth);
function changeWidth(winWidth){
    $publishBtn.css("font-size","20px");
    if(winWidth<768){//手机
        $publishBtn.css("font-size","14px");
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
    $user_head.css("width","70%").css("height",$user_head[0].offsetWidth);
    $innerDiv.css("height",$innerDiv.css("width"));
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

UE.registerUI('选择图片', function(editor, uiName) {
    //注册按钮执行时的command命令，使用命令默认就会带有回退操作
    editor.registerCommand(uiName, {
        execCommand: function() {
            $("#imageFile").trigger("click");
        }
    });
    //创建一个button
    var btn = new UE.ui.Button({
        //按钮的名字
        name: uiName,
        //提示
        title: uiName,
        //添加额外样式，指定icon图标，这里默认使用一个重复的icon
        cssRules: 'background-position: -41px -40px;',
        //点击时执行的命令
        onclick: function() {
            //这里可以不用执行命令,做你自己的操作也可
            editor.execCommand(uiName);
        }
    });
    //当点到编辑内容上时，按钮要做的状态反射
    editor.addListener('selectionchange', function() {
        var state = editor.queryCommandState(uiName);
        if (state == -1) {
            btn.setDisabled(true);
            btn.setChecked(false);
        } else {
            btn.setDisabled(false);
            btn.setChecked(state);
        }
    });
    //因为你是添加button,所以需要返回这个button
    return btn;
});
//开始加载tree
var tree = [
    {
        text: "全部微博",
    },
    {
        text: "家人",
    },
    {
        text: "朋友"
    },
    {
        text: "名人明星"
    },
    {
        text: "体育"
    },
    {
        text: "未分组"
    }
];
$('#tree').treeview({
    data: tree,
    color:"#222222",
    emptyIcon:"glyphicon glyphicon-tag",
    selectedBackColor:"#5CB85C"
});
var weiboFormData = new FormData();
//加载tree结束
$("#imageFile").change(function(){
    //以下开始修改img的src
    var $file = $(this);
    var fileObj = this;
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    if(fileObj && fileObj.files && fileObj.files[0]){
        var fileNum=fileObj.files.length;
        var userableImgNum=getUserableImgNum();
        if(userableImgNum>=fileNum){
            for(var i=0;i<fileNum;i++){
                dataURL = windowURL.createObjectURL(fileObj.files[i]);
                for(var j=1;j<=9;j++){
                    var $targetImg=$(".willSendImg[index='"+j+"']")
                    var hasimg=$targetImg.attr("hasimg");
                    if(hasimg=="false"){
                        $targetImg.css("background-image","url("+dataURL+")")
                            .css("display","block").css("height",$innerDiv.css("width"))
                            .css("border","1px solid #fff").attr("hasimg","true");
                        weiboFormData.append(dataURL, fileObj.files[i], fileObj.files[i].filename);
                        break;
                    }
                }

            }
        }else{
            alert("选择图片只能在9张以内userableImgNum："+userableImgNum+"fileNum:"+fileNum)
        }

    }else{
        alert("选择文件出问题！请检查")
        dataURL = $file.val();
        var imgObj = document.getElementById("preview");
        // 两个坑:
        // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
        // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
        imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
        imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
    }
});
function getUserableImgNum(){
    var count=0;
    $innerDiv.each(function(){
        var hasimg=$(this).attr("hasimg");
        if(hasimg=="false"){
            count++;
        }
    })

    return count;
}

$innerDiv.click(function(){
    var $this=$(this);
    var targetIndex=$(this).attr("index");
    $(".deleteImgBtn").one("click",function(){
        var imgs=new Array();
        $this.attr("hasimg","false").css("background-image","");

        var $willSendImgTable=$(".willSendImgTable");
        $innerDiv.each(function(){
            var $div=$(this);
            var bkimg=$div.css("background-image");
            if(bkimg!="" && bkimg!=undefined && bkimg!="none"){
                imgs.push(bkimg);
            }
        });
        $willSendImgTable.find(".willSendImg").css("background-image","none").attr("hasimg","false");
        for(var i=0;i<imgs.length;i++){
            var $i=$willSendImgTable.find(".willSendImg[index='"+(i+1)+"']");
            $i.css("background-image",imgs[i]).attr("hasimg","true");
        }

        $(this).parent().find(".hideModelBtn").trigger("click");

    })
});
$(".publishBtn").click(function(){
    for (var key of weiboFormData.keys()) {
        console.log(key);
    }

    /*
    $.ajaxFileUpload
    (
        {
            url:contextPah+'/inner/publishWeibo',//用于文件上传的服务器端请求地址
            secureuri:false,//一般设置为false
            fileElementId:'myChooser',//文件上传控件的id属性  <input type="file" id="file" name="file" />
            data:{
                height:offset.height,
                width:offset.width,
                top:offset.top,
                left:offset.left,
                imageName:document.getElementById("myChooser").files[0].name
            },
            dataType: 'json',//返回值类型 一般设置为json
            success: function (data,status)  //服务器成功响应处理函数
            {
                var message=JSON.parse(data);
                $submitBtn.css("display","block");
                $uploadWaiting.css("display","none");
                $(".chooserMask").css("display","none");
                if(message.isSuccess){
                    $(".profileImg , .userHeadInHead , .lisenerHead").attr("src","/music_view/img/listener_head/"+message.head+"?time="+new Date().getTime());
                }else{
                    alert("请检查网络");
                }
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert("请检查网络");
            }
        }
    );*/
});
function deepClone(o){
    var result;
    var oClass=getClass(o);
    if(oClass=="Object"){
        result={};
    }else if (oClass=="Array"){
        result=[];
    }else{
        return o;
    }
    for(key in o){
        var kClass=getClass(o[key])
        if(kClass=="Object" || kClass=="Array"){
            result[key]=arguments.callee(o[key]);
        }else{
            result[key]=o[key];
        }
    }
    return result;
}
function getClass(o){
    return Object.prototype.toString.call(o).slice(8,-1);
}


