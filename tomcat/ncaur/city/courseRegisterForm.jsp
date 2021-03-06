<%@ include file="/common/taglibs.jsp"%>

<ww:set name="downloadAuthority" value="%{getDownloadAuthority()}"/>
<ww:set name="registrAble" value="%{getRegistrAble()}"/>
<ww:set name="cancelAble" value="%{getCancelAble()}"/>



<ww:form name="courseForm" action="${registerUrl}" method="POST">
  <ww:hidden name="course.id" value="${course.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" >課程報名</td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
      
      <ww:if test="registrAble == true">
         <ww:if test="cancelAble == true">
           <input type="submit" value="取消報名"/>
         </ww:if>
         <ww:else> 
           <input type="submit" value="我要報名"/>
         </ww:else> 
      </ww:if>  
      <ww:else> 
           <input type="submit" value="截止報名" disabled/>
      </ww:else>   
      </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="course.no"/></td>
        <td class="cInputColumn">
            ${course.no}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="course.times"/></td>
        <td class="cInputColumn">
           ${course.times}
        </td>
    </tr>
    

    <tr><td class="cInputCaption"><fmt:message key="course.courseName"/></td>
        <td class="cInputColumn">
            ${course.courseName}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.teacher"/></td>
        <td class="cInputColumn">
            ${course.teacher}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.description"/></td>
        <td class="cInputColumn">
            ${course.description}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="course.registerBegin"/></td>
        <td class="cInputColumn">
            ${course.registerBegin}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.registerEnd"/></td>
        <td class="cInputColumn">
         ${course.registerEnd}
        </td>
    </tr>

    

    <tr><td class="cInputCaption"><fmt:message key="course.fee"/></td>
        <td class="cInputColumn">
         ${course.fee}
        </td>
    </tr>

    <ww:if test="downloadAuthority == true">
    <tr><td class="cInputCaption"><fmt:message key="course.file"/></td>
        <td class="cInputColumn">
          <a href="${ctx}/<fmt:message key="course.uploadFile.relativeUrl"/>/<ww:property value="course.id"/>/<ww:property value="course.file.fileName"/>"><ww:property value="course.file.fileName" /> (<ww:property value="course.file.size" /> bytes)</a><br>
        </td>
    </tr>
    </ww:if>
    
    
    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
         <span class="cLabel">
          <fmt:formatDate value="${course.lastModifiedDate}" pattern="yyyy-MM-dd HH:mm"/>
         </span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
  
      </td>
    </tr>
  </table>
</ww:form>



