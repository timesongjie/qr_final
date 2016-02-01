<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="addNoticeAction" value="/mvc/notice"></c:url>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知新增</title>
<script type="text/javascript">
	var submitForm = function(_dialog, _grid, _$) {
		if ($('#NoticeForm').form('validate')) {
			$.post("${addNoticeAction}", serializeObject($('#NoticeForm')),
					function(result) {
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
	<form action="${addNoticeAction }" id="NoticeForm" method="post">
		<table width="100%" class="table tabs-title">
			<tr>
				<th>通知</th>
				<td><input type="text" name="notice"
					data-options="required:true"
					class="easyui-validatebox" missingMessage="通知不能为空"
					style="width: 260px" /></td>
			</tr>
		</table>
	</form>
</body>
</html>