<%@ include file="/common/webtag.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="msvalidate.01" content="FF9D6A89A41F4BCE78CF4FBB1477BC3B" />
<title>中華都市更新全國總會—『三老一新』老人、老屋、老梗(智慧)進行事業第二春～『自宅的更新』</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
<meta name="keywords" content="都更總會,都市更新,老屋換新屋,都市更新平台,律師,建築師,估價師,都更規劃,台北市都更,新北市都更,權利變換,圖解都更,都更諮詢,都更服務">
<meta name="description" content="中華都市更新全國總會囊括都市更新專業領域：律師、建築師、估價師、地政士、會計師、不動產經紀人、都更規劃公司等。皆秉持服務大眾、回饋社會，辦理各項都市更新相關之教育訓練課程、座談會、講座等活動，充實住戶都市更新資訊,提供資詢服務，住戶能了解自身合理權益，主動關切生活環境、公共利益，增進推動都市更新效率。">
<meta name="copyright" content="中華都市更新全國總會">
<meta name="Author" content="中華都市更新全國總會">
<meta NAME="Creation-Date" content="01-june-2012 09:00:00">
<meta name="rating" content="general">
<meta name="robots" content="all">
<meta name="revisit-after" content="7 days">
<meta name="SPIDERS" content="all">
<meta name="WEBCRAWLERS" content="all">
<meta http-equiv="ImageToolBar" content="no">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="icon" type="image/x-icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="engine2/style.css" />
<script type="text/javascript" src="engine2/jquery.js"></script>
<script src="scripts/jquery.cookie.js"></script>

<style type="text/css">
<!--
.style1 {font-size: 10px}
-->
</style>
</head>

<body>

<div id="main">


<div class="header">
<div class="block_header">
<div class="logo"><a href="index.html"><img src="images/index_pic_01.gif" width="374"height="102" border="0" alt="logo" /></a></div>
<div class="ad"><a href="index.html"><img src="images/blank.gif" width="450"height="51" border="0" alt="logo" /></a></div>
<div class="login">

  <div ><span class="style1"><span id="username"/></span>
  <div id="loginPanel">  
    <a href="userLogin.do"><img src="images/slogin.png"  border="0" alt="logo" /></a></div>
  </div>
  <div id="logoutPanel">
   <a href="userLogout.do"><img src="images/slogout.png"  border="0" alt="logout" /></a>
  </div>
</div>

<div style="float:left; position: absolute; width: 1024px;">
<div class="menu_down">
<ul>
<li><a href="about.html" ><span>有關總會 </span></a></li> 
<li><a href="news.html"><span>圖解都更</span></a></li>
<li><a href="webCourse.do?type.id=23&course1.id="><span>都更課程</span></a></li>
<li><a href="service.html"><span>都更服務</span></a></li>
<li><a href="info.html" ><span>總會活動</span></a></li>
<li><a href="contact.do"><span>聯絡我們</span></a></li>
</ul>
</div>
</div>
</div>
</div>

<div id="gallery_pic">

<div id="slide_box">

<div id="wowslider-container2">
<div class="ws_images">
	<ul>   
		<ww:set name="banners" value="%{getBolgByBlogClass(1)}"/> 	  
    <ww:iterator value="banners">       
		 <li>
		 	 <a href="#" onclick="goURL('${link}');">
		   	<img src="upload/bolg/${id}/${myfile.fileName}" alt="" title="" id="wows2_0"/>
		 	 </a>
		 </li>
	    
	   
	    
	   <!--
	    <li><a href="${link}" target="_blank"><img src="upload/bolg/${id}/${myfile.fileName}" alt="" title="" id="wows2_0"/></a></li>
	  
	   --> 
	  
	  </ww:iterator>
	</ul>
</div>

<div class="ws_shadow"></div>
</div>	
<script type="text/javascript" src="engine2/wowslider.js"></script>
<script type="text/javascript" src="engine2/script.js"></script>

</div>

 <div id="left_box">

<!--最新消息-->
<div id="news_box">
<div id="pic_box"><img src="images/index_pic_10.gif" width="289" height="43" /></div>

  
<ul>  
	<ww:set name="news" value="%{getBulletinByTopList(4,4)}"/>  
   <ww:iterator value="news">  
    <li>${bulletinDate} <a href="newsDetail.do?id=${id}&bulletinId=4">${subject}</a></li>
   </ww:iterator>
</ul>
 

<a href="news.do?bulletinId=4" style="FLOAT:right; margin-right: 30PX ; color:#999999;">more</a>
</div>


<!--都更訊息-->
<div id="news_box">
	
<div id="pic_box"><img src="images/index_pic_12.gif" width="289" height="43" /></div>

<ul>
	<ww:set name="news" value="%{getBulletinByTopList(5,4)}"/>  
   <ww:iterator value="news">  
     <li>${bulletinDate} <a href="newsDetail.do?id=${id}&bulletinId=5">${subject}</a></li>
  </ww:iterator>
</ul>

<a href="news.do?bulletinId=5" style="FLOAT:right; margin-right: 30PX ; color:#999999;">more</a>
</div>

<!--官方公告-->
<div id="news_box">
<div id="pic_box"><img src="images/index_pic_14.gif" width="287" height="43" /></div>

<ul>
	<ww:set name="news" value="%{getBulletinByTopList(6,4)}"/>  
   <ww:iterator value="news">
     <li>${bulletinDate} <a href="newsDetail.do?id=${id}&bulletinId=6">${subject}</a></li>
   </ww:iterator>
</ul>
<a href="news.do?bulletinId=6" style="FLOAT:right; margin-right: 30PX ; color:#999999;">more</a>
</div>

 </div>

<div id="map"  >
 <!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
	<div id="wowslider-container1">
	<div class="ws_images"><ul>
		
	<ww:set name="sliders" value="%{getBolgByBlogClass(2)}"/> 
	<ww:iterator value="sliders">  		  
		<li><img src="upload/bolg/${id}/${myfile.fileName}" alt="${title}" title="${title}" id="wows1_0"/>${name}</li>
	</ww:iterator>			
		
		</ul></div>
	<div class="ws_thumbs">
<div>
	
	<ww:set name="sliders" value="%{getBolgByBlogClass(2)}"/> 	  
  <ww:iterator value="sliders">  
		<a href="#" title="${title} ${name}"><img src="upload/bolg/${id}/${photo.fileName}" alt="" /></a>
	</ww:iterator>		
		
			</div>
</div>

	<div class="ws_shadow"></div>
	</div>	
	<script type="text/javascript" src="engine1/wowslider.js"></script>
	<script type="text/javascript" src="engine1/script.js"></script>
	<!-- End WOWSlider.com BODY section -->


</div>

<div id="right_content_index">
 	
<ww:set name="news" value="%{getBulletinByTopList(7,4)}"/>  
<ww:iterator value="news">	 	
  ${description}
</ww:iterator>

</div>

</div>

<div class="clear"></div>

<div style="margin-top:30px; text-align:right;">
<embed type="application/x-shockwave-flash" src="http://i212.photobucket.com/albums/cc274/eting1/dewplayer.swf" width="200" height="20" flashvars="son=http://www.ncaur.org/NCAURs1.mp3&amp;autostart=1&amp;bgcolor=FFFFFF"></embed>
</div>

<!-- Footer --> 
<!-- // #include virtual="footer.html" -->


<div id="buttom">
<div class="navi">
<div class="navBox">
<h3>有關總會</h3>
<ul>
<li><a href="about.html">都更總會成立宗旨</a></li>
<li> <a href="about2.html">理事長的話</a></li>
<li><a href="about3.html">現任理監事名單</a></li>
<li><a href="about4.html">總會章程</a></li>
<li><a href="about5.html">會歌"更美好的家"</a></li>
<li><a href="about6.html">總會最新消息</a></li>
</ul>
</div>
<div class="navBox">
<h3>圖解都更</h3>
<ul>
<li><a href="news.html">圖解都更</a></li>
</ul>
</div>
<div class="navBox">
<h3>都更課程</h3>
<ul>
<li><a href="calendar.html">都更種子班</a></li>
<li> <a href="calendar2.html">大師有約</a></li>
<li><a href="calendar3.html">都更專題班</a></li>
<li><a href="calendar4.html">其他課程</a></li>
<li><a href="calendar5.html">都更訊息</a></li>
</ul>
</div>
<div class="navBox">
<h3>都更服務</h3>
<ul>
<li><a href="service.html">都更協商</a></li>
<li><a href="service2.html">都更案例</a></li>
<li><a href="service3.html">都市更新會</a></li>
<li><a href="service5.html">白話都更</a></li>
<li><a href="service4.html">官方公告</a></li>
<li><a href="service6.html">相關連結</a></li>
</ul>
</div>
<div class="navBox">
<h3>總會活動</h3>
<ul>
<li><a href="info.html">總會活動</a></li>
<li> <a href="info2.html">會員大會</a></li>
<li><a href="info3.html">新春團拜</a></li>
<li><a href="info4.html">其他活動</a></li>
<li><a href="info5.html">會員資訊專區</a></li>
</ul>
</div>
<div class="navBox">
<h3>聯絡我們</h3>
<ul>
<li><a href="contact.do">加入會員</a></li>
<li> <a href="contact2.html">專業諮詢</a></li>
<li><a href="contact3.html">都更Q&A</a></li>
</ul>
</div>
</div> 
<div class="footer-info">
<div class="f-logo">
<img src="images/index_pic_27.gif" width="121" height="38" />
</div>
<div class="f-txt">
<p>地址：10580台北市南京東路四段150號2樓電話：02-25780880#233傳真：02-25786600<br />

Copyright @ National Chinese Association for Urban Renewal <br />
IE8.0 & Firefox 3.0 以上版本瀏覽器</p>
</div>
</div>
</div>
</div>


</body>
</html>
<script>
$( "#buttom" ).load( "footer.html" );
</script>

<script>
    
	pageInit();
	
    function pageInit()
    {    	
	   if (typeof $.cookie('memberId') != 'undefined')
    	{    		
    		$('#username').html($.cookie('membername')+'，歡迎您！');
    		$('#loginPanel').hide();
    	}else{
    		$('#logoutPanel').hide();    		
    	}
    }
    
    function goURL(u){
    	window.location=u;
    }
    
</script>
