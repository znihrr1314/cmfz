<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
    <script type="text/javascript" src="script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/easyui.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        function changeImage() {
            $("#captchaImage").prop("src", "${pageContext.request.contextPath}/getKaptcha?t=" + new Date().getTime());
        }

        $(function () {
            //验证账号
            $("#user").validatebox({
                required: true,
                missingMessage: "账号不能为空",
            })
            //验证账号==END===

            //验证密码
            $("#pwd").validatebox({
                required: true,
                missingMessage: "密码不能为空",
            })

            //验证密码
            $("#enCode").validatebox({
                required: true,
                missingMessage: "验证码不能为空",
            })
        });

        function toLogin() {
            //  form 表单提交
            $("#loginForm").form("submit", {
                url: "login",
                onSubmit: function () {
                    var isOK = $("#loginForm").form("validate");
                    return isOK;
                },
                success: function (data) {
                    if (data) {
                        location = "${pageContext.request.contextPath}/main/main.jsp";
                    } else {
                        $.messager.show({
                            title: "登录提示",
                            msg: "登录失败",
                            showSpeed: 1000
                        });
                    }
                }
            });
        }
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" id="user" name="name" class="text" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" id="pwd" name="password" class="text" maxlength="20" autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" onclick="changeImage()" class="captchaImage"
                         src="${pageContext.request.contextPath}/getKaptcha" title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="submit" class="homeButton" value="" onclick="location.href='/'"><input type="button"
                                                                                                        onclick="toLogin()"
                                                                                                        class="loginButton"
                                                                                                        value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>