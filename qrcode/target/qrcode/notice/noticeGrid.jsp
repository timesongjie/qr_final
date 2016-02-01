<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="noticeDataGridAction" value="/mvc/notice/list"></c:url>
<c:url var="addNoticeAction" value="/notice/noticeAdd.jsp"></c:url>
<c:url var="editNoticeAction" value="/mvc/notice"></c:url>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <script type="text/javascript">
        var noticeGrid = null;
        var currNoticeId = null;
        //新增通知
        var addFun = function () {
            var dialog = parent.modalDialog({
                title: '新增通知信息',
                url: '${addNoticeAction}',
                height: 120,
                width: 450,
                buttons: [{
                    text: '添加',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, noticeGrid, parent.$);
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        dialog.dialog("destroy");
                    }
                }]
            });
        }

        //编辑通知
        var editFun = function () {
            var noticeArr = noticeGrid.datagrid("getSelections");
            if (noticeArr && noticeArr.length < 1) {
                parent.$.messager.alert("提示", "请选择要编辑的通知", "info");
                return;
            }
            var dialog = parent.modalDialog({
                title: '编辑通知信息',
                url: '${editNoticeAction}/' + noticeArr[0].id,
                height: 120,
                width: 450,
                buttons: [{
                    text: '编辑',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, noticeGrid, parent.$);
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        dialog.dialog("destroy");
                    }
                }]
            });
        }

        $(function () {
            noticeGrid = $("#noticeGrid").datagrid({
                fit: true,
                title: '',
                url: '${noticeDataGridAction}',
                method:"GET",
                pagination: true,
                singleSelect: true,
                rownumbers: true,
                fitColumns: false,
                nowrap: false,
                idField: "id",
                sortName: "id",
                sortOrder: 'desc',
                pageSize: 20,
                pageList: [10, 20, 30, 40, 50],
                columns: [[
                  {
                    title: 'id',
                    field: 'id',
                    sortable: false,
                    hidden: true
                },{
                    title: '广告',
                    field: 'notice',
                    sortable: false,
                    hidden: false
                }, {
                    title: '添加时间',
                    field: 'addDate',
                    sortable: false,
                    width:200
                }]],
                toolbar: '#toolbar',
                onBeforeLoad: function (param) {
                    parent.$.messager.progress({
                        text: '数据加载中....'
                    });
                },
                onSelect: function (rowIndex, rowData) {
                    {
                        $("#edit").linkbutton("enable");
                        $("#delete").linkbutton("enable");
                        $("#grantRole").linkbutton("enable");
                        $("#grantPermission").linkbutton("enable");
                    }
                },
                onLoadSuccess: function (data) {
                    if (data.total > 0) {
                        noticeGrid.datagrid("selectRow", 0);
                    }
                    parent.$.messager.progress('close');
                }
            });
            $(document).keyup(function (event) {
                if (event.keyCode == 13) {
                    noticeGrid.datagrid('load', serializeObject($('#queryForm')));
                }
            });
        })
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div id="toolbar" style="display: none;">
    <table width="100%">
        <tr>
            <td>
                <table>
                    <tr>
                        <td>
                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'ext-icon-note_add',plain:true" onclick="addFun();">添加</a>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td>
                            <a id="edit" href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'ext-icon-note_edit',plain:true" onclick="editFun();">编辑</a>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>

                        <td>
                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'ext-icon-note',plain:true" onclick="viewFun();">查看</a>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<div data-options="region:'center',fit:true,border:false">
    <table id="noticeGrid" data-options="fit:true,border:false" width="100%"></table>
</div>
</body>
</html>