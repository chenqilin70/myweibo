particlesJS.load('particles-js', '../json/particles.json', function() {
    console.log('callback - particles.js config loaded');
});
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