<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>北京租房网</title>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
</head>

<body>
<form action="/addclasstime" method="post" enctype="multipart/form-data">
    课程类型：<input type="text" name="classKind">
    课程名称：<input type="text" name="className">
    课程目标:<input type="text" name="classTarget">
    <input type="file" name="mp4File">
    <input type="submit">
</form>
</body>
</html>