<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat" 
		import="java.util.Date" 
		import="java.util.ArrayList"
		import="model.ContentsDetailsBean"
%>

<% 	ArrayList<ContentsDetailsBean> contentsArray = new ArrayList<ContentsDetailsBean>();
	contentsArray = (ArrayList<ContentsDetailsBean>)request.getAttribute("contentsArray");
%>

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

<%@ include file="Header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>コンテンツ変更</h1>

			<form action="ContentsInfomationChange" method="post">
				<p>タイトル</p>
				<input type="text" name="conname" required>
				
				<% for(int count=1;count<5;count++){
					if(contentsArray.size() >= count){%>
					
						<p>回答<%=count %></p>
						<input type="text" name="ans<%=count %>" value="<%=contentsArray.get(count-1).getCon_d_name() %>" disabled="disabled">
						<img src="./<%= contentsArray.get(count-1).getImage()%>" width="100" height="100">
					<%} 
				}%>
					
					<p>カテゴリ</p>
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
					<option value="13">地域、旅行、お出かけ</option>
					</select>
					<br>
					<br>
					<p>投票期日</p>
					<input type="date" name="date" min="<%= d %>">
					
					<br><br>
					<input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value = "更新">
				
			</form>
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>
