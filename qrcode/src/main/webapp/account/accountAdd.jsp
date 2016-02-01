<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="addAccountAction" value="/mvc/account"></c:url>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号新增</title>
<script type="text/javascript">

	var submitForm = function(_dialog, _grid, _$) {
		if ($('#accountForm').form('validate')) {
			$.post("${addAccountAction}", serializeObject($('#accountForm')), function(result) {
				if (result.success) {
					_grid.datagrid('load');
					_dialog.dialog('destroy');
					_$.messager.alert('提示', result.msg, 'info');
				} else {
					_$.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<form action="${addAccountAction }" id="accountForm" method="post">
		<table width="100%" class="table tabs-title">
			<tr>
				<th>账号名称</th>
				<td>
					<input type="text" name="name" data-options="required:true,validType:['length[0,256]', 'nonChinese']"
						class="easyui-validatebox" missingMessage="账号名称不能为空"  style="width:260px"/>
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td>
					<input type="password" name="password" data-options="required:true,validType:['password']"
						class="easyui-validatebox" missingMessage="密码不能为空"  style="width:260px"/>
				</td>
			</tr>
			<tr>
				<th>电话号码</th>
				<td>
					<input type="text" name="phoneNumber" data-options="required:true,validType:['phoneNumber']"
						class="easyui-validatebox" missingMessage="手机号码不能为空"  style="width:260px"/>
				</td>
			</tr>
			<tr>
				<th>状态</th>
				<td>
					<select id="status" class="easyui-combobox" name="status"
							data-options="required:true,panelHeight:'auto',editable:false"  style="width:260px;">
						<option value="0">激活</option>
						<option value="1">未激活</option>
				    </select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>