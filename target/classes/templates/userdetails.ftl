<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
    <div id="userdetails">
        <#list userList as item>
            <#list item.studentManagements as stu>
                <p>${stu.sname}</p>
            </#list>
        </#list>
    </div>
</body>
</html>