
<%@ include file="./init.jsp" %>

<p>
    <b><liferay-ui:message key="dog.caption"/></b>
</p>
<b><%=request.getAttribute("komunikat")%>
</b>

<portlet:renderURL var="redirectUrl">
    <portlet:param name="mvcPath" value="/secondpage.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="action" var="addMessageUrl"></portlet:actionURL>

<aui:form action="<%= addMessageUrl %>">
    <aui:fieldset>
        <aui:input name="name"></aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>




<jsp:useBean id="komunikat3" class="java.lang.String" scope="request"/>
<b>
    cos
    <%= komunikat3 %>

</b>

<aui:button-row>
    <aui:button onClick="<%=redirectUrl%>" value="Druga strona"></aui:button>
</aui:button-row>





<%
    boolean noConfig = Validator.isNull(colorOfIceCream);
%>

<c:choose>
    <c:when test="<%= noConfig %>">
        <p>
            Please select use the portlet configuration to select a favorite color.
        </p>
    </c:when>

    <c:otherwise>
        <p style="color: <%= colorOfIceCream %>">
            Favorite color: <%= colorOfIceCream %>!
        </p>
    </c:otherwise>
</c:choose>
















