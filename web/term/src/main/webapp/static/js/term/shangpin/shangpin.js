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
				onshow : "请输入商品名称,汉字或者英文字符",
				onfocus : "请输入3-15个字符"
			}).inputValidator({
				min : 3,
				max : 15,
				onerror : "你输入的用户名非法,请确认"
			});
	jQuery("#type").formValidator({
				empty : false,
				onshow : "请输入或者选择商品类型",
				onfocus : "请输入或者选择商品类型"
			}).inputValidator({
				min : 1,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "两边不能有空符号"
				},
				onerror : "商品类型不能为空,请确认"
			});
	jQuery("#companyDto").formValidator({
				empty : true,
				onshow : "请选择供应商",
				onfocus : "请选择供应商"
			});
}
