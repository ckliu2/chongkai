<%@ include file="/common/unsecureTaglibs.jsp"%>
<!DOCTYPE html> 
<html> 
<head> 
  <meta charset="UTF-8">	
    <script src="scripts/jquery.js"></script>
    <!--file upload-->
    <link rel="stylesheet" type="text/css" href="css/dropzone.css">
    <script src="scripts/dropzone.js" charset="UTF-8"></script>
    <script src="scripts/dropzone-amd-module.js" charset="UTF-8"></script> 
    <script src="${ctx}/scripts/jquery.js"></script>
</head> 
<body>

 
     <form class="dropzone" method="post" action="UploadServlet"  id="myAwesomeDropzone">
     	
    	
    	
     
     	</form>

    	<p>
     <input type="button" id="filechooser" name="filechooser" value="Click me to select files...1"/>
 
     
    
     
<script>
	
Dropzone.options.myAwesomeDropzone = { 
	maxFilesize: 256,
  clickable: "#filechooser" ,  
  
  init: function () {
    this.on("queuecomplete", function (file) {
       //alert('All files have uploaded!!!!!!!!!'); 
       window.location='resizer.html';      
	     //window.location.href = "choose.jsp";     
    });    
    this.on("complete", function (file) {
     
      // alert('complete='+file.name);
    });
  }
  
};

var btn = document.all["filechooser"];  
btn.click(); 
    



//$("#filechooser").trigger("click");






</script>




</body>
</html>