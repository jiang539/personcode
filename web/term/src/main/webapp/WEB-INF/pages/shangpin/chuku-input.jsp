<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>商品出库管理</title>
		<script type="text/javascript"	src="${ctx}/js/jstool/m97DatePicker/WdatePicker.js"></script>
		<script src="${ctx}/js/term/shangpin/chuku.js" type="text/javascript"></script>
	</head>
	<body>
		<form id="inputForm" <s:if test="entity.id==null">action="chuku!save.action"</s:if>
			<s:else>action="chuku!update.action"</s:else> method="post">
			<input type="hidden" name="entity.id">
			<table class="table_form">
				<tr>
					<td class="table_form_td_1">
						商品名称
						<font color="#FF0000">*</font>:
					</td>
					<td class="table_form_td_2">
						<s:select list="listShpDto" name="entity.shangPinDto.id"
							listKey="id" listValue="name" theme="simple" ></s:select>
					</td>
					<td>
						<div id="nameTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						单价
						<font color="#FF0000">*</font>:
					</td>
					<td>
						<input type="text" id="price" name="entity.price" value="${entity.price}"/>
					</td>
					<td>
						<div id="priceTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						数量
						<font color="#FF0000">*</font>:
					</td>
					<td>
						<input type="text" id="amount" name="entity.amount" value="${entity.amount}"/>
					</td>
					<td>
						<div id="amountTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						应付金额:
					</td>
					<td>
						<input type="text" id="totalMoney" name="totalMoney" readonly="readonly"/>
					</td>
					<td>
						<div></div>
					</td>
				</tr>
				<tr>
					<td>
						实付金额<font color="#FF0000">*</font>:
					</td>
					<td>
						<input type="text" id="payment" name="entity.payment" value="${entity.payment}"/>
					</td>
					<td>
						<div id="paymentTip"></div>
					</td>
				</tr>
				<tr>
					<td>
						经手人:
					</td>
					<td>
						<s:select list="listUserDto" name="entity.userDto.id" listKey="id"
							listValue="name" theme="simple" ></s:select>
							
					</td>
					<td>
						<div></div>
					</td>
				</tr>
				<tr>
					<td>
						出库日期:
					</td>
					<td>
						<input type="text" name="entity.date" value="${entity.date}"
							onfocus="WdatePicker()" />
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
