<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>客户与供应商管理</title>
		<script type="text/javascript" src="${ctx}/js/term/shangpin/company.js"></script>
	</head>
	<body>
		<form id="company"
			<s:if test="entity.id==null">action="company!save.action"</s:if>
			<s:else>action="company!update.action"</s:else> method="post">
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
						类型
						<font color="#FF0000">*</font>:
					</td>
					<td>
						<s:radio name="entity.type" list="#{'客户':'客户','供应商':'供应商'}" value="entity.type"
							theme="simple"></s:radio>
					</td>
					<td>
						<div id="typeTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						联系人
						<font color="#FF0000">*</font>:
					</td>
					<td>
						<input type="text" id="linkman" name="entity.linkman"  value="${entity.linkman}"/>
					</td>
					<td>
						<div id="linkmanTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						电话:
					</td>
					<td>
						<input type="text" id="phone" name="entity.phone"  value="${entity.phone}"/>
					</td>
					<td>
						<div id="phoneTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						地址:
					</td>
					<td>
						<input type="text" id="address" name="entity.address"  value="${entity.address}"/>
					</td>
					<td>
						<div id="addressTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						邮箱:
					</td>
					<td>
						<input type="text" id="email" name="entity.email"  value="${entity.email}"/>
					</td>
					<td>
						<div id="emailTip"></div>
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
