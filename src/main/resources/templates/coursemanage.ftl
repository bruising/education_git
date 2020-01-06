<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="../static/jquery.min.js"></script>
</head>
<body>
<form action="coursesearch">
    课程名称: <input type="text" name="course_name" id="course_name" value="">
    课程创建时间:<input type="text" name="course_date" id="course_date" value="">
    <select name="course_status" id="course_status">
        <option value="" selected="selected">全部状态</option>
        <option value="0">下架</option>
        <option value="1">上架</option>
    </select>
    <input type="submit" value="搜索">
</form>

<table align="center">
    <tr>
        <td>课程id</td>
        <td>课程名称</td>
        <td>定价</td>
        <td>学员数</td>
        <td>状态</td>
        <td>显示顺序</td>
        <td>操作</td>
    </tr>

    <#list course as c>
    <tr>
        <td>${c.course_id!}</td>
        <td>${c.course_name!}</td>
        <td>${c.course_price!}</td>
        <td>${c.course_stunum!}</td>
        <#if  c.course_status == "0">
            <td>已下架</td>
        </#if>
        <#if c.course_status == "1">
            <td>上架</td>
        </#if>
        <td>
            <input type="text" value=${c.course_sort!} id="sort" name="sort">
           <#-- ${c.course_sort!}-->
        </td>
        <td><a href="lshelf?course_id=${c.course_id!}">下架</a>   补录  学员列表  详情</td>
    </tr>
    </#list>


</table>







</body>

<script type="text/javascript">
    $(function () {
        $("sort").blur(function () {
            alert("光标移开了")
        });
    })



</script>




</html>