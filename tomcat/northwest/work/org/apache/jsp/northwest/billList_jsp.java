package org.apache.jsp.northwest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.fckeditor.*;
import javax.servlet.http.HttpSession;

public final class billList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/common/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fheaderValue_005fheaderKey_005fcssClass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005ftextfield_0026_005fvalue_005fname_005fcssClass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005fradio_0026_005fname_005flistValue_005flistKey_005flist_005fcssStyle_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005fsort_005fsize_005frequestURI_005fpartialList_005fpagesize_005fname_005fid_005fexport_005fclass_005fcellspacing;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005felse;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fheaderValue_005fheaderKey_005fcssClass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005ftextfield_0026_005fvalue_005fname_005fcssClass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005fradio_0026_005fname_005flistValue_005flistKey_005flist_005fcssStyle_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005fsort_005fsize_005frequestURI_005fpartialList_005fpagesize_005fname_005fid_005fexport_005fclass_005fcellspacing = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005felse = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fheaderValue_005fheaderKey_005fcssClass_005fnobody.release();
    _005fjspx_005ftagPool_005fww_005ftextfield_0026_005fvalue_005fname_005fcssClass_005fnobody.release();
    _005fjspx_005ftagPool_005fww_005fradio_0026_005fname_005flistValue_005flistKey_005flist_005fcssStyle_005fnobody.release();
    _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005fsort_005fsize_005frequestURI_005fpartialList_005fpagesize_005fname_005fid_005fexport_005fclass_005fcellspacing.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey.release();
    _005fjspx_005ftagPool_005fww_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fww_005felse.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Cache-control", "no-cache");
    response.setDateHeader("Expires", 0);

    response.setContentType("text/html;charset=UTF-8");

	com.common.util.Util.IMAGE_CONTEXT_ROOT_PATH = "/northwest";

	
//	java.io.File f = new java.io.File(request.getSession().getServletContext().getRealPath("/"));
//	String ff = f.getAbsolutePath();

   //System.out.println("........" + request.getSession().getServletContext().getServletContextName());     
   
      
    if (request.getSession().getAttribute("user") == null) 
    {
       // response.sendRedirect(com.common.util.Util.IMAGE_CONTEXT_ROOT_PATH );
    }

      out.write('\r');
      out.write('\n');

if (false) {

      out.write("\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("   // alert before session end\r\n");
      out.write("   var remainingseconds=");
      out.print( request.getSession().getMaxInactiveInterval());
      out.write(";\r\n");
      out.write("   var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/common/timeout.jsp\";\r\n");
      out.write("   var tid;\r\n");
      out.write("   var hWnd;\r\n");
      out.write("   var warn=0;\r\n");
      out.write("\r\n");
      out.write("   function timeoutcheck () {\r\n");
      out.write("      remainingseconds=remainingseconds-1;\r\n");
      out.write("      if (remainingseconds>0) {\r\n");
      out.write("         tid=setTimeout(\"timeoutcheck()\", 1*1000);\r\n");
      out.write("         if (remainingseconds<65) {\r\n");
      out.write("            if (remainingseconds>6) {\r\n");
      out.write("               window.defaultStatus=\"Session 時間 : 倒數 \"+ (remainingseconds-5) +\" 秒\";\r\n");
      out.write("            } else if (remainingseconds>=5) {\r\n");
      out.write("               window.defaultStatus=\"Session 時間 : 倒數 \"+ (remainingseconds-5) +\" 秒\";\r\n");
      out.write("            }\r\n");
      out.write("            if (!warn) {\r\n");
      out.write("               warn=1;\r\n");
      out.write("               \r\n");
      out.write("               hWnd = window.open(url,\"_timeoutwarning\",\"width=400,height=140,resizable=no,scrollbars=no\");\r\n");
      out.write("               hWnd.focus();\r\n");
      out.write("            }\r\n");
      out.write("         }\r\n");
      out.write("      } else {\r\n");
      out.write("         window.defaultStatus=\"Session 時間結束\";\r\n");
      out.write("         clearTimeout(tid);\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("   function sessioncheck () {\r\n");
      out.write("      if (remainingseconds>0) {\r\n");
      out.write("         return true;\r\n");
      out.write("      } else {\r\n");
      out.write("         alert(\"很抱歉, 您的作業階段已經逾時, 請重新登入\");\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("   timeoutcheck();\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
 
}

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\" cellspacing=\"1\" >\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td class=\"cContentTitle\" >");
      if (_jspx_meth_fmt_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr class=\"cActionButtonLine\">\r\n");
      out.write("        <td nowrap=\"nowrap\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form name=\"qform\"  method=\"post\" action=\"billList.html\">   \r\n");
      out.write("        \r\n");
      out.write("        <span class=\"cLabel2\">");
      if (_jspx_meth_fmt_005fmessage_005f2(_jspx_page_context))
        return;
      if (_jspx_meth_fmt_005fmessage_005f3(_jspx_page_context))
        return;
      out.write('/');
      if (_jspx_meth_fmt_005fmessage_005f4(_jspx_page_context))
        return;
      out.write(":</span>          \r\n");
      out.write("        \r\n");
      out.write("        <input type=\"input\" class=\"cInputTextFieldTiny\"\r\n");
      out.write("         oninput=\"queryKeyWord(this.value, 'allCustomer', 'findCustomer.html', 'keyword');\"\r\n");
      out.write("         onPropertyChange=\"queryKeyWord(this.value, 'allCustomer', 'findCustomer.html', 'keyword');\"\r\n");
      out.write("        /> \r\n");
      out.write("                   \r\n");
      out.write("                ");
      if (_jspx_meth_ww_005fselect_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        \r\n");
      out.write("         <span class=\"cLabel2\">");
      if (_jspx_meth_fmt_005fmessage_005f5(_jspx_page_context))
        return;
      if (_jspx_meth_fmt_005fmessage_005f6(_jspx_page_context))
        return;
      out.write(":</span>         \r\n");
      out.write("          ");
      if (_jspx_meth_ww_005ftextfield_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("         \r\n");
      out.write("         <br>\r\n");
      out.write("         \r\n");
      out.write("          <span class=\"cLabel2\">");
      if (_jspx_meth_fmt_005fmessage_005f7(_jspx_page_context))
        return;
      out.write(":</span>\r\n");
      out.write("          ");
      if (_jspx_meth_ww_005fradio_005f0(_jspx_page_context))
        return;
      out.write("           \r\n");
      out.write("          &nbsp;&nbsp;  \r\n");
      out.write("          <script type=\"text/javascript\" src=\"/northwest/webwork/jscalendar/calendar.js\"></script>\r\n");
      out.write("          <script type=\"text/javascript\" src=\"/northwest/webwork/jscalendar/lang/calendar-zh.js\"></script>\r\n");
      out.write("          <script type=\"text/javascript\" src=\"/northwest/webwork/jscalendar/calendar-setup.js\"></script>\r\n");
      out.write("          <input type=\"text\" name=\"startDate\" id=\"startDate\" class=\"cInputTextFieldTiny\" maxlength=\"8\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("          <a href=\"#\" id=\"startDate_button\"><img src=\"/northwest/webwork/jscalendar/img.gif\" width=\"16\" height=\"16\" border=\"0\" alt=\"Click Here to Pick up the date\"></a>\r\n");
      out.write("              <script type=\"text/javascript\">\r\n");
      out.write("               Calendar.setup({\r\n");
      out.write("               inputField     :    \"startDate\",\r\n");
      out.write("               ifFormat       :    \"%Y%m%d\",\r\n");
      out.write("               button         :    \"startDate_button\",\r\n");
      out.write("               step           :    1\r\n");
      out.write("              });\r\n");
      out.write("              </script>\r\n");
      out.write("\r\n");
      out.write("              ~\r\n");
      out.write("          <input type=\"text\" name=\"endDate\" id=\"endDate\" class=\"cInputTextFieldTiny\" maxlength=\"8\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${endDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("          <a href=\"#\" id=\"endDate_button\"><img src=\"/northwest/webwork/jscalendar/img.gif\" width=\"16\" height=\"16\" border=\"0\" alt=\"Click Here to Pick up the date\"></a>\r\n");
      out.write("          <script type=\"text/javascript\">\r\n");
      out.write("               Calendar.setup({\r\n");
      out.write("               inputField     :    \"endDate\",\r\n");
      out.write("               ifFormat       :    \"%Y%m%d\",\r\n");
      out.write("               button         :    \"endDate_button\",\r\n");
      out.write("               step           :    1\r\n");
      out.write("              });\r\n");
      out.write("          </script>\r\n");
      out.write("          \r\n");
      out.write("                  \r\n");
      out.write("          <input type=\"submit\" value=\"");
      if (_jspx_meth_fmt_005fmessage_005f8(_jspx_page_context))
        return;
      out.write("\" class=\"cButton\">\r\n");
      out.write("          \r\n");
      out.write("           &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("           \r\n");
      out.write("          <input type=\"button\" value=\"");
      if (_jspx_meth_fmt_005fmessage_005f9(_jspx_page_context))
        return;
      out.write("\" class=\"cButton\" onclick=\"javascript:exportExcel()\"/>\r\n");
      out.write("          \r\n");
      out.write("           &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("           \r\n");
      out.write("          <input type=\"button\" value=\"");
      if (_jspx_meth_fmt_005fmessage_005f10(_jspx_page_context))
        return;
      out.write("\" class=\"cButton\" onclick=\"javascript:exportExcel2()\"/>\r\n");
      out.write("           \r\n");
      out.write("        </form> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>  \r\n");
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_ww_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  display:table
      org.displaytag.tags.TableTag _jspx_th_display_005ftable_005f0 = (org.displaytag.tags.TableTag) _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005fsort_005fsize_005frequestURI_005fpartialList_005fpagesize_005fname_005fid_005fexport_005fclass_005fcellspacing.get(org.displaytag.tags.TableTag.class);
      try {
        _jspx_th_display_005ftable_005f0.setPageContext(_jspx_page_context);
        _jspx_th_display_005ftable_005f0.setParent(null);
        // /northwest/billList.jsp(90,0) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setName(new String("bills"));
        // /northwest/billList.jsp(90,0) name = class type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setClass("list");
        // /northwest/billList.jsp(90,0) name = cellspacing type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setCellspacing("1");
        // /northwest/billList.jsp(90,0) name = requestURI type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setRequestURI("billList.html");
        // /northwest/billList.jsp(90,0) name = id type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setUid("row");
        // /northwest/billList.jsp(90,0) name = export type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setExport(false);
        // /northwest/billList.jsp(90,0) name = pagesize type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setPagesize(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${GLOBAL_pagesize}", java.lang.Integer.class, (PageContext)_jspx_page_context, null, false)).intValue());
        // /northwest/billList.jsp(90,0) name = sort type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setSort("list");
        // /northwest/billList.jsp(90,0) name = partialList type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setPartialList(true);
        // /northwest/billList.jsp(90,0) name = size type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_display_005ftable_005f0.setSize((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${RESULT_SIZE}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
        int _jspx_eval_display_005ftable_005f0 = _jspx_th_display_005ftable_005f0.doStartTag();
        if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Object row = null;
          java.lang.Integer row_rowNum = null;
          if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_display_005ftable_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_display_005ftable_005f0.doInitBody();
          }
          row = (java.lang.Object) _jspx_page_context.findAttribute("row");
          row_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("row_rowNum");
          do {
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_ww_005fset_005f1(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f0(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write(" \r\n");
            out.write("    \r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f1(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f2(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f3(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f4(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("     ");
            if (_jspx_meth_display_005fcolumn_005f5(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f6(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("      \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f7(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("      \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f8(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f9(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f10(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f11(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f12(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write(" \r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f13(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("    \r\n");
            out.write("    \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f14(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("   \r\n");
            out.write("    ");
            if (_jspx_meth_display_005fcolumn_005f15(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write(" \r\n");
            out.write("\r\n");
            out.write("    ");
            if (_jspx_meth_c_005fset_005f3(_jspx_th_display_005ftable_005f0, _jspx_page_context))
              return;
            out.write('\r');
            out.write('\n');
            int evalDoAfterBody = _jspx_th_display_005ftable_005f0.doAfterBody();
            row = (java.lang.Object) _jspx_page_context.findAttribute("row");
            row_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("row_rowNum");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.popBody();
          }
        }
        if (_jspx_th_display_005ftable_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } finally {
        _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005fsort_005fsize_005frequestURI_005fpartialList_005fpagesize_005fname_005fid_005fexport_005fclass_005fcellspacing.reuse(_jspx_th_display_005ftable_005f0);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("      <tr class=\"cActionButtonLine\">\r\n");
      out.write("        <td>\r\n");
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<span class=\"cLabel\">\r\n");
      if (_jspx_meth_fmt_005fmessage_005f11(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</span>\r\n");
      out.write("\r\n");
      out.write("<form name=\"form1\" action=\"saveBill.html\">\r\n");
      out.write("    <input type=\"hidden\" name=\"delete\" value=\"yes\">\r\n");
      out.write("    <input type=\"hidden\" name=\"bill.id\" value=\"\">\r\n");
      out.write("    <select name=\"selectedBillIds\" multiple=\"true\" style=\"display:none\"></select>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write(" function showTable(id){\r\n");
      out.write("    document.getElementById(id).style.display = 'inline';\r\n");
      out.write("  }\r\n");
      out.write(" \r\n");
      out.write(" function hiddenTable(id){ \r\n");
      out.write("   \tdocument.getElementById(id).style.display = 'none';\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" function _display_obj(obj, status){\r\n");
      out.write("        if(obj.style.display!=status)\r\n");
      out.write("                obj.style.display=status;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" function Switch1(obj,id,j){\r\n");
      out.write("    _display_obj(obj, obj.style.display==\"none\"?\"\":\"none\");\r\n");
      out.write("\t\tshowBillFlow(id,j);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("  function showBillFlow(id,j){\r\n");
      out.write("    getMessage(id,'billFlow.html?bill.id='+j);\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("function exportExcel()\r\n");
      out.write(" { \t  \r\n");
      out.write(" \t  window.open('exportReport1.html?billNo='+qform.billNo.value); \r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" function exportExcel2()\r\n");
      out.write(" { \t  \r\n");
      out.write(" \t  window.open('exportReport2.html?billNo='+qform.billNo.value); \r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /common/taglibs.jsp(12,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("datePattern");
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_c_005fset_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_c_005fset_005f0.doInitBody();
        }
        do {
          if (_jspx_meth_fmt_005fmessage_005f0(_jspx_th_c_005fset_005f0, _jspx_page_context))
            return true;
          int evalDoAfterBody = _jspx_th_c_005fset_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fset_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fset_005f0);
      // /common/taglibs.jsp(12,25) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f0.setKey("date.format");
      int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    try {
      _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f1.setParent(null);
      // /common/taglibs.jsp(13,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setVar("ctx");
      // /common/taglibs.jsp(13,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
      int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
      if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f1.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f1.setParent(null);
      // /northwest/billList.jsp(5,35) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f1.setKey("bill.list");
      int _jspx_eval_fmt_005fmessage_005f1 = _jspx_th_fmt_005fmessage_005f1.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f2.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f2.setParent(null);
      // /northwest/billList.jsp(13,30) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f2.setKey("common.search");
      int _jspx_eval_fmt_005fmessage_005f2 = _jspx_th_fmt_005fmessage_005f2.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f3 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f3.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f3.setParent(null);
      // /northwest/billList.jsp(13,64) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f3.setKey("customer.name");
      int _jspx_eval_fmt_005fmessage_005f3 = _jspx_th_fmt_005fmessage_005f3.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f4 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f4.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f4.setParent(null);
      // /northwest/billList.jsp(13,99) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f4.setKey("common.id");
      int _jspx_eval_fmt_005fmessage_005f4 = _jspx_th_fmt_005fmessage_005f4.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fselect_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:select
    com.opensymphony.webwork.views.jsp.ui.SelectTag _jspx_th_ww_005fselect_005f0 = (com.opensymphony.webwork.views.jsp.ui.SelectTag) _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fheaderValue_005fheaderKey_005fcssClass_005fnobody.get(com.opensymphony.webwork.views.jsp.ui.SelectTag.class);
    try {
      _jspx_th_ww_005fselect_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fselect_005f0.setParent(null);
      // /northwest/billList.jsp(20,16) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setName("customerId");
      // /northwest/billList.jsp(20,16) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setId("allCustomer");
      // /northwest/billList.jsp(20,16) name = headerKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setHeaderKey("");
      // /northwest/billList.jsp(20,16) name = headerValue type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setHeaderValue("%{getText('common.pleaseSelect')+getText('customer.name')}...");
      // /northwest/billList.jsp(20,16) name = list type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setList("customerList");
      // /northwest/billList.jsp(20,16) name = listKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setListKey("id");
      // /northwest/billList.jsp(20,16) name = listValue type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setListValue("id+'-'+name");
      // /northwest/billList.jsp(20,16) name = cssClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setCssClass("cQueryFieldList");
      int _jspx_eval_ww_005fselect_005f0 = _jspx_th_ww_005fselect_005f0.doStartTag();
      if (_jspx_th_ww_005fselect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fheaderValue_005fheaderKey_005fcssClass_005fnobody.reuse(_jspx_th_ww_005fselect_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f5 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f5.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f5.setParent(null);
      // /northwest/billList.jsp(29,31) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f5.setKey("common.search");
      int _jspx_eval_fmt_005fmessage_005f5 = _jspx_th_fmt_005fmessage_005f5.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f6 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f6.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f6.setParent(null);
      // /northwest/billList.jsp(29,65) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f6.setKey("bill.id");
      int _jspx_eval_fmt_005fmessage_005f6 = _jspx_th_fmt_005fmessage_005f6.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f6);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005ftextfield_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:textfield
    com.opensymphony.webwork.views.jsp.ui.TextFieldTag _jspx_th_ww_005ftextfield_005f0 = (com.opensymphony.webwork.views.jsp.ui.TextFieldTag) _005fjspx_005ftagPool_005fww_005ftextfield_0026_005fvalue_005fname_005fcssClass_005fnobody.get(com.opensymphony.webwork.views.jsp.ui.TextFieldTag.class);
    try {
      _jspx_th_ww_005ftextfield_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005ftextfield_005f0.setParent(null);
      // /northwest/billList.jsp(30,10) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005ftextfield_005f0.setName("billNo");
      // /northwest/billList.jsp(30,10) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005ftextfield_005f0.setValue("%{billNo}");
      // /northwest/billList.jsp(30,10) name = cssClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005ftextfield_005f0.setCssClass("cInputTextFieldShort");
      int _jspx_eval_ww_005ftextfield_005f0 = _jspx_th_ww_005ftextfield_005f0.doStartTag();
      if (_jspx_th_ww_005ftextfield_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005ftextfield_0026_005fvalue_005fname_005fcssClass_005fnobody.reuse(_jspx_th_ww_005ftextfield_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f7 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f7.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f7.setParent(null);
      // /northwest/billList.jsp(34,32) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f7.setKey("bill.finish");
      int _jspx_eval_fmt_005fmessage_005f7 = _jspx_th_fmt_005fmessage_005f7.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f7);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fradio_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:radio
    com.opensymphony.webwork.views.jsp.ui.RadioTag _jspx_th_ww_005fradio_005f0 = (com.opensymphony.webwork.views.jsp.ui.RadioTag) _005fjspx_005ftagPool_005fww_005fradio_0026_005fname_005flistValue_005flistKey_005flist_005fcssStyle_005fnobody.get(com.opensymphony.webwork.views.jsp.ui.RadioTag.class);
    try {
      _jspx_th_ww_005fradio_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fradio_005f0.setParent(null);
      // /northwest/billList.jsp(35,10) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fradio_005f0.setName("state");
      // /northwest/billList.jsp(35,10) name = list type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fradio_005f0.setList("yesNoList");
      // /northwest/billList.jsp(35,10) name = listKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fradio_005f0.setListKey("id");
      // /northwest/billList.jsp(35,10) name = listValue type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fradio_005f0.setListValue("value");
      // /northwest/billList.jsp(35,10) name = cssStyle type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fradio_005f0.setCssStyle("border:0px;");
      int _jspx_eval_ww_005fradio_005f0 = _jspx_th_ww_005fradio_005f0.doStartTag();
      if (_jspx_th_ww_005fradio_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fradio_0026_005fname_005flistValue_005flistKey_005flist_005fcssStyle_005fnobody.reuse(_jspx_th_ww_005fradio_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f8 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f8.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f8.setParent(null);
      // /northwest/billList.jsp(69,38) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f8.setKey("common.search");
      int _jspx_eval_fmt_005fmessage_005f8 = _jspx_th_fmt_005fmessage_005f8.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f8);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f9 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f9.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f9.setParent(null);
      // /northwest/billList.jsp(73,38) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f9.setKey("report1");
      int _jspx_eval_fmt_005fmessage_005f9 = _jspx_th_fmt_005fmessage_005f9.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f9);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f10 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f10.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f10.setParent(null);
      // /northwest/billList.jsp(77,38) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f10.setKey("report2");
      int _jspx_eval_fmt_005fmessage_005f10 = _jspx_th_fmt_005fmessage_005f10.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f10);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    try {
      _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f2.setParent(null);
      // /northwest/billList.jsp(88,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setVar("count");
      // /northwest/billList.jsp(88,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setValue(new String("1"));
      int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
      if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:set
    com.opensymphony.webwork.views.jsp.SetTag _jspx_th_ww_005fset_005f0 = (com.opensymphony.webwork.views.jsp.SetTag) _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.get(com.opensymphony.webwork.views.jsp.SetTag.class);
    try {
      _jspx_th_ww_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fset_005f0.setParent(null);
      // /northwest/billList.jsp(89,0) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f0.setName("bills");
      // /northwest/billList.jsp(89,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f0.setValue("%{getBillList()}");
      int _jspx_eval_ww_005fset_005f0 = _jspx_th_ww_005fset_005f0.doStartTag();
      if (_jspx_th_ww_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_ww_005fset_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:set
    com.opensymphony.webwork.views.jsp.SetTag _jspx_th_ww_005fset_005f1 = (com.opensymphony.webwork.views.jsp.SetTag) _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.get(com.opensymphony.webwork.views.jsp.SetTag.class);
    try {
      _jspx_th_ww_005fset_005f1.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(92,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f1.setName("qas");
      // /northwest/billList.jsp(92,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f1.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("%{getBillQAList('${row.id}')}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      int _jspx_eval_ww_005fset_005f1 = _jspx_th_ww_005fset_005f1.doStartTag();
      if (_jspx_th_ww_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_ww_005fset_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f0 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f0.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(94,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f0.setTitleKey("common.id");
      // /northwest/billList.jsp(94,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f0.setStyle("width:5px");
      int _jspx_eval_display_005fcolumn_005f0 = _jspx_th_display_005fcolumn_005f0.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("      ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle.reuse(_jspx_th_display_005fcolumn_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f1 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f1.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(99,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f1.setTitle("photo");
      int _jspx_eval_display_005fcolumn_005f1 = _jspx_th_display_005fcolumn_005f1.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f1.doInitBody();
        }
        do {
          out.write("  \r\n");
          out.write("      <a href=\"http://192.168.1.222/?rpt=2&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         <img src=\"images/menu_photo.gif\" border=0>\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.reuse(_jspx_th_display_005fcolumn_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f2 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f2.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(105,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f2.setTitle("photo");
      int _jspx_eval_display_005fcolumn_005f2 = _jspx_th_display_005fcolumn_005f2.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f2.doInitBody();
        }
        do {
          out.write("  \r\n");
          out.write("      <a href=\"http://192.168.1.222/?rpt=3&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         <img src=\"images/form1.jpg\" border=0>\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.reuse(_jspx_th_display_005fcolumn_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f3 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f3.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(112,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f3.setTitle("photo");
      int _jspx_eval_display_005fcolumn_005f3 = _jspx_th_display_005fcolumn_005f3.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f3.doInitBody();
        }
        do {
          out.write("  \r\n");
          out.write("      <a href=\"http://192.168.1.222/?rpt=4&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         <img src=\"images/form2.jpg\" border=0>\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.reuse(_jspx_th_display_005fcolumn_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f4 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f4.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(119,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f4.setTitle("Barcode");
      int _jspx_eval_display_005fcolumn_005f4 = _jspx_th_display_005fcolumn_005f4.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f4.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("      <a href=\"http://192.168.1.222/?rpt=0&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         <img src=\"images/barcode.jpg\" border=0>\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.reuse(_jspx_th_display_005fcolumn_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f5 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f5.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(125,5) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f5.setTitle("Sticker");
      int _jspx_eval_display_005fcolumn_005f5 = _jspx_th_display_005fcolumn_005f5.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f5.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("      <a href=\"http://192.168.1.222/?rpt=6&billNo=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         Sticker\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.reuse(_jspx_th_display_005fcolumn_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f6 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f6.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(131,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f6.setTitle("sum");
      int _jspx_eval_display_005fcolumn_005f6 = _jspx_th_display_005fcolumn_005f6.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f6.doInitBody();
        }
        do {
          out.write("  \r\n");
          out.write("      <a href=\"http://192.168.1.222/?rpt=7&billno=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         <img src=\"images/sa.png\" border=0>\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle.reuse(_jspx_th_display_005fcolumn_005f6);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f7 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f7.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(138,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f7.setTitleKey("bill.id");
      // /northwest/billList.jsp(138,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f7.setSortable(true);
      // /northwest/billList.jsp(138,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f7.setStyle("width:5px");
      int _jspx_eval_display_005fcolumn_005f7 = _jspx_th_display_005fcolumn_005f7.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f7.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("      <a href=\"editBill.html?bill.id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f7.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable.reuse(_jspx_th_display_005fcolumn_005f7);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f8 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f8.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(141,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f8.setProperty("customer.name");
      // /northwest/billList.jsp(141,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f8.setSortable(true);
      // /northwest/billList.jsp(141,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f8.setTitleKey("customer.name");
      // /northwest/billList.jsp(141,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f8.setStyle("width:15%");
      int _jspx_eval_display_005fcolumn_005f8 = _jspx_th_display_005fcolumn_005f8.doStartTag();
      if (_jspx_th_display_005fcolumn_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f8);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f9 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f9.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(142,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f9.setProperty("customer.id");
      // /northwest/billList.jsp(142,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f9.setSortable(true);
      // /northwest/billList.jsp(142,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f9.setTitleKey("customer.id");
      // /northwest/billList.jsp(142,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f9.setStyle("width:5px");
      int _jspx_eval_display_005fcolumn_005f9 = _jspx_th_display_005fcolumn_005f9.doStartTag();
      if (_jspx_th_display_005fcolumn_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f9);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f10 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f10.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(143,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f10.setProperty("projectName");
      // /northwest/billList.jsp(143,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f10.setSortable(true);
      // /northwest/billList.jsp(143,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f10.setTitleKey("bill.projectName");
      // /northwest/billList.jsp(143,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f10.setStyle("width:50%");
      int _jspx_eval_display_005fcolumn_005f10 = _jspx_th_display_005fcolumn_005f10.doStartTag();
      if (_jspx_th_display_005fcolumn_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f10);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f11 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f11.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(144,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f11.setProperty("userDef2");
      // /northwest/billList.jsp(144,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f11.setSortable(true);
      // /northwest/billList.jsp(144,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f11.setTitleKey("bill.completeDate");
      // /northwest/billList.jsp(144,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f11.setStyle("width:5%");
      int _jspx_eval_display_005fcolumn_005f11 = _jspx_th_display_005fcolumn_005f11.doStartTag();
      if (_jspx_th_display_005fcolumn_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f11);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f12 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f12.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(145,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f12.setTitleKey("bill.flow");
      // /northwest/billList.jsp(145,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f12.setStyle("width:3px");
      int _jspx_eval_display_005fcolumn_005f12 = _jspx_th_display_005fcolumn_005f12.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f12.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f12.doInitBody();
        }
        do {
          out.write("    \r\n");
          out.write("      <span  onClick=\"Switch1(p");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(',');
          out.write('\'');
          out.write('p');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\"><img src=\"images/GridView.gif\" border=\"0\"></span>  \r\n");
          out.write("      <div id=\"p");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" style=\"display:none;\"></div>       \r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f12.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle.reuse(_jspx_th_display_005fcolumn_005f12);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f13 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f13.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(150,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f13.setProperty("remark");
      // /northwest/billList.jsp(150,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f13.setSortable(true);
      // /northwest/billList.jsp(150,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f13.setTitleKey("bill.remark");
      // /northwest/billList.jsp(150,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f13.setStyle("width:10%");
      int _jspx_eval_display_005fcolumn_005f13 = _jspx_th_display_005fcolumn_005f13.doStartTag();
      if (_jspx_th_display_005fcolumn_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey_005fstyle_005fsortable_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f13);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f14 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f14.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(153,4) name = titleKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f14.setTitleKey("bill.finish");
      int _jspx_eval_display_005fcolumn_005f14 = _jspx_th_display_005fcolumn_005f14.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f14 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f14.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f14.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("     ");
          if (_jspx_meth_ww_005fset_005f2(_jspx_th_display_005fcolumn_005f14, _jspx_page_context))
            return true;
          out.write(" \r\n");
          out.write("       ");
          if (_jspx_meth_ww_005fif_005f0(_jspx_th_display_005fcolumn_005f14, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("       ");
          if (_jspx_meth_ww_005felse_005f0(_jspx_th_display_005fcolumn_005f14, _jspx_page_context))
            return true;
          out.write("       \r\n");
          out.write("   ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f14.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f14 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitleKey.reuse(_jspx_th_display_005fcolumn_005f14);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fset_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f14, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:set
    com.opensymphony.webwork.views.jsp.SetTag _jspx_th_ww_005fset_005f2 = (com.opensymphony.webwork.views.jsp.SetTag) _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.get(com.opensymphony.webwork.views.jsp.SetTag.class);
    try {
      _jspx_th_ww_005fset_005f2.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fset_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f14);
      // /northwest/billList.jsp(154,5) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f2.setName("finish");
      // /northwest/billList.jsp(154,5) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f2.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("%{isBillFinish('${row.id}')}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      int _jspx_eval_ww_005fset_005f2 = _jspx_th_ww_005fset_005f2.doStartTag();
      if (_jspx_th_ww_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_ww_005fset_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f14, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:if
    com.opensymphony.webwork.views.jsp.IfTag _jspx_th_ww_005fif_005f0 = (com.opensymphony.webwork.views.jsp.IfTag) _005fjspx_005ftagPool_005fww_005fif_0026_005ftest.get(com.opensymphony.webwork.views.jsp.IfTag.class);
    try {
      _jspx_th_ww_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f14);
      // /northwest/billList.jsp(155,7) name = test type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fif_005f0.setTest((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${finish} == true", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      int _jspx_eval_ww_005fif_005f0 = _jspx_th_ww_005fif_005f0.doStartTag();
      if (_jspx_eval_ww_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_ww_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_ww_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_ww_005fif_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("          <img src=\"images/yes.gif\" border=\"0\">\r\n");
          out.write("       ");
          int evalDoAfterBody = _jspx_th_ww_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_ww_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_ww_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fif_0026_005ftest.reuse(_jspx_th_ww_005fif_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005felse_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f14, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:else
    com.opensymphony.webwork.views.jsp.ElseTag _jspx_th_ww_005felse_005f0 = (com.opensymphony.webwork.views.jsp.ElseTag) _005fjspx_005ftagPool_005fww_005felse.get(com.opensymphony.webwork.views.jsp.ElseTag.class);
    try {
      _jspx_th_ww_005felse_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005felse_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f14);
      int _jspx_eval_ww_005felse_005f0 = _jspx_th_ww_005felse_005f0.doStartTag();
      if (_jspx_eval_ww_005felse_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_ww_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_ww_005felse_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_ww_005felse_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("          <img src=\"images/no.gif\" border=\"0\">\r\n");
          out.write("       ");
          int evalDoAfterBody = _jspx_th_ww_005felse_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_ww_005felse_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_ww_005felse_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005felse.reuse(_jspx_th_ww_005felse_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f15 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable.get(org.displaytag.tags.ColumnTag.class);
    try {
      _jspx_th_display_005fcolumn_005f15.setPageContext(_jspx_page_context);
      _jspx_th_display_005fcolumn_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(163,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f15.setTitle("QA");
      // /northwest/billList.jsp(163,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f15.setSortable(true);
      // /northwest/billList.jsp(163,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005fcolumn_005f15.setStyle("width:5px");
      int _jspx_eval_display_005fcolumn_005f15 = _jspx_th_display_005fcolumn_005f15.doStartTag();
      if (_jspx_eval_display_005fcolumn_005f15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_display_005fcolumn_005f15 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005fcolumn_005f15.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005fcolumn_005f15.doInitBody();
        }
        do {
          out.write("  \r\n");
          out.write("    \t\r\n");
          out.write("    \t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(qas)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
          out.write(" 則 \r\n");
          out.write("       <a href=\"billQAList.html?bill.id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">\r\n");
          out.write("         <img src=\"images/qa.ico\" border=0>\r\n");
          out.write("      </a>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f15.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005fcolumn_005f15 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005fcolumn_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable.reuse(_jspx_th_display_005fcolumn_005f15);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    try {
      _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
      // /northwest/billList.jsp(171,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f3.setVar("count");
      // /northwest/billList.jsp(171,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${count+1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
      int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
      if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f11 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f11.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f11.setParent(null);
      // /northwest/billList.jsp(184,0) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f11.setKey("bill.memo1");
      int _jspx_eval_fmt_005fmessage_005f11 = _jspx_th_fmt_005fmessage_005f11.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f11);
    }
    return false;
  }
}
