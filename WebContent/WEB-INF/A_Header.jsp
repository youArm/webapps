<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.UserBean"%>
    <%
	UserBean user = (UserBean)session.getAttribute("userbean");
	%>
	
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>rallax Template - Materialize</title>
    
      <script src="js/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.min.js"></script>
  <script src="js/init.js"></script>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
  <script>
$(function() {
var bt = $("header").offset().top; 
var ds = 0;
 
$(document).scroll(function(){ 
    ds = $(this).scrollTop(); 
 
    if (bt <= ds) {  
        $("header").addClass('follow'); 
    } else if (bt >= ds) { 
        $("header").removeClass('follow'); 
    }
    });
});
</script>
  
</head>
<body>
<header>
	<div class="container">
		<!-- Page Content goes here -->
    </div>
   	<nav>
    	<div class="nav-wrapper" style="left: 0px; top: 0px">
      		<a href="F_A_Top" class="brand-logo"><i class="large material-icons">assessment</i>投票システム</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
        		<li><a href="UserLogin">ログアウト</a></li>
      		</ul>
    	</div>
	</nav> 
</header>

</body>
</html>

