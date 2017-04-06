package daivi.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import daivi.Advertisement;
import daivi.PageToServe;

public class AdvertisementControllerTest {

	@Test
	public void requestToAdvertiseSatsangServesPageToAssistIt() {
		String section = "satsang";
		String sectionAdassistPagename = "satsang.adassist";
		
		Advertisement advertisement = mock(Advertisement.class);
		PageToServe pageToServe = mock(PageToServe.class);
		when(pageToServe.getName()).thenReturn(sectionAdassistPagename);
		when(advertisement.handleRequestToAdvertise(section)).thenReturn(pageToServe);
		
		String viewName = new AdvertisementController(advertisement).handleRequestToAdvertise(section);

		assertEquals(sectionAdassistPagename, viewName);
	}

}
