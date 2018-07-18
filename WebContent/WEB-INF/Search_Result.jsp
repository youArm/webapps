<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ContentsBean"
	import="java.util.ArrayList"
%>

<%	ArrayList<ContentsBean> resultList = new ArrayList<ContentsBean>(); 
	resultList = (ArrayList<ContentsBean>)request.getAttribute("arraySearch");
	
	String notResult = (String)request.getAttribute("notResult");
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
				
				<% if(notResult != null){%>
					<h5><%=notResult %></h5>
				<%} %>
				
				<table border="1">
					<% for(int count=0;count<resultList.size();count++){%>
							<tr>
								<th><a href="ContentsDetail?conId=<%=resultList.get(count).getConId()%>"><%= resultList.get(count).getConName()%></a></th>
							</tr>
					<%} %>
				</table>
				
			</div>
		</div>
	</div>
	
</body>
</html>