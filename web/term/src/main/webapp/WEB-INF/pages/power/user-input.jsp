<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp"%>

<html>
	<head>
		<title>用户信息管理</title>
		<script type="text/javascript" src="${ctx}/js/term/power/user.js"></script>
	</head>
	<body>
		<div id="content">
			<form id="inputForm" <s:if test="entity.id==null">action="user!save.action"</s:if>
			<s:else>action="user!update.action"</s:else> method="post">
				<table class="table_form" width="70%">
					<tr>
						<td class="table_form_td_1">
							登录名(系统标识)<font color="#FF0000">*</font>:
						</td>
						<td  class="table_form_td_2">
							<input type="text" name="entity.id" id="id"
								value="${entity.id}" <s:if test="entity.id!=null">readonly="readonly"</s:if>/>
						</td>
						<td>
							<div id="idTip"></div>
						</td>
					</tr>
					<tr>
						<td>
							用户名<font color="#FF0000">*</font>:
						</td>
						<td>
							<input type="text" id="name" name="entity.name" 
								value="${entity.name}" />
						</td>
						<td>
							<div id="nameTip"></div>
						</td>
					</tr>
					<tr>
						<td>
							密码:
						</td>
						<td>
							<input type="password" id="password" name="entity.password" />
						</td>
						<td>
							<div id="passwordTip"></div>
						</td>
					</tr>
					<tr>
						<td>
							确认密码:
						</td>
						<td>
							<input type="password" id="passwordConfirm" name="passwordConfirm" />
						</td>
						<td>
							<div id="passwordConfirmTip"></div>
						</td>
					</tr>
					<tr>
						<td>
							性别:
						</td>
						<td>
							<input type="radio" name="entity.sex" value="男"
								<s:if test='entity.sex =="男" '>checked="checked"</s:if> >
							男
							<input type="radio" name="entity.sex" value="女"
								<s:if test='entity.sex =="女"'>checked="checked"</s:if>>
							女
						</td>
						<td>
							<div>
								&nbsp;
							</div>
						</td>
					</tr>
					<tr>
						<td>
							手机:
						</td>
						<td>
							<input type="text" name="entity.phone" 
								value="${entity.phone}" />
						</td>
						<td>
							<div>
								&nbsp;
							</div>
						</td>
					</tr>
					<tr>
						<td>
							邮箱:
						</td>
						<td>
							<input type="text" name="entity.email" 
								value="${entity.email}" />
						</td>
						<td>
							<div>
								&nbsp;
							</div>
						</td>
					</tr>
					<tr>
						<td>
							住址:
						</td>
						<td>
							<input type="text" name="entity.address" 
								value="${entity.address}" />
						</td>
						<td>
							<div>
								&nbsp;
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="提交" />
							&nbsp;
							<input type="button" value="取消" onclick="history.back()" />
						</td>
						<td>
							<div>
								&nbsp;
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>