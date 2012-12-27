jQuery.noConflict();

jQuery(document).ready(function() {
			checkInputForm();
		});

function checkInputForm() {
	jQuery.formValidator.initConfig({
				formid : "inputForm",
				onsuccess : function() {
					return true;
				},
				onerror : function(msg) {
					alert(msg)
				}
			});
	jQuery("#price").formValidator({
				onshow : "请输入数字",
				onfocus : "请输入数字"
			}).regexValidator({
				regexp : "^([+-]?)\\d*\\.?\\d+$",
				onerror : "只能输入数字"
			});
	jQuery("#amount").formValidator({
				onshow : "请输入数字",
				onfocus : "请输入数字"
			}).regexValidator({
				regexp : "^-?[1-9]\\d*$",
				onerror : "只能输入整数"
			});	
	jQuery("#payment").formValidator({
				onshow : "请输入金额",
				onfocus : "请输入金额"
			}).regexValidator({
				regexp : "^([+-]?)\\d*\\.?\\d+$",
				onerror : "只能输入整数"
			});	
}