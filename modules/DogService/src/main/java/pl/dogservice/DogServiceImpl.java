package pl.dogservice;

import org.osgi.service.component.annotations.Component;

/**
 * @author mateusz
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = DogService.class
)
public class DogServiceImpl implements DogService {


	@Override
	public String woof() { return "WOOF WOOF";}

}