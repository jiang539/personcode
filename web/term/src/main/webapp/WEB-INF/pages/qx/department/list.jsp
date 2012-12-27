<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<#include "/WEB-INF/pages/common/meta.jsp"/>
<title>用户管理</title>
</head>
<body>
	<from>
	<div class="searchDiv"></div>
	<table class="table_list">
		<thead>
			<tr>
				<th>操作</th>
				<th>姓名</th>
				<th>部门</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>地址</th>
				<th>状态</th>
			</tr>
		</thead>
		<#if (listDto ??) && (listDto?size gt 0)>
		<tbody>
			<#list listDto as dto>
			<tr>
				<#if dto ?? >
				<td>修改</td>
				<td>${(dto.userName)!''}</td>
				<td>${(dto.unitName)!''}</td>
				<td>${(dto.sex)!''}</td>
				<td>${(dto.email)!''}</td>
				<td>${(dto.phone)!''}</td>
				<td>${(dto.address)!''}</td>
				<td>${(dto.state)!''}</td> 
				</#if>
			</tr>
			</#list>
		</tbody>
		</#if>
		<tfoot>
			<tr>
				<td colspan="8">page</td>
			</tr>
		</tfoot>
	</table>

	</from>

</body>
</html>
