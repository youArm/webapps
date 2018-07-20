<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.UserBean"%>
<%
	UserBean user = (UserBean)session.getAttribute("userBean");
	%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title>投票システム</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body>
	<header><nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarEexample7">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Top.jsp">
				ホーム
			</a>
		</div>

		<div class="collapse navbar-collapse" id="navbarEexample7">
			<ul class="nav navbar-nav">
				<li><a href="Mypage.jsp">マイページ</a></li>
				<li><a href="Voted.jsp">投票履歴</a></li>
				<li><a href="UserLogin">ログアウト</a></li>
			</ul>

			<form action = "Search">
					<select name = category>
						<option value = "hobby">エンターテイメントと趣味</option>
						<option value = "news">ニュース</option>
						<option value = "device">デバイス/PC/家電</option>
						<option value = "Learning">学問/サイエンス</option>
						<option value = "life">暮らしと生活ガイド</option>
						<option value = "emotion">恋愛/人間関係</option>
						<option value = "business">ビジネス/経済とお金</option>
						<option value = "profession">職業/キャリア</option>
						<option value = "health">健康/美容/ファッション</option>
						<option value = "parenting">子育て/学校</option>
						<option value = "sports">スポーツ/アウトドア/車</option>
						<option value = "travel">地域/旅行/お出かけ</option>
						<option value = "other">その他</option>
					</select>
					<input type = "text" name = "search"  >
					<input type = "submit" value = "検索">
			</form>

		</div>
	</div>


</nav></header>
</body>
</html>