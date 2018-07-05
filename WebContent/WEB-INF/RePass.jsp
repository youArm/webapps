<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userid = (String)request.getAttribute("userid"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>パスワード再発行</h1>
				
				<form action="RePass" method="post">
					
					<p>パスワード入力</p>
					<input type="password" name="pass" required placeholder="半角英数字8文字以上">
					
					<p>パスワード確認</p>
					<input type="password" name="pass2" required placeholder="もう一度パスワードを入力してください">
					<input type="hidden" name="userid" value="<%=userid%>">
					
					<input type="submit" value="変更" onClick="return errorcheck()">
				</form>
			</div>
		</div>
	</div>
	
</body>
	<script type="text/javascript">
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
	
</html>