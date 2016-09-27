<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%> 

<%
    com.base.value.SessionUser user = (com.base.value.SessionUser) request.getSession().getAttribute("user");	
%>
<style type="text/css">
<!--
.style1 {color: #0000FF}
-->
</style>

    
<ww:set name="bulletin" value="%{getBulletinById(bulletinId)}"/> 
<div class="box3">
        <div class="hd"><b>${bulletin.bulletinType}</b></div>
	    <div class="boxcont2">
          <div id="download_msg" class="kv">
            <div class="wp_news_msg">
              <div class="kv_tit">${bulletin.bulletinType}</div>
              <a href="javascript:history.back()" class="link2">&lt; &lt;返回上一頁</a></div>
          </div>
	      <a href="javascript:void(0);" class="download_btn" onClick="swirchBlock(this,'download_msg')"><b>&nbsp;</b></a>

	      <table class="tb5" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td>
			  <div class="titBlock clearfix">${bulletin.subject}</div>
			   <table width="100%" border="0">
  <tr>
    <td align="left" valign="top">
    <div class="context">    
               <b>公告類型</b>：${bulletin.bulletinType}<br> 
               <b>公告日期</b>：${bulletin.bulletinDate}<br>    
               <b>主　　題</b>：${bulletin.subject}<br>
               
               
               <c:if test="${bulletin.title !='' && bulletin.title!=null}">
               <b>標　　題</b>：${bulletin.title}<br>
               </c:if>
               
               <c:if test="${bulletin.timeDesc !='' && bulletin.timeDesc!=null}">
               <b>時　　間</b>：${bulletin.timeDesc}<br>
               </c:if>
               
               <c:if test="${bulletin.placeDesc !='' && bulletin.placeDesc!=null}">
               <b>地　　點</b>：${bulletin.placeDesc}<br>
               </c:if>
               
               <c:if test="${bulletin.speaker !='' && bulletin.speaker!=null}">
               <b>講　　員</b>：${bulletin.speaker}<br>
               </c:if>
               
               <c:if test="${bulletin.description !='' && bulletin.description!=null}">
               <b>公告描述</b>：${bulletin.description}<br>
               </c:if>        
               
               <c:if test="${bulletin.file !='' && bulletin.file!=null}">
               <b>下載檔案</b>：<a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${bulletin.id}/${bulletin.file.fileName}" class="pdf"><b>按我下載(${bulletin.file.size} bytes)</b></a><br>
               </c:if>
               
               <c:if test="${bulletin.voice !='' && bulletin.voice!=null}">
               <b>下載聲音檔</b>：<a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${bulletin.id}/${bulletin.voice.fileName}" class="voice"><b>按我下載(${bulletin.voice.size} bytes)</b></a><br>
               </c:if>               
               
               <c:if test="${bulletin.vedio !='' && bulletin.vedio!=null}">
               <b>下載影像檔</b>：<a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${bulletin.id}/${bulletin.vedio.fileName}" class="video"><b>按我下載(${bulletin.vedio.size} bytes)</b></a><br>
               </c:if>
			   </div>
    </td>
    <td align="left" valign="top">
    <table width="100%" border="0" align="right">
  
  <tr>
    <td>
                   <c:if test="${bulletin.flv !='' && bulletin.flv!=null}">
                         
                  <script type="text/javascript">
                   AC_FL_RunContent( 'id','player','name','player','width','328','height','200','src','player-viral','allowscriptaccess','always','allowfullscreen','true','flashvars','file=./message/${bulletin.flv}&image=./images/mark.jpg','movie','player-viral' ); 
                 </script>
               </c:if></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
    
  
    <c:if test="${bulletin.worshipFlv !='' && bulletin.worshipFlv!=null && user==null}">
       <form action="login1.do" method="post">
       <span class="style1">觀看敬拜讚美影片請輸入號密碼(或洽蘇世鴻弟兄)</span>       <br>
        登入帳號:<input type="text" name="loginId" class="cInputTextFieldShort" />
         <br>
         登入密碼:<input type="text" name="password" class="cInputTextFieldShort" />
         
         <input name="bulletinId" type="hidden" value="${bulletinId}" />
          <br>
         <input type="submit"  class="cButton" value="登入"/>
       </form>
    </c:if>
    
               <c:if test="${bulletin.worshipFlv !='' && bulletin.worshipFlv!=null && user!=null}">
                         
                  <script type="text/javascript">
                   AC_FL_RunContent( 'id','player','name','player','width','328','height','200','src','player-viral','allowscriptaccess','always','allowfullscreen','true','flashvars','file=./message/${bulletin.worshipFlv}&image=./images/worshiplog.jpg','movie','player-viral' ); 
                 </script>
               </c:if>    
               
               </td>
  </tr>
</table>
    
    </td>
  </tr>
</table>

               
               </td>


               
               

               
            </tr>
          </table>
  </div>
	    <div class="ft"><b><a href="javascript:void(0);" class="goTop" onClick="scrollByTop();">&nbsp;</a></b></div>
	    </div>
        
<%
    String msg=request.getParameter("msg");
    if (msg != null && msg.equals("2")) {
%>
  <script>
    alert("<ww:text name='common.login.error' />");    
  </script>
<%
}
%>        