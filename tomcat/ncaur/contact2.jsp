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
	<link rel="stylesheet" type="text/css" href="engine3/style.css" />
	<script type="text/javascript" src="engine3/jquery.js"></script>
	<!-- End WOWSlider.com HEAD section -->


<link rel="stylesheet" type="text/css" href="css/validate.css" />
	<script src="scripts/jquery.js"></script>
	<script src="scripts/jquery.validate.js"></script>
	<script>
	$(function() {	
    $("#form1").validate();    
    $( "#cellphone" ).rules( "add", {
      required: true,
      digits:true 
     });
	});
	</script>

<style type="text/css">
.form_table {
	border: 0px solid #CCC; font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	margin:15px 30px 15px 30px;
} 

.form_table span {
	color:#FD0408;
	font-size: 13px;
	
} 

input[type="text"] {
  display: block;
  margin: 0;
  width: 80%;
  font-family: sans-serif;
 
  appearance: none;
  box-shadow: none;
  border-radius: none;
}


input[type="text"] {
  display: block;
  margin: 0;
  width: 80%;
  font-family: sans-serif;
 
  appearance: none;
  box-shadow: none;
  border-radius: none;
}



</style>


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
            <div class="ad"><a href="index.html"><img src="image/index_pic_04.gif" width="450"  height="51" border="0" alt="logo" /></a></div>


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
           <li><a href="about.html" ><span>有關總會 </span></a></li>                                
            <li><a href="news.html"><span>圖解都更</span></a></li>
            <li><a href="calendar.html"><span>都更課程</span></a></li>
            <li><a href="service.html"><span>都更服務</span></a></li>
            <li><a href="info.html" ><span>總會活動</span></a></li>                                
            <li><a href="contact.do"><span class="onclick">聯絡我們</span></a></li>
           
           
          
        </ul>
        </div>
     </div>
     
  
</div>

<div id="gallery_pic">

<div id="slide_box"> 
  <img src="image/contact.jpg" width="261" height="89" /></div>
<div id="right_ad"><img src="image/about_bg_04.gif" width="727" height="89" /></div>
  
  
  
 
  
 <div id="left_about_box"  >


<div id="left_menu"  >
<img src="image/contact_bg_09.png" width="171" height="59" />

<ul>
<li><a href="contact.do">加入會員</a></li>
<li><a href="contact2.html">專業諮詢</a></li>
<li><a href="info5.do">會員資訊專區</a></li>



</ul>
</div>


<ww:if test="${type.id != null}">
	<c:set var="id" value="${type.id}" />
</ww:if>	
<ww:else>
	<c:set var="id" value="21" />
</ww:else>	


<ww:set name="qatype" value="%{getAppPropertyById(${id})}"/>
	
	



<div id="right_contact"  >
<h1>專業諮詢<hr class="style5" ></h1>

<form id="form1" name="form1" action="addPerRefer.do" method="post">
<input type="hidden" name="perRefer.qatypeId" value="${qatype.id}"/>	
<table width="600" border="0" class="form_table">
  <tbody>
    <tr>
      <td height="337" align="center" valign="middle" bgcolor="#F7F7F7"><table width="444" height="302" border="0" cellpadding="3" cellspacing="3">
        <tbody>
        	
        	<tr>
            <td width="102"></td>
            <td width="321">${qatype.valueTw}</td>
          </tr>
          
          <tr>
            <td width="102">姓名：</td>
            <td width="321"><input type="text" name="perRefer.name" id="name" required/></td>
          </tr>
          <tr>
            <td>聯絡電話：</td>
            <td><input type="text" name="perRefer.phone" id="phone" required></td>
          </tr>
          <tr>
            <td>行動電話：</td>
            <td><input type="text" name="perRefer.cellphone" id="cellphone" required></td>
          </tr>
          <tr>
            <td>Email:</td>
            <td><input type="text" name="perRefer.email" id="email" class="text required email"></td>
          </tr>
          <tr>
            <td valign="top">備註：</td>
            <td><textarea name="perRefer.memo" id="memo" rows="5" cols="35" required></textarea></td>
          </tr>
          <tr>
            <td valign="top">&nbsp;</td>
            <td>
             <input class="submit" type="submit" value="送出資料" id="mysubmit">  	
            </td>
          </tr>
        </tbody>
      </table></td>
    </tr>
  </tbody>
</table>
    
</form>    
  



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