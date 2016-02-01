<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:url var="accountAction" value="/index/account.jsp"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subSystem.systemName }</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<script type="text/javascript">
	var menuTree = null;
	var menuTabs = null;
	$(function(){

		menuTree = $("#menuTree").tree({
			data: [{
				text: '用户管理',
				children: [{
					text: '用户列表',
					"attributes":{
						"url":"/account/accountGrid.jsp"
					}
				}]
			},{
				text: '产品管理',
				children: [
					{
						text: '产品列表',
						"attributes":{
							"url":"/device/deviceGrid.jsp"
						}
				    },{
						text: '服务记录管理',
						"attributes":{
							"url":"/serviceinfo/serviceInfoGrid.jsp"
						}
				}
				]
			},{
				text: '公告管理',
				"attributes":{
					"url":"/notice/noticeGrid.jsp"
				}
			}],
			onClick : function(node) {
				if (node.attributes && node.attributes.url) {
					var src = null;
					/* if (!(node.attributes.url).startWith("/")) {
						src = '${ctx}/' + node.attributes.url
					}else{ */
						src = '${ctx}' + node.attributes.url;
					//}
					if (node.attributes.target && node.attributes.target.length > 0) {
						window.open(src, node.attributes.target);
					} else {
						var tabs = $('#menuTabs');
						var opts = {
							title : node.text,
							closable : true,
							//iconCls : node.iconCls,
							iconCls: 'ext-icon-link',
							content : '<iframe src="' + src +'" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>',
							border : false,
							fit : true
						};
						if (tabs.tabs('exists', opts.title)) {
							tabs.tabs('select', opts.title);
						} else {
							tabs.tabs('add', opts);
						}
					}
				}
			}
		});
		
		menuTabs = $('#menuTabs').tabs({
			fit : true,
			border : false,
			tools : [ {
				text : '刷新',
				iconCls : 'ext-icon-arrow_refresh',
				handler : function() {
					var panel = menuTabs.tabs('getSelected').panel('panel');
					var frame = panel.find('iframe');
					try {
						if (frame.length > 0) {
							for (var i = 0; i < frame.length; i++) {
								frame[i].contentWindow.document.write('');
								frame[i].contentWindow.close();
								frame[i].src = frame[i].src;
							}
							if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
								try {
									CollectGarbage();
								} catch (e) {
								}
							}
						}
					} catch (e) {
					}
				}
			}, {
				text : '关闭',
				iconCls : 'ext-icon-cross',
				handler : function() {
					var index = menuTabs.tabs('getTabIndex', menuTabs.tabs('getSelected'));
					var tab = menuTabs.tabs('getTab', index);
					if (tab.panel('options').closable) {
						menuTabs.tabs('close', index);
					} else {
						$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
					}
				}
			} ]
		});
		
		$('#mainLayout').layout('panel', 'center').panel({
			onResize : function(width, height) {
				setIframeHeight('centerIframe', $('#mainLayout').layout('panel', 'center').panel('options').height - 5);
			}
		});
		
		setIframeHeight = function(iframe, height) {
			iframe.height = height;
		};
		
		logoutFun = function() {
			$.post('${logoutAction}', function(result) {
				location.replace('${indexAction}');
			}, 'json');
		};
		
		//修改密码
		$('#passwordDialog').show().dialog({
			modal : true,
			closable : false,
			width: 350,
			iconCls : 'ext-icon-lock_edit',
			buttons : [ {
				text : '修改',
				handler : function() {
					if ($('#passwordDialog form').form('validate')) {
						$.post('${updatePasswordAction}', {
							'oldPassword' : $('#oldPassword').val(),
							'password' : $('#password').val()
						}, function(result) {
							if (result.success) {
								$.messager.alert('提示', result.msg, 'info');
								$('#passwordDialog').dialog('close');
							}else{
								$.messager.alert('提示', result.msg, 'error');
							}
						}, 'json');
					}
				}
			}],
			onOpen : function() {
				$('#passwordDialog form :input').val('');
			}
		}).dialog('close');
		
		<c:if test="${mustModifyPassword}">
			$('#passwordDialog').dialog('open');
		</c:if>
	});

</script>
</head>
<body class="easyui-layout" id="mainLayout">
	<!-- logo、用户信息区域　 -->
	<div data-options="region:'north',split:true, href:'${accountAction }'" style="height:80px;"></div>
	<!-- 菜单区域 -->
	<div data-options="region:'west',href:'',split:true" title="菜单树" style="width: 200px; padding: 10px;">
		<ul id="menuTree"></ul>
	</div>
	<!-- 主区域 -->
	<div data-options="region:'center',href:'',split:true">
		<div id="menuTabs" class="easyui-tabs">
			<div title="关于${subSystem.systemName }" data-options="iconCls:'ext-icon-heart'">
				<iframe src="${welcomeAction }" allowTransparency="true" style="border: 0; width: 100%; height: 99%;" frameBorder="0"></iframe>
			</div>
    	</div>
	</div>
	<!-- 信息、版权区域 -->
	<div data-options="region:'south',split:true, href:''" style="height:60px;">
		<p align="center">
		<font face="Georgia" size="4">CopyRight &copy;1995-2015</font>
		<font size="4">xxx有限公司</font>
		</p>
	</div>
	
	
	<div id="passwordDialog" title="修改密码" style="display: none;">
		<form method="post" class="form" onsubmit="return false;">
			<table width="100%" border="0" class="table">
				<tr>
					<th width="30%">旧密码</th>
					<td><input id="oldPassword" name="oldPassword" type="password" class="easyui-validatebox" 
						style="width:200px;" data-options="required:true,validType:'length[0,100]'" missingMessage="请输入旧密码"/></td>
				</tr>
				<tr>
					<th width="30%">新密码</th>
					<td><input id="password" name="password" type="password" class="easyui-validatebox" 
						style="width:200px;" data-options="required:true,validType:['password','length[0,100]']" missingMessage="请输入新密码"/></td>
				</tr>
				<tr>
					<th width="30%">重复密码</th>
					<td><input type="password" class="easyui-validatebox" style="width:200px;" 
						data-options="required:true,validType:['password','equalsPassword[\'#password\']','length[0,100]']" missingMessage="请输入重复密码"/></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>