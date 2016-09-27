<%@ include file="/common/unsecureTaglibs.jsp"%>
<!DOCTYPE html> 
<html> 
<head>
  <meta charset="UTF-8">	
	<title>沖洗照片</title> 	
	<meta name="viewport" content="width=device-width, initial-scale=1">     
  <link rel="stylesheet" href="${ctx}/css/jquery.mobile.structure-1.0.1.css" />
	<link rel="stylesheet" href="${ctx}/css/jquery.mobile-1.0.1.css" />   
	<link rel="stylesheet" href="${ctx}/css/custom.css" />  
	<script src="${ctx}/scripts/jquery-1.7.1.min.js"></script>
	<script src="${ctx}/scripts/jquery.mobile-1.0.1.min.js"></script>
	<script src="${ctx}/scripts/jquery.cookie.js"></script>
</head>  
<body> 

<div data-role="page">

	
<div data-role="content" data-theme="a">
		<h3>請輸入您註冊時的手機號碼</h3>
		
<form>

  <div class="ui-field-contain">   
    <input type="text" name="cellphone" id="cellphone" value="0958058735"/>
  </div>
 
  
  <a href="#" data-role="button" id="submitBtn">登入</a>
  <a href="profile.jsp" data-role="button" data-rel="back" data-theme="a">取消</a>
  
</form>


		
	  
	</div>
	
	
<script> 
 $(function() {
  $('#submitBtn').on('click',function(){
  	  var cellphone= $("#cellphone").val();
      //alert("cellphone="+cellphone);
      
      //ajax
      $.ajax({
        url: 'loginCellphone.html',
        type: "POST",        
        data: {"cellphone":cellphone},  
        dataType: "json",
        success: function(data) {
        	var returnValue=parseInt(data.returnValue); 
        	if(returnValue==1){
        		var userId=parseInt(data.userId); 
        		var customername=data.customername; 
        		alert(customername + ' 您好!歡迎登入');
        		window.location='index.html';
        	}else{
        		alert('Sorry!登入失敗!');
        	}
        	
        }
        });
      
      
    });
  });
</script>


</div>






</body>
</html>