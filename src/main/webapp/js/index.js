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
$("#registerUsername").blur(function(){
    $.ajax({
        url:contentPath+"/existNickname",
        data:{
            "nickname":$(this).text()
        },
        error:function(){
            alert("请检查网络！")
        },
        success:function(data){
            console.log(data)
        }
    })
});