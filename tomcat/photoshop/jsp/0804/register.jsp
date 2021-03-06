<%@ include file="/common/unsecureTaglibs.jsp"%>

<!doctype html>
<head>
<!--[if lt IE 7]> <html class="ie6 oldie"> <![endif]-->
<!--[if IE 7]>    <html class="ie7 oldie"> <![endif]-->
<!--[if IE 8]>    <html class="ie8 oldie"> <![endif]-->
<!--[if gt IE 8]><!-->
<!--<![endif]-->
<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登入</title>
<style type="text/css">
html{
	width: 100%;
	font-family: "微軟正黑體";
	-webkit-text-size-adjust: none;
	background-color: #1e69de;
	background-image: url(images/join.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: left top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
}
</style>


<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/validate.js"></script>
<script src="${ctx}/scripts/jquery.cookie.js"></script>

</head>

<body>
<div class="login">
    <div class="login_cen">    	  
          <input name="customer.name" id="customername" type="text" class="input" id="target" placeholder="姓名:" />
          <input name="customer.cellphone" id="cellphone" type="text" class="input" id="target" placeholder="手機:" />
          <input name="customer.email" id="email" type="text" class="input" id="target" placeholder="E-MAIL:" />                    
          <input name="customer.address" id="address" type="text" class="input" id="target" placeholder="住址:" />                    
          
          <div class="btn3">
          <a href="javascript:checkForm()">註冊</a> 
          </div> 
          <div class="line"></div>
          <div class="text">
          隨心所欲拍您想要的照片，並且立即上傳至我們的雲端沖洗館。
          </div>                   
    </div>      
</div>


<script>

function checkForm() {
		
	var customername=$('#customername').val();
	var cellphone=$('#cellphone').val();
	var email=$('#email').val();
	var address=$('#address').val();
	var msg=''
	if(customername==''){
		msg+='請輸入姓名\n';
	}
	if(isPhone(cellphone)==false){
		msg+='請輸入完整手機號碼\n';
	}
	if(isEmail(email)==false){
		msg+='請輸入完整Email\n';
	}	
	
	if(msg.length==0){		
		
		$.ajax({
           type: "POST",
           url: "registerCustomer.html",
           data: {"customer.name":customername,"customer.cellphone":cellphone,"customer.email":email,"customer.address":address},  
           dataType: "json",
           success: function(data)
           {
              var returnValue=data.returnValue;  
              //alert('returnValue='+returnValue);
              if(returnValue==0){
              	alert('該手機已被註冊\n請更換其他手機號碼!');
              } if(returnValue==1){
              	var userId=data.userId; 
              	//alert('userId='+userId);
              	$.cookie('userId', userId, { expires: 3650 });
        		    $.cookie('customername', customername, { expires: 3650 });
              	alert(customername+' 您好:\n謝謝您的註冊!');
              	window.location="index.html";
              }else{
              	alert('註冊失敗!');
              }               
           }
         });   
		
	}else{
		 alert(msg);
	}

}


</script>


</body>
</html>






