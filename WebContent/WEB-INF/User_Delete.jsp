<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ退会</title>
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
			
			<h2>退会</h2>
			<h3>パスワードを入力してください</h3>
			<form action="UserDelete" method="post">
				<input type="password" name="pass" placeholder="パスワード" required>
				<input type="submit" value="退会" class="btn btn-lg btn-primary btn-block btn-signin" onClick="disp()">
			</form>
			
			<p></p>
			
			<button type="button" class="btn btn-lg btn-primary btn-block btn-signin" onclick="history.back()">戻る</button>
			
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
	<script>
	function disp(){
	
	// 「OK」時の処理開始 ＋ 確認ダイアログの表示
	if(window.confirm('退会しますか？')){

		location.href = "example_confirm.html"; // example_confirm.html へジャンプ

	}
	// 「OK」時の処理終了

	// 「キャンセル」時の処理開始
	else{

		window.alert('キャンセルされました'); // 警告ダイアログを表示

	}
	// 「キャンセル」時の処理終了
	
	}
	</script>
</body>
</html>