<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userid = (String)request.getAttribute("userid"); %>
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
				
				<form action="RePass" method="post">
					
					<h5>パスワード入力</h5>
					<input type="password" name="pass" id="pass" required placeholder="パスワード">
					
					<h5>パスワード確認</h5>
					<input type="password" name="pass2" id="pass2" required placeholder="もう一度パスワードを入力してください">
					<input type="hidden" name="userid" value="<%=userid%>">
					
					<input type="submit" value="変更" class="btn btn-lg btn-primary btn-block btn-signin" onClick="return errorcheck()">
				</form>
				
				<p></p>
				<button type="button" class="btn btn-lg btn-primary btn-block btn-signin" onclick="history.back()">戻る</button>
				
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	

	<script>
		function errorcheck() {
   	 	var pass = document.getElementById('pass').value;
    	var pass2 = document.getElementById('pass2').value;
    	
    	
    	// パスワードの一致確認
    	if (pass != pass2){
    		
      		alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
      		return false;
    	}else{
     		 return true;
    	}
	};
</script>
</body>
</html>