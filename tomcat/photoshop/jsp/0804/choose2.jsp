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
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: left top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
	background-image: url(images/bg2.jpg);
}
</style>


<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/grayscale.js"></script>
<link href="Spry01/SpryAccordion.css" rel="stylesheet" type="text/css">
<script src="Spry01/SpryAccordion.js" type="text/javascript"></script>
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


<ww:set name="sizes" value="%{getSizeListByProduct()}"/>    
<ww:set name="stys" value="%{getStytleListByProduct()}"/>     	

	
<form name="form1" method="post" action="saveBill.html" >
	
<div class="mid_cen">
	<span class="title2">您目前選擇了<span id='selectPhotos'>${fn:length(photos)}</span>張照片</span>
  <div id="Accordion1" class="Accordion" tabindex="0">
	    <div class="AccordionPanel">
	      <div class="AccordionPanelTab">
        快速下單</div>
	      <div class="AccordionPanelContent">
         <!--內容-->
           
    <div class="size">
    	<span class="size_1">選擇沖洗樣式</span> 
    	
    	<ww:select name="sty${count}"  id="sty${count}"
                list="stys"
                listKey="id"
                listValue="name"              
       /> 
    	   
    </div>
    
<c:forEach items="${sizes}" var="s">
<ww:set name="px" value="%{getPriceByProduct(${s.id})}"/>  
    <div class="size">
        <span class="size_1">${s.width}x${s.height}</span> 
        <img src="images/+.png" width="40" onClick="addNum('${s.id}',1)">
        <span class="size_2">x<span id="size${s.id}">0</span></span>
        <img src="images/-.png" width="40" onClick="addNum('${s.id}',-1)">
        <span class="size_3">共:<span id="sum${s.id}">0</span>元</span>
        <img src="images/t.png" width="20" onClick="delAll('${s.id}')">              
    </div> 
    <input name="disabled${count}" id="disabled${count}" type="hidden" value="0">                 	

</c:forEach>    
         	
          
          
          <!--內容結束-->	           
          </div>
        </div>

    
	    <div class="AccordionPanel">
	      <div class="AccordionPanelTab">照片總覽</div>
	      <div class="AccordionPanelContent">
 	<!--照片總覽-->
    <div class="pic2">
    	

<c:set var="count" value="1" />
<c:forEach items="${photos}" var="p">  
	    	      
    <div class="photo2">
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
    <!--照片總覽結束-->     
</div>
</div>   
       
  </div>
	  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
	    <tr>
	      <td align="center"><div class="line"></div></td>
        </tr>
	    <tr>
	      <td align="center"><table width="100%" border="0" cellspacing="5" cellpadding="0">
	        <tr>
	          <td align="center"><span class="size_2">小計</span></td>
	          <td align="center"><span class="textb2">
	          	<span id="pricesum">0</span>
	          	<input name="totalPrice" id="totalPrice" type="hidden" value="0">		          		
	          </td>
            </tr>
	        </table></td>
        </tr>
	    <tr>
	      <td align="center">
          <div class="btn3">
          <a href="choose1.html">單張預覽挑選</a>
          </div>
          <div class="btn3">
          <a href="choose.html">返回照片總覽</a>
          </div>          
          </td>
        </tr>
	    <tr>
	      <td align="center"><div class="btn3"> <a href="javascript:checkout();">結帳</a></div></td>
        </tr>
  </table>
</div>

<!------------------------------------------------------------------->
<div id='controlPanel'>
<c:set var="count" value="1" />
<c:forEach items="${photos}" var="p">  
	
	 <ww:select name="sty${count}"  id="sty${count}"
                list="stys"
                listKey="id"
                listValue="name"              
   /> 
   <br>
   
   <c:forEach items="${sizes}" var="s">
   <ww:set name="px" value="%{getPriceByProduct(${s.id})}"/>  
  <font color="white">
    ${s.width}x${s.height}  &nbsp;&nbsp;
    hsize: <input name="hsize${count}-${s.id}" id="hsize${count}-${s.id}" type="text" value="0">
    &nbsp;&nbsp;
    price: <input name="price${count}-${s.id}" id="price${count}-${s.id}" type="text" value="${px.price}">                    	
  </font>
    <br>                
   </c:forEach>
         
   <hr>      
<c:set var="count" value="${count+1}" />
</c:forEach>	

</div>
<!------------------------------------------------------------------->

</form>

<script>
   var Accordion1 = new Spry.Widget.Accordion("Accordion1");

	 var len=${fn:length(photos)};
	 
	 function sel(id){
	 	 var el = document.getElementById("photo"+id);
     grayscale.reset(el);
     disabledPhoto(id,0);   
     
    // var c=parseInt($('#selectPhotos').html());
    // $('#selectPhotos').html(c+1);
	 }
	 
	 function del(id){ 	
	 	 var el = document.getElementById("photo"+id);
     grayscale(el);
     disabledPhoto(id,1);  
     
     //var c=parseInt($('#selectPhotos').html());
     //$('#selectPhotos').html(c-1);
     
   }
   
   function addNum(id,n){
   	 var num=parseInt($("#size"+id).html()) + n;
     if(num<0){
       num=0;
     } 
     $('#size'+id).html(num);
     
     for(var i=1;i<=len;i++)
     {
       var disabled=$("#disabled"+i).val();  	
       if(disabled==1){
       	 $("#hsize"+i+'-'+id).attr({"value":0});         
       }else{
       	 $("#hsize"+i+'-'+id).attr({"value":num});  
       }
     }
     
     
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
   
   function delAll(id)
   {   	
   	$('#size'+id).html(0);
   	for(var i=1;i<=len;i++){ 
   		$("#hsize"+i+'-'+id).attr({"value":0});      
   	}
   }
   
   function calculate()
   {
   	  var list = [];
      <c:forEach items="${sizes}" var="s">
        list.push(${s.id});   
      </c:forEach>  
   
    //總計
   	 var totalPrice=0;	
   	 for(var i=1;i<=len;i++){     	 		 	
   	 	 for(var j=0;j<list.length;j++)
   	 	 {
   	 	  	var num=parseInt($('#hsize'+i+'-'+list[j]).val());
		      var price=parseInt($('#price'+i+'-'+list[j]).val());
		      totalPrice+=num*price;	 
   	 	 }   	 	  	 
   	}
   	$("#totalPrice").val(totalPrice);
   	$("#pricesum").html(totalPrice);
   	
   	//小計
   	for(var j=0;j<list.length;j++)
   	{
   		var sum=0;
   		for(var i=1;i<=len;i++){
   			var num=parseInt($('#hsize'+i+'-'+list[j]).val());
		    var price=parseInt($('#price'+i+'-'+list[j]).val());
		    sum+=num*price;
   	 	 	//alert('num='+num+'--'+price);
   	 	}
   	 	$('#sum'+list[j]).html(sum);
   	}
   	
   }
   
//預設grayscale	 
function statusCheck()
{
<c:forEach var="item" items="${sessionScope.disabledPhoto}">
 var el${item} = document.getElementById("photo${item}");
 grayscale(el${item});
 $("#disabled${item}").val(1); 
</c:forEach>
}

$('#selectPhotos').html(len-${fn:length(sessionScope.disabledPhoto)});

//$('#controlPanel').show();
$('#controlPanel').hide();

 function checkout(){
 	 form1.submit();
 }

setInterval("calculate()", 500);
setInterval("statusCheck()", 500);
   
</script>

<input type="button" value="calculate()" onclick="calculate();"/>


</body>
</html>
