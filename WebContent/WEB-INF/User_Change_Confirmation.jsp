<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean" 
	import="model.PassWordBean"
%>
<% 	UserBean userBean = (UserBean)session.getAttribute("userBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>基本情報変更</h1>
				<h2>以下の内容で変更しますか？</h2>
				<p>ユーザーID<br><%=userBean.getUserId() %></p>
				<p>ニックネーム<br><%=userBean.getNickname() %></p>
				<p>性別<br><%=userBean.getGender() %></p>
				<p>生年月日<br><%=userBean.getBirthYear() %>年<%=userBean.getBirthMonth() %>月<%=userBean.getBirthDay() %>日</p>
				<p>都道府県<br><%=userBean.getPrefectures() %></p>
				<p>秘密の質問<%=userBean.getQuestionId() %></p>
				<p>質問の答え<br><%=userBean.getAnswer() %></p>
				<button type="button" onclick="history.back()">戻る</button>
				<form action="User_Infomation_Change">
					<input type="submit" value="変更">
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>
