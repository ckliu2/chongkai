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
        <div class="hd"><b>主日早堂信息</b></div>
	    <div class="boxcont2">
	      <div id="download_msg" class="kv">
	        <div class="wp_video_list_msg">
              <div class="kv_tit">主日早堂信息</div>
	          影音下載收聽需使用<a href="http://www.microsoft.com/windows/windowsmedia/download/default.asp?DispLang=tw" class="link2">Media Player 10.0以上版本</a>或<a href="http://forms.real.com/netzip/getrde601.html?h=software-dl.real.com&dc=1010109108&f=windows/RealPlayer10-5GOLD_bb.exe&p=RealOne+Player&oem=dlrhap_bb&tagtype=ie&type=dlrhap_bb" class="link2">Real Player</a>播放,請自行下載更新。<br>
            </div>
	      </div>
	      <a href="javascript:void(0);" class="download_btn" onClick="swirchBlock(this,'download_msg')"><b>&nbsp;</b></a>

	      <table class="tb5" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table class="tb2" width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="50%" class="video">
                             <c:if test="${bulletin.flv !='' && bulletin.flv!=null}">
                              <!--
                               <script type="text/javascript">
                                 AC_FL_RunContent( 'id','player','name','player','width','428','height','300','src','player-viral','allowscriptaccess','always','allowfullscreen','true','flashvars','file=./message/${bulletin.flv}&image=./images/mark.jpg','movie','player-viral' ); 
                               </script>
                               -->
                               <iframe src="${bulletin.flv}" width="400" height="300" frameborder="0"></iframe>
                             </c:if>       
                            </td>
                            <td width="50%"><div class="titBlock clearfix">${bulletin.subject}</div>
                              <div class="context"> <b>日　　期</b>：${bulletin.bulletinDate}<br>
                                  <b>講　　員</b>：${bulletin.speaker}<br>
                                  <b>地　　點</b>：${bulletin.placeDesc}<br>
                                  
                                  <c:if test="${bulletin.file !='' && bulletin.file!=null}">
                                     <b>下載檔案</b>：<a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${bulletin.id}/${bulletin.file.fileName}" class="pdf"><b>按我下載</b></a><br>
                                  </c:if>
               
                                  <c:if test="${bulletin.voice !='' && bulletin.voice!=null}">
                                     <b>下載聲音檔</b>：<a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${bulletin.id}/${bulletin.voice.fileName}" class="voice"><b>按我下載</b></a><br>
                                  </c:if>              
               
                                  <c:if test="${bulletin.vedio !='' && bulletin.vedio!=null}">
                                     <b>下載影像檔</b>：<a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${bulletin.id}/${bulletin.vedio.fileName}" class="video"><b>按我下載</b></a><br>
                                  </c:if>
                                  
                                  
                                  
                          </div></td>
                        </tr>
                  </table>
			   <div class="context">               
			        ${bulletin.description}
			   </div></td>
            </tr>
          </table>
          
     <c:if test="${bulletin.worshipFlv !='' && bulletin.worshipFlv!=null && user==null}">
       
       <input type="checkbox" name="isShow" onclick="if (this.checked == true) document.showLogin.style.display='inline'; else document.showLogin.style.display='none';">
       <br>
        <form action="login1.do" method="post" name="showLogin">
           <!--
            <span class="style1">觀看敬拜讚美影片請輸入號密碼(或洽蘇世鴻弟兄)</span><br>
            -->  
               登入帳號:<input type="text" name="loginId" class="cInputTextFieldShort" />
               <br>
               登入密碼:<input type="password" name="password" class="cInputTextFieldShort" />         
               <input name="bulletinId" type="hidden" value="${bulletinId}" />
               <br>
               <input type="submit"  class="cButton" value="登入" name="btn"/>
         </form>
        
    </c:if>
    
     <c:if test="${bulletin.worshipFlv !='' && bulletin.worshipFlv!=null && user!=null}">
                 <!--        
                  <script type="text/javascript">
                   AC_FL_RunContent( 'id','player','name','player','width','428','height','300','src','player-viral','allowscriptaccess','always','allowfullscreen','true','flashvars','file=./message/${bulletin.worshipFlv}&image=./images/worshiplog.jpg','movie','player-viral' ); 
                 </script>
                 -->
                 <iframe src="${bulletin.worshipFlv}" width="400" height="300" frameborder="0"></iframe>
     </c:if> 
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


  <script>
    document.showLogin.style.display='none';
  </script>
    