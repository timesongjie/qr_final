<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url var="editAccountAction" value="/mvc/account"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	var submitForm = function(_dialog, _grid, _$) {
		if ($('#accountForm').form('validate')) {
			$.ajax({
				url:"${editAccountAction}", 
				data:serializeObject($('#accountForm')),
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
				type:"PUT"
			});
		}
	}

	$(function() {
		$('#status').combobox('setValue', '${account.status}');
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<form action="${editAccountAction }" id="accountForm">
		<input type="hidden" name="id" value="${account.id }" id="id">
		<table width="100%" class="table tabs-title">
			<table width="100%" class="table tabs-title">
				<tr>
					<th>账号名称</th>
					<td><input type="text" name="name"
						value="${account.name }"
						data-options="required:true,validType:['length[0,256]', 'nonChinese']"
						class="easyui-validatebox" missingMessage="账号名称不能为空"
						style="width: 260px" /></td>
				</tr>
			<!-- 	<tr>
					<th>密码</th>
					<td><input type="password" name="password"
						data-options="required:true,validType:['password']"
						class="easyui-validatebox" missingMessage="密码不能为空"
						style="width: 260px" /></td>
				</tr> -->
				<tr>
					<th>电话号码</th>
					<td><input type="text" name="phoneNumber"
						value="${account.phoneNumber }"
						data-options="required:true,validType:['phoneNumber']"
						class="easyui-validatebox" missingMessage="手机号码不能为空"
						style="width: 260px" /></td>
				</tr>
				<tr>
					<th>状态</th>
					<td><select id="status" class="easyui-combobox"
						name="status"
						data-options="required:true,panelHeight:'auto',editable:false"
						style="width: 260px;">
							<option value="1">未激活</option>
							<option value="0">激活</option>
					</select></td>
				</tr>
			</table>
			</form>
</body>
</html>