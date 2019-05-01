<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<%@ attribute name="path" required="false" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="items" required="true" type="java.util.List" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="lable" required="true" %>
<%@ attribute name="required" required="false" %>
<%@ attribute name="init" required="false" type="java.lang.Boolean" %>
  <c:choose>
    <c:when test="${ type eq 'combobox'}">
    	<li><label><spring:message code="${lable}"/>
    			<select class="select01" name="${name}" id="${name}">
				  <c:forEach items="${items}" var="item"><option value="${item.code}">${item.codeNm}</option></c:forEach>
			   </select></label>
		</li>
	</c:when>
   <c:otherwise>
    </c:otherwise>
  </c:choose>
