<%@ include file="/common/taglibs.jsp"%>

    <ww:set name="groupsList" value="%{getBillAuthorityListByBill('${bill.id}')}"/> 

             <display:table name="groupsList" class="list" cellspacing="1" requestURI="" id="grouprow${bill.id}" export="false" pagesize="15" sort="list">
             <display:setProperty name="paging.banner.placement" value="bottom" />
                  <display:column property="group.groupNameEn" sortable="true" titleKey="bill.flow" style="text-align:left" />
                  <display:column property="complete" sortable="true" titleKey="bill.complete" style="text-align:left" />
                  <display:column property="uncomplete" sortable="true" titleKey="bill.uncomplete" style="text-align:left" />
             </display:table>             
