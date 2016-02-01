/**
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.extend($.fn.panel.defaults, {
	onBeforeDestroy : function() {
		var frame = $('iframe', this);
		try {
			if (frame.length > 0) {
				for (var i = 0; i < frame.length; i++) {
					frame[i].src = '';
					frame[i].contentWindow.document.write('');
					frame[i].contentWindow.close();
				}
				frame.remove();
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
});

/**
 * 防止panel/window/dialog组件超出浏览器边界
 * 
 * 
 * @requires jQuery,EasyUI
 */
onMove = {
	onMove : function(left, top) {
		var l = left;
		var t = top;
		if (l < 1) {
			l = 1;
		}
		if (t < 1) {
			t = 1;
		}
		var width = parseInt($(this).parent().css('width')) + 14;
		var height = parseInt($(this).parent().css('height')) + 14;
		var right = l + width;
		var buttom = t + height;
		var browserWidth = $(window).width();
		var browserHeight = $(window).height();
		if (right > browserWidth) {
			l = browserWidth - width;
		}
		if (buttom > browserHeight) {
			t = browserHeight - height;
		}
		$(this).parent().css({/* 修正面板位置 */
			left : l,
			top : t
		});
	}
};
$.extend($.fn.dialog.defaults, onMove);
$.extend($.fn.window.defaults, onMove);
$.extend($.fn.panel.defaults, onMove);

/**
 * 
 * 通用错误提示
 * 
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 * 
 * @requires jQuery,EasyUI
 */
onLoadError = {
	onLoadError : function(XMLHttpRequest) {
		if (parent.$ && parent.$.messager) {
			parent.$.messager.progress('close');
			parent.$.messager.alert('错误', XMLHttpRequest.responseText);
		} else {
			$.messager.progress('close');
			$.messager.alert('错误', XMLHttpRequest.responseText);
		}
	}
};
$.extend($.fn.datagrid.defaults, onLoadError);
$.extend($.fn.treegrid.defaults, onLoadError);
$.extend($.fn.tree.defaults, onLoadError);
$.extend($.fn.combogrid.defaults, onLoadError);
$.extend($.fn.combobox.defaults, onLoadError);
$.extend($.fn.form.defaults, onLoadError);


/**
 * 扩展validatebox，添加新的验证功能
 * 
 * 
 * @requires jQuery,EasyUI
 */
$.extend($.fn.validatebox.defaults.rules, {
	equalsPassword : {/* 验证两次密码是否一致功能 */
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两次输入的密码不一致！'
	}
});

$.extend($.fn.validatebox.defaults.rules, {
	nonChinese : {//只能输入字母、数字、下划线
		validator : function(value, param) {
			return /^[a-zA-Z0-9_]+$/.test(value);
		},
		message : '只能输入字母、数字、下划线！'
	}
});

$.extend($.fn.validatebox.defaults.rules, {
	phoneNumber : {//手机号码
		validator : function(value, param) {
			return /^1[3|4|5|7|8][0-9]\d{8}$/.test(value);
		},
		message : '非法的手机号码！'
	}
});

$.extend($.fn.validatebox.defaults.rules, {
	password : {//密码验证
		validator : function(value, param) {
			return /(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^0-9a-zA-Z]).{8,}/.test(value);
		},
		message: '密码必须由数字、字母和特殊字符组成，且少于８位'
	}
});

/**
 * 创建一个modal dialog
 * 
 * @requires jQuery,EasyUI
 * 
 */
modalDialog = function(options) {
	var opts = $.extend({
		title : '&nbsp;',
		width : 640,
		height : 480,
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
	if (options.url) {
		opts.content = '<iframe id="" src="'
				+ options.url
				+ '" allowTransparency="true" scrolling="auto" width="100%" height="98%" frameBorder="0" name=""></iframe>';
	}
	return $('<div/>').dialog(opts);
};

serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (this['value'] != undefined && this['value'].length > 0) {// 如果表单项的值非空，才进行序列化操作
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		}
	});
	return o;
};
