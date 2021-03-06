<%@ include file="/common/unsecureTaglibs.jsp"%>
<!doctype html>
<head>
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
	background-image: url(images/bg1.jpg);
}
</style>


<link href="css/css.css" rel="stylesheet" type="text/css">
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
	<div class="title3">
    	親愛的　${sessionScope.customer.name}　您好
  </div>
	<div class="title2">
    	您的歷史消費記錄
  </div>

<ww:set name="history" value="%{getBillListByCustomer()}"/>   
<c:forEach items="${history}" var="p"> 
		    
    <div class="size">
        <span class="size_1"><fmt:formatDate type="time" value="${p.createdDate}" pattern="yyyy.MM.dd" /></span> 
        <span class="size_2">${p.product.name}</span>
        <span class="size_3">共:${p.totalPrice}元</span>      
    </div> 
</c:forEach>
	     
</div>

</body>
</html>
