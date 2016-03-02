<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="serviceInfoDataGridAction" value="/mvc/serviceInfo/list"></c:url>
<c:url var="serviceInfoExportAction" value="/mvc/serviceInfo/export"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	$(function() {
		$("#sserviceDate").datebox({
			required : true,
			editable : false,
			onSelect : function(date) {
				$("#sserviceDate").val(date);
			}
		});
		$("#eserviceDate").datebox({
			required : true,
			editable : false,
			onSelect : function(date) {
				$("#eserviceDate").val(date);
			}
		});

		serviceTypeGrid = $("#serviceTypeGrid").datagrid({
			fit : true,
			title : '',
			url : '${serviceInfoDataGridAction}',
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
				hidden : false
			}, {
				title : '服务类型',
				field : 'serviceTypeId',
				sortable : false,
				hidden : false,
				width : 100,
				formatter : function(value, row, index) {
					if (value == 1) {
						return "售前";
					} else if (value == 2) {
						return "售中";
					} else if (value == 3) {
						return "售后";
					}
				}
			}, {
				title : '服务时间',
				field : 'serviceDate',
				sortable : false,
				hidden : false,
				width : 200
			}, {
				title : '服务内容',
				field : 'serviceContent',
				sortable : false,
				hidden : false,
				width : 300
			}, {
				title : '服务位置',
				field : 'serviceLocation',
				sortable : false,
				hidden : false,
				width : 100
			}, {
				title : '备注',
				field : 'bak',
				sortable : false,
				hidden : false,
				width : 300
			} ] ],
			toolbar : '#toolbar',
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onSelect : function(rowIndex, rowData) {
				{
				}
			},
			onLoadSuccess : function(data) {
				if (data.total > 0) {
					serviceTypeGrid.datagrid("selectRow", 0);
				}
				parent.$.messager.progress('close');
			}
		});
		$(document).keyup(
				function(event) {
					if (event.keyCode == 13) {
						serviceTypeGrid.datagrid('load',
								serializeObject($('#queryForm')));
					}
				});
	})
	function exportExcel() {
		var stime = $.trim($('#sserviceDate').datebox('getValue'));
		var etime = $.trim($('#eserviceDate').datebox('getValue'));
		if(stime == "" || stime == ""){
			alert("请选择开始时间和结束时间");
			return;
		}
		location.href="${serviceInfoExportAction}"+"?sserviceDate="+stime+"&eserviceDate="+etime; 
	}
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
								<th>记录开始时间：</th>
								<td><input type="text" name="sserviceDate"
									id="sserviceDate" style="width: 200px;"></td>
								<th>记录结束时间：</th>
								<td><input type="text" name="eserviceDate"
									id="eserviceDate" style="width: 200px;"></td>
							</tr>
							<tr>
								<th>项目名称：</th>
								<td><input type="text" name="projectName" id="projectName"
									style="width: 200px;"></td>
								<td></td>
								<td colspan="1"><a href="javascript:void(0);"
									class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-zoom',plain:true"
									onclick="serviceTypeGrid.datagrid('load',serializeObject($('#queryForm')));">查询</a>
									<a href="javascript:void(0);" class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-zoom_out',plain:true"
									onclick="$('#queryForm input').val('');serviceTypeGrid.datagrid('load',{});">重置查询</a>
									<a href="javascript:void(0)" class="easyui-linkbutton"
									data-options="iconCls:'ext-icon-bullet_disk ',plain:true"
									onclick="exportExcel(serializeObject($('#queryForm')))">导出</a>
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
							<!-- <td><a id="edit" href="javascript:void(0);"
								class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-note_edit',plain:true"
								onclick="editFun();">编辑</a></td> -->
							<td>
								<div class="datagrid-btn-separator"></div>
							</td>
							<!-- 	<td><a href="javascript:void(0);" class="easyui-linkbutton"
								data-options="iconCls:'ext-icon-note',plain:true"
								onclick="viewFun();">查看</a></td>
							<td> -->
							<div class="datagrid-btn-separator"></div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',fit:true,border:false">
		<table id="serviceTypeGrid" data-options="fit:true,border:false"
			width="100%"></table>
	</div>
</body>
</html>