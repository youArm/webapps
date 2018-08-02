<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="model.Vote_History_Bean"
	import="model.Vote_Info_Bean"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票履歴</title>
</head>
<body>
	<%-- TODO:2-1 jsp:includeでヘッダー画面を読み込む --%>
	<%@ include file="Header.jsp" %>
        <h1>結果一覧</h1>
    <%-- リクエストスコープからBeanクラスの配列を取得 --%>
    <% ArrayList<Vote_History_Bean> List = (ArrayList<Vote_History_Bean>)request.getAttribute("vort"); %>

    <form action="CartDelete">
        <table class="shopping_table">
            <tbody>
                <tr>
                    <th>コンテンツ名</th>
                    <th>投票先</th>
                </tr>
                <%-- Beanの要素数分（商品の種類分）テーブルを作成 --%>
                <% for (Vote_History_Bean bean : List) {%>
                <tr>
                
                    <td><a href="Vote_Result_jsp?con_id=<%=bean.getCon_id()%>"><%=bean.getCon_d()%></a></td>
                    <td><%=bean.getCon_d_id()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </form>
    
    <p></p>
    
    <a href="javascript:history.back();" class="waves-effect waves-light btn-large">戻る</a>
    
    
    <%@ include file="Footer.jsp" %>

</body>
</html>