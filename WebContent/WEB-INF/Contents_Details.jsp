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
				<form action="Voteadd">
					<div class="col-md-3">
						<h5><%=arrayContentsDetails.get(count).getCon_d_name()%></h5>
						<img src="./<%=arrayContentsDetails.get(count).getImage() %>" width="100" height="100">
						<h5><%=arrayContentsDetails.get(count).getDescription() %></h5>
						
						<input type="hidden" value="<%=arrayContentsDetails.get(count).getCon_id() %>" name="con_id">
						<input type="hidden" value="<%=arrayContentsDetails.get(count).getCon_d_id()%>" name="con_d_id">
						
						<input type="submit" class="btn btn-lg btn-primary btn-block btn-signin" value="投票">
					</div>
				</form>
			<%} %>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
</body>
</html>