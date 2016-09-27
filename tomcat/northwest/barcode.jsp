<%@ include file="/common/unsecureTaglibs.jsp"%>


<html>
<head>
<title> <fmt:message key="barcode.title"/> </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/northwest/scripts/jquery-1.3.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="/northwest/css/style.css" />
<link rel="stylesheet" type="text/css" href="/northwest/css/displaytag1.css" />

<body bgcolor="#C3D9F9">

<form name="form1" method="post"  onsubmit="return mybarcode();">
<table width="100%" border="0">
  <tr>
    <td align="center">
    
    <table border="0" align="center">      
      <tr>
        <td colspan="2" align="center"><span class="barcodeHead"><fmt:message key="barcode.title"/></span> 
        (<a href="/northwest/download/code39.zip" target="_blank"><fmt:message key="barcode.font"/></a>)
        <hr></td>
      </tr>
      <tr>
        <td colspan="2" align="left">&nbsp;</td>
      </tr>
      

      
      
      <tr>
        <td colspan="2" align="center"><span id="user" class="barcodeTitle"></span></td>
      </tr>
      
      
      <tr>
        <td>
         <div align="center">         
          <div align="left" class="barcodeLabel"><fmt:message key="barcode.user.steps"/></div>
         </div>        
        </td>
        <td>    
          <div align="left" id="usersteps" class="barcodeInfo"></div>  
        </td>
      </tr>
      
      
      <tr>
        <td>
         <div align="center">         
          <div align="left" class="barcodeLabel"><fmt:message key="barcode.option.mode"/></div>
         </div>        
        </td>
        <td>    
          <div align="left" id="optionmode" class="barcodeInfo"></div>  
        </td>
      </tr>
      
      <tr>
        <td>
         <div align="center">         
          <div align="left" class="barcodeLabel"><fmt:message key="barcode.select.mode"/></div>
         </div>        
        </td>
        <td>       
          <div align="left" id="selectmode" class="barcodeInfo"></div>  
        </td>
      </tr>
      
      
      <tr>
        <td>
         <div align="center">         
          <div align="left" class="barcodeLabel"><fmt:message key="barcode.input"/></div>
         </div>        
        </td>
        <td><input type="text" name="barcode" id="barcode" class="barcodeInput"/></td>
      </tr>
      
      
      <tr>
        <td colspan="2"><hr></td>
      </tr>
      <tr>  
        <td colspan="2">
          <img id="loading" src="/northwest/images/loading.gif" align="center"/> 
          <div align="center" id="info" class="barcodeInfo"></div>  
        </td>
      </tr>
    </table>
    
    
    </td>
  </tr>
</table>
</form>

<script>

function userstep(){
	$("#usersteps").html('');
	var u="barcodeUserStep.html";
	$.ajax({
        url: u,
        type: "GET",
        dataType: "json",
        success: function(data) {   
        	 
        	 var newElement = $(document.createElement('input')).attr({ type: 'radio' ,name:"step", value:'0' });   
           $('#usersteps').append(newElement);     
           $('#usersteps').append('<strong><fmt:message key="barcode.user.allsteps"/></strong>');
        	         	
          for (var i = 0; i < data.length; i++) {            		      
           var id=data[i].id;
           var groupName=data[i].groupName;
           //alert(id+"--"+groupName);  
           var newElement = $(document.createElement('input')).attr({ type: 'radio' ,name:"step", value:id });   
           $('#usersteps').append(newElement);     
           $('#usersteps').append(groupName);      
          } 
          $('input[name="step"]')[0].checked = true;
          
          //add event
          $("#usersteps").click(function(event) {
            $('#barcode').focus();
          });
                    	
        }	
   });
	
}


function completeStatus(code){ 
	var u="barcodeCompleteStatus.html?code="+code;
	$.ajax({
            url: u,
            type: "GET",
            dataType: "json",
            success: function(data) {
            	var complete=data[0].complete;
            	var uncomplete=data[0].uncomplete;
            	document.getElementById('complete'+code).innerHTML=complete;	
            	document.getElementById('uncomplete'+code).innerHTML=uncomplete;	
            }	
         });
}


   function mybarcode(){     	
   	var step = $("input[name='step']:checked").val();
   	var stepurl='';
   	if ( typeof(step) !== 'undefined'){ 		
   		stepurl='&step='+step;
   	}   	
   	var code = $("#barcode").val();
   	var user = $("#user").html(); 
   	$("#info").html('');
   	$("#loading").show();
    $("#optionmode").html('Barcode');
    
     var u="barcodeActive.html?barcode="+code+stepurl;
     //alert(u);
	  	     $.ajax({
            url: u,
            type: "GET",
            dataType: "json",
            success: function(data) {
            	$("#loading").hide();
            	var returnValue=data[0].returnValue;            	
            	//alert("returnValue="+returnValue);
            	
            	if(returnValue=='login-index')
            	{
            	  $("#info").html('<fmt:message key="barcode.unlogin"/>');
              }else
              {
              	
              	 if(returnValue=='mode')
            	   {
            		  var selectmode=data[0].selectmode;
            		  var optionmode=data[0].optionmode;
            		  if(selectmode=='SELECT1')
            		  {
            		  	$("#selectmode").html('<fmt:message key="barcode.select1"/>'); 
            		  }
            		  if(selectmode=='SELECT2')
            		  {
            		  	$("#selectmode").html('<fmt:message key="barcode.select2"/>'); 
            		  }
            		  if(selectmode=='SELECT3')
            		  {
            		  	$("#selectmode").html('<fmt:message key="barcode.select3"/>'); 
            		  }
            		  if(optionmode=='DELETE')
            		  {
            		  	$("#optionmode").html('<fmt:message key="barcode.delete"/>');
            		  }else{
            		  	$("#optionmode").html('Barcode');
            		  }                 
            	   }
            	   
            	   if(returnValue=='barcode-error-selectmode')
            	   {
            		   $("#info").html('<fmt:message key="barcode-error-selectmode"/>');    
            	   }            	   
            	   
            	   if(returnValue=='login-success')
            	   {
            		  var username=data[0].username;
            		  $("#user").html(username);              		  
            		  //取得流程權限
            		  userstep();             		           
            	   }
            	   
            	   if(returnValue=='login-fail')
            	   {
            		  $("#user").html('');
            	   } 
            	   
            	   if(returnValue=='workflow-error')
            	   {
            		    $("#info").html('<fmt:message key="barcode.steperror"/>');
            	   }            	
            	
            	   if(returnValue=='barcode-success')
            	   {            	   	 
            		   var infotxt='';              		   
            		   
            		   var groupname=data[data.length-1].groups;   
            		   var billno=data[data.length-1].billno;   
            		   infotxt+= '<fmt:message key="profit.id"/>:'+billno+'<br>';
            		   //infotxt+= '<fmt:message key="barcode.completesteps"/>:'+groupname+'<hr>';
            		            		
            		   infotxt+=' <table cellspacing="1" class="list"> ';            		
            		   infotxt+='<thead>';
                   infotxt+='  <tr> ';
                   infotxt+='   <th>No.</th> ';
                   infotxt+='   <th><fmt:message key="product.id"/></th> ';
                   infotxt+='   <th><fmt:message key="product.name2"/></th> ';
                   infotxt+='   <th><fmt:message key="billdetail.fromRow"/></th> ';
                   infotxt+='   <th><fmt:message key="billDetail.quantity"/></td> ';
                   infotxt+='   <th><fmt:message key="billDetail.detail"/></th> ';
                   infotxt+='   <th><fmt:message key="bill.remark"/></th> ';
                   infotxt+='   <th><fmt:message key="barcode.complete"/></th> ';   
                   infotxt+='   <th><fmt:message key="barcode.uncomplete"/></th> ';
                   infotxt+='  </tr> ';                
                   infotxt+='</thead>';
                  
            		     for (var i = 0; i < data.length-1; i++) {            		      
                       var productId=data[i].productId;
            		       var productName=data[i].productName;
            		       var fromRow=data[i].fromRow;
            		       var width=data[i].width;
            		       var heigh=data[i].heigh;
            		       var visibleWidth=data[i].visibleWidth;
            		       var visibleHeigh=data[i].visibleHeigh;
            		       var quantity=data[i].quantity;
            		       var itemRemark=data[i].itemRemark;               		       
            		       var description=data[i].memo;    
            		       var optionCode=data[i].optionCode;
            		       var code=data[i].code;
            		                  		      
            		                  		        
            		       var bgcolor="";        
            		       if(optionCode=='delete')
            		       {
            		       	 bgcolor="#FF6600";            		       	
            		       }
            		       if(optionCode=='delete-fail')
            		       {
            		       	 bgcolor="#FF8080";            		       	
            		       }
            		       if(optionCode=='overwrite-fail')
            		       {
            		       	 bgcolor="#FF8080";            		       	
            		       }
            		       if(optionCode=='barcode-ok')
            		       {
            		       	 bgcolor="#0066FF";            		       	
            		       } 
            		       if(optionCode=='workflow-error')
            		       {
            		       	 bgcolor="#FF8080";            		       	
            		       }
            		                    		               		    
            	         infotxt+='  <tr bgcolor="'+bgcolor+'"> ';
                       infotxt+='   <td nowrap align="left">'+(i+1)+'</td> ';
                       infotxt+='   <td nowrap align="left">'+productId+'</td> ';
                       infotxt+='   <td nowrap align="left">'+productName+'</td> ';
                       infotxt+='   <td nowrap align="left">'+fromRow+'</td> ';
                       infotxt+='   <td nowrap align="left">'+quantity+'</td> ';
                       infotxt+='   <td nowrap align="left">'+width+'*'+heigh+'('+visibleWidth+'*'+visibleHeigh+')</td> ';
                       infotxt+='   <td nowrap align="left">'+itemRemark+'</td> ';
                       infotxt+='   <td nowrap align="left"><span id=complete'+code+'/></td> ';
                       infotxt+='   <td nowrap align="left"><span id=uncomplete'+code+'/></td> ';                                           
                       infotxt+='  </tr> ';
                     }                 
                    infotxt+='</table>';                 
                    $("#info").html(infotxt);   
                    
                    for (var j = 0; j < data.length-1; j++) {
            	  	    var code=data[j].code;
            	  	    //alert("code j="+j+"--"+code);
            	        completeStatus(code);
            	     }              
            	  }
            	  
            	  
            	 if(returnValue=='barcode-fail')
            	 {
            		$("#info").html('<fmt:message key="barcode.nocode"/>');
            	 }
            	
            	if(returnValue=='format-fail')
            	{
            		$("#info").html('<fmt:message key="barcode.formaterror"/>');
            	}              		     
            }           
            $("#barcode").val("");		
         }
      });      
  
     $('#barcode').focus(); 
     return false;
     
   }   

  $('#barcode').focus();
  $("#loading").hide();
 
</script>

</body>
</html>
