<%@ include file="/common/unsecureTaglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>酷樂拍</title>
<style type="text/css">
body {
	background-color: #000;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>


<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/jquery.cookie.js"></script>
	
</head>

<body>
<div class="top">
   <div class="home_btn">
   <a href="indexPage.jsp"><img src="${ctx}/images/home_btn.png"></a>
   </div>
   <div class="home_btn">
   <a href="index.html"><img src="${ctx}/images/out.png"></a>
   </div>   
</div>

<ww:set name="products" value="%{getProductListOnLine()}"/>  
   <ww:iterator value="products">   
     <a href="upload.html?product.id=${id}"><img src="${ctx}/images/hh_01.jpg" width="100%" ></a>
   </ww:iterator>
   
<div class="mid_foot">
    <div class="btn3">
        <a href="history.html">歷史紀錄查詢</a> 
  </div>  
</div>



<script> 
 if (typeof $.cookie('userId') == 'undefined')
 {
 	  alert('您尚未登入');
 	  window.location='indexPage.jsp';
 }
</script>

</body>
</html>







