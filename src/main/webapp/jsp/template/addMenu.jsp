<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/9
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>添加菜单</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<!-- content start -->
<div class="admin-content">
    <div class="admin-content-body">
        <div class="am-cf am-padding am-padding-bottom-0">
            <div class="am-fl am-cf">
                <strong class="am-text-primary am-text-lg">新增菜单</strong> /
            </div>
        </div>

        <hr>

        <div class="am-tabs am-margin" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active"><a href="#tab1">基本信息</a></li>
                <li><a href="#tab2">详细描述</a></li>
                <li><a href="#tab3">SEO 选项</a></li>
            </ul>

            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">所属类别</div>
                        <div class="am-u-sm-8 am-u-md-10">
                            <select data-am-selected="{btnSize: 'sm'}">
                                <option value="option1">选项一...</option>
                                <option value="option2">选项二.....</option>
                                <option value="option3">选项三........</option>
                            </select>
                        </div>
                    </div>

                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">显示状态</div>
                        <div class="am-u-sm-8 am-u-md-10">
                            <div class="am-btn-group" data-am-button>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="radio" name="options" id="option1"> 正常
                                </label>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="radio" name="options" id="option2"> 待审核
                                </label>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="radio" name="options" id="option3"> 不显示
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">推荐类型</div>
                        <div class="am-u-sm-8 am-u-md-10">
                            <div class="am-btn-group" data-am-button>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="checkbox"> 允许评论
                                </label>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="checkbox"> 置顶
                                </label>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="checkbox"> 推荐
                                </label>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="checkbox"> 热门
                                </label>
                                <label class="am-btn am-btn-default am-btn-xs">
                                    <input type="checkbox"> 轮播图
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            发布日期
                        </div>
                        <div class="am-u-sm-8 am-u-md-10">
                            <form action="" class="am-form am-form-inline">
                                <div class="am-form-group am-form-icon">
                                    <i class="am-icon-calendar"></i>
                                    <input type="date" class="am-form-field am-input-sm" placeholder="日期">
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">
                            发布时间
                        </div>
                        <div class="am-u-sm-8 am-u-md-10">
                            <form action="" class="am-form am-form-inline">
                                <div class="am-form-group am-form-icon">
                                    <i class="am-icon-calendar"></i>
                                    <input type="datetime-local" class="am-form-field am-input-sm" placeholder="时间">
                                </div>
                            </form>
                        </div>
                    </div>

                </div>

                <div class="am-tab-panel am-fade" id="tab2">
                    <form class="am-form">
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">

                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm">
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                文章作者
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                                <input type="text" class="am-input-sm">
                            </div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                信息来源
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm">
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">选填</div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                内容摘要
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm">
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">不填写则自动截取内容前255字符</div>
                        </div>

                        <div class="am-g am-margin-top-sm">
                            <div class="am-u-sm-12 am-u-md-2 am-text-right admin-form-text">
                                内容描述
                            </div>
                            <div class="am-u-sm-12 am-u-md-10">
                                <textarea rows="10" placeholder="请使用富文本编辑插件"></textarea>
                            </div>
                        </div>

                    </form>
                </div>

                <div class="am-tab-panel am-fade" id="tab3">
                    <form class="am-form">
                        <div class="am-g am-margin-top-sm">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                SEO 标题
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end">
                                <input type="text" class="am-input-sm">
                            </div>
                        </div>

                        <div class="am-g am-margin-top-sm">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                SEO 关键字
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end">
                                <input type="text" class="am-input-sm">
                            </div>
                        </div>

                        <div class="am-g am-margin-top-sm">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                SEO 描述
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end">
                                <textarea rows="4"></textarea>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>

        <div class="am-margin">
            <button type="button" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
            <a type="button" class="am-btn am-btn-primary am-btn-xs" href="<%=basePath%>/Menus/getMenuMain">放弃保存</a>
        </div>
    </div>
</div>
<!-- content end -->
</body>
</html>
