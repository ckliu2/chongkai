

<form name="form1" action="saveAgreeTerms.do" method="post">
	
<table width="100%" border="0" align="left">
  <tr>
    <td align="left" valign="top"><IFRAME src="showAgreeTermsContent.jsp" width="780" height="300"  scrolling="yes" ></IFRAME></td>
  </tr>
  <tr>
    <td align="left" valign="top">   
      <input type="checkbox" name="result" value="yes" onClick="ck('checkbox');"/> 確認
      <input type="hidden" name="memberId" value="${memberId}"/>
  
   </td>
  </tr>
  <tr>
    <td> 
       <input type="submit" name="sbmt" value="送出" disabled /> 
     </td>
  </tr>
</table>

</form>


<script>
	
  function ck(op){  	
  	var v=form1.result.value;  	
  	if(op=='checkbox'){
  		var ck=form1.result.checked;
  		 if(ck==true){  		 	  
  		 	  document.all.sbmt.disabled=false;
  		  }else{  			  
  			  document.all.sbmt.disabled=true;
  	   	}
  	}	
  }

</script>
