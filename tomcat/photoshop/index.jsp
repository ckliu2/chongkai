<%@ include file="/common/unsecureTaglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>酷樂拍</title>
<style type="text/css">
html{
	width: 100%;
	font-family: "微軟正黑體";
	-webkit-text-size-adjust: none;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: left top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
	background-image: url(${ctx}/images/bg1.jpg);
}


#mask {
  position:absolute;
  left:0;
  top:0;
  z-index:9000;
  background-color:#000;
  display:none;
}
  
#boxes .window {
  position:fixed;
  left:0;
  top:0;
  width:100%;
  height:200px;
  display:none;
  z-index:9999;
  padding:20px;
}

#boxes #dialog {
  width:100%; 
  height:203px;
  padding:10px;
  background-color:#ffffff;
}

#boxes #dialog2 {
  width:100%;  
}


</style>


<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/jquery.cookie.js"></script>

 <!--file upload-->
 <link rel="stylesheet" type="text/css" href="${ctx}/css/dropzone.css">
 <script src="${ctx}/scripts/dropzone.js" charset="UTF-8"></script>
 <script src="${ctx}/scripts/dropzone-amd-module.js" charset="UTF-8"></script> 
 

</head>

<body>
<div class="top">
   <div class="home_btn">
   <a href="indexPage.jsp"><img src="images/home_btn.png"></a>
   </div>
   <div class="home_btn">
    <a href="javascript:logout();"><img src="images/out.png"></a>    
   </div>   
</div>
<div class="mid_cen">
	<div class="title3">
    	親愛的　${sessionScope.customer.name}　您好
    </div>
	<span class="title2">請問您要沖洗什麼</span>

<ww:set name="products" value="%{getProductListOnLine()}"/>  
<ww:iterator value="products">   
	
  	<div class="home_pic1">  		
        <div class="h_p1" id="filechooser">
        	<a href="${id}" name="modal"><font color="white">${name}</font></a>
        </div>   
    </div>
	
</ww:iterator>	



<div class="mid_foot">
    <div class="btn3">  
        <a href="history.html">歷史紀錄查詢</a> 
  </div>  
</div>
</div>


<div id="boxes">

<div id="dialog2" class="window"> 
  <form class="dropzone" method="post" action="UploadServlet"  id="myAwesomeDropzone"/>
</div>
  <div id="mask"></div>
</div>



<script> 
	
 if (typeof $.cookie('userId') == 'undefined')
 {
 	  alert('您尚未登入');
 	  window.location='indexPage.jsp';
 }
 
 Dropzone.options.myAwesomeDropzone = { 
 maxFilesize: 256,
 clickable: "#filechooser" , 
 init: function () {
    this.on("queuecomplete", function (file) {
    	 //alert('queuecomplete');
       window.location='resizer.html';    
    });    
    this.on("complete", function (file) {     
      // alert('complete='+file.name);
    });
  }  
};



$(document).ready(function() {	
	$('a[name=modal]').click(function(e) {	
		e.preventDefault();			
		var id = '#dialog2';	
		var productId = $(this).attr('href');
		 productAjax(productId);	
		//alert('productId='+productId);
	
		var maskHeight = $(document).height();
		var maskWidth = $(window).width();	
		$('#mask').css({'width':maskWidth,'height':maskHeight});
		$('#mask').fadeIn(1000);	
		$('#mask').fadeTo("slow",0.8);	
		$(id).fadeIn(1000); 	
	});	

	$('.window .close').click(function (e) {
		e.preventDefault();		
		$('#mask').hide();
		$('.window').hide();
	});
	
	$('#mask').click(function () {
		$(this).hide();
		$('.window').hide();
	});	
	
});


function logout(){
	
	if (confirm("您確定要登出?"))
	{
		window.location="userlogout.html";	
	}
}


function productAjax(id){
	$.ajax({url: "selectProduct.html?product.id="+id, success: function(result){        
  }});
}

</script>


</body>
</html>