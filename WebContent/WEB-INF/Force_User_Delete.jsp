<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ退会</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	
	<%@ include file="A_Header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
			<h2>ユーザ削除</h2>
			<h5>ユーザIDを入力してください</h5>
			<form action="ForceUserDelete" method="post">
				<input type="text" name="userid" placeholder="ユーザID" required>
				<input type="submit" value="削除" onClick="disp()" class="btn btn-lg btn-primary btn-block btn-signin">
			</form>
			
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
	<script type="text/javascript">
	function disp(){
		
		// 「OK」時の処理開始 ＋ 確認ダイアログの表示
		if(window.confirm('削除しますか？')){

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