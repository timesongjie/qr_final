<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="${ctx}/mvc/account/logout" var="logoutAction"></c:url>
<c:url value="${ctx}/index/login.jsp" var="loginAction"></c:url>
<script type="text/javascript" charset="utf-8">
	var logoutFun = function() {
		$.post('${logoutAction}', function(result) {
			location.replace('${loginAction}');
		}, 'json'); 
		
	};
</script>
	<div align="center">
		<font size="6">欢迎使用！</font>　
	</div>

	<div id="sessionInfoDiv" style="position: absolute; right: 10px; top: 5px;">
			欢迎您xxx
	</div>
	<div style="position: absolute; right: 0px; bottom: 0px;">
		<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#myInfoMenu',iconCls:'ext-icon-cog'">控制面板</a>
		<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#logoutMenu',iconCls:'ext-icon-disconnect'">注销</a>
	</div>
	<div id="myInfoMenu" style="width: 100px; display: none;">
		<div data-options="iconCls:'ext-icon-user_edit'" onclick="$('#passwordDialog').dialog('open');">修改密码</div>
		<%--
		<div class="menu-sep"></div>
		<div data-options="iconCls:'ext-icon-user'" onclick="showMyInfoFun();">我的信息</div>
		 --%>
	</div>
	<div id="logoutMenu" style="width: 100px; display: none;">
		<div data-options="iconCls:'ext-icon-door_out'" onclick="logoutFun()" >退出系统</div>
		<%--
		<div data-options="iconCls:'ext-icon-door_out'" onclick="logoutFun()" href="${logoutAction }">退出系统</div>
		--%>

	</div>





