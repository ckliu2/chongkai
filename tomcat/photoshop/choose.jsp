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
 <link rel="stylesheet" type="text/css" href="${ctx}/css/shadowbox.css" />

  <script type="text/javascript" src="${ctx}/scripts/shadowbox.js"></script>
  <script type="text/javascript">
    Shadowbox.init();
  </script>
<style type="text/css">
html{
	width: 100%;
	font-family: "微軟正黑體";
	-webkit-text-size-adjust: none;
	background-image: url(${ctx}/images/bg1.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: right top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
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
<script src="${ctx}/scripts/grayscale.js"></script>

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
   <a href="userlogout.html"><img src="images/out.png"></a>
   </div>   
</div>
<div class="mid_cen">
	<div class="title3">
    	親愛的　${sessionScope.customer.name}　您好
    </div>
	<div class="title2">
    	請選擇您要製作的照片
    </div>
<div>
    <div class="btn3">
        <a href="choose2.html">全部快速挑選</a> 
    </div> 
    <div class="btn3">
        <a href="choose1.html">單張預覽挑選</a> 
    </div>  
</div>
<c:set var="count" value="1" />
<c:forEach items="${photos}" var="p">   
	    
	<div class="photo">
    	<div class="pp"> 
        <a href="#">
        <img id="photo${count}" src="${ctx}/upload/thumbnail/${tempdir}/${count}.jpg" width="100%">
        </a>
        </div>
        <div class="size2">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
         <td><img src="images/ok.png" width="24" height="20" onclick="sel('${count}')"></td>
         <td align="right"><img src="images/t.png" width="20" onclick="del('${count}')"></td>
        </tr>
        </table>       
      </div>                 
  </div>
    
 <c:set var="count" value="${count+1}" />
</c:forEach>	  

	<div class="photo">
    	<div class="pp" id="filechooser"> 
        <a href="#1" name="modal">
           <img src="images/pho1+.jpg" width="100%">
        </a>
        </div>
        <div class="size2">
      
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
	
	 function sel(id){
	 	 var el = document.getElementById("photo"+id);
     grayscale.reset(el);
     disabledPhoto(id,0);   
	 }
	 
	 function del(id){ 	
	 	 var el = document.getElementById("photo"+id);
     grayscale(el);
      disabledPhoto(id,1);   
	 }
	 
	 function disabledPhoto(id,disabled){   	
     $.ajax({
        url: 'disabledPhoto.html',
        type: "POST",        
        data: {"photoId":id,"disabled":disabled},  
        dataType: "json",
        success: function(data) {
        	
        }
      });	      
   }

//預設grayscale	 
function statusCheck()
{
<c:forEach var="item" items="${sessionScope.disabledPhoto}">
 var el${item} = document.getElementById("photo${item}");
 grayscale(el${item});
</c:forEach>
}

 setInterval("statusCheck()", 500);
 
 
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

if (typeof $.cookie('userId') == 'undefined')
 {
 	  alert('您尚未登入');
 	  window.location='indexPage.jsp';
 }
 
 
 	
</script>	

</body>
</html>




