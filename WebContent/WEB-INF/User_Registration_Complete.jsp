<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="css/Registration_Complete.css">
  <script src="js/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>

	<%@ include file="Header.jsp" %>

	<div class="container center">
		<div class="row">
			<div class="col-md-12">
				<h5>会員登録が完了しました</h5>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<a class="btn btn-success" href="F_Top" role="button"/>トップ</a>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<a class="btn btn-success" href="F_Mypage" role="button"/>マイページ</a>
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>