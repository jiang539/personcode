<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>403 - 缺少权限</title>
	</head>

	<body>
		<div>
			<div>
				<h1>
					你没有访问该页面的权限.
				</h1>
			</div>
			<div>
				<a href="<c:url value='/'/>">返回首页</a>
				<a href="<c:url value='/j_spring_security_logout'/>">退出登录</a>
			</div>
		</div>
	</body>
</html>