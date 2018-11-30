<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    var tb = [{
        text: "添加",
        iconCls: 'icon-add',
        handler: function () {
            $("#dd").dialog('open');
        }
    }, '-', {
        text: "编辑",
        iconCls: 'icon-edit',
        handler: function () {
            var row = $("#vv").edatagrid("getSelected")
            if (row == null) {
                $.messager.show({
                    title: '警告',
                    msg: '请选中一行',
                });
            } else {
                var index = $("#vv").edatagrid("getRowIndex", row);
                $("#vv").edatagrid("editRow", index);
            }
        }
    }, '-', {
        text: "删除",
        iconCls: 'icon-remove',
        handler: function () {
            var row = $("#vv").edatagrid("getSelected")
            var id = row.id;
            var img = row.imgPath;
            if (row == null) {
                $.messager.show({
                    title: '警告',
                    msg: '请选中一行',
                });
            } else {
                $.ajax({
                    url: "removeView",
                    data: "id=" + id + "&imgPath=" + img,
                    method: "post",
                    success: function (data) {
                        if (data) {
                            $("#vv").edatagrid("reload");
                        } else {
                            $.messager.alert("提示框", "删除失败", "warning");
                        }
                    }
                })
            }
        }
    }, '-', {
        text: "保存",
        iconCls: 'icon-save',
        handler: function () {
            $("#vv").edatagrid("saveRow")
        }
    }]
    $(function () {
        $('#dd').dialog({
            resizable: true,
            title: '添加',
            closed: true,
            modal: true,
            width: 400,
            height: 400
        });

        $("#vv").edatagrid({
            updateUrl: "updateStatus",
            toolbar: tb,
            title: '轮播图',
            url: 'allView',
            fitColumns: true,
            columns: [[
                {field: 'id', title: 'ID', width: 80, hidden: true},
                {field: 'title', title: '名字', width: 100, sortable: true},
                {
                    field: 'status', title: '状态', width: 80, align: 'right', sortable: true, editor: {
                        type: "text",
                    }
                },
                {field: 'imgPath', title: '路径', width: 80, align: 'right', sortable: true},
                {field: 'desc', title: '详情', width: 80, align: 'right', sortable: true},
                {field: 'date', title: '时间', width: 150, sortable: true},
            ]],
            pagination: true,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:80px;"></td>' +
                    '<td style="border:0">' +
                    '<p>名称: ' + rowData.title + '</p>' +
                    '<p>详情: ' + rowData.desc + '</p>' +
                    '<p>时间: ' + rowData.date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addForm").form({
            url: "addView",
            success: function (data) {
                if (data == "true") {
                    $("#vv").edatagrid("reload");
                    $("#dd").dialog("close");
                } else {
                    $.messager.show({
                        title: "添加提示",
                        msg: "添加失败",
                        showSpeed: 1000
                    });
                }
            }
        })
    })
</script>

<table id="vv"></table>

<div id="dd" class="easyui-dialog" style="width:600px;height:300px">
    <form method="post" id="addForm" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    标题：
                </td>
                <td>
                    <input name="title" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    图片：
                </td>
                <td>
                    <input name="pic" type="file"/>
                </td>
            </tr>
            <tr>
                <td>
                    描述：
                </td>
                <td>
                    <input name="desc" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
</div>

