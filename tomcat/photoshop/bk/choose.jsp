<%@ include file="/common/unsecureTaglibs.jsp"%>
<!DOCTYPE html> 
<html>
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">     
    <link rel="stylesheet" href="css/jquery.mobile.structure-1.0.1.css" />
	  <link rel="stylesheet" href="css/jquery.mobile-1.0.1.css" />   
	  <link rel="stylesheet" href="css/custom.css" /> 
    <script src="scripts/jquery-1.7.1.min.js"></script>
	<script src="scripts/jquery.mobile-1.0.1.min.js"></script> 
</head> 
<body>

<ww:set name="sizes" value="%{getSizeListByProduct()}"/>    
<ww:set name="stys" value="%{getStytleListByProduct()}"/>                  


 
<div data-role="page" id="home">


   

<div data-role="header">     
    <table width="100%" border="0">
    <tr>
     <td width="10%"><div data-role="button"><a href="upload.jsp" rel="external"> 更多照片 </a></div></td>
     <td><div align="center"><img src="images/header_logo.png"/></div></td>
    </tr>
    </table>
</div> 
    
<div data-role="content">

<form method="post" action="saveBill.html" target="_parent">

    <h3 align="center"><font color="blue">您選擇${product.name}</font></h3>
    
    
    <h3 align="center">快速選取以下所選照片的規格和數量</h3>

    <hr>
    
    <h3 align="center">
        
     <c:forEach items="${sizes}" var="s">
          ${s.width}X${s.height} 
          <img src="images/add.png" onClick="addAllNum(${s.id},1)" /> 
          <span id="sizeall${s.id}">0份</span>
          <img src="images/minus.png" onClick="addAllNum(${s.id},-1)"/>            
          <span id="pricesum${s.id}">NT.0</span>          
          <br>       
     </c:forEach>
          
     <ww:select name="styall" id="styall" onchange="styChange();"
      headerKey=""
      headerValue="沖洗樣式"
      list="stys"
      listKey="id"
      listValue="name"              
     />
     
    </h3>
    
    <hr>
    
	<div class="choice_list">     
	<ul data-role="listview" data-inset="true">	

<!----------------------------------------------------------> 

<!---
相片編號-size編號
-->
<c:set var="count" value="1" />
<c:forEach items="${photos}" var="p">
   
<li>    
 
 <table border="0" width="100%">
  <tr>
    <td align="center" valign="middle">    
    
    ${count}.
    <img id="loading${count}" src="images/loading.gif"/> 
    
   
    </td>
    <td align="left" valign="top">
    
    <table border="0" align="center" width="100%">
    
    <c:set var="i" value="1" />
    <c:forEach items="${sizes}" var="s">	    
	   <tr>
        <td nowrap><h5>${s.width}X${s.height}</h5></td>
        <td nowrap><div align="left"><img src="images/add.png" onClick="addNum('${count}-${s.id}',1)"/></div></td>
        <td nowrap><h4 align="center"><span id="size${count}-${s.id}">0份</span></h4> <input name="hsize${count}-${s.id}" id="hsize${count}-${s.id}" type="hidden" value="0"></td>
        <td nowrap><div align="left"><img src="images/minus.png" onClick="addNum('${count}-${s.id}',-1)"/></div></td>
         <td nowrap><div align="left"><span id="price${s.id}">NT.0</span></div></td>
      </tr>
	  <c:set var="i" value="${i+1}" />   
	  </c:forEach>
	  
      
      <tr>
        <td colspan="4" nowrap>
        <fieldset>
         <label for="sty1">沖洗樣式</label>
         
         
         <ww:select name="sty${count}"  id="sty${count}"
                list="stys"
                listKey="id"
                listValue="name"              
                />
         
        </fieldset>
        
        </td>
        </tr>
    </table>
    </td>
  </tr>
</table>       
</li> 

 <c:set var="count" value="${count+1}" />
</c:forEach>

  </ul>	

<input type="submit" value="確定沖洗" onClick="ck()"/>

</div>

</form>
    
    
<div data-role="footer">
 <h1>西北影像股份有限公司</h1>
</div>    

</div>


<script>
 var len=${fn:length(photos)};
 
 function ck(){ 
   //window.location="thanks.jsp";
 }
 
function addAllNum(id,n)
{	
	/*
	var per=10;
	alert('per='+);
	*/
	
	var num=parseInt($("#sizeall"+id).html()) + n;
	if(num<0){
		num=0;
	}
	$("#sizeall"+id).html(num+'份');	
	for(var i=1;i<=len;i++){	 
	 	$("#size"+i+'-'+id).html(num+'份');
    $("#hsize"+i+'-'+id).attr({"value":num});	   
	}	 
}

function addNum(id,n){
  var ls=id.split("-");
  var num=parseInt($("#size"+ls[0]+'-'+ls[1]).html()) + n;
  if(num<0){
    num=0;
  }  
  $("#size"+ls[0]+'-'+ls[1]).html(num+'份');
  $("#hsize"+ls[0]+'-'+ls[1]).attr({"value":num});	
}


function styChange(){ 
  var sty = $('select[name=styall]').val();
  for(var i=1;i<=len;i++){	
	    $('#sty'+i).val(sty).selectmenu('refresh');	  
   }   
}


function preview(){
	 for(var i=1;i<=len;i++){  
    $("#loading"+i).attr("src", "${ctx}/upload/thumbnail/${tempdir}/"+i+".jpg");
   }
}

function sleep(milliseconds) {
     var start = new Date().getTime();
      for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > milliseconds){
         break;
       }
     }
   }  
   
setTimeout("preview()",1000); 
   
</script>
    

</body>
</html>