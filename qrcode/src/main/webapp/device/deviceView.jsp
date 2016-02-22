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
</script>
<style type="text/css">
	th{
	 width:100px;
	 text-align;
	}
</style>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<table width="100%" class="table tabs-title">
		<tr>
			<th>项目名称</th>
			<td>
					${device.projectName}&nbsp;
			</td>
		</tr>
		<tr>
			<th>产品二维码</th>
			<td>
				${device.deviceQrcode}
			</td>
		</tr>
		<tr>
			<th>产品编码</th>
			<td>
				${device.deviceCode}
			</td>
		</tr>
			<tr>
			<th>产品型号</th>
			<td>
				${device.deviceModel}
			</td>
		</tr>
		<tr>
			<th>项目经理</th>
			<td>
				${device.projectLeader}
			</td>
		</tr>
		<tr>
			<th>项目成员</th>
			<td>
				${device.projectOthers}
			</td>
		</tr>
		<tr>
			<th>合同指标</th>
			<td>
				${device.contractPoint}
			</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>
				${device.clientName}
			</td>
		</tr>
		<tr>
			<th>客户地址</th>
			<td>
				${device.clientSite}
			</td>
		</tr>
		<tr>
			<th>客户联系人</th>
			<td>
				${device.client}
			</td>
		</tr>
			<tr>
			<th>客户电话号码</th>
			<td>
				${device.clientTel}
			</td>
		</tr>
		<tr>
			<th>激活码</th>
			<td>
				${device.activationCode}  
			</td>
		</tr>
		<tr>
			<th>激活码</th>
			<td>
				${device.activationCode2}
			</td>
		</tr>
		<tr>
			<th>激活码</th>
			<td>
				${device.activationCode3}
			</td>
		</tr>
		<tr>
			<th>激活码</th>
			<td>
			   ${device.activationCode4}
			</td>
		</tr>
		<tr>
			<th>无线路由</th>
			<td>
				${device.wlan}
			</td>
		</tr>
		<tr>
			<th>sim手机号</th>
			<td>
				${device.simPhone}
			</td>
		</tr>
		<tr>
			<th>sim收费</th>
			<td>
				${device.simFee}
			</td>
		</tr>
		<tr>
			<th>备注</th>
			<td>
				${device.bak}
			</td>
		</tr>
	</table>
</body>
</html>