<%@ include file="/common/taglibs.jsp"%>

<script src="${ctx}/scripts/jquery-1.9.1.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />  
<link rel="shortcut icon" href="${ctx}/images/favicon.ico" />
     
<form name="form1" method="post" action="saveWaiting.html">

<table width="50%" border="1" align="center"  class="cContentTable2">
  
  <tr>
    <td colspan="2" ><div align="center"><strong>待業</strong></div></td>
  </tr>
  <tr>
    <td nowrap="nowrap" class="cInputCaption2">目前待業最大的可能原因</td>
    <td nowrap="nowrap" class="cInputCaption1">
      <ww:radio  name="waiting" id="waiting"       
               list="waitingList"
               listKey="id"
               listValue="valueUs"
               
       />  
     <input type="text" name="member1.waitingOther" id="waitingOther" class="cInputTextField"/>     
    </td>
  </tr>
  
  <tr>
    <td nowrap="nowrap" class="cInputCaption2">目前找工作時間多久</td>
    <td nowrap="nowrap" class="cInputCaption1">
       <ww:radio  name="waitingDays" id="waitingDays"       
               list="waitingDaysList"
               listKey="id"
               listValue="valueUs"
               
       /> 
    </td>
  </tr> 
  
  
  <tr>
    <td colspan="2" nowrap="nowrap" >
      <div align="center">
        <input type="button" name="button" id="button" value="送出" onclick="ck();"/>
      </div>
    </td>
  </tr>
  
  
</table>

</form>


<script>

  function radioClick(name){
  	var i=0;  	
  	$("input[name='"+name+"']").each(function() {
    	if ($(this).is(":checked"))
      {
      	i++;
      }
    });
    return i;
  }

  function ck(){
  	var txt='';
  	var waiting=radioClick('waiting');
  	var waitingDays=radioClick('waitingDays');  	
  	var waitingOther=$('#waitingOther').val();  	

  	if(waiting==0){
  		 txt+='「目前待業最大的可能原因」為必填欄位!\n';    		
  	}
  	
  	var waitingId=$('input[name=waiting]:checked').val();
  	if(parseInt(waitingId)==456){  		
  		 if(waitingOther==''){
  		 txt+='「請填寫目前待業最大的可能原因」\n';   
  		} 		
  	} 	  	
  	
  	if(waitingDays==0){
  		 txt+='「目前找工作時間多久」為必填欄位!\n';    		
  	}
  	
    if(txt.length==0){
   	   form1.submit();
     }else{
 	    alert(txt);      
     }
  }
  
   
  function fulljobAreaCheck(){
  	var fulljobAreaId=$('input[name=fulljobArea]:checked').val();
  	if(parseInt(fulljobAreaId)==480){  		
  		 $("#fulljobLocationPanel").show();
  	}else{
  		 $("#fulljobLocationPanel").hide();
  	}  
  	
  	if(parseInt(fulljobAreaId)==482){  		
  		 $("#fulljobCityPanel").show();
  	}else{
  		 $("#fulljobCityPanel").hide();
  	} 	
  	 
  }

  function bye()
  {
  	window.close();
  }
  
  $("#fulljobLocationPanel").hide(); 
  $("#fulljobCityPanel").hide();
  
  
  <%
  String msg=request.getParameter("msg"); 
  if (msg != null && msg.equals("1")) {
  %>
    
   window.opener.parent.location.reload();
   alert("<fmt:message key='common.save'/><fmt:message key='common.successful'/>");
   window.close();	    
   
  <%
   }
  %>   
</script>



 