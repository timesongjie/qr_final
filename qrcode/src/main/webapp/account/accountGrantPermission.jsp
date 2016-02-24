<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<c:url var="accountGrantPermission" value="/mvc/account/perm"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号权限授权</title>
<script type="text/javascript">
	var submitForm = function(_dialog, _grid, _$) {
		var checked = $('#permissionTree').tree("getChecked");
		var value = [ '0', '0', '0' ];
		var allow = 0;
		$(checked).each(function(i, e) {
			if (e.id == 1) {
				value[0] = '1';
			} else if (e.id == 2) {
				value[1] = '1';
			} else if (e.id == 3) {
				value[2] = '1';
			} else if (e.id == 4) {
				allow = 1;
			}
		});
		var id = ${param.id};
		$.post("${accountGrantPermission}", {id:id,perms:value.join(""),allow:allow}, function(result) {
			if (result.success) {
				_grid.datagrid('load');
				_dialog.dialog('destroy');
				_$.messager.alert('提示', result.msg, 'info');
			} else {
				_$.messager.alert('提示', result.msg, 'error');
			}
		}, 'json');
	}
	var tree = null;
	$(function() {
		parent.$.messager.progress({
			text : '数据加载中....'
		});
		tree = $('#permissionTree').tree({
			checkbox : true,
			cascadeCheck : true,
			url : "${accountGrantPermission}?id=${param.id}",
			method : "get",
			onLoadSuccess : function(node, data) {
				parent.$.messager.progress('close');
				if (data.length == 0) {
					parent.$.messager.alert('提示', '数据异常', 'info');
				}
			}
		});
	});
</script>
</head>
<body>
	<ul id="permissionTree"></ul>
	<span class="tree-title" id="tips" style="display: none;">请设置权限</span>
	<ul id="permissionTree2"></ul>
</body>
</html>