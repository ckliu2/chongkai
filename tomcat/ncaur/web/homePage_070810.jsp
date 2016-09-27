<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" errorPage="/error.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/webwork" prefix="ww" %>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Cache-control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>

<html>
<head>
<title> <c:out value="${website.title}"/>  </title>

<link rel="stylesheet" type="text/css" href="inc/css/base.css">
<script type="text/javascript" src="inc/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="inc/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="inc/js/base.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>

<body class="index">
<div id="wrapper">
    <div id="header">
        <div class="navBar">
        	<input type="text" class="search_txt"><a href="#" class="btn1">  <fmt:message key="webSite.search"/>  </a>
            |<a href="#" class="link1">  <fmt:message key="webSite.goindex"/>  </a>|<a href="#" class="link1">  <fmt:message key="webSite.Favorites"/>  </a>|<a href="#" class="link1">  <fmt:message key="webSite.simplechinese"/>   </a></div>
        <div class="banner1"><img src="inc/img/layout/banner_home.gif" width="595" height="86"></div>
    </div><!--header-->
    
    
  
<!-- 
 ************************ 
 * menu 
 ************************
-->
<div id="menu">
    <c:set var="count" value="0" />    
    <ww:iterator value="menuList">   
    <c:set var="isMenuRoot" value="" />  
        <ww:if test="${count} == 0">
      	  <c:set var="isMenuRoot" value="current" /> 
        </ww:if>
        <ww:else>
          <c:set var="isMenuRoot" value="" /> 
        </ww:else>    
     
     
    	    <a href="#" class="<c:out value="${isMenuRoot}"/>"><span><b>  <ww:property value="name"/>  </b></span></a>   
    	    <c:set var="count" value="${count+1}" />  
    </ww:iterator>
</div>
    

<!-- 
 ************************ 
 * menuSub 
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
 * slideshow 
 ************************
-->        
<ww:set name="slideshow" value="%{getBolgById(13)}"/> 

        	<div id="slideshow" class="banner">
            	<div id="nav"></div>             	
                    <c:out value="${slideshow.content}" escapeXml="false"/>       	
            </div>
            

<!-- 
 ************************ 
 * news 
 ************************
-->
<ww:set name="news" value="%{getBlogClassById(5)}"/> 
<ww:set name="newsBolgList" value="%{getBolgByBlogClass(5)}"/>    
                 
        <div class="box2">
        	<div class="hd"><b> <c:out value="${news.name}" escapeXml="false"/> </b></div>
            <dl class="list1">
                 <ww:iterator value="newsBolgList">
                    <dt><a href="#" class="link2">   <ww:property value="name"/>  </a> </dt>
                 </ww:iterator>
            </dl>
        	<div class="ft"><b><a href="#" class="moreInfo">  <fmt:message key="webSite.moreInfo"/>  </a></b></div>
        </div>
        
        
<!-- 
 ************************ 
 * bible 
 ************************
-->
<ww:set name="bibleClass" value="%{getBlogClassById(7)}"/> 
<ww:set name="bible" value="%{getBolgById(15)}"/>          
        
        <div class="box1">
                <div class="hd"><b>  <c:out value="${bibleClass.name}" escapeXml="false"/>  </b></div>
                <div class="ft">
                     <c:out value="${bible.content}" escapeXml="false"/>
                </div>               
         </div>
            
            
        </div><!--content-->
    </div><!--pageBody-->
    
    
    <div id="sideLeft">
    
 


<!-- 
 ************************ 
 * witness share 
 ************************
-->
<ww:set name="witness" value="%{getBolgById(7)}"/>   
    	 <div class="share clearfix">  
        	 <c:out value="${witness.name}" escapeXml="false"/>        
        </div>
        


<!-- 
 ************************ 
 * worship place 
 ************************
-->
<ww:set name="worshipPlace" value="%{getBolgById(14)}"/>  
<ww:set name="worshipPlaceBolgClass" value="%{getBlogClassById(6)}"/>   
        <div class="box2">
                <div class="hd"><b>  <c:out value="${worshipPlaceBolgClass.name}" escapeXml="false"/>  </b></div>
                <div class="boxcont">               
                     <c:out value="${worshipPlace.content}" escapeXml="false"/>  
                </div>
                <div class="ft"><b><a href="#" class="moreInfo"> <fmt:message key="webSite.moreInfo"/>  </a></b></div>
            </div>
            
<!-- 
 ************************ 
 * download 
 ************************
-->        
<ww:set name="newsDownload" value="%{getBlogClassById(11)}"/>
<ww:set name="newsDownloadList" value="%{getBolgByBlogClass(11)}"/> 
        <div class="box2">
        	<div class="hd"><b> <c:out value="${newsDownload.name}" escapeXml="false"/> </b></div>
            <dl class="list2">
                <c:set var="count" value="1" />
                 <ww:iterator value="newsDownloadList">              
                   <dt class="no<c:out value="${count}"/>"><a href="#" class="pdf"><b> <ww:property value="name"/> </b></a></dt>
                   <c:set var="count" value="${count+1}" />
                 </ww:iterator> 
            </dl>
        	<div class="ft"><b><a href="content1.do" class="moreInfo"> <fmt:message key="webSite.moreInfo"/> </a></b></div>
        </div>
        
    </div><!--sideLeft-->
    <div id="sideRight">
 
 
<!-- 
 ************************ 
 * onlineMsg 
 ************************
-->
<ww:set name="onlineMsgBlogClass" value="%{getBlogClassById(8)}"/>
<ww:set name="onlineMsg" value="%{getBolgById(16)}"/>     
       	<div class="box1">
        	<div class="hd"><b>  <c:out value="${onlineMsgBlogClass.name}" escapeXml="false"/>  </b></div>
            <div class="boxcont">
				         <a href="#" class="video_player"><img src="inc/img/do/video_img.gif"></a>
            </div>
        	<div class="ft"><b><a href="#" class="link2">
        	     <c:out value="${onlineMsg.content}" escapeXml="false"/>
        	</b></div>
        </div>
        

<!-- 
 ************************ 
 * music 
 ************************
--> 
<ww:set name="music" value="%{getBlogClassById(9)}"/>    
<ww:set name="musicBlog" value="%{getBolgById(17)}"/>        
    	<div class="box2">
        	<div class="hd"><b> <c:out value="${music.name}" escapeXml="false"/> </b></div>
            <div class="music_cont">            
                    <c:out value="${musicBlog.content}" escapeXml="false"/>                
            </div>
        	<div class="ft"><b><a href="#" class="moreInfo"> <fmt:message key="webSite.worshopchinese"/> </a></b></div>
        	
        	
        </div>
        
    </div><!--sideRight-->
    <div id="footer">
    	 <c:out value="${website.footer}" escapeXml="false"/>
    </div><!--footer-->
</div><!--wrapper-->
</body>
</html>
