<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	String msg = (String)request.getAttribute("msg"); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
						
			<h2>パスワード再発行</h2>
			
			<h5>ユーザIDを入力してください</h5>
			<%
			if(msg != null){%>
				<label style="color:red"><%=msg %></label>
			<% }%>
			
			<form action="PassForget" method="post">
				<input type="text" name="userid" placeholder="UserID" required>
				
				<h5>秘密の質問を選択してください</h5>
				
				<div class="input-field col s12">
					<select name="question" required>
						<option value="1">思い出の場所は？</option>
						<option value="2">好きな食べ物は？</option>
						<option value="3">尊敬する人は？</option>
						<option value="4">子供の頃のニックネームは？</option>
						<option value="5">好きな本のタイトルは？</option>
					</select>
				</div>
				<h5>秘密の質問の答えを入力してください</h5>
				
				<input type="text" name="answer" required>
				
				<input type="submit" value="送信" class="btn btn-lg btn-primary btn-block btn-signin">
			</form>
			
			<p></p>
			
			<button type="button" class="btn btn-lg btn-primary btn-block btn-signin" onclick="history.back()">戻る</button>
			
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
	<script>
    
    document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, options);
  });

  // Or with jQuery

  $(document).ready(function(){
    $('select').formSelect();
  });
    </script>
</body>
</html>