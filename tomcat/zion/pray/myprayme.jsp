<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/webtag.jsp"%>
 
<html> 
<head> 
	<title>基督教溝子口錫安堂教會</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css"/>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<style>
	html, body { padding: 0; margin: 0; }
	html, .ui-mobile, .ui-mobile body {
    	height: 85px;
	}
	.ui-mobile, .ui-mobile .ui-page {
    	min-height: 85px;
	}
	.ui-content{
		padding:10px 15px 0px 15px;
	}
    .nav-glyphish-example .ui-btn .ui-btn-inner { padding-top: 40px !important; }
    .nav-glyphish-example .ui-btn .ui-icon { width: 30px!important; height: 30px!important; margin-left: -15px !important; box-shadow: none!important; -moz-box-shadow: none!important; -webkit-box-shadow: none!important; -webkit-border-radius: 0 !important; border-radius: 0 !important; }
    #prayall .ui-icon { background:  url(images/368.png) 50% 50% no-repeat; background-size: 30px 30px; }
    #prayme .ui-icon { background:  url(images/prayme.png) 50% 50% no-repeat; background-size: 30px 30px;  }
    #bodypray .ui-icon { background:  url(images/bodypray.png) 50% 50% no-repeat;  background-size: 30px 30px; }
    #login .ui-icon { background:  url(images/login.png) 50% 50% no-repeat;  background-size: 30px 30px; }
   	</style>
</head> 
<body> 
  <div id="prayitem" >      
    <ul data-role="listview"  data-inset="true">
    
     <c:set var="count" value="1" />
     <ww:set name="myPrayList" value="%{getMyPrayList()}"/>	     
     <ww:iterator value="myPrayList">   
      <li>
       <a href="#church${count}" data-rel="popup" data-position-to="window" data-inline="Flow">
      
        <ww:if test="${active} == true">
          <font color="green">已顯示</font> 
        </ww:if>
	      <ww:else>	
	        <font color="#999999">不顯示</font> 
	      </ww:else>	
        
       [<fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/>]  ${content}
       </a> 
      </li>
       
       
       <div data-role="popup" id="church${count}" class="ui-content" data-overlay-theme="a" data-corners="false" data-tolerance="30,15">
	     <a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" class="ui-btn-right">Close</a> 
	     
	     <ww:set name="replayList" value="%{getPrayYouListByPrayMe('${id}')}"/>	 
	     <!--代禱回應--> 	              
       <ww:iterator value="replayList">	     
	          [ <fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/> / ${member.nickname} ]  ${content} <hr>
       </ww:iterator> 
       
       <p>
     
       目前狀態: 
       <ww:if test="${active} == true">
          <font color="green">已顯示</font> 
       </ww:if>
	     <ww:else>	
	        <font color="#999999">不顯示</font> 
	     </ww:else>	
	     
	     
	     <input type="button" name="button" value="顯示代禱事項" onclick="javascript:displaypray('${id}','1');"/> 
	     <br>
	     <input type="button" name="button" value="不顯示代禱事項" onclick="javascript:displaypray('${id}','0');"/> 
	    
	     <ww:if test="${fn:length(replayList)} == 0">
	        <br>
          <input type="button" name="button" value="刪除本代禱事項" onclick="javascript:delpray('${id}');"/> 
       </ww:if>
       
       </div>
       
      <c:set var="count" value="${count+1}" />  
     </ww:iterator>     
     
    </ul>   
  </div>

  <br>
  

  

<script>

function displaypray(id,active){	
      $.ajax({    
        type:'post',        
        url:'displaypray.do?prayMe.id='+id+'&active='+active,         
        cache:false,    
        dataType:'json',    
        success:function(data){   
        	if(active==0){
        		alert('已不顯示此代禱事項');
        	}else{
        		alert('已顯示代禱事項\n弟兄姐妹可以在網站上幫您代禱');
        	}
        	 window.location.reload();
        }    
    });    
}


function delpray(id){
		
if(confirm("您確定要刪除此代禱事項?"))
  {      
      $.ajax({    
        type:'post',        
        url:'delPrayMe.do?prayMe.id='+id,         
        cache:false,    
        dataType:'json',    
        success:function(data){   
        	 alert('我們已刪除您的代禱事項');
        	 window.location.reload();
        }    
    });     
  }	
}

</script>








</body>
</html>
