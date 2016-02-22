<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="deviceDataGridAction" value="/mvc/device/list"></c:url>
<c:url var="viewDeviceAction" value="/mvc/device"></c:url>
<c:url var="editDeviceAction" value="/mvc/device"></c:url>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	var deviceGrid = null;
	//编辑设备
	var editFun = function() {
		var deviceArr = deviceGrid.datagrid("getSelections");
		if (deviceArr && deviceArr.length < 1) {
			parent.$.messager.alert("提示", "请选择要编辑的账号", "info");
			return;
		}
		var dialog = parent.modalDialog({
			title : '编辑产品信息',
			url : '${editDeviceAction}/' + deviceArr[0].id+"?forward=edit",
			height : 640,
			width : 400,
			buttons : [
					{
						text : '编辑',
						handler : function() {
							dialog.find('iframe').get(0).contentWindow
									.submitForm(dialog, deviceGrid, parent.$);
						}
					}, {
						text : '取消',
						handler : function() {
							dialog.dialog("destroy");
						}
					} ]
		});
	}
	//查看设备
	var viewFun = function() {
		var deviceArr = deviceGrid.datagrid("getSelections");
		if (deviceArr && deviceArr.length < 1) {
			parent.$.messager.alert("提示", "请选择要查看的产品", "info");
			return;
		}
		var dialog = parent.modalDialog({
			title : '查看产品信息',
			url : '${viewDeviceAction}/' + deviceArr[0].id+"?forward=view",
			height : 560,
			width : 400,
			buttons : [ {
				text : '关闭',
				handler : function() {
					dialog.dialog("destroy");
				}
			} ]
		});
	}

	$(function() {
		deviceGrid = $("#deviceGrid").datagrid({
			fit : true,
			title : '',
			url : '${deviceDataGridAction}',
			method : "GET",
			pagination : true,
			singleSelect : true,
			rownumbers : true,
			fitColumns : false,
			nowrap : false,
			idField : "id",
			sortName : "id",
			sortOrder : 'desc',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50 ],
			columns : [ [ {
				title : 'id',
				field : 'id',
				sortable : false,
				hidden : true
			}, {
				title : '项目名称',
				field : 'projectName',
				sortable : false,
				width : 150
			} ,{
				title : '产品编号',
				field : 'deviceCode',
				width:250,
				sortable : false,
				hidden : false
			}, {
				title : '产品型号',
				field : 'deviceModel',
				sortable : false,
				width:200,
				hidden : false
			}, {
				title : '产品二维码',
				field : 'deviceQrcode',
				sortable : false,
				width:250,
				hidden : false
			}, {
				title : '调试时间',
				field : 'debugDate',
				width:100,
				sortable : false,
				hidden : false
			}, {
				title : '完成时间',
				field : 'finishDate',
				sortable : false,
				width:100,
				hidden : false
			}] ],
			toolbar : '#toolbar',
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onSelect : function(rowIndex, rowData) {
				{
					$("#edit").linkbutton("enable");
					$("#delete").linkbutton("enable");
					$("#grantRole").linkbutton("enable");
					$("#grantPermission").linkbutton("enable");
				}
			},
			onLoadSuccess : function(data) {
				if (data.total > 0) {
					deviceGrid.datagrid("selectRow", 0);
				}
				parent.$.messager.progress('close');
			}
		});
		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				deviceGrid.datagrid('load', serializeObject($('#queryForm')));
			}
		});
	})
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="toolbar" style="display: none;">
		<table width="100%">
			<tr>
				<td width="100%">
					<form id="queryForm" method="post">
						<table width="100%" border="0" class="table tabs-title">
							<tr>
								<th>设备编码：</th>
								<td><input type="text" name="deviceCode"
									style="width: 200px;"></td>
								<th>项目名称：</th>
								<td><input type="text" name="projectName"
									style="width: 200px;"></td>
								<td></td>
							</tr>
							<tr>
								<th>项目经理：</th>
								<td><input type="text" name="projectLeader"
									style="width: 200px;"></td>
								<th>客户名称：</th>
								<td><input type="text" name="clientName"
									style="width: 200px;"></td>
								<td></td>
							</tr>
							<tr>
								<th>SIM卡手机号：</th>
								<td><input type="text" name="simPhone"
									style="width: 200px;"></td>
								<td colspan="2" align="center"></td>
								<td><a href="javascript:void(0);" class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-zoom',plain:true"
									onclick="deviceGrid.datagrid('load',serializeObject($('#queryForm')));">查询</a>
									<a href="javascript:void(0);" class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-zoom_out',plain:true"
									onclick="$('#queryForm input').val('');deviceGrid.datagrid('load',{});">重置查询</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								<div class="datagrid-btn-separator"></div>
							</td>
							<td><a id="edit" href="javascript:void(0);"
								class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-note_edit',plain:true"
								onclick="editFun();">编辑</a></td>
							<td>
								<div class="datagrid-btn-separator"></div>
							</td>
							<td><a href="javascript:void(0);" class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-note',plain:true"
								onclick="viewFun();">查看</a></td>
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
		<table id="deviceGrid" data-options="fit:true,border:false"
			width="100%"></table>
	</div>
</body>
</html>