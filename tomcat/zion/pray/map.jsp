<!DOCTYPE html> 
<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>

<html>
    
    <head>
    <meta charset="utf-8">
    <meta name=”viewport” content=”width=device-width, initial-scale=1,user-scalable=no,,minimum-scale=1.0, maximum-scale=1.0〃>
    <title>${praytw.area.valueCh}</title>  
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="http://demos.jquerymobile.com/1.4.0/_assets/css/jqm-demos.css">
    <script src="http://demos.jquerymobile.com/1.4.0/js/jquery.js"></script>
    <script src="http://demos.jquerymobile.com/1.4.0/_assets/js/index.js"></script>
    <script src="http://demos.jquerymobile.com/1.4.0/js/jquery.mobile-1.4.0.min.js"></script>
    <script src="/zion/scripts/jquery.cookie.js"></script>
 </head>
  
<body> 
<div data-role="tabs">
  <div data-role="navbar" id="navbar_id">
    <ul>
      <li><a href="javascript:showMap();">地圖</a></li>
      <li><a href="javascript:areaInfoSite();">區域資料</a></li>      
      <li><a href="javascript:areaPrayerPage();">禱告事項</a></li> 
      <li><a href="javascript:areaSingupPage();">地區認領</a></li>
    </ul>
  </div>  

</div>

<iframe id="mobileIframe" src=""
        width="100%" height="100%" frameBorder="0" style="display:none">        
</iframe>

<div id="signup"align="center"> 
     <a href="javascript:claim(1);" data-role="button">我要認領 [ ${praytw.area.valueCh} ] 區域</a>
     <a href="javascript:claim(0);" data-role="button">取消 [ ${praytw.area.valueCh} ] 區域認領</a>
</div> 

<!-- Footer Improvement -->
<jsp:include page="../layout/footer.jsp"/>
<script>
   
    <ww:if test="praystreet != null">        
        <ww:if test="${fn:length(praystreet.longitude)} != 0   && ${fn:length(praystreet.latitude)} != 0"> 
          var url_loc= "&ll=${praystreet.latitude},${praystreet.longitude}&";          
        </ww:if>            
      </ww:if>
      <ww:else> 
     
      <ww:if test="${fn:length(praytw.longitude)} != 0   && ${fn:length(praytw.latitude)} != 0"> 
          var url_loc= "&ll=${praytw.latitude},${praytw.longitude}&";
      </ww:if>
      
	  </ww:else>   
   
    var currentItem = 0; 

    $(document).on("pagebeforecreate",function(event)
    {
      // alert("pagebeforecreate event fired!");
      // alert("Jeremy page loaded");
      setTimeout(InitPage, 500);
    });

    $(document).on("pagecreate",function(event) {
      $(window).on("orientationchange",function(event) {
        switch (currentItem)
        {
          case 0:
           // alert("currentItem: " + currentItem + "eventDegree:" +window.orientation);
           // window.location.reload();
           setTimeout(InitPage, 500);
           break;
           case 1:
             setTimeout(showMap, 500);
           break;
           case 2:
             setTimeout(areaInfoSite, 500);
           break;
           case 3:
             setTimeout(areaPrayerPage, 500);
           break;
	   case 4:
             setTimeout(areaSingupPage, 500);
           break;
         default:
          alert("No!!!!")
          return;
        }
     });                     
    });

    function areaInfoSite() {
      $('[id^=mymap]').hide();
      $('[id^=signup]').hide();
      var elem = document.getElementById('mobileIframe');
      elem.src = encodeURI("${praytw.descriptionUrl}");
      var pageHeight = ($(window).height() - document.body.clientHeight);
      elem.style.height =  pageHeight.toString() + 'px';
      elem.style.display = '';
      currentItem = 2; // area
    }
    
    function areaPrayerPage(/* will set by parameter */) {
      $('[id^=mymap]').hide();
      $('[id^=signup]').hide();
      var elem = document.getElementById('mobileIframe');
      elem.src = "areaprayers.do"; //////
      var pageHeight = ($(window).height() - document.body.clientHeight);
      elem.style.height =  pageHeight.toString() + 'px';
      elem.style.display = '';
      currentItem = 3; // areaPrayer
    }

    function areaSingupPage(/* will set by parameter */) {
      $('[id^=mymap]').hide();
      $('[id^=signup]').show();
      var elem = document.getElementById('mobileIframe');
      elem.src = "areasignup.do?praytw.id=${praytw.id}"; //////
      var divHeight = document.getElementById('signup').clientHeight + 20;
      var pageHeight = ($(window).height() - document.body.clientHeight - divHeight);
      elem.style.height =  pageHeight.toString() + 'px';
      elem.style.display = '';
      currentItem = 4; // areaSignup
    }
    
    function showMap() {
      $('[id^=signup]').hide();
      $('[id^=mymap]').hide();
      var elem = document.getElementById('mobileIframe');
      elem.style.display = 'none';
      var pageHeight = ($(window).height() - document.body.clientHeight);
      var url_prefix = "http://www.dr2ooo.com/tools/maps/maps.php?zoom=18";
      var url_width = "&width=" + $(window).width().toString(); 
      var url_height = "&height=" + pageHeight.toString();   
      elem.src= url_prefix + url_width + url_height + url_loc;
      elem.style.height =  pageHeight.toString() + 'px';
      elem.style.display = '';
      currentItem = 1; // map
    }

    function InitPage() {
      $('[id^=signup]').hide();
      var divHeight = document.getElementById('signup').clientHeight + 20; 
      var elem = document.getElementById('mobileIframe');
      var pageHeight = ($(window).height() - document.body.clientHeight - divHeight);
      var url_prefix = "http://www.dr2ooo.com/tools/maps/maps.php?zoom=18";
      var url_width = "&width=" + $(window).width().toString(); 
      var url_height = "&height=" + pageHeight.toString();
      elem.src= url_prefix + url_width + url_height + url_loc;
      elem.style.height =  pageHeight.toString() + 'px';      
      elem.style.display = '';
      currentItem = 0; // page
    }
  
    function claim(join) {
     var memberId=$.cookie('memberId');     
     var membername=$.cookie('membername'); 
     var u='userTWClaim.do?praytw.id=${praytw.id}&member.id='+memberId+'&join='+join;
     if (typeof(memberId) == "undefined")
     {
       alert('您尚未登入無法認領');
       window.location='index.do'; 
     }else{        
        $.ajax({
        url: u,
        type: "GET",
        dataType: "json",
        success: function(data) {
            var returnValue=data.returnValue;  
            var claim=data.claim;           
            if(returnValue=='success')  
            {
                 var op;
                 if(claim=='1'){
                   op='成功認領';
                 }else{
                     op='取消認領';
                 }               
                 var msg=membername+',你好:你已'+op+'${praytw.area.valueCh}';
                 alert(msg);    
                 
            }else{
                alert('認領失敗');  
            }                    
        }
      });
     } 
   }
    
  
    
</script>   



</body>
</html>
