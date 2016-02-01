<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jquery -->
<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui-1.4.2/jquery.min.js'/>"></script>
<!-- easyui -->
<link id="easyuiTheme" rel="stylesheet" href="<c:url value='/resources/js/jquery-easyui-1.4.2/themes/metro/easyui.css'/>" type="text/css">
<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui-1.4.2/jquery.easyui.min.js'/>" charset="utf-8"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js'/>" charset="utf-8"></script>

<!-- 引入easyui扩展 -->
<script type="text/javascript" src="<c:url value='/resources/js/easyuiExt.js'/>" charset="utf-8"></script>

<%-- 引入扩展图标 --%>
<link rel="stylesheet" href="<c:url value='/resources/css/easyuiExtIcon.css'/>" type="text/css">

<%-- 引入自定义样式 --%>
<link rel="stylesheet" href="<c:url value='/resources/css/easyuiExtCss.css'/>" type="text/css">

<script type="text/javascript">
$(".combo").click(function(){
	$(this).prev().combobox("showPanel");
})
</script>
