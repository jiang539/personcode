<#-- 

分页信息 
page:分页实体类参数
listDto:数据列信息,主要用于判断是否有数据
formId:查询条件所有的form的id
pageIndexId:当前要显示的页码的隐藏域Id
-->
<#macro pagination page=page listDto=listDto fromId="queryForm" pageIndexId="pageIndex" actionUrl="">
<table class="pageTable">
	<tr>
		<td>
		<#if listDto?size <= 0>
			<div align="center"> 没有相关数据！</div>
		<#else>
<div class="pageDiv">
  <#if !page.hasPrevious>首页 上一页<#rt/>
  <#else><#rt/>
  	<a href="javascript:pageGoto('${fromId}','1','${actionUrl}')">首页</a><#rt/>
  	<a href="javascript:pageGoto('${fromId}','${page.pageIndex-1}','${actionUrl}')">上一页</a><#rt/>
  </#if><#rt/>
  <#if !page.hasNext>下一页 尾页<#rt/>
  <#else><#rt/>
  	<a href="javascript:pageGoto('${fromId}','${page.pageIndex+1}','${actionUrl}')">下一页</a><#rt/> 
  	<a href="javascript:pageGoto('${fromId}','${page.pageCount}','${actionUrl}')">尾页</a><#rt/>
  </#if><#rt/>
     当前 <span class="pageSpan">${page.pageIndex}/ ${page.pageCount}</span>页 每页<span class="pageSpan"> ${page.pageSize}</span>条 共<span class="pageSpan"> ${page.totalCount}</span>条<#rt/>
  <#rt/>
</div>
		</#if>
		</td>
	</tr>
</table>

</#macro>