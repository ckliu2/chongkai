﻿<%@ include file="/common/unsecureTaglibs.jsp"%>

<SCRIPT src="${ctx}/scripts/common.js" type="text/javascript"></SCRIPT>     
<SCRIPT src="${ctx}/scripts/list.js" type="text/javascript"></SCRIPT>    
<link href="<ww:url value="/webwork/jscalendar/calendar-blue.css" />" rel="stylesheet" type="text/css" media="all"/>
    

 
<ww:form name="form1" action="saveScheduleDaily.html" method="POST">
<ww:hidden name="scheduleDaily.id" value="${scheduleDaily.id}"/>
<ww:hidden name="reader.id" value="${reader.id}"/>

<span class="cRequired">
註：<br>
1. 手動排程用於臨時調課、突發事件，可手動彈性調整冷氣相關設定。<br>	
2. 請依序step1~step2 完成手動排程設定。
</span> 

<table width="100%" border="0">
  <tr><td class="cContentTitle" colspan="2" >手動排程(即時)</td></tr>
  <tr>
    <td width="50%" align="left" valign="top">
    
    <table width="100%" border="1" class="cContentTable">
      
      <tr>
        <td class="cInputCaption">參數設定<span class="cRequired">(step1)</span></td>
        <td><table width="100%" border="0">
      
        <tr>
            <td class="cInputColumn">排程編號</td>
            <td>${scheduleDaily.id}</td>
        </tr>
          
      
          <tr>
            <td class="cInputColumn">設定溫度</td>
            <td>
            
            <ww:select name="scheduleDaily.temp"                
               list="temperatureList"
               listKey="id"
               listValue="value"
               cssClass="cInputListField"
            />
  
            </td>
          </tr>
          <tr>
            <td class="cInputColumn">是否開啟</td>
            <td>
              <ww:select name="scheduleDaily.driveId" id="driveId"             
               list="driveList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />            
            </td>
          </tr>
          <tr>
            <td class="cInputColumn">空調模式</td>
            <td>
              <ww:select name="scheduleDaily.modeId"                
               list="modeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
              />            
             </td>
          </tr>

  
          <tr id="HoneyWell1">
            <td class="cInputColumn">是否鎖定面版</td>
            <td>  
              <ww:select name="scheduleDaily.lockId"                
               list="lockList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
              />                       
            </td>
          </tr> 
          
          <tr id="HoneyWell2">
            <td class="cInputColumn">風扇速度</td>
            <td>  
              <ww:select name="scheduleDaily.fanSpeedId"  id="fanSpeedId"             
               list="fanSpeedList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />          
            </td>
          </tr>                       
       
          <tr id="MITSUBISHI1">
            <td class="cInputColumn">是否准許手動控制開關冷氣</td>
            <td>  
              <ww:select name="scheduleDaily.driveItemId"                
               list="driveItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
              />            
            </td>
          </tr>
          
          <tr id="MITSUBISHI2">
            <td class="cInputColumn">是否准許手動控制空調模式</td>
            <td>
               <ww:select name="scheduleDaily.modeItemId"                
               list="modeItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
              />            
            </td>
          </tr>
          
          <tr id="MITSUBISHI3">
            <td class="cInputColumn">是否准許手動控制設定溫度</td>
            <td>  
               <ww:select name="scheduleDaily.tempItemId"                
               list="tempItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
              />            
            </td>
          </tr>
          
          <tr id="MITSUBISHI4">
            <td class="cInputColumn">是否准許手動重設濾網</td>
            <td>
               <ww:select name="scheduleDaily.filterItemId"                
               list="filterItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
               />            
            </td>
          </tr>
        </table></td>
      </tr>
      
      
      <tr>
        <td class="cInputCaption">上述設定套用到其他面版<span class="cRequired">(step2)</span></td>
        <td class="cInputColumn">
         
          <table>
          
            <tr>
             <td>
             
                <ww:select name="spaceId"  id="spaceId" onchange="javascript:selectspace()"
                 headerKey=""
                 headerValue="%{getText('請選擇管制區域')}....."
                 list="spaceListAir"
                 listKey="id"
                 listValue="name"
                 cssClass="cInputListField"
                />  
                         
             </td>
            </tr>
            
            
            <tr>
                <th align="center"><span style="font-size:10pt">可選擇的面版</style></th>
                <th>&nbsp</th>
                <th align="center"><span style="font-size:10pt">已選擇的面版</style></th>
            </tr><tr>
            <td>               
                <ww:select id="allReaders" 
                list="readerListBySpace"
                listKey="reader.id"
                listValue="'名稱:'+reader.name+'-編號:'+reader.readerId"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />                          
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allReaders, selectedReader);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allReaders, selectedReader);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedReader, allReaders);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedReader, allReaders);"><br>
            </td><td align="center"> 
                <ww:select name="selectedReaderIds" id="selectedReader"
                list="selectedReaderList"
                listKey="id"
                listValue="'名稱:'+name+'-編號:'+readerId"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />        
            </td>
            </tr>

            
            </table>        
         </td>
      </tr>
      <tr>
        <td colspan="2" >
        <div align="center">
          <input type="button" name="button" id="button" onClick="onSubmit();" value="儲存" class="cButton"/>
          <ww:if test="scheduleDaily.id != null">
            <input type="submit" name="delete1"  value="刪除" class="cButton" onClick="javascript:return confirm('確定要刪除排程編號${scheduleDaily.id}?')"  />
          </ww:if>
        </div>        
       </td>
        </tr>
    </table></td>
    <td width="50%" align="left" valign="top">
    
    <table width="100%" border="1" class="cContentTable">
      <tr>
        <td>
        
        <table width="100%" border="0">
          <tr>
            <td colspan="3" class="cInputColumn"  align="center">${today} 今日排程</td>
          </tr>
          
          <tr>
            <td colspan="3" class="cInputColumn"  align="left"><a href="scheduleDaily1.html?reader.id=${reader.id}"><img src="${ctx}/images/add.png" border="0"/>新增排程</a></td>
          </tr>
          
          <tr>
            <td class="cInputColumn">
            
              <c:set var="count" value="0" />
              
              <ww:set name="ls" value="%{getScheduleDailyByReader()}"/>  
              
             
              <display:table name="ls" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
                <display:column title="No" sortable="true">
                  ${count+1}
                </display:column>
                <display:column property="scheduleDaily.id" sortable="true" title="排程編號" style="text-align:left" />
                <display:column property="scheduledDate" sortable="true" title="時間" style="text-align:left" decorator="com.base.web.displaytag.DateformatDecorator"/>
                
                <display:column title="類別" sortable="true">
                  ${row.scheduleDaily.type}
                </display:column> 
                
                <display:column title="開關" sortable="true">
                  ${row.scheduleDaily.drive}
                </display:column>
                <display:column title="溫度" sortable="true">
                  ${row.scheduleDaily.temp} ℃
                </display:column>
                <display:column title="模式" sortable="true">
                  ${row.scheduleDaily.mode}
                </display:column>
                <display:column title="權限" sortable="true">
                
                   <a id="jttrigger-${count}"><img src="${ctx}/images/GridView.gif" border="0" id="c-${count}"/></a>
			             <div id="jttip-${count}" class="jttip" style="display:none;">
				           <div class="jttipcontent">
				            排程編號:${row.scheduleDaily.id} <br>
				            設定溫度:${row.scheduleDaily.temp} ℃<br>	
				            模式:${row.scheduleDaily.mode} <br>					         
				            是否准許手動控制開關冷氣:${row.scheduleDaily.driveItem}  <br>
				            是否准許手動控制空調模式:${row.scheduleDaily.modeItem}  <br>
				            是否准許手動控制設定溫度:${row.scheduleDaily.tempItem}  <br>
				            是否准許手動重設濾網:${row.scheduleDaily.filterItem}  <br> 
					         </div>
		              </div> 
                  
                </display:column>
                
                <c:set var="count" value="${count+1}" />
                
                <display:column title="卡機" sortable="true">
                    <a id="jttrigger-${count}"><img src="${ctx}/images/GridView.gif" border="0" id="c-${count}"/></a>
			              <div id="jttip-${count}" class="jttip" style="display:none;">
				            <div class="jttipcontent">	
				               <c:forEach var="reader" items="${row.scheduleDaily.readers}">  
				                 名稱:${reader.name}-編號:${reader.readerId}<br>
				               </c:forEach>            
				             </div>
		              </div> 
				           
				           
                </display:column>
                
                
                <display:column property="scheduleDaily.lastModifiedUser.name" sortable="true" title="最後修改人" style="text-align:left" />
                <display:column property="scheduleDaily.ip" sortable="true" title="ip" style="text-align:left" />
                <display:column property="scheduleDaily.lastModifiedDate" sortable="true" title="最後時間" style="text-align:left" decorator="com.base.web.displaytag.DateformatDecorator1"/>
              
                <display:column title="執行" sortable="true">                
                    <ww:if test="${row.active == true}">
                       <font color="blue">已執行</font>
                    </ww:if>
                    <ww:else>
                       <font color="red">未執行</font>
                    </ww:else>
                </display:column>
               
                
                <display:column title="編輯" sortable="true">                   
                     <a href="scheduleDaily2.html?reader.id=${reader.id}&scheduleDaily.id=${row.scheduleDaily.id}">
                        <img src="${ctx}/images/GridEdit.gif"/>
                      </a>
                </display:column>
                
                <c:set var="count" value="${count+1}" />
              </display:table>
              

            </td>        
          </tr>
        
        </table>
        
        </td>
        </tr>
    </table></td>
  </tr>
</table>

</ww:form>

<script>
 
 function selectspace(){
 	var spaceId= $("#spaceId").val(); 
 	var urls='readerByJSON.html?space.id='+spaceId+"&scheduleDaily.id=${scheduleDaily.id}";
	$.getJSON(urls,function( data ) {  
    $.each( data,function( key, val ) {       
     $("#allReaders").append($("<option></option>").attr("value", val.id ).text( val.name )); 
    });
  });	
  
}
 
 function onSubmit() {
   mySelectAll(document.form1.selectedReader);
   var theSel=document.getElementById("selectedReader"); 
   var theSelLen=theSel.length;  
   var title=''; 
   if(theSelLen==0){
      title+='至少需要選擇一台卡機! \n'; 
   }   
   
   
   
   if(title.length==0){
 	   form1.submit();
   }else{
 	   alert(title);
   }
 }
 
<c:if test="${powerControllerReader.powerController.deviceType=='HoneyWell'}">
  for(i=1;i<=4;i++){   
   	var s = eval('MITSUBISHI'+i) ;
   	s.style.display = "none";
  }
</c:if>

<c:if test="${powerControllerReader.powerController.deviceType=='G50'}">
  var s1 = eval('HoneyWell'+i) ;
  s1.style.display = "none";
</c:if>
 
 <%
 String msg=request.getParameter("msg"); 
  if (msg != null && msg.equals("1")) {
 %>
   alert("更新成功!");
   window.close();
 <%
 }
 %>
 
</script>




