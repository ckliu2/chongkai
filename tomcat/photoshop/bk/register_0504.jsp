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
	<script src="${ctx}/scripts/jquery.validate.js"></script>	
</head>  
<body> 

<div data-role="page">

	
<div data-role="content" data-theme="a">
		<h3>註冊:請輸入以下資料</h3>
		
<form id="form1" >

  <div class="ui-field-contain">  
  
    <label for="name">姓名</label> 
    <input type="text" name="customer.name" id="name" class="required"/>
    
    <label for="cellphone">手機</label> 
    <input type="text" name="customer.cellphone" id="cellphone"/>
    
    <label for="email">Email</label> 
    <input type="text" name="customer.email" id="email"/>
   
  </div>
 
  

  <button class="btnLogin" type="submit" data-theme="a">登入</button>
                    
  <a href="profile.jsp" data-role="button" data-rel="back" data-theme="a">取消</a>
  
</form>
	  
</div>
	
<script>
/*
$(function(){	
	$("#form1").validate();
});
*/

/*
$("#form1").submit(function() {
  alert('123');

    var url = "saveRegister.html"; 

    $.ajax({
           type: "POST",
           url: url,
           data: $("#form1").serialize(), // serializes the form's elements.
           success: function(data)
           {
              // alert(data); // show response from the php script.
           }
         });         

    return false;
});
*/

</script>


</div>






</body>
</html>