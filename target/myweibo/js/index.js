var contentPath=$("#contextPath").val();
particlesJS.load('particles-js', contentPath+'/json/particles.json', function() {
    console.log('callback - particles.js config loaded');
});
$(".errorMessage").each(function(){
    if($(this).text().replace(" ","")!=""){
        var $form=$(this).parent();
        if($form.attr("class").indexOf("registerForm")!=-1){
            $form.parent().find("form").css("display","none");
            $form.css("display","block");
            $(".loginAction").parent().attr("class","");
            $(".registerAction").parent().attr("class","active");
        }
        return false;
    }
})
$(".loginAction").click(function(){
    $(this).parent().attr("class","active");
    $(".registerAction").parent().attr("class","");
    $(".loginForm").css("display","block");
    $(".registerForm").css("display","none");
});
$(".registerAction").click(function(){
    $(this).parent().attr("class","active");
    $(".loginAction").parent().attr("class","");
    $(".loginForm").css("display","none");
    $(".registerForm").css("display","block");
});
$(".validateImg").click(function(){
    $(this).css("background-image","url('"+contentPath+"/validateImg?time="+new Date().getTime()+"')")
});
var $registerUsername=$("#registerUsername");
$registerUsername.blur(function(){
    var $message=$(".nicknameError");
    if(validateNickname()){
        existNickname(function(data){
            if(data=="true"){
                $message.text("用户名已存在！");
            }else{
                $message.text("");
            }
        });
    }else{
        $message.text("用户名不能为空，且长度应小于20!");
    }
});
var $registerPassword=$("#registerPassword");
$registerPassword.blur(function(){
    if(!validatePassword()){
        $(".passwordError").text("密码长度必须在6位到20位之间！");
    }else{
        $(".passwordError").text("");
    }
});
function validatePassword(){
    var len=$registerPassword.val().length;
    return (len>=6 && len<20);
}
function validateNickname(){
    var val=$registerUsername.val().replace(" ","");
    if(val=="" || val.length>20){
        return false;
    }else{
        return true;
    }
}
function existNickname(callback) {
    var nickname = $registerUsername.val();
    $.ajax({
        url: contentPath + "/existNickname",
        data: {
            "nickname": nickname
        },
        error: function () {
            alert("请检查网络！")
        },
        success: function (data) {
            callback(data);
        }
    });
}
$("#validateCodeInput").blur(function () {
    isValidateCodeRight(function(data){
        var $validateCodeError=$(".validateCodeError");
        if(data=="false"){
            $validateCodeError.text("验证码输入错误！");
        }else if(data=="true"){
            $validateCodeError.text("")
        }
    });
});
    function isValidateCodeRight(callback){
        var input=$("#validateCodeInput").val();
        $.ajax({
            url: contentPath + "/isValidateCodeRight",
            data: {
                "validateCode": input
            },
            error: function () {
                alert("请检查网络！")
            },
            success: function (data) {
                callback(data);
            }
        });
    }
    $("#registerBtn").click(function(){
        var $btn=$(this);
        var $nicknameMessage=$(".nicknameError");
        if(validateNickname()){
            existNickname(function(data){
                if(data=="true"){
                    $nicknameMessage.text("用户名已存在！");
                }else{
                    $nicknameMessage.text("");
                    var $passwordMessage=$(".passwordError");
                    if(validatePassword()){
                        $passwordMessage.text("");
                        isValidateCodeRight(function(data){
                            var $validateCodeError=$(".validateCodeError");
                            if(data=="false"){
                                $validateCodeError.text("验证码输入错误！");
                            }else if(data=="true"){
                                $validateCodeError.text("");
                                $btn.parent().submit();
                            }
                        });
                    }else{
                        $passwordMessage.text("密码长度必须在6位到20位之间！");
                    }
                }
            });
        }else{
            $nicknameMessage.text("用户名不能为空，且长度应小于20");
        }
        return false;
    });
    $("#loginNicknameInput , #loginPasswordInput").blur(function () {
        var val=$("#loginNicknameInput").val().replace(" ","");
        var $loginError=$(".loginError");
        if(val==""){
            $loginError.text("昵称不能为空！")
        }else{
            if($("#loginPasswordInput").val()==""){
                $loginError.text("密码不能为空！");
            }else{
                $loginError.text("");
            }
        }
    });
    $("#loginBtn").click(function(){
        var val=$("#loginNicknameInput").val().replace(" ","");
        var $loginError=$(".loginError");
        if(val==""){
            $loginError.text("昵称不能为空！")
        }else{
            if($("#loginPasswordInput").val()==""){
                $loginError.text("密码不能为空！");
            }else{
                $loginError.text("");
                return true;
            }
        }
        return false;
    });
