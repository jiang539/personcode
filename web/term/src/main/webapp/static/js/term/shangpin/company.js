jQuery.noConflict();

jQuery(document).ready(function() {
			checkForm();
		});

function checkForm() {
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
	jQuery("#name").formValidator({
				onshow : "请输入客户名称,汉字或者英文字符",
				onfocus : "请输入3-15个字符",
				oncorrect : "该系统标识可以使用"
			}).inputValidator({
				min : 3,
				max : 15,
				onerror : "你输入的用户名非法,请确认"
			});
	jQuery("#linkman").formValidator({
				empty : false,
				onshow : "请输入联系人",
				onfocus : "联系人信息"
			}).inputValidator({
				min : 1,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "两边不能有空符号"
				},
				onerror : "联系人不能为空,请确认"
			});
	jQuery("#phone").formValidator({
				empty : true,
				onshow : "请输入联系电话",
				onfocus : "请输入联系电话"
			});
	jQuery("#address").formValidator({
				empty : true,
				onshow : "请输入地址",
				onfocus : "请输入地址"
			});
	jQuery("#email").formValidator({
				empty : true,
				onshow : "请输入邮箱",
				onfocus : "请输入邮箱"
			});
}
