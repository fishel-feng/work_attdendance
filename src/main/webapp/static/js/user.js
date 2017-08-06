function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName === '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}

$(function () {
    $.ajax({
        type:"POST",
        url:getRootPath()+"/user/info",
        dataType:"json",
        contentType:"application/json",
        data:{},
        success:function (data) {
            $(".user_head_img").attr("src",getRootPath()+data.headImage);
            $(".user_name").html(data.realName);
        }
    });
});