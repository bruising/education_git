<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生信息</title>
    <style type="text/css">
        #bdiv{
            width: 800px;
            height: 600px;
            margin: 0px auto;
        }
        .button {
            border-radius: 5px;
            text-shadow: 0px -1px 0px #2b665e;
            -webkit-box-shadow: inset 0px 1px 3px 0px #868686;
            -moz-box-shadow: inset 0px 1px 3px 0px #868686;
            box-shadow: inset 0px 1px 3px 0px #868686;
            font-family: Arial;
            color: #FFFFFF;
            font-size: 15px;
            background: #868686;
            padding: 6px 25px 6px 25px;
            border: solid #566963 1px;
            text-decoration: none;
        }

        .button:hover {
            color: #FFFFFF;
            background: #6c7c7c;
            text-decoration: none;
        }
        #tximg{
            height: 100px;
            width:100px;
            border-radius:50%;
        }
        tr td:nth-child(1){
            font-size: 18px;
            color: #868686;
        }
        tr td:nth-child(2){
            text-align: center;
        }
    </style>
</head>
<body>
    <div id="bdiv">
        <br>
        <p align="right"><span id="btnspan"><button class="button">退出</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="button">编辑</button></span></p>
        <br><br><br><br>
        <form>
            <table align="center">
                <tr>
                    <td>头像</td>
                    <td><img id="tximg" src="${user.userPhoto!}" alt="暂无"></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>昵称</td>
                    <td>${user.nickname!}</td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>手机号</td>
                    <td>${user.phone!}</td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>邮箱</td>
                    <td>${user.email!}</td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>