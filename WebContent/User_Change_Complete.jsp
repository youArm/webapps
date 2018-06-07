<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.UserBean"%>

<%	UserBean userbean = (UserBean)session.getAttribute("userbean"); 
	String sysYear = (new java.text.SimpleDateFormat("yyyy").format(new java.util.Date())); 
	int isysYear = Integer.parseInt(sysYear);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>基本情報変更</h1>
	
	<h2>基本情報</h2>
	<form action="InfomationChange" method="post" name="form">
		
		名前<br><input type="text" name="name" value="<%=userbean.getName() %>" size="35"  required><br>
		
		名前（カナ）<br><input type="text" name="nameKana" value="<%=userbean.getNameKana()%>" size="35" required><br>
		
		郵便番号<br><input type="text" name="postalcode" value="<%= userbean.getPostalcode()%>" size="35" required><br>
		
		都道府県<br><select name="prefecture" required>
			<option value="北海道" selected>北海道</option>
			<option value="青森県">青森県</option>
			<option value="岩手県">岩手県</option>
			<option value="宮城県">宮城県</option>
			<option value="秋田県">秋田県</option>
			<option value="山形県">山形県</option>
			<option value="福島県">福島県</option>
			<option value="茨城県">茨城県</option>
			<option value="栃木県">栃木県</option>
			<option value="群馬県">群馬県</option>
			<option value="埼玉県">埼玉県</option>
			<option value="千葉県">千葉県</option>
			<option value="東京都">東京都</option>
			<option value="神奈川県">神奈川県</option>
			<option value="新潟県">新潟県</option>
			<option value="富山県">富山県</option>
			<option value="石川県">石川県</option>
			<option value="福井県">福井県</option>
			<option value="山梨県">山梨県</option>
			<option value="長野県">長野県</option>
			<option value="岐阜県">岐阜県</option>
			<option value="静岡県">静岡県</option>
			<option value="愛知県">愛知県</option>
			<option value="三重県">三重県</option>
			<option value="滋賀県">滋賀県</option>
			<option value="京都府">京都府</option>
			<option value="大阪府">大阪府</option>
			<option value="兵庫県">兵庫県</option>
			<option value="奈良県">奈良県</option>
			<option value="和歌山県">和歌山県</option>
			<option value="鳥取県">鳥取県</option>
			<option value="島根県">島根県</option>
			<option value="岡山県">岡山県</option>
			<option value="広島県">広島県</option>
			<option value="山口県">山口県</option>
			<option value="徳島県">徳島県</option>
			<option value="香川県">香川県</option>
			<option value="愛媛県">愛媛県</option>
			<option value="高知県">高知県</option>
			<option value="福岡県">福岡県</option>
			<option value="佐賀県">佐賀県</option>
			<option value="長崎県">長崎県</option>
			<option value="熊本県">熊本県</option>
			<option value="大分県">大分県</option>
			<option value="宮崎県">宮崎県</option>
			<option value="鹿児島県">鹿児島県</option>
			<option value="沖縄県">沖縄県</option>
			
		</select><br>
		
		住所<br><input type="text" name="city" size="35" value="<%=userbean.getCity() %>" required><br>
		
		建物名<br><input type="text" name="buildingName" value="<%=userbean.getBuildingName() %>" size="35"><br>
		
		電話番号<br><input type="text" name="phoneNumber" value="<%=userbean.getPhoneNumber()%>" size="35" required><br>
		<input type="hidden" name="userid" value="<%=userbean.getUserID()%>">
		
		<input type="submit" value="確認">
	</form>
	
</body>
</html>