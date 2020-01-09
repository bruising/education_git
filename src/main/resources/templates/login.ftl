<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body>
<center>
    <h1>登录</h1>
    <form action="loginByPwd" method="post">
        <p>用户邮箱<input type="text" name="userid"/></p>
        <p>密码<input type="password" name="pwd"/></p>
        <input type="submit" value="登录"/>
    </form>
</center>

<script type="text/javascript">
        $("form").submit(function(){
            var pwd=$("[name='pwd']").val();
            var userid=$("[name='userid']").val();
            jQuery.ajax({
                type: "post",
                url: "/chazhao",
                data: {"pwd": pwd,"userid":userid},
                success: function (returnData) {
                    $("[name='pwd']").val(returnData);
                }
            });
        })
        $("[name='userid']").blur(function () {
            var userid=$("[name='userid']").val();
            jQuery.ajax({
                type: "post",
                url: "/chazhao1",
                data: {"userid":userid},
                success: function (returnData) {
                    $("[name='pwd']").val(returnData);
                }
            });
        })

</script>
</body>
</html>