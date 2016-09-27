<%@ include file="/common/taglibs.jsp"%>

<ww:form name="courseOpenForm" action="saveCourseOpen" method="POST">
  <ww:hidden name="courseOpen.id" value="${courseOpen.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="courseOpen.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="courseOpen.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="courseOpen.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="courseOpen.week"/></td>
        <td class="cInputColumn">
            <ww:textfield name="courseOpen.week" value="%{courseOpen.week}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('courseOpen.week')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.startTime"/></td>
        <td class="cInputColumn">
            <ww:textfield name="courseOpen.startTime" value="%{courseOpen.startTime}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.endTime"/></td>
        <td class="cInputColumn">
            <ww:textfield name="courseOpen.endTime" value="%{courseOpen.endTime}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.active"/></td>
        <td class="cInputColumn">
            <ww:textfield name="courseOpen.active" value="%{courseOpen.active}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.node"/></td>
        <td class="cInputColumn">
            <ww:textfield name="courseOpen.node" value="%{courseOpen.node}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('courseOpen.node')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.reservation"/></td>
        <td class="cInputColumn">
            <ww:textfield name="courseOpen.reservation" value="%{courseOpen.reservation}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.course"/></td>
        <td class="cInputColumn">
            <ww:select name="courseOpen.courseId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="courseList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.teacher"/></td>
        <td class="cInputColumn">
            <ww:select name="courseOpen.teacherId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="teacherList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="courseOpen.classroom"/></td>
        <td class="cInputColumn">
            <ww:select name="courseOpen.classroomId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="classroomList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="courseOpen.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="courseOpen.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
