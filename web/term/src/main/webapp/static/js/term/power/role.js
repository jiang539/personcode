jQuery.noConflict();

jQuery(document).ready(function() {
			checkRoleForm();
		});

function checkRoleForm() {
	jQuery.formValidator.initConfig({
				formid : "role",
				// autotip : true,
				// tidymode : true,
				onsuccess : function() {
					return true;
				},
				onerror : function(msg) {
					alert(msg)
				}
			});
	jQuery("#id").formValidator({
				onshow : "请输入用户标识,英文字符",
				onfocus : "请输入6-15个字符",
				oncorrect : "该系统标识可以使用"
			}).inputValidator({
				min : 6,
				max : 15,
				onerror : "你输入的用户名非法,请确认"
			}).regexValidator({
				regexp : "^TERM_\\w+$$",
				onerror : "格式不正确,必须以 'TERM_' 开头,如 TERM_user"
			}).ajaxValidator({
				type : "get",
				url : "role!isExist.action",
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
			});
	jQuery("#parentId").formValidator({
				empty : true
			}).inputValidator({
				regexp : "^TERM_\\w+$$",
				min : 6,
				max : 15,
				onerror : "长度在6-15之间,且以 'TERM_' 开头"
			}).ajaxValidator({
				type : "get",
				url : "role!isExist.action",
				datatype : "json",
				success : function(data) {
					if (data) {
						return true;
					}
					return false;
				},
				error : function() {
					alert("服务器没有返回数据，可能服务器忙，请重试");
				},
				onerror : "该标识不可用，请从下面列表的系统标识中进行选择",
				onwait : "正在对系统标识进行合法性校验，请稍候..."
			});
}