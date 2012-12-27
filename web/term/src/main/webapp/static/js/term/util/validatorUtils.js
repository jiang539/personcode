
jQuery.noConflict();
function vNum(idName, minLen, maxLen) {
	jQuery("#"+idName).formValidator({
				onshow : "请输入数字",
				onfocus : "请输入数字"
			}).inputValidator({
				min : 3,
				max : 15,
				onerror : "你输入的用户名非法,请确认"
			}).regexValidator({
				regexp : "^\\w+$",
				onerror : "格式不正确,请输入英文字符"
			})}

