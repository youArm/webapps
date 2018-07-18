<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Vote_result_bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- 商品一覧画面 --%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%-- TODO:2-1 jsp:includeでヘッダー画面を読み込む --%>
        <h1>結果一覧</h1>
    <%-- リクエストスコープからBeanクラスの配列を取得 --%>
    <% ArrayList<Vote_result_bean> List = (ArrayList<Vote_result_bean>)request.getAttribute("vort"); %>

    <form action="CartDelete">
        <table class="shopping_table">
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
                    <td><img src="<%= bean.getImage()%>"></td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <a href="go"><input type="button" value="モドる"></a>
    </form>
</body>
</html>