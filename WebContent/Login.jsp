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
	
<div style="margin-top: 90px;"></div>
  <div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <h1 class="header center teal-text text-lighten-2">ログイン</h1>
        <div class="row center">
        </div>
        <div class="row">
     </div>
    	</div>
    		<div class="parallax"><img src="background1.jpg" alt="Unsplashed background img 1"></div>
  		</div>
  		
	<div class="container">
		<div class="container"style="width:50%">
			<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
			<p id="profile-name" class="profile-name-card"></p>
			<%if(login != null){ %>
      
					<h5 style="color:red"><%= login %><%} %></h5>
					
			<form class="form-signin" action = "UserLogin" method = "Post">
			
				<span id="reauth-email" class="reauth-email"></span>
				
				<input type="text" id="inputEmail" class="form-control" placeholder="UserID" required autofocus name = "id">
				
				<input type="password" id="inputPassword" class="form-control" name = "pass" placeholder="Password" required>
				<p></p>
				<input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value = "Sign in">
			</form>
			<!-- /form -->
			
			<br>
			<p></p>
			<a href="F_Registration" class="waves-effect waves-light btn-large" style="width:100%"><i class="material-icons left">dehaze</i>新規会員登録 </a>
			 
			 <br>
			<br>
			<a href="F_PassForget" class="waves-effect waves-light btn-large" style="width:100%"><i class="material-icons left">dehaze</i>パスワードを忘れた場合</a>
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->            
  		
  		
    
    

  <div class="parallax-container valign-wrapper" style="top: 20%">
    <div class="section no-pad-bot">
      <div class="container">
      </div>
    </div>
    <div class="parallax"><img src="background3.jpg" alt="Unsplashed background img 3"></div>
  </div>
	
	<%@ include file="WEB-INF/Footer.jsp" %>
	
</body>
</html>