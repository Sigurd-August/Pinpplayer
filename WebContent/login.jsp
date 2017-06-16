<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<title>Pinp - Pinp Is Not a Player</title>
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript">
			function check(){
				var name = document.getElementById('name');
				var password = document.getElementById('password');
				if(name.value == ""){
					alert("User name can not be empty!");
					name.focus();
					return false;
				}
				if(password.value == ""){
					alert("Password can not be empty!");
					password.focus();
					return false;
				}
			}
		</script>
<script type="text/javascript">
			function check2(){
				var rname = document.getElementById('rname');
				var rpassword = document.getElementById('rpassword');
				var rpassword2 = document.getElementById('rpassword2');
				if(rname.value == ""){
					alert("User name can not be empty!");
					name.focus();
					return false;
				}
				if(rpassword.value == ""){
					alert("Password can not be empty!");
					password.focus();
					return false;
				}
				if(rpassword2.value != rpassword.value){
					alert("Repeat password and password should keep consistent!");
					return false;
				}			
			}
		</script>
</head>

<body>
<div class="cotn_principal">
 <center class="video">
	 <section id="rt-showcase-surround">
		<div id="rt-showcase" class="slider-container rt-overlay-dark">
			<div class="rt-container slider-container">
				<div class="rt-grid-12 rt-alpha rt-omega">
					
					<link rel="stylesheet" href="css/lb.css">
	
					<div class="csslider1 autoplay">
						<input name="cs_anchor1" autocomplete="off" id="cs_slide1_0" type="radio" class="cs_anchor slide" >
						<input name="cs_anchor1" autocomplete="off" id="cs_slide1_1" type="radio" class="cs_anchor slide" >
						<input name="cs_anchor1" autocomplete="off" id="cs_slide1_2" type="radio" class="cs_anchor slide" >
						<input name="cs_anchor1" autocomplete="off" id="cs_play1" type="radio" class="cs_anchor" checked>
						<input name="cs_anchor1" autocomplete="off" id="cs_pause1" type="radio" class="cs_anchor" >
						<ul>
							<div style="width: 100%; visibility: hidden; font-size: 0px; line-height: 0;">
								<img src="images/1.jpg" style="width: 100%;">
							</div>
							<li class="num0 img">
								<img src="images/1.jpg" alt="Clouds" title="Clouds" />
							</li>
							<li class="num1 img">
								<img src="images/2.jpg" alt="Typewriter" title="Typewriter" />
							</li>
							<li class="num2 img">
								<img src="images/3.jpg" alt="Bicycle" title="Bicycle" />
							</li>
						
						</ul>
						<div class="cs_description">
							<label class="num0">
								<span class="cs_title"><span class="cs_wrapper">奥特曼简史</span></span>
								
							</label>
							<label class="num1">
								<span class="cs_title"><span class="cs_wrapper">那些美的惊人的古风歌词</span></span>
								
							</label>
							<label class="num2">
								<span class="cs_title"><span class="cs_wrapper">2016西安不插电</span></span>
								
							</label>
						</div> 
						
						<div class="cs_arrowprev">
							<label class="num0" for="cs_slide1_0"></label>
							<label class="num1" for="cs_slide1_1"></label>
							<label class="num2" for="cs_slide1_2"></label>
						</div>
						<div class="cs_arrownext">
							<label class="num0" for="cs_slide1_0"></label>
							<label class="num1" for="cs_slide1_1"></label>
							<label class="num2" for="cs_slide1_2"></label>
						</div>
						
						<div class="cs_bullets">
							<label class="num0" for="cs_slide1_0">
								<span class="cs_point"></span>
								<span class="cs_thumb"><img src="images/small/1.jpg" width="100px" height="50px" alt="Clouds" title="Clouds" /></span>
							</label>
							<label class="num1" for="cs_slide1_1">
								<span class="cs_point"></span>
								<span class="cs_thumb"><img src="images/small/2.jpg" width="100px" height="50px" alt="Typewriter" title="Typewriter" /></span>
							</label>
							<label class="num2" for="cs_slide1_2">
								<span class="cs_point"></span>
								<span class="cs_thumb"><img src="images/small/3.jpg" width="100px" height="50px" alt="Bicycle" title="Bicycle" /></span>
							</label>
						</div>
						
					</div>
	
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</section> 
</center>
  <img class="logo" src="./images/PINP_4.png"></img>
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>LOGIN</h2>
            <p>tape here if you have an account</p>
            <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>SIGN UP</h2>
            <p>Or not</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="./images/po.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="./images/po.jpg" alt="" /> </div>
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">←</i></a>
          <h2>LOGIN</h2>
          <form action="login" method="post">
          <%
			String name = "";
			if (request.getAttribute("userName") != null) {
			name = (String) request.getAttribute("userName");
			}
		  %>
          <input type="text" name="name" id="name" placeholder="ID" />
          <input type="password" name="password" id="password" placeholder="Password" />
          <%
								if (request.getAttribute("message") != null) {
							%> <%=request.getAttribute("message")%> <%
								}
							%>
          <button class="btn_login" onClick="return check()">LOGIN</button>
          </form>
        </div>
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">←</i></a>
          <h2>SIGN UP</h2>
          <form action="register" method="post">
          <table>
          <tr><td>
          <input type="text" name="rname" id="rname" placeholder="User" /></td></tr>
          <tr><td>
          <input type="text" name="email" id="email" placeholder="Email" /></td></tr>
          <tr><td>
          <input type="password" name="rpassword" id="rpassword" placeholder="Password" /></td></tr>
          <tr><td>
          <input type="password" name="rpassword2" id="rpassword2" placeholder="Confirm Password" /></td></tr>
          </table>
          <button class="btn_sign_up" onClick="return check2()">SIGN UP</button>  
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="js/login.js"></script>

</body>
</html>
