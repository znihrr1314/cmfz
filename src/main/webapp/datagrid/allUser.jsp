<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    var tb = [{
        text: "全部导出",
        iconCls: 'icon-help',
        handler: function () {
            location = "export";
        }
    }, '-', {
        text: "导入",
        iconCls: 'icon-add',
        handler: function () {

        }
    }, '-', {
        text: "导出",
        iconCls: 'icon-edit',
        handler: function () {
            var q = $("#userTree").treegrid("getSelected")

        }
    }]
    $(function () {
        $("#userTree").datagrid({
            toolbar: tb,
            url: "allUser",
            title: "全部用户",
            fitColumns: true,
            columns: [[
                {field: 'id', title: '编号', width: 180},
                {field: 'username', title: '用户名', width: 180},
                {field: 'province', title: '省份', width: 80},
                {field: 'city', title: '城市', width: 80},
                {field: 'sex', title: '性别', width: 80},
                {field: 'date', title: '注册日期', width: 80}
            ]]
        })
    })
</script>
<table id="userTree"></table>