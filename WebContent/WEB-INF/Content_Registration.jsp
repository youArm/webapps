<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat" import="java.util.Date"%>
<%
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date date1 = new Date();
	String d = df.format(date1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>コンテンツ登録</title>
<head />
<body>
	
	<%@ include file="Header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>コンテンツ登録</h2>

				<form action="Content_Registration" method="post" enctype="multipart/form-data">

					<h5>タイトル</h5>
					<input type="text" name="conname" required>

					<h5>回答１</h5>
					<input type="text" name="ans1" required> 
					<input type="file" name="ansImage1">

					<h5>回答２</h5>
					<input type="text" name="ans2" required>
					<input type="file" name="ansImage2">

					<h5>回答３</h5>
					<input type="text" name="ans3"> <input type="file"
						name="ansImage3">

					<h5>回答４</h5>
					<input type="text" name="ans4"> <input type="file"
						name="ansImage4">

					<h5>カテゴリ</h5>
					<div class="row">
        				<div class="input-field white">
							<select name="catename" required>
								<option value="1" selected>エンターテインメントと趣味</option>
								<option value="4">ニュース</option>
								<option value="7">デバイス・PC・家電</option>
								<option value="10">学問・サイエンス</option>
								<option value="2">暮らしと生活ガイド</option>
								<option value="5">恋愛・人間関係</option>
								<option value="8">ビジネス・経済とお金</option>
								<option value="11">職業とキャリア</option>
								<option value="3">健康・美容・ファッション</option>
								<option value="6">子育て・学校</option>
								<option value="9">スポーツ、アウトドア、車</option>
								<option value="12">その他</option>
							</select> <br> <br>
						</div><
					</div>
					<h5>投票期日</h5>
					<input type="date" name="date" min="<%=d%>" required> <br>
					<br>
					<input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="登録" onClick="return check()">
				</form>
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
  
  function check(){

		if(window.confirm('送信してよろしいですか？')){ // 確認ダイアログを表示

			return true; // 「OK」時は送信を実行

		}
		else{ // 「キャンセル」時の処理

			window.alert('キャンセルされました'); // 警告ダイアログを表示
			return false; // 送信を中止

		}

	}
  
  
    </script>
	
	
</body>
</html>
