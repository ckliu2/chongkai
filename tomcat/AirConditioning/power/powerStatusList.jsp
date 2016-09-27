<%@ include file="/common/unsecureTaglibs.jsp"%>
<script type="text/javascript" src="${ctx}/scripts/powerStatus.js" id="ps" poweruser="${sessionUser.role}"></script>

<form name="form1" method="post">
<table width="100%" border="0" class="cContentTitle" >

  <tr>
    <td colspan="2">
    
     <table width="100%" border="1" style="position: fixed;">       
       <tr>
        <td width="19%" rowspan="2" bgcolor="#CCCCCC"><div align="center">連線中斷</div></td>
        <td width="19%" rowspan="2" bgcolor="#F5F5F5"><div align="center">未開啟</div></td>
        <td colspan="2" bgcolor="#BBBBFF"><div align="center">課表排程</div></td>
        <td width="19%" colspan="2" bgcolor="#FF9966"><div align="center">手動排程開啟/關閉</div></td>
        <td width="23%" rowspan="2" bgcolor="#CC0000"><div align="center">異常開啟</div></td>
       </tr>
       
       <tr>
         <td width="10%" bgcolor="#BBBBFF"><div align="center">有課表</div></td>
         <td width="10%" nowrap bgcolor="#F5F5F5"><div align="center">但未開啟</div></td>
         <td width="10%" bgcolor="#FF9966"><div align="center">有排程</div></td>
         <td width="10%" bgcolor="#F5F5F5"><div align="center">但未開啟</div></td>
       </tr>
       
        <tr>
         <td colspan="6" bgcolor="#FFFFFF">
            <ww:select name="buildingId"  onchange="javascript:go()"
               headerKey=""
               headerValue="%{getText('請選擇全部區域')}....."
               list="buildingList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            />   
            
            <ww:select name="readerStateId"  onchange="javascript:go()"
               headerKey=""
               headerValue="%{getText('請選擇全部狀態')}....."
               list="readerState"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            />         </td>
         <td bgcolor="#FFFFFF">
           <input type=button onClick="javascript:window.location='main.html'" class="cButton" value="回上一頁" />
           &nbsp;&nbsp;
           <input type=button onClick="javascript:window.location='logout.html'" class="cButton" value="登出" />         </td>
       </tr>       
      </table>

   </td>
  </tr>  
</table>

   </td>
  </tr>  
</table>

<p>

<!------------------------------------------------------------------>
<c:set var="i" value="0" />
<c:set var="result" value="${building}"/>
<c:forEach var="row" items="${result}">
<ww:set name="space" value="%{getSpaceByBuilding(${row.id})}"/> 
<ww:set name="spacereader" value="%{getReaderListBySpace(${space.id})}"/> 
<!------------------------------------------------------------------>

<table width="100%" border="0">
  <tr>
    <td height="5">&nbsp;</td>
  </tr>
  <tr>
    <td height="5">&nbsp;</td>
  </tr>
  <tr>
    <td><div align="center"><strong>${space.name}</strong></div></td>
  </tr>
  <tr>
    <td>
 <!--------------------------------------面版狀態---------------------------------------------->   
    
    <table width="100%" border="1" cellspacing="1" class="cContentTable" id="B${id}">    
  
 
<c:set var="count" value="0" />

 <c:forEach var="sr" items="${spacereader}">  
 
  <c:if test="${count%4==0}">
    <tr>    
  </c:if>  
  
  <td width="14%" nowrap="nowrap" bgcolor="#CCCCCC" id="${sr.reader.id}" valign="top">
  
  <!---------------------------------------------------------------------------------->     
   <table width="100%" border="0" bordercolor="#000000" ><tr><td><div align="left">
  
        <table width="100%" border="0"><tr>
           <td width="50%" id="tda${sr.reader.id}">
            
           <div align="left"> 
           
           <a id="jttrigger-${i}"><img src="images/deconnection.png" height="16" border="0" id="devicestatus${sr.reader.id}" /></a>
			      <div id="jttip-${i}" class="jttip" style="display:none;">
				       <div class="jttipcontent">
				         <span id="classname${sr.reader.id}"/>					        
				       </div>
		       </div>
		       
		       <c:if test="${sr.powercontroller.deviceType=='HoneyWell'}">
		         <img src="images/lock.png" height="16" border="0" id="lockstatus${sr.reader.id}" />		         
		       </c:if>   	 
                          
            <c:set var="i" value="${i+1}" /> 
            <strong>${sr.reader.name}</strong> 
            <span align="left" id="dinlettemp${sr.reader.id}" class="showTemp"/>                         
           </div>   
                        
           </td> 
             <td width="50%" id="tdb${sr.reader.id}">                
                <div align="right">                  
                   <input type="button" name="ON${sr.reader.id}" id="ON${sr.reader.id}" value="啟動" class="cButton"  onclick="setDevicePowerStatus('${sr.reader.name}','${sr.reader.id}','ON','啟動')"/>
                   <input type="button" name="OFF${sr.reader.id}" id="OFF${sr.reader.id}" value="關閉" class="cButton" onClick="setDevicePowerStatus('${sr.reader.name}','${sr.reader.id}','OFF','關閉')" />
                 <%--
                  <c:if test="${sr.powercontroller.deviceType=='HoneyWell'}">
                   <p>
                   <input type="button" name="LOCK${sr.reader.id}" id="OFF${sr.reader.id}" value="解鎖" class="cButton" onClick="setLockStatus('${sr.reader.name}','${sr.reader.id}','UNLUCK','解鎖')" />
                   <input type="button" name="ONLOCK${sr.reader.id}" id="OFF${sr.reader.id}" value="鎖定" class="cButton" onClick="setLockStatus('${sr.reader.name}','${sr.reader.id}','LUCK','鎖定')" />
                  </c:if>
                 --%> 	
                </div>           
             </td>
          </tr>
          <tr>
            <td align="right" class="showTimeBox" id="tdc${sr.reader.id}">            
            <div align="left" id="time${sr.reader.id}"></div>  
            
           
            <!---------------------------排程------------------------------>            
            <a id="jttrigger-${i}"><img src="images/schedule.png" id="scheduleICON${sr.reader.id}" border="0" title="檢視排程"/></a>
			      <div id="jttip-${i}" class="jttip" style="display:none;">
				    <div class="jttipcontent">
				       <span id="schedule${sr.reader.id}"/>					   
				    </div>
		        </div> 
		            
            <!---------------------------排程------------------------------>
            
            <c:set var="i" value="${i+1}" />        
            
            <!---------------------------設備屬性------------------------------>            
            <a id="jttrigger-${i}"><img src="images/settings.png" id="settingICON${sr.reader.id}" border="0" title="設備屬性"/></a>
			      <div id="jttip-${i}" class="jttip" style="display:none;">
				    <div class="jttipcontent">
				       <span id="setting${sr.reader.id}"/>					   
				    </div>
		        </div>   
		        
		       
		        
		        </td>
            <td align="left" class="showTimeBox" valign="bottom" id="tdd${sr.reader.id}">
            
              
              <!---------------------------設備屬性------------------------------>
                  <c:set var="i" value="${i+1}" />
                  <!---------------------------是否啟用------------------------------>
                  <c:set var="active" value="" />
                  <c:set var="activemsg" value="" />
                  <ww:if test="${sr.reader.active == true}">
                    <c:set var="active" value="active.png" />
                    <c:set var="activemsg" value="套用課表、每日強制關閉、每日強制初始化" />
                  </ww:if>
                  <ww:else>
                    <c:set var="active" value="none.png" />
                    <c:set var="activemsg" value="不套用課表、每日強制關閉、每日強制初始" />
                  </ww:else>
                  <a id="jttrigger-${i}"><img src="images/${active}" id="activeICON${sr.reader.id}" border="0" title="是否套用課表排程" /></a>
                  <div id="jttip-${i}" class="jttip" style="display:none;">
                    <div class="jttipcontent"> ${activemsg} </div>
                  </div>
                  
              <!---------------------------Information------------------------------>
                  <c:set var="i" value="${i+1}" />
                  <a id="jttrigger-${i}"><img src="images/info.png" border="0" title="其他資訊"/></a>
                  <div id="jttip-${i}" class="jttip" style="display:none;">
                    <div class="jttipcontent"> <span id="info${sr.reader.id}"/> </div>
                  </div>
              <!---------------------------Information------------------------------>
              
              <!---------------------------bypass------------------------------>             
              <c:if test="${sr.reader.pass==true}">   
               &nbsp; &nbsp;          
		           <img src="images/pass.png" height="16" border="0" id="pass${sr.reader.id}" />		         
		          </c:if> 
		          <!---------------------------bypass------------------------------>
           
            </td>
          </tr>
        </table>        
        </div>
        </td></tr></table>
        
  <!---------------------------------------------------------------------------------->        
  </td> 
        
     <c:if test="${count%4==6}">
         </tr>
     </c:if>   
     
     <c:if test="${count==fn:length(space.reader)-1}">
         </tr>
     </c:if>	  
         
     <c:set var="count" value="${count+1}" />   
     <c:set var="i" value="${i+1}" />   
 </c:forEach>  
</table>    
    
    
 <!--------------------------------------面版狀態---------------------------------------------->   
      
    </td>
  </tr>
</table>

<P></P>

</c:forEach> 

<p>
  
  <script>
  	
  function setLockStatus(door,readerId,ps,pschinese){
  	 var msg='是否確定'+pschinese+door+'面版?';
  	 	  	if(confirm(msg)){			
	  		 var u="setLockStatus.html?readerId="+readerId+"&ps="+ps;
	  		 //alert(u);
	  		 
	  	     $.ajax({
            url: u,
            type: "GET",
            dataType: "json",
            success: function(data) {
            	/*
            	var powerstatus=data[0].powerstatus;
              var state=data[0].state;
            	var info=data[0].info;
            	var id=data[0].id;
            	var countroltime=data[0].countroltime;
            	*/
            }
          }); 
          
       } 
  }
  
  function setDevicePowerStatus(door,readerId,ps,pschinese){  
	  var msg='是否確定'+pschinese+door+'冷氣?';
	  	if(confirm(msg)){			
	  		 var u="setDevicePowerStatus.html?readerId="+readerId+"&ps="+ps;
	  		 //alert(u);
	  	     $.ajax({
            url: u,
            type: "GET",
            dataType: "json",
            success: function(data) {
            	var powerstatus=data[0].powerstatus;
              var state=data[0].state;
            	var info=data[0].info;
            	var id=data[0].id;
            	var countroltime=data[0].countroltime;
            
				      //即時更新畫面
				      var time=eval('document.all.time'+id);
				      time.innerHTML=countroltime;				      
				      //alert('powerstatus='+powerstatus+'--state='+state+'--info='+info+'--id='+id+'--countroltime='+countroltime);
		          var devicestatus=eval('document.all.devicestatus'+id);	
				      var tda=eval('document.all.tda'+id);
				      var tdb=eval('document.all.tdb'+id);			      
				      var tdc=eval('document.all.tdc'+id);	
				      var tdd=eval('document.all.tdd'+id);					      
				      tda.style.backgroundColor=state;
				      tdb.style.backgroundColor=state;
				      tdc.style.backgroundColor=state;
				      tdd.style.backgroundColor=state;				      
				      if(powerstatus===true){				      					
				       	devicestatus.src='images/driveON.png'; 				       	 
				       }else{ 				       
				       	 devicestatus.src='images/driveOff.png';				       	
				       }  
            }
          }); 
       }  
	}
	
  
  
  function go(){
	   form1.submit();	  
	}

	
	window.setInterval("isReflash()",60000);
	sendRequest('status.xml','getStatusXML'); 
  //sendRequest1('status1.xml','getStatusXML1');  
  sendRequest2('honeywellstatus.xml','getHoneyWellStatusXML');  
  window.setInterval("sendRequest('status.xml','getStatusXML')",60000); 	
  //window.setInterval("sendRequest1('status1.xml','getStatusXML1')",60000);   
  window.setInterval("sendRequest2('honeywellstatus.xml','getHoneyWellStatusXML')",60000); 
  
  
  sendRequest3('DEM510CStatus.xml','getDEM510CStatusXML');
  window.setInterval("sendRequest3('DEM510CStatus.xml','getDEM510CStatusXML')",60000); 
  
  
  //alert('國際大樓系統測試中，目前資料皆是舊資料，測試完畢會再開啟服務!');
	
	
</script>

</form>






