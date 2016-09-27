<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>  <c:out value="${website.title}"/> </title>
<link rel="stylesheet" type="text/css" href="inc/css/base.css">
<!--<script type="text/javascript" src="inc/js/jquery-1.4.2.js"></script>-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="inc/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="inc/plug/menu/droplinemenu.js"></script>
<link rel="stylesheet" type="text/css" href="inc/plug/menu/droplinebar.css">
<script type="text/javascript" src="inc/js/base.js"></script>
<style type="text/css">


</style>
</head>

<body class="index">
<div id="wrapper">
    <div id="header">
      <div class="navBar">
        	<input type="text" class="search_txt"><a href="#" class="btn1">搜尋</a>
          |<a href="javascript:window.external.AddFavorite('http://www.truth.org.tw/','基督教台北真道教會')" class="link1">加入最愛</a>|<a href="#" class="link1">簡體</a>|<a href="admin.do" class="link1" target="_blank">登入</a></div>
          <a href="index.do" class="logo"><b>真道教會</b></a>
        <div class="banner1"><img src="inc/img/banner/banner_home.gif" width="575" height="86"></div>
    </div><!--header-->
    
    
    
    <ul id="dropline">
    
    
    
    
<!-- 
 ************************ 
 * 主選單 
 ************************
-->
<ww:set name="topSubMenu" />
<c:set var="count" value="0" />    
<ww:iterator value="menuList">   
        <c:set var="isMenuRoot" value="" />        
        <ww:set name="menu" value="%{getMenuById(id)}"/>  
        <ww:if test="${count} == 0">
      	  <c:set var="isMenuRoot" value="first" /> 
        </ww:if>
        <ww:else>
          <c:set var="isMenuRoot" value="" /> 
        </ww:else>      
        
 
                   
           <ww:if test="isBulletinSubMenuByMenu(id) == true">
               <ww:set name="topSubMenu" value="%{getTopSubMenuByMenu(id)}"/>
               <li class="<c:out value="${isMenuRoot}"/>" ><a href="${topSubMenu.url}" class="sub"><b><span><ww:property value="name"/> </span></b><!--[if gte IE 7]><!--></a><!--<![endif]-->   
           </ww:if>
           <ww:else>
               <li class="<c:out value="${isMenuRoot}"/>" ><a href="webContent.do?menuId=<ww:property value="id"/>" class="sub"><b><span><ww:property value="name"/> </span></b><!--[if gte IE 7]><!--></a><!--<![endif]-->            
           </ww:else>
              
           <%-- 判斷是否有公告          --%>
        
            
<!-- 
 ************************ 
 * 次選單 
 ************************
-->          
            <div>
                <ul>
                    <ww:set name="subMenuList" value="%{getSubMenuListByMenu(id)}"/>  
                    <ww:iterator value="subMenuList">
                         
                     <%-- 判斷是否有公告          --%>
                     <ww:if test="url != null && url!=''">
      	                 <li><a href="${url}" target="${linkType.valueUs}"><ww:property value="name"/></a></li> 
                     </ww:if>
                     <ww:else>
                         <li><a href="webContent.do?menuId=${menu.id}&subMenuId=${id}"><ww:property value="name"/></a></li>
                     </ww:else> 
                         
                    </ww:iterator>
                </ul>
            </div>
           </td></tr></table></a>
          
            
            
            
        </li>
</ww:iterator>     
    </ul>
    <div id="pageBody">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="cont_tb">
	<tr>
	<td class="td_3_l">
    	<div class="share clearfix">
        	<img src="inc/img/pageImg/share.gif">
<!-- 
 ************************ 
 * witness share 
 ************************
-->
<ww:set name="witness" value="%{getBolgById(7)}"/>
            <c:out value="${witness.name}" escapeXml="false"/>
            <a href="#" class="link2">&lt;&lt; 詳全文 &gt;&gt;</a>        
        </div>

<!-- 
 ************************ 
 * 主日敬拜場所 
 ************************
-->
<ww:set name="worshipPlace" value="%{getBolgById(22)}"/>
            <c:out value="${worshipPlace.content}" escapeXml="false"/>        
        
           
            
<!-- 
 ************************ 
 * 熱門下載
 ************************
-->
<ww:set name="newsDownload" value="%{getBlogClassById(11)}"/>
<ww:set name="newsDownloadList" value="%{getBolgByBlogClass(11)}"/>             
        <div class="box2">
        	<div class="hd"><b>熱門下載</b></div>
            <dl class="list2">
            
           <c:set var="count" value="1" />
           <ww:iterator value="newsDownloadList"> 
                <dt class="no<c:out value="${count}"/>"><a href="#" class="pdf"><b><ww:property value="name"/></b></a></dt>
            <c:set var="count" value="${count+1}" />
            </ww:iterator> 
            
            </dl>
        	<div class="ft"><b><a href="content1.do" class="moreInfo">更多下載</a></b></div>
        </div>
        
        
		</td>
	<td class="td_3_m">
	
	
<!-- 
 ************************ 
 * 首頁的Banner 
 ************************
--> 
<ww:set name="bannerList" value="%{getBolgByBlogClass(12)}"/> 	
       	  <div id="slideshow" class="banner">
            	<div id="nav"></div>  
            	<ww:iterator value="bannerList"> 
           	   
            	   <img src="upload/bolg/<ww:property value="id"/>/<ww:property value="photo.fileName"/>" width="427" height="148">  

        	    </ww:iterator>   
        	</div>
        	
        	
        	
        	<div class="box2">
        	<div class="hd"><b>真道最新消息</b></div>
            <dl class="list1">
            
<!-- 
 ************************ 
 * 真道最新消息 
 ************************
--> 
<ww:set name="news" value="%{getBlogClassById(5)}"/> 
<ww:set name="newsBolgList" value="%{getBolgByBlogClass(5)}"/>    

           <ww:iterator value="newsBolgList">
                <dt><a href="#" class="link2"><ww:property value="name"/></a> </dt>
           </ww:iterator>
            </dl>
        	<div class="ft"><b><a href="#" class="moreInfo">更多消息</a></b></div>
        </div>

<!-- 
 ************************ 
 * 本週經句背誦 
 ************************
-->
<ww:set name="bibleClass" value="%{getBlogClassById(7)}"/> 
<ww:set name="bible" value="%{getBolgById(15)}"/> 
        
        	<div class="box1">
                <div class="hd"><b>本週經句背誦</b></div>
                <div class="ft"><div class="scripture">
                    <c:out value="${bible.content}" escapeXml="false"/>                    
                </div>
                </div>
            </div>
            
        </td>
	<td class="td_3_r">
    
<!-- 
 ************************ 
 * 本週主日信息收看 
 ************************
-->     
<ww:set name="topBulletin" value="%{getTopBulletin()}"/> 
    
    	<div class="box1">
        	<div class="hd"><b>本週主日信息收看</b></div>
            <div class="boxcont">
                <a href="bulletinDetail.do?bulletinId=${topBulletin.id}" class="video_player" target="_blank">
                 <img src="<fmt:message key="bulletin.uploadFrontcover.relativeUrl"/>/${topBulletin.id}/${topBulletin.frontcover.fileName}" width="182" height="139">
                </a>
            </div>
        	<div class="ft"><b><a href="#" class="link2"><span class="tit1">${topBulletin.speaker}</span>：${topBulletin.subject}</a><a href="#" class="link2"></a></b></div>
        </div>
        
        
        
<!-- 
 ************************ 
 * 全華音樂-華人的讚美敬拜 
 ************************
-->  
<ww:set name="music1" value="%{getBolgById(17)}"/>    
<ww:set name="music2" value="%{getBolgById(18)}"/>  
        
    	<div class="box2">
        	<div class="hd"><b>全華出版品</b></div>
            <div class="music_cont">
            	<p class="clearfix">
                	<img src="upload/bolg/<c:out value="${music1.id}" escapeXml="false"/>/<c:out value="${music1.photo.fileName}" escapeXml="false"/>" class="imgRight" width="80"  height="106">


                    	
<c:out value="${music1.content}" escapeXml="false"/>      
                    </p>
            	<p class="clearfix">
                    <img src="upload/bolg/<c:out value="${music2.id}" escapeXml="false"/>/<c:out value="${music2.photo.fileName}" escapeXml="false"/>" class="imgLeft"  width="80"  height="106">  
                    <c:out value="${music2.content}" escapeXml="false"/>  
                </p>
            </div>
        	<div class="ft"><b><a href="#" class="moreInfo">華人的讚美敬拜</a></b></div>
        </div>
		</td></tr>
		</table>
		
    </div><!--pageBody-->
	
	
	
    <div id="footer">
        <c:out value="${website.footer}" escapeXml="false"/>
    </div><!--footer-->
</div><!--wrapper-->
</body>
</html>
