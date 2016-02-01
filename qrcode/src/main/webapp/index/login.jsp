<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:url var="indexAction" value="/index/index.jsp"></c:url>
<c:url var="loginAction" value="/mvc/account/login"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		if (top.location != self.location){   
			top.location=self.location;   
		} 
		
		var loginFun = function() {
			var loginForm = $("#loginForm");
			if (loginForm.form('validate')) {
				$('#loginBtn').linkbutton('disable');
				$.post('${loginAction}', loginForm.serialize(), function(result) {
					if (result.success) {
						location.replace('${indexAction}');
					} else {
						$.messager.alert('提示', result.msg, 'error', function() {
							$('#loginBtn').linkbutton('enable');
						});
					}
				}, 'json');
			}
		}
		
		$("#loginDialog").show().dialog({
			modal : true,
			closable : false,
			iconCls : 'ext-icon-lock_open',
			buttons : [ {
				id : 'loginBtn',
				text : '登录',
				handler : function() {
					loginFun();
				}
			} ],
			onOpen : function() {
				$('form :input:first').focus();
				$('form :input').keyup(function(event) {
					if (event.keyCode == 13) {
						loginFun();
					}
				});
			}
		});
		
	});
</script>
</head>
<body>
	<div id="loginDialog" title="系统登录" 　style="display: none">
		<form action="" id="loginForm">
			<table style="width: 100%; height: 100%;" class="table">
				<tr>
					<th width="50">用户名</th>
					<td><input name="username" class="easyui-validatebox"
						data-options="required:true" value="" style="width: 200px;" missingMessage="用户名不能为空"/></td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input name="password" type="password"
						class="easyui-validatebox" data-options="required:true" value=""
						style="width: 200px;"  missingMessage="密码不能为空"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>