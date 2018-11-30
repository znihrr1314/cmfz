<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<head>
    <script type="text/javascript">
        var bb = [{
            title: "添加",
            iconCls: 'icon-add',
            handler: function () {
                alert('编辑按钮')
            }
        }, '-', {
            title: "编辑",
            iconCls: 'icon-edit',
            handler: function () {
                alert('帮助按钮')
            }
        }, '-', {
            title: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                alert('帮助按钮')
            }
        }, '-', {
            title: "保存",
            iconCls: 'icon-save',
            handler: function () {
                alert('帮助按钮')
            }
        }]

        $('#mm').datagrid({
            toolbar: tb,
            title: '用户',
            url: 'allUser',
            fitColumns: true,
            columns: [[
                {field: 'id', title: 'ID', width: 80, hidden: true},
                {field: 'title', title: '名字', width: 100, sortable: true},
                {field: 'status', title: '状态', width: 80, align: 'right', sortable: true},
                {field: 'imgPath', title: '路径', width: 80, align: 'right', sortable: true},
                {field: 'date', title: '时间', width: 150, sortable: true},
            ]],
            pagination: true,
        })
    </script>
</head>
<table id="mm"></table>