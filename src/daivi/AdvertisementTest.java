package daivi;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdvertisementTest {

	@Test
	public void requestToAdvertiseSatsangServesPageToAssistIt() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise(Section.SATSANG);
		PageToServe expectedPageToServe = new PageToServe("satsang.adassist");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
}
