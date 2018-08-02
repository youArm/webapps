<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"
	import="model.ContentsBean"
%>
<%	ArrayList<ContentsBean> contentsArray = new ArrayList<ContentsBean>();
	contentsArray = (ArrayList<ContentsBean>)request.getAttribute("contentsArray");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<h1>コンテンツ削除</h1>
				
				<form action="AdminContentsDelete" method="post">
					<select name="conid">
						<% for(int count=0;count<contentsArray.size();count++){ %>
							<option value="<%=contentsArray.get(count).getConId() %>"><%=contentsArray.get(count).getConName() %></option>
						<%} %>
						
						<input type="submit" value="削除">
					</select>
				</form>
				
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>