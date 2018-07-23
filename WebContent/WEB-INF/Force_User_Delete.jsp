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
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
			<h1>ユーザ削除</h1>
			<h2>ユーザIDを入力してください</h2>
			<form action="ForceUserDelete" method="post">
				<input type="text" name="userid" placeholder="ユーザID" required>
				<input type="submit" value="削除" onClick="disp()">
			</form>
			
			</div>
		</div>
	</div>
</body>
</html>