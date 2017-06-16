<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<title>Pinp - Pinp Is Not a Player</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/switchover/switchover.css">

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
	<!-- <section id="rt-showcase-surround">
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
	</section> -->
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
<div class="box">

	<div class="list">
		<ul>
			<li class="p7"><a href="#"><img src="./css/switchover/1.png" alt="" /></a></li>
			<li class="p6"><a href="#"><img src="./css/switchover/2.png" alt="" /></a></li>
			<li class="p5"><a href="#"><img src="./css/switchover/3.png" alt="" /></a></li>
			<li class="p4"><a href="#"><img src="./css/switchover/44.jpg" alt="" /></a></li>
			<li class="p3"><a href="#"><img src="./css/switchover/55.jpg" alt="" /></a></li>
			<li class="p2"><a href="#"><img src="./css/switchover/66.jpg" alt="" /></a></li>
			<li class="p1"><a href="#"><img src="./css/switchover/77.jpg" alt="" /></a></li>
		</ul>
	</div>
	
	<a href="javascript:;" class="prev btn"><</a>
	<a href="javascript:;" class="next btn">></a>

	<div class="buttons">
		<a href="javascript:;"><span class="blue"></span></a>
		<a href="javascript:;"><span></span></a>
		<a href="javascript:;"><span></span></a>
		<a href="javascript:;"><span></span></a>
		<a href="javascript:;"><span></span></a>
		<a href="javascript:;"><span></span></a>
		<a href="javascript:;"><span></span></a>
	</div>
</div>
<script src="js/login.js"></script>

<script type="text/javascript" src="./js/switchover/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
var $a=$(".buttons a");
var $s=$(".buttons span");
var cArr=["p7","p6","p5","p4","p3","p2","p1"];
var index=0;
$(".next").click(
	function(){
	nextimg();
	}
)
$(".prev").click(
	function(){
	previmg();
	}
)
//上一张
function previmg(){
	cArr.unshift(cArr[6]);
	cArr.pop();
	//i是元素的索引，从0开始
	//e为当前处理的元素
	//each循环，当前处理的元素移除所有的class，然后添加数组索引i的class
	$("li").each(function(i,e){
		$(e).removeClass().addClass(cArr[i]);
	})
	index--;
	if (index<0) {
		index=6;
	}
	show();
}

//下一张
function nextimg(){
	cArr.push(cArr[0]);
	cArr.shift();
	$("li").each(function(i,e){
		$(e).removeClass().addClass(cArr[i]);
	})
	index++;
	if (index>6) {
		index=0;
	}
	show();
}

//通过底下按钮点击切换
$a.each(function(){
	$(this).click(function(){
		var myindex=$(this).index();
		var b=myindex-index;
		if(b==0){
			return;
		}
		else if(b>0) {
			/*
			 * splice(0,b)的意思是从索引0开始,取出数量为b的数组
			 * 因为每次点击之后数组都被改变了,所以当前显示的这个照片的索引才是0
			 * 所以取出从索引0到b的数组,就是从原本的这个照片到需要点击的照片的数组
			 * 这时候原本的数组也将这部分数组进行移除了
			 * 再把移除的数组添加的原本的数组的后面
			 */
			var newarr=cArr.splice(0,b);
			cArr=$.merge(cArr,newarr);
			$("li").each(function(i,e){
			$(e).removeClass().addClass(cArr[i]);
			})
			index=myindex;
			show();
		}
		else if(b<0){
			/*
			 * 因为b<0,所以取数组的时候是倒序来取的,也就是说我们可以先把数组的顺序颠倒一下
			 * 而b现在是负值,所以取出索引0到-b即为需要取出的数组
			 * 也就是从原本的照片到需要点击的照片的数组
			 * 然后将原本的数组跟取出的数组进行拼接
			 * 再次倒序,使原本的倒序变为正序
			 */
			cArr.reverse();
			var oldarr=cArr.splice(0,-b)
			cArr=$.merge(cArr,oldarr);
			cArr.reverse();
			$("li").each(function(i,e){
			$(e).removeClass().addClass(cArr[i]);
			})
			index=myindex;
			show();
		}
	})
})

//改变底下按钮的背景色
function show(){
		$($s).eq(index).addClass("blue").parent().siblings().children().removeClass("blue");
}

//点击class为p2的元素触发上一张照片的函数
$(document).on("click",".p2",function(){
	previmg();
	return false;//返回一个false值，让a标签不跳转
});

//点击class为p4的元素触发下一张照片的函数
$(document).on("click",".p4",function(){
	nextimg();
	return false;
});

//			鼠标移入box时清除定时器
$(".box").mouseover(function(){
	clearInterval(timer);
})

//			鼠标移出box时开始定时器
$(".box").mouseleave(function(){
	timer=setInterval(nextimg,4000);
})

//			进入页面自动开始定时器
timer=setInterval(nextimg,4000);
</script>

<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</body>
</html>
