<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>
	
	<footer class="page-footer teal" id="footer">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">投票システム</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">お問い合わせ</h5>
          <ul>
            <li><a class="white-text" href="#!">shimoheihe@gmail.com</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">リンク</h5>
          <ul>
            <li><a class="white-text" href="#!">Twitter</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="brown-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>
  
  <script type="text/javascript">
  	new function(){
		
		var footerId = "footer";
		//メイン
		function footerFixed(){
			//ドキュメントの高さ
			var dh = document.getElementsByTagName("body")[0].clientHeight;
			//フッターのtopからの位置
			document.getElementById(footerId).style.top = "0px";
			var ft = document.getElementById(footerId).offsetTop;
			//フッターの高さ
			var fh = document.getElementById(footerId).offsetHeight;
			//ウィンドウの高さ
			if (window.innerHeight){
				var wh = window.innerHeight;
			}else if(document.documentElement && document.documentElement.clientHeight != 0){
				var wh = document.documentElement.clientHeight;
			}
			if(ft+fh<wh){
				document.getElementById(footerId).style.position = "relative";
				document.getElementById(footerId).style.top = (wh-fh-ft-1)+"px";
			}
		}
		
		//文字サイズ
		function checkFontSize(func){
		
			//判定要素の追加	
			var e = document.createElement("div");
			var s = document.createTextNode("S");
			e.appendChild(s);
			e.style.visibility="hidden"
			e.style.position="absolute"
			e.style.top="0"
			document.body.appendChild(e);
			var defHeight = e.offsetHeight;
			
			//判定関数
			function checkBoxSize(){
				if(defHeight != e.offsetHeight){
					func();
					defHeight= e.offsetHeight;
				}
			}
			setInterval(checkBoxSize,1000)
		}
		
		//イベントリスナー
		function addEvent(elm,listener,fn){
			try{
				elm.addEventListener(listener,fn,false);
			}catch(e){
				elm.attachEvent("on"+listener,fn);
			}
		}
	
		addEvent(window,"load",footerFixed);
		addEvent(window,"load",function(){
			checkFontSize(footerFixed);
		});
		addEvent(window,"resize",footerFixed);
		
	}
  </script>
  
</body>
</html>