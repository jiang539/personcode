<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#include "/WEB-INF/pages/template/freemaker/head.ftl"/>	
<title>用户管理</title>
<SCRIPT type="text/javascript">
<!--
	var setting = {
		check : {
			enable : true,
			chkboxType : {
				"Y" : "",
				"N" : ""
			}
		},
		view : {
			dblClickExpand : false
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick : beforeClick,
			onCheck : onCheck
		}
	};

	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "北京"
	}, {
		id : 2,
		pId : 0,
		name : "天津"
	}, {
		id : 3,
		pId : 0,
		name : "上海"
	}, {
		id : 6,
		pId : 0,
		name : "重庆"
	}, {
		id : 4,
		pId : 0,
		name : "河北省",
		open : true,
		nocheck : true
	}, {
		id : 41,
		pId : 4,
		name : "石家庄"
	}, {
		id : 42,
		pId : 4,
		name : "保定"
	}, {
		id : 43,
		pId : 4,
		name : "邯郸"
	}, {
		id : 44,
		pId : 4,
		name : "承德"
	}, {
		id : 5,
		pId : 0,
		name : "广东省",
		open : true,
		nocheck : true
	}, {
		id : 51,
		pId : 5,
		name : "广州"
	}, {
		id : 52,
		pId : 5,
		name : "深圳"
	}, {
		id : 53,
		pId : 5,
		name : "东莞"
	}, {
		id : 54,
		pId : 5,
		name : "佛山"
	}, {
		id : 6,
		pId : 0,
		name : "福建省",
		open : true,
		nocheck : true
	}, {
		id : 61,
		pId : 6,
		name : "福州"
	}, {
		id : 62,
		pId : 6,
		name : "厦门"
	}, {
		id : 63,
		pId : 6,
		name : "泉州"
	}, {
		id : 64,
		pId : 6,
		name : "三明"
	} ];

	function beforeClick(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}

	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getCheckedNodes(true), v = "";
		for ( var i = 0, l = nodes.length; i < l; i++) {
			v += nodes[i].name + ",";
		}
		if (v.length > 0)
			v = v.substring(0, v.length - 1);
		var cityObj = $("#citySel");
		cityObj.attr("value", v);
	}

	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		$("#menuContent").css({
			left : cityOffset.left + "px",
			top : cityOffset.top + cityObj.outerHeight() + "px"
		}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "citySel"
				|| event.target.id == "menuContent" || $(event.target).parents(
				"#menuContent").length > 0)) {
			hideMenu();
		}
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
//-->
</SCRIPT>
</head>
<body>
	<form id="inputForm" method="post" class="form">
		<legend>
			<small>用户管理</small>
		</legend>
		<table class="formTable">
			<tr>
				<td>用户登陆标识</td>
				<td><input type="text" id="id" name="dto.id" size="50" value="${(dto.id)!''}" class="required" /></td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" id="id" name="dto.name" size="50" value="${(dto.name)!''}" class="required" /></td>
			</tr>
			<tr>
				<td>用户部门</td>
				<td>
					<input id="citySel" type="text" readonly value="" size="50" onclick="showMenu();" />
					<div id="menuContent" class="menuContent" style="display: none; position: absolute;">
						<ul id="treeDemo" class="ztree" style="margin-top: 0px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;"></ul>
					</div>
				</td>
			</tr>
			<tr>
				<td>用户性别</td>
				<td><select name="dto.sex">
						<option value="男">男</option>
						<option vallue="女">女</option>
				</select></td>
			</tr>
			<tr>
				<td>用户邮箱</td>
				<td><input type="text" id="id" name="dto.email" size="50" value="${(dto.email)!''}" class="required" /></td>
			</tr>
			<tr>
				<td>用户电话</td>
				<td><input type="text" id="id" name="dto.phone" size="50" value="${(dto.phone)!''}" class="required" /></td>
			</tr>
			<tr>
				<td>用户地址</td>
				<td><input type="text" id="id" name="dto.address" size="50" value="${(dto.address)!''}" class="required" /></td>
			</tr>
			<tr>
				<td>用户状态</td>
				<td><select name="dto.state">
						<option value="1">在职</option>
						<option vallue="0">离职</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="submit_btn" class="btn" type="button" value="提交" />&nbsp; <input
					id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()" /></td>
			</tr>
		</table>
	</form>

</body>
</html>