<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>控制栏头部</title>
</head>
<body>
<header>
    <!-- logo -->
    <div class="am-fl tpl-header-logo">
        <a href="javascript:;"><img src="<%=IDEAPath%>assets/img/h7.ico" alt=""
                                    style="display: inline-block;width: 50px;"></a>
    </div>
    <!-- 右侧内容 -->
    <div class="tpl-header-fluid">
        <!-- 侧边切换 -->
        <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
        </div>
        <!-- 搜索 -->
        <div class="am-fl tpl-header-search">
            <form class="tpl-header-search-form" action="javascript:;">
                <button class="tpl-header-search-btn am-icon-search"></button>
                <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
            </form>
        </div>
        <!-- 其它功能-->
        <div class="am-fr tpl-header-navbar">
            <ul>
                <!-- 欢迎语 -->
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <a href="javascript:;">欢迎你</a>
                </li>
                <li class="am-text-sm">
                    <div class="user-sign-out" style="line-height: 56px;
                                                      display: block;
                                                      padding: 0 16px;
                                                      position: relative;
                                                      cursor: pointer;
">
                        <span class="am-icon-sign-out"></span> 退出
                    </div>
                </li>
            </ul>
        </div>
    </div>
</header>
<script>
    $(function () {
        $('.tpl-header-navbar-welcome').find('a').text(sessionStorage.getItem('userName') || '游客');
        $('.user-sign-out').on('click.signOut', function () {
            $.ajax({
                headers: {
                    'access-token': sessionStorage.getItem('accessToken') || ''
                },
                url: basePath + 'auth/invalidateToken',
                type: 'GET',
                dataType: 'json'
            }).always(function (resp) {
                var result = resp.result;
                sessionStorage.setItem('userName', '游客');
                sessionStorage.removeItem('accessToken');
                sessionStorage.setItem('accessToken', result);
                location.href = basePath + 'IDEA/template/login/userLogin.jsp';
            });
            //sessionStorage.removeItem('accessToken');

        });
    });
</script>
</body>
</html>
