<%@ include file="/common/webtag.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>中華都市更新全國總會—『三老一新』老人、老屋、老梗(智慧)進行事業第二春～『自宅的更新』</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<!-- Start WOWSlider.com HEAD section --> <!-- add to the <head> of your page -->
	<link rel="stylesheet" type="text/css" href="engine1/style.css" />
	<script type="text/javascript" src="engine1/jquery.js"></script>
	<!-- End WOWSlider.com HEAD section -->




</head>

<script src="scripts/jquery.cookie.js"></script>

<style type="text/css">
<!--
.style1 {font-size: 10px}
-->
</style>

<body>
<div id="main">


   <div class="header">
   <div class="block_header">
            <div class="logo"><a href="index.html"><img src="image/index_pic_01.gif" width="374"  height="102" border="0" alt="logo" /></a></div>
            <div class="ad"><a href="#"><img src="image/blank.gif" width="450"  height="51" border="0" alt="logo" /></a></div>
           
           <div class="login">
  <div>
  	<span class="style1"><span id="username"/></span>
  <div id="loginPanel">  
    <a href="userLogin.do"><img src="images/slogin.png"  border="0" alt="logo" /></a></div>
  </div>
  <div id="logoutPanel">
   <a href="userLogout.do"><img src="images/slogout.png"  border="0" alt="logout" /></a>
  </div>
</div>
           
            
       <div style="float: right; position: absolute; width: 1089px;">
       
        
        
        <div class="menu_down">
          <ul>
           <li><a href="about.html" ><span class="onclick">有關總會 </span></a></li>                                
            <li><a href="news.html"><span>圖解都更</span></a></li>
            <li><a href="calendar.html"><span>都更課程</span></a></li>
            <li><a href="service.html"><span>都更服務</span></a></li>
            <li><a href="info.html" ><span>總會活動</span></a></li>                                
            <li><a href="contact.do"><span>聯絡我們</span></a></li>
           
           
          
        </ul>
        </div>
     </div>
     
  
</div>

<div id="gallery_pic">

<div id="slide_box"> 
  <img src="image/about_bg_02.gif" width="261" height="89" /></div>
<div id="right_ad"><img src="image/about_bg_04.gif" width="727" height="89" /></div>
  
  
  
 
  
 <div id="left_about_box"  >


<div id="left_menu"  >
<img src="image/about_bg_09.png" width="171" height="59" />

<ul>
<li><a href="about.html">都更總會成立宗旨</a></li>
<li><a href="about2.html">理事長的話</a></li>
<li><a href="about3.html">現任理監事名單</a></li>
<li><a href="about4.html">總會章程</a></li>
<li><a href="about5.html">會歌"更美好的家"</a></li>
<li><a href="about6.html">總會最新消息</a></li>

</ul>
</div>



<div id="right_content"  >
<h1>最新消息
  <hr /></h1>

<div id="right_table" >
<table class="news_table" width="660" >
  <tbody>
  	
    <tr>
      <td width="63" bgcolor="#6c927f"><p2>編號</p2></td>
      <td width="444" bgcolor="#6c927f"><p2>文章標題</p2></td>
      <td width="137" bgcolor="#6c927f"><p2>日期</p2></td>
    </tr>
   
   <c:set var="count" value="1" /> 
   <ww:set name="news" value="%{getBulletinByTopList(${bulletinId},10000000)}"/>  
   <ww:iterator value="news">
    <tr>
      <td>${count}</td>
      <td><a href="newsDetail.do?id=${id}&bulletinId=${bulletinId}">${subject}</a></td>
      <td><span2>${bulletinDate}</span2></td>
    </tr>
   <c:set var="count" value="${count+1}" />
   </ww:iterator> 
     
     
   </tbody>
</table>


<div class="page_no">

<table width="342" >
  <tbody>
   
  </tbody>
</table>
</div>


</div>

</div>



 </div>
 
 
 


 
</div>
<div class="clear"></div>

<div id="buttom">
    <img src="image/index_pic_27.gif" width="121" height="38" />
    <div class="menu_down2">
          <ul>
           <li><a href="about.html" ><span>有關總會 </span></a></li>                                
            <li><a href="news.html"><span>圖解都更</span></a></li>
            <li><a href="calendar.html"><span>都更課程</span></a></li>
            <li><a href="service.html"><span>都更服務</span></a></li>
            <li><a href="info.html" ><span>總會活動</span></a></li>                                
            <li><a href="contact.do"><span>聯絡我們</span></a></li>
           
           
          
        </ul>
        </div> 

<p>地址：10580台北市南京東路四段150號2樓  電話：02-25780880#233  傳真：02-25786600<br />

Copyright @ National Chinese Association for Urban Renewal <br />
IE8.0 & Firefox 3.0 以上版本瀏覽器</p>
 
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
