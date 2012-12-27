<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>商品入库管理</title>
		<script type="text/javascript" src="${ctx}/js/jstool/m97DatePicker/WdatePicker.js"></script>
	</head>
	<body>
		<table class="table_query">
			<tr>
				<td align="left" class="tableTdMenu">
					<a href="ruku!input.action">填写入库单</a>
				</td>
			</tr>
			<tr>
				<td align="left">
					<div class="queryDiv">
						<form action="ruku!query.action" method="post">
							入库日期 从
							<input type="text" name="queryBean.startDate"
								value="${queryBean.startDate}" size="10" onfocus="WdatePicker()" />
							到
							<input type="text" name="queryBean.endDate"
								value="${queryBean.endDate}" size="10" onfocus="WdatePicker()" />
							商品
							<s:select list="listShpDto" name="queryBean.spId" listKey="id"
								listValue="name" headerKey="" headerValue="请选择" theme="simple"></s:select>
							经手人
							<s:select list="listUserDto" name="queryBean.userId" listKey="id"
								listValue="name" headerKey="" headerValue="请选择" theme="simple"></s:select>
							&nbsp;
							<input id="submit" type="submit" value="查询" />
						</form>
					</div>
				</td>
			</tr>
		</table>
		<table class="table_list" id="roleTable">
			<thead>
				<tr>
					<th>
						商品名称
					</th>
					<th>
						单价
					</th>
					<th>
						数量
					</th>
					<th>
						经手人
					</th>
					<th>
						时间
					</th>
					<th>
						操作
					</th>
				</tr>
			</thead>
			<s:iterator value="listEntity" status="st">
				<tr <s:if test="#st.even"> class="alt"</s:if>>
					<td>
						${shangPinDto.name}
					</td>
					<td>
						${price}
					</td>
					<td>
						${amount}
					</td>
					<td>
						${userDto.name}
					</td>
					<td>
						${date}
					</td>
					<td align="center">
						<a href="ruku!input.action?sid=${id}">修改</a>&nbsp;
						<a href="ruku!delete.action?sid=${id}">删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<s:url var="thisUrl" action="ruku.action"></s:url>
		<%@ include file="/WEB-INF/pages/template/page.jsp"%>		
	</body>
</html>
