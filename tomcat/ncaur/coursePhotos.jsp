<%@ include file="/common/unsecureTaglibs.jsp"%>

<!---dropzone -->
<script src="/ncaur/scripts/jquery-1.7.2.js"></script>
<link rel="stylesheet" type="text/css" href="/ncaur/css/dropzone.css">
<script src="/ncaur/scripts/dropzone.js"></script>
<script src="/ncaur/scripts/dropzone-amd-module.js"></script>
<link rel="stylesheet" type="text/css" href="/ncaur/engine3/style.css" />



<ww:set name="c" value="%{getCourseById(${course.id})}"/>  
  


<table width="100%" border="0">
  <tr>
    <td colspan="2">
    	<div align="center">
    		
    		<form class="dropzone" action="UploadServlet?courseId=${course.id}"  id="myAwesomeDropzone"></form>
     	</div>    </td>
  </tr>
  <tr>
    <td>
    	<div align="center">
    		
<!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
<div id="wowslider-container1">
	<div class="ws_images"><ul>
		
	
		<c:forEach var="w" items="${c.photos}">	
			
		<li><img src="upload/course/${c.id}/${w.fileName}" alt="${c.courseName}" title="${c.courseName}" id="wows3_0"/></li>
    </c:forEach>
    	
    	
	</ul></div>
	<div class="ws_thumbs">
<div>
	  
	<c:forEach var="w" items="${c.photos}">	
		   <a href="#" title="${c.courseName}"><img src="upload/course/${c.id}/${w.fileName}" alt=""  height="50"/></a>  </c:forEach>
	</div>
</div>

	<div class="ws_shadow"></div>
	</div>	
	<script type="text/javascript" src="/ncaur/engine3/wowslider.js"></script>
	<script type="text/javascript" src="/ncaur/engine3/script.js"></script>
	<!-- End WOWSlider.com BODY section -->
    	</div>    </td>
    <td align="left" valign="top"><div align="center">
      <table width="100" border="0">
        <tr>
          <td>刪除下列照片</td>
        </tr>
      
      <c:forEach var="w" items="${c.photos}">	  
        <tr>
          <td><a href="javascript:del(${w.id})"><img src="upload/course/${c.id}/${w.fileName}" width="100"></a></td>
        </tr>
      </c:forEach>
        
      </table>
    </div></td>
  </tr>
</table>


    
<script>
	
	 Dropzone.options.myAwesomeDropzone = {
   maxFiles: 10,
   maxFilesize: 512,
   acceptedFiles: ".jpg,.png,.gif",
   init: function () {  
   	
     this.on("queuecomplete", function (file) {
    	 Dropzone.forElement("#myAwesomeDropzone").removeAllFiles(true);
    	 window.location='coursePhotos.do?course.id=${c.id}';
    });
    
    
   
 }  
};


function del(id){
  
  if(confirm("您確定要刪除該照片?"))
  {
  	//alert('del id='+id);
  	
  	$.ajax({
        url: 'removeCoursePhotoJSON.do',
        type: "POST",        
        data: {"course.id":${c.id},"photo.id":id},  
        dataType: "json",
        success: function(data) {
           window.location="coursePhotos.do?course.id=${c.id}";       	
        	       	 
        }        
      });
      
  }

}

</script>	     