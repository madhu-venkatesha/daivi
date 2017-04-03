package daivi.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.ui.Model;

import daivi.Advertisement;
import daivi.PageToServe;

public class AdvertisementControllerTest {

	@Test
	public void requestToAdvertiseSatsangServesPageToAssistIt() {
		Model model = mock(Model.class);
		String section = "satsang";
		String sectionAdassistPagename = "satsang.adassist";
		
		Advertisement advertisement = mock(Advertisement.class);
		PageToServe pageToServe = mock(PageToServe.class);
		when(pageToServe.getName()).thenReturn(sectionAdassistPagename);
		when(advertisement.handleRequestToAdvertise(section)).thenReturn(pageToServe);
		
		String viewName = new AdvertisementController(advertisement).handleRequestToAdvertise(section, model);

		assertEquals(sectionAdassistPagename, viewName);
		verifyZeroInteractions(model);
	}

}
