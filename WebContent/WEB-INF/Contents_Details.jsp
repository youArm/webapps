<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"
		import="model.ContentsDetailsBean"
%>
<%	ArrayList<ContentsDetailsBean> arrayContentsDetails = new ArrayList<ContentsDetailsBean>();
	arrayContentsDetails = (ArrayList<ContentsDetailsBean>)request.getAttribute("contentsDetails");
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
			<% for(int count=0;count<arrayContentsDetails.size();count++){%>
				<form action="#">
					<div class="col-md-3">
						<p><%=arrayContentsDetails.get(count).getCon_d_name()%></p>
						<p><%=arrayContentsDetails.get(count).getImage() %></p>
						<p><%=arrayContentsDetails.get(count).getDescription() %></p>
						
						<input type="hidden" value="<%=arrayContentsDetails.get(count).getCon_id() %>">
						<input type="hidden" value="<%=arrayContentsDetails.get(count).getCon_d_id()%>">
						
						<input type="submit" value="投票">
					</div>
				</form>
			<%} %>
		</div>
	</div>
	
</body>
</html>