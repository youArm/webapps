<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String sysYear = (new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()));
	int isysYear = Integer.parseInt(sysYear);
%>

<%
	String msgflg = (String) request.getAttribute("msgflg");
	String msg = "";

	//request変数に値が入っていたらエラーメッセージを格納
	if (msgflg != null) {
		msg = "ユーザIDが重複しています。";

	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    	<title>会員登録</title>
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
<script src="/js/Registration.js"></script>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	</head>

	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>基本情報登録</h1>

					<form action="Registration" method="post" name="regist">
						<p>ユーザーID</p>
						<input type="text" name="userid" placeholder="半角英数字24文字以内" required>
						<label style="color:red"><%=msg %></label>

						<p>パスワード</p>
						<input type="password" name="pass" id="pass" placeholder="半角英数字8文字以上" required>

						<p>パスワード確認</p>
						<input type="password" id="pass2" required placeholder="もう一度パスワードを入力してください">

						<p>ニックネーム</p>
						<input type="text" name="nickname" required>
						
						<p>性別</p>
						<p>
							<label>
								<input class="with-gap" name="gender" type="radio" value="男"/>
								<span>男</span>
							</label>
						</p>
						
						
						<p>
							<label>
								<input class="with-gap" name="gender" type="radio" value="女"/>
								<span>女</span>
							</label>
						</p>
						
						<p>生年月日</p>
						<div class="input-field col s12">
							<select name="birthyear" required>
								<% for(int year=1900;year<=isysYear;year++){ %>
								<option value=<%=year%>><%=year%></option>
								<%} %>
							</select>年
						</div>
						
						<div class="input-field col s12">
							<select name="birthmonth" required>
								<% for(int month=1;month<=12;month++){ %>
								<option value=<%=month%>><%=month%></option>
							<%} %>
							</select>月
						</div>
						
						<div class="input-field col s12">
							<select name="birthday" required>
								<% for(int day=1;day<=31;day++){ %>
								<option value=<%=day%>><%=day %></option>
								<%} %>
							</select>日
						</div>
						
						<p>都道府県</p>
						<div class="input-field col s12">
							<select name="plefectures" required>
								<option value="北海道" selected>北海道</option>
								<option value="青森県">青森県</option>
								<option value="岩手県">岩手県</option>
								<option value="宮城県">宮城県</option>
								<option value="秋田県">秋田県</option>
								<option value="山形県">山形県</option>
								<option value="福島県">福島県</option>
								<option value="茨城県">茨城県</option>
								<option value="栃木県">栃木県</option>
								<option value="群馬県">群馬県</option>
								<option value="埼玉県">埼玉県</option>
								<option value="千葉県">千葉県</option>
								<option value="東京都">東京都</option>
								<option value="神奈川県">神奈川県</option>
								<option value="新潟県">新潟県</option>
								<option value="富山県">富山県</option>
								<option value="石川県">石川県</option>
								<option value="福井県">福井県</option>
								<option value="山梨県">山梨県</option>
								<option value="長野県">長野県</option>
								<option value="岐阜県">岐阜県</option>
								<option value="静岡県">静岡県</option>
								<option value="愛知県">愛知県</option>
								<option value="三重県">三重県</option>
								<option value="滋賀県">滋賀県</option>
								<option value="京都府">京都府</option>
								<option value="大阪府">大阪府</option>
								<option value="兵庫県">兵庫県</option>
								<option value="奈良県">奈良県</option>
								<option value="和歌山県">和歌山県</option>
								<option value="鳥取県">鳥取県</option>
								<option value="島根県">島根県</option>
								<option value="岡山県">岡山県</option>
								<option value="広島県">広島県</option>
								<option value="山口県">山口県</option>
								<option value="徳島県">徳島県</option>
								<option value="香川県">香川県</option>
								<option value="愛媛県">愛媛県</option>
								<option value="高知県">高知県</option>
								<option value="福岡県">福岡県</option>
								<option value="佐賀県">佐賀県</option>
								<option value="長崎県">長崎県</option>
								<option value="熊本県">熊本県</option>
								<option value="大分県">大分県</option>
								<option value="宮崎県">宮崎県</option>
								<option value="鹿児島県">鹿児島県</option>
								<option value="沖縄県">沖縄県</option>
							</select>
						</div>

						<p>秘密の質問</p>
						<div class="input-field col s12">
							<select name="question" required>
								<option value="1">思い出の場所は？</option>
								<option value="2">好きな食べ物は？</option>
								<option value="3">尊敬する人は？</option>
								<option value="4">子供の頃のニックネームは？</option>
								<option value="5">好きな本のタイトルは？</option>
							</select>
						</div>
						<p>答え</p>
						<input type="text" name="answer" required>
						<br>
						<input type="submit" class="btn btn-lg btn-primary btn-block btn-signin" value="確認" onClick="return errorcheck()"/>
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
		  
		  function errorcheck() {
			    var pass = document.getElementById('pass').value;
			    var pass2 = document.getElementById('pass2').value;
			    
			    // パスワードの一致確認
			    if (pass != pass2){
			    	
			    	console.log(pass + 'aaaa' + pass2);
			      alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
			      return false;
			    }else{
			      return true;
			    }
			};

		</script>
	</body>
</html>