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
	background-image: url(${ctx}/images/bg2.jpg);
}
</style>


<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/grayscale.js"></script>

</head>

<body>
<div class="top">
   <div class="home_btn">
   <a href="index.html"><img src="${ctx}/images/home_btn.png"></a>
   </div>
   <div class="home_btn">
   <a href="index.html"><img src="${ctx}/images/out.png"></a>
   </div>   
</div>

<form name="form1" method="post" action="saveBill.html" >
	
<div class="mid_cen">
	<span class="title2">請選擇照片數量與沖洗樣式</span>
<!--照片總覽-->

<ww:set name="sizes" value="%{getSizeListByProduct()}"/>    
<ww:set name="stys" value="%{getStytleListByProduct()}"/>     	
<c:set var="count" value="1" />
<c:forEach items="${photos}" var="p">  
	 	
<!--單張內容開始-->
    <div class="pic2">
   	  <div class="photo3">
            <div class="pp"> 
            	<img id="photo${count}" src="${ctx}/upload/thumbnail/${tempdir}/${count}.jpg" width="100%">
            	<input name="disabled${count}" id="disabled${count}" type="hidden" value="0">
            </div>
        <div class="size2"> 
        	
        	<img src="images/ok.png" width="24" height="20" onclick="sel('${count}')">            	
          <img src="images/t.png" width="20"  onclick="del('${count}')">  
        	      
        </div>             
    	<div class="size_all">
                    <div class="size-">
              
              
             <ww:select name="sty${count}"  id="sty${count}"
                list="stys"
                listKey="id"
                listValue="name"              
             /> 
                 
           </div>
          
          <c:forEach items="${sizes}" var="s">
          <ww:set name="px" value="%{getPriceByProduct(${s.id})}"/>  
          	
           <div class="size-">
                    <img src="${ctx}/images/+.png" width="20"  onClick="addNum('${count}-${s.id}',1,${px.price})">            
                    <span class="size_1">${s.width}x${s.height}</span> 
                    <img src="${ctx}/images/-.png" width="20" onClick="addNum('${count}-${s.id}',-1,${px.price})">
                    <span class="size_2">x  
                    	<span id="size${count}-${s.id}">0</span>  
                    	<input name="hsize${count}-${s.id}" id="hsize${count}-${s.id}" type="hidden" value="0">
                    	<input name="price${count}-${s.id}" id="price${count}-${s.id}" type="hidden" value="${px.price}">                    	
                    </span>                    
            </div> 
           </c:forEach>
                                
        </div>
   	</div>
<!--單張內容結束--> 
 <c:set var="count" value="${count+1}" />
</c:forEach>	
                
    </div>
         
     <!--照片總覽結束-->   
	  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
	    <tr>
	      <td align="center"><div class="line"></div></td>
        </tr>
	    <tr>
	      <td align="center"><table width="100%" border="0" cellspacing="5" cellpadding="0">
	        <tr>
	          <td align="center"><span class="size_2">小計</span></td>
	          <td align="center">
	          	<span class="textb2">	          	
	          	      <span id="pricesum">0</span>
	          	      <input name="totalPrice" id="totalPrice" type="hidden" value="0">
	          	元</span>
	          </td>
            </tr>
	        </table></td>
        </tr>
	    <tr>
	      <td align="center">
          <div class="btn3">
          <a href="choose2.html">全部快速挑選</a>
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

</form>
	
<script>
	 var len=${fn:length(photos)};
	 
	 function sel(id){
	 	 //alert('sel id='+id);
	 	 var el = document.getElementById("photo"+id);
     grayscale.reset(el);     
     $("#disabled"+id).val(0);  
     disabledPhoto(id,0);   
	 }
	 
	 function del(id){ 	
	 	 var el = document.getElementById("photo"+id);
     grayscale(el);
     $("#disabled"+id).val(1);  
     disabledPhoto(id,1);   
     
     //取消
     <c:forEach items="${sizes}" var="s">
       $("#size"+id+'-'+${s.id}).html(0);
       $("#hsize"+id+'-'+${s.id}).html(0);
     </c:forEach>
     
	 }
	 
	 function addNum(id,n,price){	  
     var ls=id.split("-");
     var num=parseInt($("#size"+ls[0]+'-'+ls[1]).html()) + n;
     
     var disabled=$("#disabled"+ls[0]).val();  
	 	 //alert('disabled='+disabled);
     if(disabled==0)
     {
     if(num<0){
       num=0;
     }       
     $("#size"+ls[0]+'-'+ls[1]).html(num);
     $("#hsize"+ls[0]+'-'+ls[1]).attr({"value":num});   
    }  
   }
   
   
   
   function calculate()
   {
   	var list = [];
      <c:forEach items="${sizes}" var="s">
        list.push(${s.id});   
      </c:forEach>  
   
   	 var sum=0;
   	 for(var i=1;i<=len;i++){   	 	   	 	
   	 jQuery.each( list, function( j, id ) {        
        var num=parseInt($("#size"+i+"-"+id).html());
		    var price=parseInt($("#price"+i+"-"+id).val());		   
		    sum+=num*price;				  
     });
   	}
   	$("#pricesum").html(sum);
   	$("#totalPrice").val(sum)
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
  
   setInterval("calculate()", 500);
   setInterval("statusCheck()", 500);
 
function statusCheck()
{   
<c:forEach var="item" items="${sessionScope.disabledPhoto}">
 var el = document.getElementById("photo${item}");
 grayscale(el);
 $("#disabled${item}").val(1);  
</c:forEach>
}

 function checkout(){
 	 form1.submit();
 }
  
	
</script>




</body>
</html>
