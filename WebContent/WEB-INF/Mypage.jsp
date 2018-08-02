<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

	<%@ include file="Header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>ユーザー情報の変更はこちら</h2>
				<span class="glyphicon glyphicon-hand-down"></span>
				<br>
				<a class="btn btn-success" href="F_UserChange" role="button">変更</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>ユーザーの退会はこちら</h2>
				<span class="glyphicon glyphicon-hand-down"></span>
				<br>
				<a class="btn btn-success" href="F_DeleteUser" role="button">退会</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>アンケート作成履歴</h2>
				<span class="glyphicon glyphicon-hand-down"></span>
				<br>
				<a class="btn btn-success" href="F_Contents_History" role="button">アンケート作成履歴</a>
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>