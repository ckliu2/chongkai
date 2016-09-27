<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>${website.title}  ${menu.name}</title>



<link rel="stylesheet" type="text/css" href="inc/css/base.css">
<link rel="stylesheet" type="text/css" href="inc/css/print.css">
<script type="text/javascript" src="inc/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="inc/js/base.js"></script>
<script src="scripts/AC_RunActiveContent.js" type="text/javascript"></script>

</head>

<body>
<div id="wrapper">

   

  <div id="header">
      <div class="navBar">
        	<input type="text" class="search_txt"><a href="#" class="btn1">搜尋</a>
          |<a href="./index.do" class="link1">回首頁</a>|<a href="javascript:bookmark()" class="link1">加入最愛</a>|<a href="#" class="link1">簡體</a>|<a href="admin.do" class="link1">登入</a></div>
          <a href="./index.do" class="logo"><b> </b></a>
        <div class="banner1"><img src="inc/img/banner/banner_home.gif" width="575" height="86"></div>
   </div>

<!-- 
 ************************ 
 * 主選單 
 ************************
-->
    <div id="menu">
      <ww:iterator value="menuList">       
          <ww:if test="${id} == ${menu.id}">
            <c:set var="isCurrent" value="current" /> 
          </ww:if>
          <ww:else>
            <c:set var="isCurrent" value="" /> 
          </ww:else> 
          
          <%-- 判斷是否有公告           --%>
           <ww:set name="topSubMenu" value="%{getTopSubMenuByMenu(${id})}"/>
           <ww:if test="isBulletinSubMenuByMenu(${id}) == true">              
               <a href="${topSubMenu.url}" class="${isCurrent}"><span><b><ww:property value="name"/></b></span></a>
           </ww:if>
           <ww:else>
               <a href="webContent.do?menuId=<ww:property value="id"/>" class="${isCurrent}"><span><b><ww:property value="name"/></b></span></a>
           </ww:else>              
           <%-- 判斷是否有公告          --%>
     </ww:iterator>  
    </div>

	<div id="main_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="cont_tb">
	<tr>
	<td class="td_lev3">
	  <div id="lv3" class="lv3">
        <dl>
          <dt><b>${menu.name}</b> </dt>
          
<!-- 
 ************************ 
 * 次選單 
 ************************
--> 
<ww:set name="topSubMenu" /> 

        <ww:set name="subMenuList" value="%{getSubMenuListByMenu(${menu.id})}"/> 
        <c:set var="count" value="0" />  
        <ww:iterator value="subMenuList">  
        <ww:set name="subMenuIdx" value="${id}" />
         
           <ww:if test="${count} == 0">      	                                 
              <ww:set name="topSubMenu" value="%{getSubMenuById(${id})}" />   
              <c:set var="isCurrent" value="current" />               
           </ww:if>
           
           
           
           <ww:if test="${id} == ${subMenuId}">
      	      <c:set var="isCurrent" value="current" />    
           </ww:if>
           <ww:else>
             <c:set var="isCurrent" value="" /> 
           </ww:else>
           
                 <!--
                  * 判斷是否有subltem
                 -->
                 <ww:set name="isEndSubMenu" value="%{isEndSubMenu(${id})}"/>
                 
                 <ww:if test="${isEndSubMenu} == true">                      
                      <!--                      
                       * 顯示subltem
                       -->
                       <dd class="${isCurrent}"><a href="#">${name}</a>
		                <span class="wp">
                               <ww:set name="subItemList" value="%{getSubItemBySubMenu(${id})}"/>
                               <ww:iterator value="subItemList">  
                    	         <a href="webContent.do?menuId=${menu.id}&subItemId=${id}&subMenuId=${subMenuIdx}">${name}</a>
                               </ww:iterator> 
                        </span></dd>
                 </ww:if>
                 <ww:else>
                 
                     <%-- 判斷是否有公告          --%>
                     <ww:if test="url != null && url!=''">
      	                 <dd class="${isCurrent}"><a href="${url}" target="${linkType.valueUs}">${name}</a></dd>
                     </ww:if>
                     <ww:else>
                         <dd class="${isCurrent}"><a href="webContent.do?menuId=${menu.id}&subMenuId=${id}">${name}</a></dd>
                     </ww:else> 
                 
                     
                
                 </ww:else>        
           <c:set var="count" value="${count+1}" />     
         </ww:iterator> 
         
          </dd>
        </dl>
	    <div class="banner_left"> 

<!-- 
 ************************ 
 * 好站連結 
 ************************
-->   
         <ww:iterator value="linksList">    
            <a href="${link}" target="_blank"><img src="<fmt:message key="links.uploadPhoto.relativeUrl"/>/${id}/${photo.fileName}" width="150"> </a>
         </ww:iterator> 
        </div>
	    </div>

		</td>
	<td class="td_lev3_r">
           <tiles:insert attribute="content"/>
	  </td>
	</tr>
  </table>
  </div>

  <div id="footer">
        ${website.footer}               
  </div>

</div>
</body>
</html>

