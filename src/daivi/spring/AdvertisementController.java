package daivi.spring;

import org.springframework.ui.Model;

import daivi.Advertisement;

public class AdvertisementController {

	private final Advertisement advertisement;

	public AdvertisementController(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public String handleRequestToAdvertise(String section, Model model) {
		return advertisement.handleRequestToAdvertise(section).getName();
	}

}
