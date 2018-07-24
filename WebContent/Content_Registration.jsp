<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat" import="java.util.Date"%>
<% SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date date1 = new Date();
	String d = df.format(date1);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>コンテンツ登録</title>
<head />
<body>

<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1></h1>

					<form action="Content_Registration" method="post" name="" enctype="multipart/form-data">

<p>タイトル</p>
<input type="text" name="conname" required>

<p>回答１</p>
<input type="text" name="ans1" required>
<input type="file" name="ansImage1" accept="image/png">

<p>回答２</p>
<input type="text" name="ans2" required>
<input type="file" name="ansImage2" accept="image/png">

<p>回答３</p>
<input type="text" name="ans3" >
<input type="file" name="ansImage3" accept="image/png">

<p>回答４</p>
<input type="text" name="ans4" >
<input type="file" name="ansImage4" accept="image/png">

<p>カテゴリ</p>
<select name="catename" required>
<option value="1" selected>エンターテインメントと趣味</option>
<option value="4" selected>ニュース</option>
<option value="7" selected>デバイス・PC・家電</option>
<option value="10" selected>学問・サイエンス</option>
<option value="2" selected>暮らしと生活ガイド</option>
<option value="5" selected>恋愛・人間関係</option>
<option value="8" selected>ビジネス・経済とお金</option>
<option value="11" selected>職業とキャリア</option>
<option value="3" selected>健康・美容・ファッション</option>
<option value="6" selected>子育て・学校</option>
<option value="9" selected>スポーツ、アウトドア、車</option>
<option value="12" selected>その他</option>
<option value="13" selected>地域、旅行、お出かけ</option>
<option value=""></option>
</select>
<br>
<br>
<p>投票期日</p>
<input type="date" name="date" min="<%= d %>">

<br><br>
<input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value = "登録">

</form>
				</div>
			</div>
		</div>
</body>
</html>