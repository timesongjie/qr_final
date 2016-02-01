<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="accountDataGridAction" value="/mvc/account/list"></c:url>
<c:url var="addAccountAction" value="/account/accountAdd.jsp"></c:url>
<c:url var="editAccountAction" value="/mvc/account"></c:url>
<c:url var="deleteAccountAction" value="/mvc/account"></c:url>
<c:url var="accountGrantPermission" value="/account/accountGrantPermission.jsp"></c:url>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <script type="text/javascript">
        var accountGrid = null;
        var currAccountId = null;
        //新增账号
        var addFun = function () {
            var dialog = parent.modalDialog({
                title: '新增账号信息',
                url: '${addAccountAction}',
                height: 200,
                width: 450,
                buttons: [{
                    text: '添加',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, accountGrid, parent.$);
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        dialog.dialog("destroy");
                    }
                }]
            });
        }

        //编辑账号
        var editFun = function () {
            var accountArr = accountGrid.datagrid("getSelections");
            if (accountArr && accountArr.length < 1) {
                parent.$.messager.alert("提示", "请选择要编辑的账号", "info");
                return;
            }
            var dialog = parent.modalDialog({
                title: '编辑账号信息',
                url: '${editAccountAction}/' + accountArr[0].id,
                height: 200,
                width: 450,
                buttons: [{
                    text: '编辑',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, accountGrid, parent.$);
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        dialog.dialog("destroy");
                    }
                }]
            });
        }

        //删除账号
        var deleteFun = function (id) {
            var accountArr = accountGrid.datagrid("getSelections");
            if (accountArr && accountArr.length < 1) {
                parent.$.messager.alert("提示", "请选择要删除的账号", "info");
                return;
            }
            parent.$.messager.confirm('询问', '您确定要删除此账号？', function (r) {
                if (r) {
                    $.ajax({
                    	url:"${deleteAccountAction}/" + accountArr[0].id,
                    	contentType:"application/json",
                    	dataType:"json",
                    	type:"delete",
                    	success:function (data) {
                            accountGrid.datagrid('reload');
                            if (data.success) {
                                parent.$.messager.alert("提示", data.msg, "info");
                            } else {
                                parent.$.messager.alert("提示", data.msg, "error");
                            }
                            return;
                        }
                    });
                }
            });
        }

        //账号权限授权
        var grantPermissionFun = function () {
            var accountArr = accountGrid.datagrid("getSelections");
            if (accountArr && accountArr.length < 1) {
                parent.$.messager.alert("提示", "请选择要授权的账号", "info");
                return;
            }
            var dialog = parent.modalDialog({
                title: '账号权限授权',
                url: '${accountGrantPermission}?id=' + accountArr[0].id,
                height: 160,
                width: 300,
                buttons: [{
                    text: '授权',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.submitForm(dialog, accountGrid, parent.$);
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        dialog.dialog("destroy");
                    }
                }]
            });
        }

        //查看账号
        var viewFun = function () {
            var accountArr = accountGrid.datagrid("getSelections");
            if (accountArr && accountArr.length < 1) {
                parent.$.messager.alert("提示", "请选择要编辑的账号", "info");
                return;
            }
            var dialog = parent.modalDialog({
                title: '查看账号信息',
                url: '${viewAccountAction}?account.id=' + accountArr[0].id,
                height: 260,
                width: 450,
                buttons: [{
                    text: '关闭',
                    handler: function () {
                        dialog.dialog("destroy");
                    }
                }]
            });
        }

        $(function () {
            accountGrid = $("#accountGrid").datagrid({
                fit: true,
                title: '',
                url: '${accountDataGridAction}',
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
                columns: [[{
                    title: '账号ID',
                    field: 'id',
                    sortable: false,
                    hidden: true
                }, {
                    title: '账号名称',
                    field: 'name',
                    sortable: false,
                    width:200
                },  {
                    title: '手机号码',
                    field: 'phoneNumber',
                    sortable: false,
                    width:200
                },{
                    title: '状态',
                    field: 'status',
                    sortable: true,
                    formatter: function (value, row, index) {
                        switch (value) {
                            case 0:
                                return '激活';
                            case 1:
                                return '未激活';
                            case 2:
                                return '冻结';
                        }
                    }
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
                        accountGrid.datagrid("selectRow", 0);
                    }
                    parent.$.messager.progress('close');
                }
            });
            $(document).keyup(function (event) {
                if (event.keyCode == 13) {
                    accountGrid.datagrid('load', serializeObject($('#queryForm')));
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
                            <a id="delete" href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'ext-icon-note_delete',plain:true" onclick="deleteFun();">删除</a>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td>
                            <a id="grantPermission" href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'ext-icon-key',plain:true" onclick="grantPermissionFun();">权限授权</a>
                        </td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>

                   <!--      <td>
                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'ext-icon-note',plain:true" onclick="viewFun();">查看</a>
                        </td> -->
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
    <table id="accountGrid" data-options="fit:true,border:false" width="100%"></table>
</div>
</body>
</html>