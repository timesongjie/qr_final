<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">

	$(function() {
		$('#status').combobox('setValue','${account.status}');
	})
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<table width="100%" class="table tabs-title">
		<tr>
			<th>所属系统</th>
			<td>
				<c:forEach items="${account.subSystemSet}" var="system">
					${system.systemName}&nbsp;
				</c:forEach>
			</td>
		</tr>
		<c:if test="${account.ctrlSubSystemSet != null && fn:length(account.ctrlSubSystemSet) > 0}">
			<tr>
				<th>管控系统</th>
				<td>
					<c:forEach items="${account.ctrlSubSystemSet}" var="system">
						${system.systemName}&nbsp;
					</c:forEach>
				</td>
			</tr>
		</c:if>
		<tr>
			<th>账号名称</th>
			<td>
				${account.accountId }
			</td>
		</tr>
		<tr>
			<th>手机号码</th>
			<td>
				${account.phoneNumber }
			</td>
		</tr>
		<tr>
			<th>状态</th>
			<td>
				<select id="status" class="easyui-combobox" name="status" disabled="disabled"
						data-options="required:true,panelHeight:'auto',editable:false"  style="width:200px;">
			        <option value="0">激活</option>
			        <option value="1">未激活</option>
			        <option value="2">冻结</option>
			    </select>
			</td>
		</tr>
		<tr>
			<th witdh="35%">创建日期</th>
			<td width="65%">
				<fmt:formatDate value="${account.createDate }" pattern="yyyy-MM-dd" type="date"/>
			</td>
		</tr>
		<tr>
			<th witdh="35%">上次修改日期</th>
			<td width="65%">
				<fmt:formatDate value="${account.lastModifyDate }" pattern="yyyy-MM-dd" type="date"/>
			</td>
		</tr>
	</table>
</body>
</html>