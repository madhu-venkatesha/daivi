package daivi;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdvertisementTest {

	@Test
	public void requestToAdvertiseSatsangServesPageToAssistIt() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise("satsang");
		PageToServe expectedPageToServe = new PageToServe("satsang.adassist");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
	@Test
	public void requestToAdvertiseInvalidSectionServesErrorPage() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise(null);
		PageToServe expectedPageToServe = new PageToServe("error.msg");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
}
