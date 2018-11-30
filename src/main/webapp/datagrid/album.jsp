<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    var db = [{
        text: "专辑详情",
        iconCls: 'icon-help',
        handler: function () {
            var r = $("#myTree").treegrid("getSelected")
            if (r != null) {
                if (r.score != null) {
                    $("#ff").dialog("open");
                    $('#ff').form('load', r);
                    $("#img").prop("src", "${pageContext.request.contextPath}/img/" + r.coverImg)
                } else {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中专辑',
                        showType: 'show',
                    });
                }
            } else {
                $.messager.show({
                    title: '警告',
                    msg: '请选中一行',
                    showType: 'show',
                });
            }

        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-add',
        handler: function () {
            $("#add").dialog("open");
        }
    }, '-', {
        text: "添加章节",
        iconCls: 'icon-edit',
        handler: function () {
            var q = $("#myTree").treegrid("getSelected")
            if (q != null) {
                if (q.score != null) {
                    $("#chapter").dialog("open");
                    $("#p_id").val(q.id);
                    alert(q.id)
                } else {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中专辑',
                    });
                }
            } else {
                $.messager.show({
                    title: '警告',
                    msg: '请选中一行',
                });
            }
        }
    }, '-', {
        text: "下载音频",
        iconCls: 'icon-help',
        handler: function () {
        }
    }]
    $(function () {

        $('#ff').dialog({
            resizable: true,
            title: '专辑详情',
            closed: true,
            modal: true,
            width: 400,
            height: 400
        });

        $('#add').dialog({
            resizable: true,
            title: '添加专辑',
            closed: true,
            modal: true,
            width: 400,
            height: 400,
            buttons: [{
                text: '保存',
                handler: function () {
                    addAlbum();
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#add").dialog("close")
                }
            }],
        });

        $('#chapter').dialog({
            resizable: true,
            title: '添加章节',
            closed: true,
            modal: true,
            width: 400,
            height: 400,
            buttons: [{
                text: '保存',
                handler: function () {
                    addchapter();
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#chapter").dialog("close")
                }
            }],
        });

        $('#myTree').treegrid({
            toolbar: db,
            fitColumns: true,
            url: 'allAlbum',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 180},
                {field: 'size', title: '文件大小', width: 60},
                {field: 'duration', title: '时长', width: 80},
                {field: 'downPath', title: '下载路径', width: 80}
            ]]
        });
    })

    function addchapter() {
        $("#addChapter").form("submit", {
            url: "addchapter",
            success: function (data) {
                if (data == "true") {
                    $("#chapter").dialog("close")
                    $("#myTree").treegrid("reload")
                } else {
                    $.messager.show({
                        title: "添加提示",
                        msg: "添加失败",
                        showSpeed: 1000
                    });
                }
            }
        })
    }

    function addAlbum() {
        $("#addAlbum").form("submit", {
            url: "addAlbum",
            success: function (data) {
                if (data == "true") {
                    $("#add").dialog("close")
                    $("#myTree").treegrid("reload")
                } else {
                    $.messager.show({
                        title: "添加提示",
                        msg: "添加失败",
                        showSpeed: 1000
                    });
                }
            }
        })
    }
</script>
<table id="myTree"></table>
<div>
    <form id="ff" method="post">
        <table>
            <tr>
                <td>
                    标题：
                </td>
                <td>
                    <input type="text" name="title"/>
                </td>
            </tr>
            <tr>
                <td>
                    集数：
                </td>
                <td>
                    <input type="text" name="count"/>
                </td>
            </tr>
            <tr>
                <td>
                    评分：
                </td>
                <td>
                    <input type="text" name="score"/>
                </td>
            </tr>
            <tr>
                <td>
                    作者：
                </td>
                <td>
                    <input type="text" name="author"/>
                </td>
            </tr>
            <tr>
                <td>
                    播音：
                </td>
                <td>
                    <input type="text" name="broadCast"/>
                </td>
            </tr>
            <tr>
                <td>
                    简介：
                </td>
                <td>
                    <textarea name="brief" style="width:280px;height:30px;"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    图片：
                </td>
                <td>
                    <img id="img" src="" width="280px" height="200px">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="add">
    <form id="addAlbum" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    标题：
                </td>
                <td>
                    <input type="text" name="title"/>
                </td>
            </tr>
            <tr>
                <td>
                    集数：
                </td>
                <td>
                    <input type="text" name="count"/>
                </td>
            </tr>
            <tr>
                <td>
                    评分：
                </td>
                <td>
                    <input type="text" name="score"/>
                </td>
            </tr>
            <tr>
                <td>
                    作者：
                </td>
                <td>
                    <input type="text" name="author"/>
                </td>
            </tr>
            <tr>
                <td>
                    播音：
                </td>
                <td>
                    <input type="text" name="broadCast"/>
                </td>
            </tr>
            <tr>
                <td>
                    简介：
                </td>
                <td>
                    <textarea name="brief" style="width:280px;height:30px;"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    图片：
                </td>
                <td>
                    <input type="file" name="pic"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="chapter">
    <form id="addChapter" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    标题：
                </td>
                <td>
                    <input type="text" name="title"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input id="p_id" name="pid" value="" type="hidden"/>
                </td>
            </tr>
            <tr>
                <td>
                    文件：
                </td>
                <td>
                    <input type="file" name="muc"/>
                </td>
            </tr>
        </table>
    </form>
</div>