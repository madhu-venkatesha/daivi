package daivi;

import static org.junit.Assert.*;

import java.text.MessageFormat;
import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class AdvertisementTest {

	@RunWith(Parameterized.class)
	public static class RequestToAdvertiseInvalidSectionServesErrorPage {

		private final String section;

		@Parameters
		public static Iterable<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{null},
				{""},
				{"    "},
				{"satSang"}
			});
		}

		public RequestToAdvertiseInvalidSectionServesErrorPage(String section) {
			this.section = section;
		}
		
		@Test
		public void requestToAdvertiseInvalidSectionServesErrorPage() {
			PageToServe pageToServe = Advertisement.handleRequestToAdvertise(section);
			PageToServe expectedPageToServe = new PageToServe("error.html");
			assertEquals(expectedPageToServe, pageToServe);
		}
	}
	
	@RunWith(Parameterized.class)
	public static class RequestToAdvertiseASectionServesPageToAssistIt {
		
		private final String section;
		
		@Parameters
		public static Iterable<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{"satsang"}
			});
		}
		
		public RequestToAdvertiseASectionServesPageToAssistIt(String section) {
			this.section = section;
		}
		
		@Test
		public void requestToAdvertiseInvalidSectionServesErrorPage() {
			PageToServe pageToServe = Advertisement.handleRequestToAdvertise(section);
			PageToServe expectedPageToServe = new PageToServe(MessageFormat.format("{0}.adassist", section));
			assertEquals(expectedPageToServe, pageToServe);
		}
	}
	
}
