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


<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/jquery.cookie.js"></script>
<link href="Spry01/SpryAccordion.css" rel="stylesheet" type="text/css">
<script src="Spry01/SpryAccordion.js" type="text/javascript"></script>
</head>

<body>

<form action="billConfirm.html" name="form1">
<input name="bill.id"   type="hidden" value="${bill.id}">
	
<div class="top">
   <div class="home_btn">
   <a href="home.html"><img src="images/home_btn.png"></a>
   </div>
   <div class="home_btn">
   <a href="index.html"><img src="images/out.png"></a>
   </div>   
</div>

<div class="mid_cen">
	<div class="title3">
    	親愛的　${sessionScope.customer.name}　您好
  </div>
    
	<span class="title2">請確認以下資訊是否正確</span>
	
	<table width="100%" border="0" cellspacing="5" cellpadding="0">
	  <tr>
	    <td align="center"><span class="size_2">小計</span></td>
	    <td align="center"><span class="textb2"><span id="totalPrice">0</span>元</span></td>
      </tr>
  </table>
  
	  <div id="Accordion1" class="Accordion" tabindex="0">

    
	    <div class="AccordionPanel">
	      <div class="AccordionPanelTab">
          運送資訊
          </div>
	      <div class="AccordionPanelContent">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
  <tr>
    <td align="center"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td align="center"><table width="0" border="0" cellspacing="0" cellpadding="5">
          <tr>
            <td><input type="checkbox" name="ship" id="ship" onclick="c()"></td>
            <td><span class="size_1">運費</span></td>
            </tr>
          </table></td>
        <td align="center">
        	  <span class="textb2"><span id="shipment">0</span>元</span>
        	  <input name="bill.sfee" id="sfee" type="hidden" value="0">        	
        	</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="0" cellspacing="5" cellpadding="5">  
      <tr>
        <td colspan="2"><label for="textfield"></label> 
          <input name="customer.name" id="name" type="text" class="ccc3" id="textfield" value="${bill.customer.name}" size="30" maxlength="30"></td>
        </tr>
      <tr>
        <td colspan="2"><input name="customer.cellphone" id="cellphone" type="text" class="ccc3" id="textfield2" value="${bill.customer.cellphone}" size="30" maxlength="30"></td>
        </tr>
      <tr>
        <td colspan="2"><input name="customer.address" type="text" id="address" class="ccc3" id="textfield3" value="${bill.customer.address}" size="30" maxlength="30"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" class="size_2">預計到貨:<fmt:formatDate type="time" value="${pickupDate}" pattern="yyyy/MM/dd" /></td>
  </tr>
  <tr>
    <td align="center">&nbsp;</td>
  </tr>
  </table>          
</div>
        </div>           
      
      
	    <div class="AccordionPanel">
	      <div class="AccordionPanelTab">
          訂單資訊
          </div>
	      <div class="AccordionPanelContent">
          <!--訂單資訊內容-->
          <table width="100%" border="0" cellspacing="5" cellpadding="0">
            
          <c:forEach var="item" items="${pictures}">   
          <ww:set name="pictureInfo" value="%{getSizeListByPicture(${bill.id},${item})}"/>     
            
            <tr>
              <td><table width="100%" border="0" cellspacing="5" cellpadding="0">
                <tr>
                  <td width="100"><img src="${ctx}/upload/thumbnail/${bill.thumbnail}/${item}.jpg" width="100%"></td>
                  <td>
                  	<table width="0" border="0" cellspacing="0" cellpadding="0">
                    
                    <c:forEach var="info" items="${pictureInfo}">   
                      <tr>
                        <td> <span class="size_3">${info.size.width}x${info.size.height} ${info.copies}張 共:${info.sum}元 </span></td>
                      </tr>
                    </c:forEach>
                    	
                  </table>
                  </td>
                </tr>
              </table>
                <div class="line"></div></td>
            </tr>
           
          </c:forEach> 
           
            
          </table>

         	
          
          
          <!--訂單資訊內容結束-->	
          </div>
        </div>
     
  </div>
  
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">
	    <tr>
	      <td align="center"><div class="line"></div></td>
        </tr>
	    <tr>
	      <td align="center">&nbsp;</td>
        </tr>
	    <tr>
	      <td align="center"><div class="btn3"> <a href="javascript:comfirmCK()">確認</a></div></td>
        </tr>
  </table>

</div>

</form>

<script type="text/javascript">
 var Accordion1 = new Spry.Widget.Accordion("Accordion1");
 
 
 $('#totalPrice').html(${bill.totalPrice});
 
 function c(){
   var p=50;
   if ( $('#ship').prop( "checked" ) )
   {
   	 //alert('運費');	
   	 $('#totalPrice').html(${bill.totalPrice}+p);
   	 $('#shipment').html(p);  
   	 $('#sfee').val(p); 	 
   }else{
   	 //alert('取消運費');	
   	 $('#totalPrice').html(${bill.totalPrice});
   	 $('#shipment').html(0);
   	 $('#sfee').val(0); 
   }
 }
 
 function comfirmCK()
 {
  form1.submit();
 }


 if (typeof $.cookie('userId') == 'undefined')
 {
 	  alert('您尚未登入');
 	  window.location='indexPage.jsp';
 }
 
</script>


</body>
</html>



