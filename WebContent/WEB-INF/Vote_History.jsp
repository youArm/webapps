<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="model.Vote_History_Bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- TODO:2-1 jsp:includeでヘッダー画面を読み込む --%>
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
                    <td><a href="Vote_Result_jsp?con_id=<%=bean.getCon_d()%>"><%=bean.getCon_d()%></a></td>
                    <td><%=bean.getCon_d_id()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <a href="go"><input type="button" value="モドる"></a>
    </form>

</body>
</html>