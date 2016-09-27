<%@ include file="/common/mytag.jsp"%>
<html>
<head>
<title>Taipei Truth Church1</title>
<link rel="stylesheet" type="text/css" href="inc/css/base.css">
<script type="text/javascript" src="inc/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="inc/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="inc/js/base.js"></script>
</head>

<body class="index">
<div id="wrapper">
    <div id="header">
        <div class="navBar">
        	<input type="text" class="search_txt"><a href="#" class="btn1">   <fmt:message key="webSite.search"/>  </a>
            |<a href="#" class="link1">  <fmt:message key="webSite.goindex"/>  </a>|<a href="#" class="link1">   <fmt:message key="webSite.Favorites"/>   </a>|<a href="#" class="link1">   <fmt:message key="webSite.simplechinese"/>  </a></div>
        <div class="banner1"><img src="inc/img/layout/banner_home.gif" width="595" height="86"></div>
</div>    

  
  

    <!-- 
    ************************ 
    * 主選單 
    ************************
    -->
<div id="menu">
    <ww:iterator value="menuList">
    	    <a href="#"><span><b>  <ww:property value="name"/>  </b></span></a>      	     
    	    <!-- <a href="#"><span><b>1</b></span></a>  -->
    </ww:iterator>
</div>


    <!-- 
    ************************ 
    * 子選單 
    ************************
    -->

<div id="menuSub" class="clearfix">
  <c:set var="count" value="0" />
  <ww:iterator value="menuList">
     <ww:if test="${count} == 0">
      	  <ul class="current">
     </ww:if>
     <ww:else>
          <ul>
     </ww:else>    

  <ww:set name="subMenuList" value="%{getSubMenuListByMenu(id)}"/>  
     <ww:iterator value="subMenuList">
    	  
        	 <li><a href="#"> <ww:property value="name"/></a> </li>
          
     </ww:iterator>
  </ul>
      <c:set var="count" value="${count+1}" />
  </ww:iterator>
</div>    
    
    
    
    
    <div id="pageBody">
      <div id="content">
   
   <!-- 
    ************************ 
    * 廣告特區
    ************************
    -->  

     <ww:set name="advertisement" value="%{getBolgById(13)}"/> 
     
          <div id="slideshow" class="banner">
            	<Div Id="Nav"></Div>          
                <c:out value="${advertisement.content}" escapeXml="false"/>
            </div>
 
    <!-- 
    ************************ 
    * 主日敬拜場所
    ************************
    -->  

     <!--   
     <ww:set name="worshipPlace" value="%{getBolgById(14)}"/> 
     
        	<div class="box2">
                <div class="hd"><b> <c:out value="${worshipPlace.name}" escapeXml="false"/>   </b></div>
                <div class="boxcont">  
                          <c:out value="${worshipPlace.content}" escapeXml="false"/>
                      
                </div>
                <div class="ft"><b><a href="#" class="moreInfo">  <fmt:message key="webSite.moreInfo"/> </a></b></div>
            </div>
    -->
   
   

                
                
   <!-- 
    ************************ 
    * 本週經句背誦
    ************************
    -->       
      
      
      <ww:set name="bible" value="%{getBolgById(15)}"/>       
        	 <div class="box1">
                <div class="hd"><b>   <c:out value="${bible.name}" escapeXml="false"/>  </b></div>
                <div class="ft">   <c:out value="${bible.content}" escapeXml="false"/>   </div>
            </div>
       
          
        </div> <!--content-->
    </div><!--pageBody-->
    
    
    
    
    
    <div id="sideLeft">  
    
    <!-- 
    ************************ 
    * 見證分享 
    ************************
    -->

    
      <ww:set name="witness" value="%{getBolgById(7)}"/>   
    	 <div class="share clearfix">   	
    	    <c:out value="${witness.name}" escapeXml="false"/>       
       </div>
     

     <!-- 
    ************************ 
    * 真道最新消息 
    ************************
    --> 
     
     <ww:set name="news" value="%{getBlogClassById(5)}"/> 
     <ww:set name="newsBolgList" value="%{getBolgByBlogClass(5)}"/>         
        <div class="box2">
        	<div class="hd"><b> <c:out value="${news.name}" escapeXml="false"/>  </b></div>
            <dl class="list1">            
                 <ww:iterator value="newsBolgList">
                    <dt><a href="#" class="link2">   <ww:property value="name"/>  </a> </dt>
                 </ww:iterator>
            </dl>
        	<div class="ft"><b><a href="#" class="moreInfo">    <fmt:message key="webSite.moreInfo"/>    </a></b></div>
      </div>


     <!-- 
    ************************ 
    * 真道最新消息下載
    ************************
    -->         
        <ww:set name="newsDownload" value="%{getBlogClassById(11)}"/>
        <ww:set name="newsDownloadList" value="%{getBolgByBlogClass(11)}"/> 
        <div class="box2">
        	<div class="hd"><b>   <c:out value="${newsDownload.name}" escapeXml="false"/>   </b></div>
            <dl class="list2">
              <c:set var="count" value="1" />
              <ww:iterator value="newsDownloadList">
              
                <dt class="no<c:out value="${count}"/>"><a href="#" class="pdf"><b> <ww:property value="name"/> </b></a></dt>
              <c:set var="count" value="${count+1}" />
              </ww:iterator> 
              
            </dl>
        	<div class="ft"><b><a href="#" class="moreInfo">   <fmt:message key="webSite.moreInfo"/>  </a></b></div>
        </div>
      
        
    </div><!--sideLeft-->
    
    <div id="sideRight">
   
   
   <!-- 
    ************************ 
    * 本週主日信習收看
    ************************
    -->  
      <ww:set name="onlineMsgBlogClass" value="%{getBlogClassById(8)}"/>
      <ww:set name="onlineMsg" value="%{getBolgById(16)}"/> 
    	<div class="box1">
        	<div class="hd"><b>  <c:out value="${onlineMsgBlogClass.name}" escapeXml="false"/>   </b></div>
              <c:out value="${onlineMsg.content}" escapeXml="false"/>
      </div>
  
  
     <!-- 
    ************************ 
    * 全華音樂
    ************************
    --> 
       <ww:set name="music" value="%{getBlogClassById(9)}"/>    
       <ww:set name="musicBlog" value="%{getBolgById(17)}"/> 
    	<div class="box2">
        	<div class="hd"><b>  <c:out value="${music.name}" escapeXml="false"/>  </b></div>
        	
            <c:out value="${musicBlog.content}" escapeXml="false"/>
        	
        </div>
      
    </div><!--sideRight-->
    
    <div id="footer">
    	 <!--
    	 ©  2010 TAIPEI TRUTH CHURCH All Rights Reserved.   基督教台北真道教會   版權所有<br>
		新西門堂：台北巿萬華區中華路一段144號4樓 / 主日聚會文藝中心：台北巿萬華區中華路一段69號  電話：02-23116767 　傳真：02-23113060　
    -->
    </div>
    
    <!--footer-->
</div><!--wrapper-->
</body>
</html>
