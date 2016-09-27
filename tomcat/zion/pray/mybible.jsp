<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>
<html>
<body>
<head> 
	<title>基督教溝子口錫安堂教會</title> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="/zion/scripts/jquery.cookie.js"></script>
	<style>
    body { margin: 0; padding: 0; line-height: 1.5em; font-family: "Times New Roman" Times, serif; font-size: 14px; color: #000000; background: #f2e7ca url(images/templatemo_body.jpg) top center no-repeat; } 
</style>
</head>


<image src="/zion/images/cal.jpg">
<span id="myday"></span> 
<span id="week"></span>  
<font color="blue"><strong><span id="bibleFullName"></span>-<span id="chapter"></span>章</strong></font>

<div align="center">
 <a href="#setting" id="login" data-icon="custom" data-rel="popup" data-position-to="window" data-transition="fade">讀經設定</a>
</div>

<hr>

<span id="lection"></span>


<!--
<div data-role="popup" id="setting" data-overlay-theme="a" data-theme="d" data-corners="false">
		<a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" class="ui-btn-right">Close</a>
		請設定章節:<br>
		<form name="form1" >	
			 <ww:select name="bible.id" id="bibleId" onchange="mychapter();"
               headerKey=""
               headerValue="請選擇經..."
               list="bibleList"
               listKey="id"
               listValue="fullName"              
        /> 
        
        <select name="chapter" id="chapter">
          <option>請選擇章數</option>
        </select>
        
        <input type="submit" name="button" id="button" value="確定" />
        
     </form> 
      
</div>

-->

<hr>



<jsp:include page="../layout/footer.jsp"/>

<script>
//var memberId=$.cookie('memberId');  
//alert('memberId='+memberId);
 personnel();
 lection();
 
  function lection(){
 	var memberId=$.cookie('memberId');  
 	var myday='2015/1/3';
  //alert('memberId='+memberId);
 	   $.ajax({
        url: 'todayBibleByMemberByJSON.do',
        type: "POST",        
        data: {"member.id":memberId,"myday":myday},  
        dataType: "json",
        success: function(data) {         
         //$("#bibleFullName").html(bibleFullName);
        }
      });      
 }

 function personnel(){
 	var memberId=$.cookie('memberId');  
 	var myday='2015/1/3';
  //alert('memberId='+memberId);
 	   $.ajax({
        url: 'todayBibleJSON.do',
        type: "POST",        
        data: {"member.id":memberId,"myday":myday},  
        dataType: "json",
        success: function(data) {
         var bibleFullName=data[0].bibleFullName;  
         var chapter=data[0].chapter;  
         var myday=data[0].myday;
         var week=data[0].week;
         $("#bibleFullName").html(bibleFullName);
         $("#chapter").html(chapter);
         $("#myday").html(myday);
         switch(week)
         {
           case 1:
            $("#week").html('星期一');
           break;	
           case 2:
            $("#week").html('星期二');
           break;
           case 3:
            $("#week").html('星期三');
           break;
           case 4:
            $("#week").html('星期四');
           break;
           case 5:
            $("#week").html('星期五');
           break;
           case 6:
            $("#week").html('星期六');
           break;
           case 7:
            $("#week").html('主日');
           break;         
         }        	
        	//alert("bibleFullName="+bibleFullName+"---chapter="+chapter);
        }
      });      
 }


 function mychapter(){
 	var bibleId = $('#bibleId').val();	
   alert("mychapter()..bibleId="+bibleId);	
   
   $.ajax({
        url: 'chapterNumber.do',
        type: "POST",        
        data: {"bible.id":bibleId},  
        dataType: "json",
        success: function(data) {
        	var returnValue=data.returnValue;  
        	
        	for(var i=1;i<=parseInt(returnValue);i++ ){
        		$("#chapter").append("<option value='"+i+"'>第"+i+"章</option>");
        	}
        	
        	alert("returnValue="+returnValue);
        }
      });
      
 }
</script>

</body>
</html>

