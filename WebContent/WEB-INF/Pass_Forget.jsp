<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form action="PassForget" method="post">
				<input type="text" name="userid" placeholder="UserID" required>
				
				<select name="question" required>
							<option value="1">思い出の場所は？</option>
							<option value="2">好きな食べ物は？</option>
							<option value="3">尊敬する人は？</option>
							<option value="4">子供の頃のニックネームは？</option>
							<option value="5">好きな本のタイトルは？</option>
				</select>
				
				<input type="text" name="answer" required>
				
				<input type="submit" value="送信">
			</form>
			</div>
		</div>
	</div>
	
</body>
</html>