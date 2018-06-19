<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String login = (String)session.getAttribute("login");
	session.invalidate(); %>

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
<title>ログイン</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
			<p id="profile-name" class="profile-name-card"></p>
			<%if(login != null){ %>
					<h5 style="color:red"><%= login %><%} %></h5>
			<form class="form-signin" action = "UserLogin" method = "Post">
				<span id="reauth-email" class="reauth-email"></span>
				<input id="inputEmail" class="form-control" placeholder="UserID" required autofocus name = "id">
				<input type="password" id="inputPassword" class="form-control" name = "pass" placeholder="Password" required>
				<input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value = "Sign in">
			</form>
			<!-- /form -->
			<br>
			<a href="User_Registration.jsp" class="new-member">
			 New member registration </a>
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
</body>
</html>