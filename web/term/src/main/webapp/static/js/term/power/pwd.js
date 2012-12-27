jQuery.noConflict();

jQuery(document).ready(function() {
			checkForm();
		});

function checkForm() {
	jQuery.formValidator.initConfig({
				formid : "inputForm",
				onsuccess : function() {
					return true;
				},
				onerror : function(msg) {
					alert(msg)
				}
			});
	jQuery("#password").formValidator({
				onshow : "请输入密码.如果密码为空,则表示不修改密码",
				onfocus : "请输入密码"
			});
	jQuery("#password21").formValidator({
				onshow : "请输入新密码",
				onfocus : "请输入3-15个字符"
			}).inputValidator({
				min : 3,
				max : 15,
				onerror : "密码长度在3-15之间,请确认"
			});
	jQuery("#password22").formValidator({
				onshow : "请重新输入新密码",
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
				desid : "password21",
				operateor : "=",
				onerror : "2次密码不一致,请确认"
			});;
}