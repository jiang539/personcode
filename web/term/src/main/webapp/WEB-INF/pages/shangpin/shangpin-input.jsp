<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>商品管理</title>
		<script type="text/javascript" src="${ctx}/js/term/shangpin/shangpin.js"></script>
	</head>
	<body>
		<form id="shangpin"
			<s:if test="entity.id==null">action="shangpin!save.action"</s:if>
			<s:else>action="shangpin!update.action"</s:else> method="post">
			<input type="hidden" name="entity.id" value="${entity.id}">
			<table class="table_form">
				<tr>
					<td class="table_form_td_1">
						名称
						<font color="#FF0000">*</font>:
					</td>
					<td class="table_form_td_2">
						<input type="text" id="name" name="entity.name" value="${entity.name}"/>
					</td>
					<td>
						<div id="nameTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						商品类型
						<font color="#FF0000">*</font>:
					</td>
					<td>
						<s:combobox id="type" list="listSpType" name="entity.type" theme="simple"></s:combobox>
					</td>
					<td>
						<div id="typeTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						供应商:
					</td>
					<td>
						<s:select id="companyDto" list="listCompanyDto" name="entity.companyDto.id" listKey="id" listValue="name"
							theme="simple"></s:select>
					</td>
					<td>
						<div id="companyDtoTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td>
						<input type="text" name="entity.memo" value="${entity.memo}" />
					</td>
					<td>
						<div></div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input id="submit" type="submit" value="提交" />
						&nbsp;
						<input type="button" value="取消" onclick="history.back()" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
