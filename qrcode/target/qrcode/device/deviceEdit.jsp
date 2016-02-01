<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url var="editDeviceAction" value="/mvc/device"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
var submitForm = function(_dialog, _grid, _$) {
	if ($('#deviceForm').form('validate')) {
		$.ajax({
			url:"${editDeviceAction}", 
			data:serializeObject($('#deviceForm')),
			success:function(result) {
				if (result.success) {
					_grid.datagrid('load');
					_dialog.dialog('destroy');
					_$.messager.alert('提示', result.msg, 'info');
				} else {
					_$.messager.alert('提示', result.msg, 'error');
				}
			},
			dataType:"json",
			type:"post"
		});
	}
}
</script>
<style type="text/css">
th {
	width: 100px;
	text-align;
}
input{
	height:22px;
}
</style>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<form id="deviceForm">
	<table width="100%" class="table tabs-title">
	  <input type="hidden" name="id" value="${device.id }" id="id">
		<tr>
			<th>项目名称</th>
			<td><input value="${device.projectName}" name="projectName" data-options="required:true"
						class="easyui-validatebox" missingMessage="项目名称不能为空">&nbsp;
			</td>
		</tr>
		<tr>
			<th>产品二维码</th>
			<td><input  name="deviceQrcode" value="${device.deviceQrcode}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>产品编码</th>
			<td><input  name="deviceCode" value="${device.deviceCode}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>产品型号</th>
			<td><input value="${device.deviceModel}" name="deviceModel"  data-options="required:true"
						class="easyui-validatebox" missingMessage="产品型号不能为空"/></td>
		</tr>
		<tr>
			<th>项目领导</th>
			<td><input value="${device.projectLeader}" name="projectLeader"  data-options="required:true"
						class="easyui-validatebox" missingMessage="项目领导不能为空"/>
			</td>
		</tr>
		<tr>
			<th>项目成员</th>
			<td><input value="${device.projectOthers}" name="projectOthers" data-options="required:true"
						class="easyui-validatebox" missingMessage="项目成员不能为空"/></td>
		</tr>
		<tr>
			<th>合同指标</th>
			<td><input value="${device.contractPoint}" name="contractPoint"  data-options="required:true"
						class="easyui-validatebox" missingMessage="合同指标不能为空"/></td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td><input value="${device.clientName}"  name="clientName" data-options="required:true"
						class="easyui-validatebox" missingMessage="客户名称不能为空"></td>
		</tr>
		<tr>
			<th>客户地址</th>
			<td><input value="${device.clientSite}" name="clientSite" data-options="required:true"
						class="easyui-validatebox" missingMessage="客户地址不能为空"></td>
		</tr>
		<tr>
			<th>客户联系人</th>
			<td><input value="${device.client}" name="client" data-options="required:true"
						class="easyui-validatebox" missingMessage="客户联系人不能为空"></td>
		</tr>
		<tr>
			<th>客户电话号码</th>
			<td><input value="${device.clientTel}" name="clientTel" data-options="required:true"
						class="easyui-validatebox" missingMessage="客户电话号码不能为空"></td>
		</tr>
		<tr>
			<th>激活码</th>
			<td><input value="${device.activationCode}" name="activationCode" ></td>
		</tr>
		<tr>
			<th>激活码</th>
			<td><input value="${device.activationCode2}" name="activationCode2"></td>
		</tr>
		<tr>
			<th>激活码</th>
			<td><input value="${device.activationCode3}"  name="activationCode3"></td>
		</tr>
		<tr>
			<th>激活码</th>
			<td><input value="${device.activationCode4}"  name="activationCode4"></td>
		</tr>
		<tr>
			<th>无线路由</th>
			<td><input value="${device.wlan}" name="wlan"></td>
		</tr>
		<tr>
			<th>sim手机号</th>
			<td><input value="${device.simPhone}" name="simPhone"></td>
		</tr>
		<tr>
			<th>sim收费</th>
			<td><input value="${device.simFee}" name="simFee"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td><input value="${device.bak}" name="bak"></td>
		</tr>
	</table>
	</form>
</body>
</html>