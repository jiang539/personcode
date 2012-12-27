<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@ page import="java.util.Calendar"%>
<%
	Throwable ex = null;
	if (request.getAttribute("exception") != null) {
		ex = (Throwable) request.getAttribute("exception");
	}
	StringBuffer message = new StringBuffer();
	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	String action = "URL:"
			+ (String) request.getAttribute("struts.request_uri") + " ";
	if (ex != null) {
		logger.error(action + ex.getMessage(), ex);
		message.append(ex.getMessage() + "<br>");
		for (StackTraceElement e : ex.getStackTrace()) {
			message.append(e.toString() + "<br>");
		}
	} else {
		logger.error(action);
	}
	String currentDate = Calendar.getInstance().getTime().toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>500 - 系统内部错误</title>
</head>
<body>
	<div id="content">
		<h3>系统发生内部错误.</h3>
		<button onclick="history.back();">返回</button>
		<table class="Table2" width="100%" cellspacing="10" style="border: 1px;">
			<tr>
				<td>姓名：</td>
				<td></td>
			</tr>
			<tr>
				<td>时间：</td>
				<td><%=currentDate%></td>
			</tr>
			<tr>
				<td>URL：</td>
				<td colspan="2"><%=request.getAttribute("struts.request_uri")%></td>
			</tr>
			<tr>
				<td>异常信息：</td>
				<td><%=message%></td>
			</tr>
		</table>
		<s:property value="%{exception.message}"/>
	</div>
</body>
</html>
