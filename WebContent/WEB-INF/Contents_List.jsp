<%@page import="java.util.ArrayList"
		import="model.ContentsBean"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>(); 
	contentsList = (ArrayList<ContentsBean>)session.getAttribute("contentsList");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<h1>アンケート一覧</h1>
				<table border="1">
					<% for(int count=0;count<contentsList.size();count++){%>
							<tr>
								<th><a href="ContentsDetail?conId=<%=contentsList.get(count).getConId()%>" ><%= contentsList.get(count).getConName()%></a></th>
							</tr>
					<%} %>
				</table>
				
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>