function AgreeTermsCheck() {
	
    var mymsg="<IFRAME src='showBulletinContent.jsp' width='550'/>"; 
	  var memberId = document.getElementById('bulletin').getAttribute('memberId');
    var URLs = "agreeTermsCheck.do?memberId="+memberId;
    //alert(URLs);    
    $.ajax({
    url: URLs,
    data: $('#sentToBack').serialize(),
    type: "POST",
    dataType: 'text',
    success: function (status) {    
    	//alert('status='+myTrim(status));	    	  
    	  if( myTrim(status) =='' ){
    
    	  	 $.messager.alert('個資同意說明',mymsg).window({  
              width:600
           }); 
           
           //saveAgreeTerm
           $.ajax({
           url: 'saveAgreeTerms.do?memberId='+memberId,
           data: $('#sentToBack').serialize(),
           type: "POST",
           dataType: 'text',
           success: function (status) {  
           	 alert('您已報名成功!');  
           }
          }); 
    	  }
      }
    });     
}

function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}




    

 
 