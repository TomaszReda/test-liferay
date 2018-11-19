<%@ include file="./init.jsp" %>

<p>
	<liferay-ui:message key="com_liferay_docs_exampleconfig_portlet_ExampleConfigPortlet.caption"/>
</p>

<%
	boolean noConfig = Validator.isNull(favoriteColor);
%>

<c:choose>
	<c:when test="<%= noConfig %>">
		<p>
			Please select use the portlet configuration to select a favorite color.
		</p>
	</c:when>

	<c:otherwise>
		<p style="color: <%= favoriteColor %>">
			Favorite color: <%= favoriteColor %>!
		</p>
	</c:otherwise>
</c:choose>