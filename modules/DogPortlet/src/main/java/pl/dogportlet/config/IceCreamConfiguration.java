package pl.dogportlet.config;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;

@ExtendedObjectClassDefinition(category = "productivity",scope =
        ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "pl.dogportlet.config.IceCreamConfiguration")
public interface IceCreamConfiguration {

    @Meta.AD(required = true
            , deflt = "blue")
    public String colorOfIceCream();

    @Meta.AD(
            deflt = "delicious",
            required = false
    )
    public String qualityOfIceCream();
}




