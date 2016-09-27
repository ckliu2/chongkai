<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> ${website.title}</title>
<link rel="stylesheet" type="text/css" href="inc/css/base.css">
<!--<script type="text/javascript" src="inc/js/jquery-1.4.2.js"></script>-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="inc/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="inc/plug/menu/droplinemenu.js"></script>
<link rel="stylesheet" type="text/css" href="/inc/plug/menu/droplinebar.css">
<script type="text/javascript" src="inc/js/base.js"></script>
<style type="text/css">


</style>
</head>

<body class="index">
<div id="wrapper">
    <div id="header">
      <div class="navBar">
        	<input type="text" class="search_txt"><a href="html/under_construction.html" class="btn1">搜尋</a>
          |<a href="javascript:window.external.AddFavorite('http://www.truth.org.tw/','基督教台北真道教會')" class="link1">加入最愛</a>|<a href="#" class="link1">簡體</a>|<a href="admin.do" class="link1" target="_blank">登入</a></div>
          <a href="index.html" class="logo"><b>真道教會</b></a>
        <div class="banner1"><img src="inc/img/banner/banner_home.gif" width="575" height="86"></div>
    </div><!--header-->
    
    
    
<!-- 
 ************************ 
 * 主選單 
 ************************
--> 
<ul id="dropline">
  
     <ww:set name="topSubMenu" />
     <c:set var="count" value="0" />    
     <ww:iterator value="menuList">  
  
        <li class="first">        
        <a href="webContent.do?menuId=<c:out value="${id}"/>" class="sub"><b><span>  ${name} </span></b><!--[if gte IE 7]><!--></a><!--<![endif]--> 
            
            <!--[if lte IE 6]><table><tr><td><![endif]-->            
            <div>
                <ul>
                    <!-- 
                     ************************ 
                     * 次選單 
                     ************************
                    --> 
                     <ww:set name="subMenuList" value="%{getSubMenuListByMenu(id)}"/>  
                     <ww:iterator value="subMenuList">    
                           <ww:if test="${fn:indexOf(url,'Bulletin.do')} == 0">
                               <li><a href="${url}">${name}</a></li>                    
                           </ww:if>
                           <ww:else>
                               <li><a href="webContent.do?menuId=${menu.id}&subMenuId=${id}">${name}</a></li>
                           </ww:else>      
                     </ww:iterator>                      
                </ul>
            </div>
            <!--[if lte IE 6]></td></tr></table></a><![endif]--> 
        </li>
     </ww:iterator>      
</ul>
    
    
   
    
    <div id="pageBody">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="cont_tb">
	<tr>
	<td class="td_3_l">
    	<div class="share clearfix">

             <!-- 
              ************************ 
              * 見證分享
              ************************
             -->
            <ww:set name="witness" value="%{getBolgById(7)}"/>
            <c:out value="${witness.content}" escapeXml="false"/>


      </div>
		
		<div class="box2">
        	<div class="hd"><b>真道最新消息</b></div>
            <dl class="list1">
            
                <!-- 
                 ************************ 
                 * 真道最新消息 
                 ************************
                --> 
                <c:set var="newsBolgListCount" value="1" />
                <ww:set name="newsBolgList" value="%{getBulletinByTopList(34,7)}"/>    
                <ww:iterator value="newsBolgList">
                    <ww:if test="${fn:length(newsBolgList)} == ${newsBolgListCount}">
                      <dd><a href="bulletinDetail.do?bulletinId=${id}" class="link2">${subject}(${bulletinDate})</a> </dd>
                    </ww:if>
                    <ww:else>
                       <dt><a href="bulletinDetail.do?bulletinId=${id}" class="link2">${subject}(${bulletinDate})</a> </dt>
                    </ww:else>                   
                   <c:set var="newsBolgListCount" value="${newsBolgListCount+1}" />
                </ww:iterator>     
            </dl>
        	<div class="ft"><b><a href="/webbase/Bulletin.do?menuId=2&bulletinTypeId=34" class="moreInfo">更多消息</a></b></div>
        </div>
		
		
       <div class="box2">
        	<div class="hd"><b>熱門下載</b></div>
            <dl class="list2">
                <dt class="no1"><a href="/webbase/Bulletin.do?menuId=2&bulletinTypeId=21" class="pdf"><b>真道週報下載</b></a></dt>
                <dt class="no2"><a href="/webbase/Bulletin.do?menuId=2&bulletinTypeId=22" class="pdf"><b>講道大綱下載</b></a></dt>
                <dt class="no3"><a href="/webbase/Bulletin.do?menuId=3&bulletinTypeId=26" class="pdf"><b>小組教材4W下載</b></a></dt>
                <dd class="no4"><a href="/webbase/Bulletin.do?menuId=2&bulletinTypeId=36" class="pdf"><b>兒童週報信息</b></a></dd>
            </dl>
        	<div class="ft_s"><b>&nbsp;</b></div>
        </div>
        
        
		</td>
	<td class="td_3_m">
    
<!-- 
 ************************ 
 * 首頁的Banner 
 ************************
--> 

         <div id="slideshow" class="banner">
              <div id="nav"></div> 
              <ww:set name="bannerList" value="%{getBolgByBlogClass(12)}"/> 	  
                  <ww:iterator value="bannerList">                                      
                     <a href="${link}" target="${linkType.valueUs}"><img src="upload/bolg/${id}/${photo.fileName}" border="0" width="470" height="155" ></a>            
		         </ww:iterator>  
          </div>


<!-- 
 ************************ 
 * 全華音樂出版品 
 ************************
-->
        	  
<div class="box2">
          <div class="hd"><b>全華音樂出版品</b></div>
          <div class="music_cont">      
 
             <ww:set name="music1" value="%{getBolgById(17)}"/>  
             <c:out value="${music1.content}" escapeXml="false"/>   
           </div>
<div class="ft_s"><b>&nbsp;</b></div>  
</div>
		 
          <!--div class="ft"><b><a href="html/Publication.html" class="moreInfo">華人的讚美敬拜</a></b></div-->
        
		


 <ww:set name="bible" value="%{getBolgById(15)}"/>
            
            <div class="box1">
                <div class="hd"><b>本週經句背誦</b></div>
                <div class="ft">
                    <c:out value="${bible.content}" escapeXml="false"/> 
                </div>
            </div>
        </td>
	<td class="td_3_r">
    	<div class="box1">
        	<div class="hd"><b>主日信息線上收看</b></div>
            <div class="boxcont">
            
<!-- 
 ************************ 
 * 本週主日信息收看 
 ************************
-->     
<ww:set name="topBulletin" value="%{getTopBulletin()}"/> 

			
         
                
				<a href="bulletinDetail.do?bulletinId=${topBulletin.id}" class="video_player">
                <img src="<fmt:message key="bulletin.uploadFrontcover.relativeUrl"/>/${topBulletin.id}/${topBulletin.frontcover.fileName}" width="182" height="139">
                </a>
                
                </div>
        	<div class="ft"><b>
           
            <a href="bulletinDetail.do?bulletinId=${topBulletin.id}" class="link2"><span class="tit1">${topBulletin.speaker}</span>：${topBulletin.subject}</a>
           
        
            </b></div>
        </div>
       
       
       
    	<div class="box2">
          <div class="hd"><b>主日敬拜場所</b></div>
    	  <div class="boxcont">
                      <!-- 
                      ************************ 
                      * 主日敬拜場所 
                      ************************
                      -->
                      <ww:set name="worship" value="%{getBolgById(22)}"/> 
                      <c:out value="${worship.content}" escapeXml="false"/>  
  	    </div>
    	  <div class="ft"><b><a href="/webbase/webContent.do?menuId=1&subMenuId=3" class="moreInfo">更多聚會時間表</a></b></div>
  	  </div>
      
      
    	</td>
	</tr>
		</table>
		
    </div><!--pageBody-->
	
	
	
    <div id="footer">
      <c:out value="${website.footer}" escapeXml="false"/>    	
    </div><!--footer-->
</div><!--wrapper-->
</body>
</html>
