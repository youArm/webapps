<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"
		import="model.ContentsBean"
%>
<%	ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
	contentsList = (ArrayList<ContentsBean>)request.getAttribute("contentsHistory");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アンケート作成一覧</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>作成アンケート一覧</h1>

					<% for(int count=0;count<contentsList.size();count++){%>
						<p><%= contentsList.get(count).getConName()%><a class="btn btn-success" href="ContentsInfomastionChange?conId=<%=contentsList.get(count).getConId()%> role="button">変更</a></p>
					<%} %>

			</div>
		</div>
	</div>

</body>
</html>