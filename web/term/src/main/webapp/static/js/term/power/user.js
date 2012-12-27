jQuery.noConflict();

jQuery(document).ready(function() {
			checkUserForm();
		});

function checkUserForm() {
	jQuery.formValidator.initConfig({
				formid : "inputForm",
				// autotip : true,
				// tidymode : true,
				onsuccess : function() {
					return true;
				},
				onerror : function(msg) {
					alert(msg);
				}
			});
	jQuery("#id").formValidator({
				onshow : "请输入用户标识,英文字符",
				onfocus : "请输入3-15个字符",
				oncorrect : "该系统标识可以使用"
			}).inputValidator({
				min : 3,
				max : 15,
				onerror : "你输入的用户名非法,请确认"
			}).regexValidator({
				regexp : "^\\w+$",
				onerror : "格式不正确,请输入英文字符"
			}).ajaxValidator({
				url : "user!isExist.action",
				datatype : "json",
				data : "sid=" + jQuery("#id").val(),
				success : function(data) {
					if (!data) {
						return true;
					}
					return false;
				},
				error : function() {
					alert("服务器没有返回数据，可能服务器忙，请重试");
				},
				onerror : "该标识不可用，请更换系统标识",
				onwait : "正在对系统标识进行合法性校验，请稍候..."
			});
	jQuery("#name").formValidator({
				onshow : "请输入用户名,汉字或者英文字符",
				onfocus : "请输入3-15个字符",
				oncorrect : "该系统标识可以使用"
			}).inputValidator({
				min : 3,
				max : 15,
				onerror : "你输入的用户名非法,请确认"
			}).ajaxValidator({
				type : "get",
				url : "user!isExist.action",
				datatype : "json",
				data : "sid=" + jQuery("#id").val(),
				success : function(data) {
					if (!data) {
						return true;
					}
					return false;
				},
				error : function() {
					alert("服务器没有返回数据，可能服务器忙，请重试");
				},
				onerror : "该标识不可用，请更换系统标识",
				onwait : "正在对系统标识进行合法性校验，请稍候..."
			});
	jQuery("#passwordConfirm").formValidator({
				empty : true,
				onshow : "请输入重复密码",
				onfocus : "两次密码必须一致哦",
				oncorrect : "密码一致"
			}).inputValidator({
				min : 1,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "重复密码两边不能有空符号"
				},
				onerror : "重复密码不能为空,请确认"
			}).compareValidator({
				desid : "password",
				operateor : "=",
				onerror : "2次密码不一致,请确认"
			});
	jQuery("#password").formValidator({
				empty : true,
				onshow : "请输入密码.如果密码为空,则表示不修改密码",
				onfocus : "请输入密码"
			});
}
