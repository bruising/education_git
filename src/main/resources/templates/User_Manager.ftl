<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
    <form action="/getUser" method="post">
        <p>
            <span>手机号：<input type="text" name="phone" value="${phone!}"/></span>
            <span>最近登录时间:<input type="text" name="latest_login_time" value="${latest_login_time!}"/></span>
           <span>付费状态：
                <select name="payment_status">
                    <option value="">全部付费状态</option>
                    <option value="1">已付费</option>
                    <option value="0">未付费</option>
            </select>
           </span>
            <span>注册时间：<input type="text" name="registration_time" value="${registration_time!}"/></span>
            <input type="submit" value="搜索"/>
            <input type="reset" value="重置"/>
        </p>
    </form>
    <table border="1px" cellspacing="0">
        <tr>
            <td>用户ID</td>
            <td>手机号</td>
            <td>用户昵称</td>
            <td>邮箱</td>
            <td>付费状态</td>
            <td>最近登录时间</td>
            <td>最近付费时间</td>
            <td>注册时间</td>
            <td>操作</td>
        </tr>
        <#list userPageNto.data as item>
            <tr>
            <td>${item.userid}</td>
            <td>${item.phone!}</td>
            <td>${item.nickname}</td>
            <td>${item.email}</td>
            <td>${item.payment_status!'--'}</td>
            <td>${item.latest_login_time!'--'}</td>
            <td>${item.latest_payment_time!'--'}</td>
            <td>${item.registration_time}</td>
            <td><a href="/userdetails?userid=${item.userid}&usertype=${item.usertype}">用户详情</a></td>
            </tr>
        </#list>
    </table>
    <p>
        <a href="/getUser?pageindex=1">首页</a>
        <#if userPageNto.hasPrevPage == true>
            <a href="/getUser?pageindex=${userPageNto.pageindex-1}">上一页</a>
        </#if>
        <#list 1..pagetotal as page_Num>
            <#if page_Num == (userPageNto.pageindex)>
                <a>${page_Num}</a>
            </#if>
            <#if page_Num != (userPageNto.pageindex)>
                <a href="/getUser?pageindex=${page_Num}">${page_Num}</a>
            </#if>
        </#list>
        <#if userPageNto.hasNextPage == true>
            <a href="/getUser?pageindex=${userPageNto.pageindex+1}">下一页</a>
        </#if>

        <a href="/getUser?pageindex=${pagetotal}">末页</a>
    </p>
</center>
</body>
</html>