<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Header.jsp" %>

退会手続き
※これまで作成又は投票したコンテンツ内容を全て削除します（この処理は取り消しできません）
<br><br>

<form class="form-signin" action = "UserDelete" method = "Post">
<input type="password" id="inputPassword" class="form-control" name = "pass" placeholder="Password" required>

<input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value = "退会">
</form>
</body>
</html>