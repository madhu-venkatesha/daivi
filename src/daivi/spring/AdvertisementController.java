package daivi.spring;

import org.springframework.ui.Model;

import daivi.Advertisement;

public class AdvertisementController {

	public String handleRequestToAdvertise(String section, Model model) {
		return Advertisement.handleRequestToAdvertise(section).getName();
	}

}
