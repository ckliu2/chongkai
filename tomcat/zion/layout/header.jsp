<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/webwork" prefix="ww" %>
<%@ page import="com.common.value.*;" %>


<%
WebSite website=(WebSite)session.getValue("website");
Menu menu=(Menu)session.getValue("menu");
SubMenu submenu=(SubMenu)session.getValue("submenu");
SubItem subitem=(SubItem)session.getValue("subitem");
out.print(menu);
%>
112



        
        
        
