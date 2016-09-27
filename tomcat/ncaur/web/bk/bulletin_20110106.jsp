<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>
<link href="<ww:url value="/webwork/jscalendar/calendar-blue.css" />" rel="stylesheet" type="text/css" media="all"/>

<form  name="form1" action="Bulletin.do?menuId=${menuId}&bulletinTypeId=${bulletinTypeId}" method="post">
<div class="box3">
        <div class="hd"><b> 
        ${bulletinType}
        </b></div>
	    <div class="boxcont2">
          <div id="download_msg" class="kv">
            <div class="wp_download_msg">
              <div class="kv_tit">${bulletinType}</div>
              
              
             <ww:if test="${bulletinTypeId==24}">  	      	            
	             影音下載收聽需使用<a href="http://www.microsoft.com/windows/windowsmedia/download/default.asp?DispLang=tw" class="link2">Media Player 10.0以上版本</a>或<a href="http://forms.real.com/netzip/getrde601.html?h=software-dl.real.com&dc=1010109108&f=windows/RealPlayer10-5GOLD_bb.exe&p=RealOne+Player&oem=dlrhap_bb&tagtype=ie&type=dlrhap_bb" class="link2">Real Player</a>播放,請下載更新。
	           </ww:if>
	           <ww:else>	              
               PDF下載檔文件需使用 <a href="http://www.chinese-t.adobe.com/products/acrobat/readstep2.html?c=tw" class="link2" target="_blank">Acrobat Reader</a> 軟體閱讀</div></div> 
	           </ww:else>
	      </div>
	      
	      <a href="javascript:void(0);" class="download_btn" onClick="swirchBlock(this,'download_msg')"><b>&nbsp;</b></a>
	      
	      <c:if test="${bulletinTypeId==24}"> 
	      	    <div class="ps1">
                    	<div class="ps1_hd"><div class="bd">&nbsp;</div></div>
                        <div class="ps1_bd"><div class="bd">
                        如欲索取主日講道光碟，洽詢專線：02-2311-6767 轉分機：467、468（盧淑媛姐妹）
                        </div></div>
              </div>
	      </c:if>
	      
	      
	      
	      <table class="tb_search" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td>           
             
			    <span class="search_tit1">日期區間</span>：
			  <label>起日</label>
            	<ww:datepicker cssClass="date_txt" name="begindate" id="begindate" value="%{begindate}" language="zh" format="%Y/%m/%d" readonly="true"/>        
                
                
                
                迄日
            	<ww:datepicker cssClass="date_txt" name="enddate" id="enddate" value="%{enddate}" language="zh" format="%Y/%m/%d"  readonly="true"/>        

			  <span class="search_tit2">主題搜尋</span>：
                  <ww:textfield name="subject" value="%{subject}" maxlength="50" cssClass="txt1" />
                <a href="javascript:form1.submit();" class="btn1">查詢</a> 
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:reset();" class="btn1">重設</a>                </td>
              <td>&nbsp;</td>
            </tr>
          </table>
          
          

    <display:table name="bulletinList" style="width: 100%" class="tb4" cellspacing="1" requestURI="" id="tb4" export="false" pagesize="${GLOBAL_pagesize}" sort="list" >
       <display:setProperty name="paging.banner.placement" value="bottom" />    
 
       <display:column titleKey="bulletin.bulletinDate" headerClass="td_hd" style="width: 15%" sortable="false" > 
          ${tb4.bulletinDate}
       </display:column>
       <display:column titleKey="bulletin.subject" headerClass="td_hd" style="text-align:left;width: 30%"  sortable="false" >            
            <a href="bulletinDetail.do?bulletinId=${tb4.id}" class="link2">${tb4.subject}</a>
       </display:column>
       
       
       <c:if test="${tb4.speaker !='' && tb4.speaker!=null}">
       <display:column titleKey="bulletin.speaker" headerClass="td_hd" style="text-align:left;width: 15%"  sortable="false" > 
            ${tb4.speaker}
       </display:column>
       </c:if>

       <c:if test="${bulletinTypeId==24}"> 
       <display:column titleKey="bulletin.msg1" headerClass="td_hd" style="text-align:left;width: 12%" >        
              <c:choose>
               <c:when test="${tb4.file != null}"> 
                   <a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${tb4.id}/${tb4.file.fileName}" class="pdf"><b>下載大綱</b></a>
               </c:when>   
               <c:otherwise>  
                    
               </c:otherwise>   
              </c:choose>            
       </display:column> 
      </c:if>   
       
       
      <c:if test="${bulletinTypeId==24}"> 
        <display:column titleKey="bulletin.online" headerClass="td_hd" style="text-align:left;width: 12%"> 
             <a href="bulletinDetail.do?bulletinId=${tb4.id}"><img src="images/online.gif" width="18" height="18"></a>
            
        </display:column>
      </c:if> 
      
      <%--
      <c:if test="${bulletinTypeId==24}"> 
        <display:column titleKey="bulletin.online1" headerClass="td_hd" style="text-align:left;width: 12%"> 
            <c:choose>
               <c:when test="${tb4.file != null}"> 
                   <a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${tb4.id}/${tb4.voice.fileName}" class="voice"><b>線上收聽</b></a>
               </c:when>   
               <c:otherwise>  
                   
               </c:otherwise>   
              </c:choose>         
        </display:column>
      </c:if>
      --%>
      
 
     <%--     
     <c:if test="${bulletinTypeId!=24}"> 
       <display:column titleKey="bulletin.msg1" headerClass="td_hd" style="text-align:left;width: 12%" >        
              <c:choose>
               <c:when test="${tb4.file != null}"> 
                   <a href="${ctx}/<fmt:message key="bulletin.uploadFile.relativeUrl"/>/${tb4.id}/${tb4.file.fileName}" class="pdf"><b>下載大綱</b></a>
               </c:when>   
               <c:otherwise>  
                    <fmt:message key="common.nofile"/>
               </c:otherwise>   
              </c:choose>            
       </display:column> 
       </c:if> 
     --%>  
       
    </display:table> 
      
     
	    </div>
	   <c:if test="${bulletinTypeId==24}"> 
	     <p align="right"><a href="http://www.truth.org.tw/public/showav.asp?under=8" class="moreInfo">前往舊版頁面</a></p>
     </c:if> 
	    <div class="ft"><b><a href="javascript:void(0);" class="goTop" onClick="scrollByTop();">&nbsp;</a></b></div>
	    </div>
</form> 


<script>
  function reset(){
     form1.enddate.value="";
	 form1.begindate.value="";
	 form1.subject.value="";
	 
  }
</script>  
