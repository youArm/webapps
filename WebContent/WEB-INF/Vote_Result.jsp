<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Vote_result_bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- 商品一覧画面 --%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="css/Table.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%-- TODO:2-1 jsp:includeでヘッダー画面を読み込む --%>
	<%@ include file="Header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
        		<h1>結果一覧</h1>
    			<%-- リクエストスコープからBeanクラスの配列を取得 --%>
    			<% ArrayList<Vote_result_bean> List = (ArrayList<Vote_result_bean>)request.getAttribute("vort"); %>
    			<form action="CartDelete">
        			<table class="ProductTable">
            			<tbody>
                			<tr>
                    			<th>名前</th>
                    			<th>得票数</th>
                    			<th>画像</th>
                			</tr>
                			<%-- Beanの要素数分（商品の種類分）テーブルを作成 --%>
                			<% for (Vote_result_bean bean : List) {%>
                			<tr>
                    			<td><%=bean.getCon_d_name()%></td>
                    			<td><%=bean.getVotes()%></td>
                    			<td><img src="./<%= bean.getImage()%>" width="100" height="100"></td>
                			</tr>
                			<% }%>
            			</tbody>
        			</table>
    			</form>
    			
    			<p></p>
    			<a href="F_Top" class="waves-effect waves-light btn-large">トップに戻る</a>
    			
    		</div>
    	</div>
   </div>
   
   <%@ include file="Footer.jsp" %>
   
</body>
</html>