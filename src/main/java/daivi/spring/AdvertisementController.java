package daivi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daivi.Advertisement;

@Controller
public class AdvertisementController {

	private final Advertisement advertisement;

	@Autowired
	public AdvertisementController(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	@RequestMapping("/advertise")
	public String handleRequestToAdvertise(@RequestParam(value="section") String section) {
		return advertisement.handleRequestToAdvertise(section).getName();
	}

}
