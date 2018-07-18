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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<%@ include file="Header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<% for(int count=0;count<arrayTopContents.size();count++){%>
					<p><a href="ContentsDetail?conId=<%=arrayTopContents.get(count).getConId()%>"><%= arrayTopContents.get(count).getConName()%></a></p>
				<%} %>
				
				<a href="ContentsList" class="square_fsn">アンケート一覧</a><br>
				<br>
				<a href="#" class="square_fsn">アンケートを作る</a><br>
			</div>
		</div>
	</div>
		
</body>
</html>