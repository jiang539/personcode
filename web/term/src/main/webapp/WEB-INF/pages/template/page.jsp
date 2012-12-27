<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>


<table class="table_list_page">
	<tr>
		<td>
			<div class="pageDiv"  align="center">
				<s:if test="page.isEmpty">没有数据</s:if>
				<s:else>
					<s:if test="page.isFirst">第一页</s:if>
					<s:else>
						<a href="${thisUrl}?pageIndex=1">第一页</a>
					</s:else>
					<s:if test="page.hasPrevious">
						<a href="${thisUrl}?pageIndex=${page.pageIndex-1}">上一页</a>
					</s:if>
					<s:else>上一页</s:else>
					<s:if test="page.hasNext">
						<a href="${thisUrl}?pageIndex=${page.pageIndex+1}">下一页</a>
					</s:if>
					<s:else>下一页</s:else>
					<s:if test="page.isLast">最后一页</s:if>
					<s:else>
						<a href="${thisUrl}?pageIndex=${page.pageCount}">最后一页</a>
					</s:else>
				当前 ${page.pageIndex}/ ${page.pageCount} 页 每页 ${page.pageSize} 条 共 ${page.totalCount} 条
			</s:else>
			</div>
		</td>
	</tr>
</table>
<script type="text/javascript" src="${ctx}/js/term/util/listcss.js"></script>