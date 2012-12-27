<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>
<html>
	<head>
		<title>商品出库管理</title>
		<script type="text/javascript" src="${ctx}/js/purview/role.js"></script>
	</head>
	<body>		
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
						经手人
					</th>
					<th>
						日期
					</th>
				</tr>
			</thead>
			<s:iterator value="listEntity">
				<tr>
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
					<td align="center">
						<a href="kucun!details.action?sid=${spId}">详细信息</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
