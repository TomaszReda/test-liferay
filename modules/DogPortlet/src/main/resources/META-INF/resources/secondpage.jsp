<%@ include file="./init.jsp" %>

<portlet:renderURL var="mainPage">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="thirtyPage">
    <portlet:param name="mvcPath" value="/thirty.jsp"></portlet:param>
</portlet:renderURL>

<b>To jest druga strona</b>

<aui:button-row>
    <aui:button onClick="<%= mainPage %>" value="Cofnij"></aui:button>
</aui:button-row>

<aui:button-row>
    <aui:button onClick="<%= thirtyPage %>" value="klikni"></aui:button>
</aui:button-row>