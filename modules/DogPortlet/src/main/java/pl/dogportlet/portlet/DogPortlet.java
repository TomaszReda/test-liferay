package pl.dogportlet.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import pl.dogportlet.config.IceCreamConfiguration;
import pl.dogportlet.constants.DogPortletKeys;

import javax.portlet.*;
import java.io.IOException;
import java.util.Map;

/**
 * @author mateusz
 */
@Component(
        immediate = true,
        configurationPid =
                "pl.dogportlet.config.IceCreamConfiguration",
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + DogPortletKeys.Dog,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DogPortlet extends MVCPortlet {

    @Reference
    protected pl.dogservice.DogService DogService;
    private volatile IceCreamConfiguration _exampleConfiguration;

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
            System.err.println(_exampleConfiguration.colorOfIceCream());
        DogService.woof();
        renderRequest.setAttribute("komunikat", DogService.woof());
        super.render(renderRequest, renderResponse);
    }

    public void action(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
        request.setAttribute("komunikat3", ParamUtil.getString(request, "name"));
    }

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {

        renderRequest.setAttribute(
                IceCreamConfiguration.class.getName(),
                _exampleConfiguration);

        super.doView(renderRequest, renderResponse);
    }

    public String getFavoriteColor(Map labels) {
        return (String) labels.get(_exampleConfiguration.colorOfIceCream());
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _exampleConfiguration = ConfigurableUtil.createConfigurable(
                IceCreamConfiguration.class, properties);
    }


}

