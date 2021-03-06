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
	background-image: url(images/bg1.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: right top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
}
</style>


<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/grayscale.js"></script>

</head>

<body>
<div class="top">
   <div class="home_btn">
   <a href="index.html"><img src="images/home_btn.png"></a>
   </div>
   <div class="home_btn">
   <a href="index.html"><img src="images/out.png"></a>
   </div>   
</div>
<div class="mid_cen">
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
          	<img src="images/ok.png" width="24" height="20" onclick="sel('${count}')">            	
          	<img src="images/t.png" width="20"  onclick="del('${count}')">        
        </div>                 
    </div>
    
 <c:set var="count" value="${count+1}" />
</c:forEach>	
        	
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
 	
</script>	


</body>
</html>



