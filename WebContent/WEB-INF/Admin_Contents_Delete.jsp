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
	
	<%@ include file="A_Header.jsp" %>
	
	<div class="container center">
		<div class="row">
			<div class="col-md-12">
				
				<h2>コンテンツ削除</h2>
				
				<% if(contentsArray.size() == 0){%>
					<h5>登録されたコンテンツがありません。</h5>
					<p></p>
					<a href="F_A_Top" class="btn btn-lg btn-primary btn-block btn-signin">トップ</a>
				<% }else{%>
				
				<form action="AdminContentsDelete" method="post">
					<div class="input-field white">
						<select name="conid">
							<% for(int count=0;count<contentsArray.size();count++){ %>
								<option value="<%=contentsArray.get(count).getConId() %>"><%=contentsArray.get(count).getConName() %></option>
							<%} %>
							
							<input type="submit" value="削除" class="btn btn-lg btn-primary btn-block btn-signin">
						</select>
					</div>
				</form>
				<%}%>
				
			</div>
		</div>
	</div>
	
	<%@ include file="Footer.jsp" %>
	
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