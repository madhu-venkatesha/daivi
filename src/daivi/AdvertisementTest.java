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
	public void requestToAdvertiseNullSectionServesErrorPage() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise(null);
		PageToServe expectedPageToServe = new PageToServe("error.html");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
	@Test
	public void requestToAdvertiseEmptySectionServesErrorPage() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise("");
		PageToServe expectedPageToServe = new PageToServe("error.html");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
	@Test
	public void requestToAdvertiseBlankSectionServesErrorPage() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise("    ");
		PageToServe expectedPageToServe = new PageToServe("error.html");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
	@Test
	public void requestToAdvertiseInvalidSectionServesErrorPage() {
		PageToServe pageToServe = Advertisement.handleRequestToAdvertise("satSang");
		PageToServe expectedPageToServe = new PageToServe("error.html");
		assertEquals(expectedPageToServe, pageToServe);
	}
	
}
