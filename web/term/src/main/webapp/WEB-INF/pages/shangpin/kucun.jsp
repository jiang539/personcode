<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>商品库存管理</title>
	</head>
	<body>
		<table class="table_query">
			<tr>
				<td align="left">
					<div class="queryDiv">
						<form action="kucun!query.action" method="post">
							商品
							<s:select list="listShpDto" name="queryBean.spId" listKey="id"
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
						入库数量
					</th>
					<th>
						出库数量
					</th>
					<th>
						库存数量
					</th>
				</tr>
			</thead>
			<s:iterator value="listEntity" status="st">
				<tr <s:if test="#st.even"> class="alt"</s:if>>
					<td>
						${spName}
					</td>
					<td>
						${ruKunAmount}
					</td>
					<td>
						${chuKuAmount}
					</td>
					<td>
						${kuCunAmount}
					</td>					
				</tr>
			</s:iterator>
		</table>
		<c:set var="thisUrl" value="kucun.action" ></c:set>
		<%@ include file="/WEB-INF/pages/template/page.jsp"%>
	</body>
</html>
