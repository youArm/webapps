<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean" 
	import="model.PassWordBean"
%>
<% 	UserBean userBean = (UserBean)session.getAttribute("userBean");
	PassWordBean passBean = (PassWordBean)session.getAttribute("passBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>基本情報確認</h1>
				<h2>以下の内容で登録しますか？</h2>
				<table border="1">
					<tr>
						<th><p>ユーザーID<br><%=userBean.getUserId() %></p></th>
					</tr>
					<tr>
						<th><p>パスワード<br><%=passBean.getPass() %></p></th>
					</tr>
					<tr>
						<th><p>ニックネーム<br><%=userBean.getNickname() %></p></th>
					</tr>
					<tr>
						<th><p>性別<br><%=userBean.getGender() %></p></th>
					</tr>
					<tr>
						<th><p>生年月日<br><%=userBean.getBirthYear() %>年<%=userBean.getBirthMonth() %>月<%=userBean.getBirthDay() %>日</p></th>
					</tr>
					<tr>
						<th><p>都道府県<br><%=userBean.getPrefectures() %></p></th>
					</tr>
					<tr>
						<th><p>秘密の質問<%=userBean.getQuestionId() %></p></th>
					</tr>
					<tr>
						<th><p>質問の答え<br><%=userBean.getAnswer() %></p></th>
					</tr>
				</table>
				
				<form action="Registration">
					<input type="submit" value="登録" class="btn btn-lg btn-primary btn-block btn-signin">
				</form>
				
				<p></p>
				
				<button type="button" class="btn btn-lg btn-primary btn-block btn-signin" onclick="history.back()">戻る</button>
				
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>