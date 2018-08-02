<%@ page language="java" contentType ="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"
	import="model.ContentsBean"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	ArrayList<ContentsBean> arrayTopContents = new ArrayList<ContentsBean>();
	arrayTopContents = (ArrayList<ContentsBean>)request.getAttribute("arrayTopContents");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ</title>
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>

<body>
	
	<%@ include file="Header.jsp" %>
	
	<!--  --><div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <h1 class="header center teal-text text-lighten-2">投票システム</h1>
        <div class="row">
  <nav>
    <div class="nav-wrapper">
      <form action="Search">
        <div class="input-field">
          <input id="search" type="search" name="keyword" required>
          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
          <i class="material-icons">close</i>
        </div>
        
        <div class="row">
        	<div class="input-field white">
    <select name="category">
      <option value="0" selected>全て</option>
      <option value="1">エンターテイメントと趣味</option>
      <option value="2">暮らしと生活ガイド</option>
      <option value="3">健康・美容・ファッション</option>
      <option value="4">ニュース</option>
      <option value="5">恋愛・人間関係</option>
      <option value="6">子育て・学校</option>
      <option value="7">デバイス・PC・家電</option>
      <option value="8">ビジネス・経済・お金</option>
      <option value="9">スポーツ・アウトドア</option>
      <option value="10">学問・サイエンス</option>
      <option value="11">職業とキャリア</option>　
      <option value="12">その他</option>
    </select>
    
		</div>
		<input type="submit" style="display: none">
	</div> 
	</form>
	</div>
</nav>
    </div>
    </div>
    	<!-- <div class="parallax"><img src="background1.jpg" alt="Unsplashed background img 1"></div> -->
	</div>
	
	<div class="container">
  		<div class="container"style="margin-top: 90px;">
			<ul class="collection with-header">
  		      <li class="collection-header black-text"><h4 class="valign-wrapper"><span lang="ja"></span><i class="medium material-icons">equalizer</i>ランキング</h4></li>
  		      	<% for(int count=0;count<arrayTopContents.size();count++){%>
  		      		<li class="collection-item black-text"><div><i class="material-icons">filter_<%=count +1 %></i><a href="ContentsDetail?conId=<%=arrayTopContents.get(count).getConId()%>" class="secondary-content"><i class="material-icons">show_chart</i></a><%= arrayTopContents.get(count).getConName()%></div></li>
				<%} %>
      		</ul>
		</div>
	</div>
      
	<div class="parallax-container valign-wrapper" style="top: 20%">
      <div class="container">
        <div class="row center">
        
        <a href="ContentsList" class="waves-effect waves-light btn-large" style="width:50%"><i class="material-icons left">dehaze</i>アンケート一覧を見る</a>
        <p></p>
              <a href="F_Contents_Registration" class="waves-effect waves-light btn-large" style="width:50%"><i class="material-icons left">add</i>アンケートを作る</a>
        </div>
      </div>
    <div class="parallax"><img src="background3.jpg" alt="Unsplashed background img 3"></div>
  </div>
  
	
	<%@ include file="Footer.jsp" %>
</div>
	
	 <script>
    
    document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, options);
  });

  // Or with jQuery

  $(document).ready(function(){
    $('select').formSelect();
  });
    </script>
	
</body>
</html>