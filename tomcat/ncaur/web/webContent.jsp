<%
String menuId=request.getParameter("menuId");
String subMenuId=request.getParameter("subMenuId");
String subItemId=request.getParameter("subItemId");
String memberId=request.getParameter("memberId");
%>





<%
  if(menuId!=null && subMenuId==null && subItemId==null){
%>
        ${topSubMenu.content}
<%      
  }  
%>


<%
if(subMenuId!=null && subItemId==null){
%>
        ${submenu.content}
<%
}
%>


<%
if(subItemId!=null && memberId!=null){
%>

        ${member.introduction} 
      
<%
}
%>


<%
if(subItemId!=null && memberId==null){
%>
        ${subitem.content}
<%
}
%>



