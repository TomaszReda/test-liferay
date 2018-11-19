package com.liferay.docs.exampleconfig.portlet.portlet;

import com.liferay.docs.exampleconfig.configuration.ExampleConfiguration;
import com.liferay.docs.exampleconfig.portlet.constants.ExampleConfigPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Map;


/**
 * @author tomasz
 */
@Component(
        configurationPid =
        "com.liferay.docs.exampleconfig.configuration.ExampleConfiguration",
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ExampleConfigPortletKeys.ExampleConfig,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ExampleConfigPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {

        renderRequest.setAttribute(
                ExampleConfiguration.class.getName(),
                _exampleConfiguration);

        super.doView(renderRequest, renderResponse);
    }

    public String getFavoriteColor(Map labels) {
        return (String) labels.get(_exampleConfiguration.favoriteColor());
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _exampleConfiguration = ConfigurableUtil.createConfigurable(
                ExampleConfiguration.class, properties);
    }

    private volatile ExampleConfiguration _exampleConfiguration;

}