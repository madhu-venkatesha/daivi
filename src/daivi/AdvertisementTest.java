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

	@RunWith(Enclosed.class)
	public static class RequestToAdvertiseASection {
		
		protected final String section;

		public RequestToAdvertiseASection(String section) {
			this.section = section;
		}
		
		@RunWith(Parameterized.class)
		public static class InvalidSectionServesErrorPage extends RequestToAdvertiseASection {
			
			@Parameters
			public static Iterable<Object[]> data() {
				return Arrays.asList(new Object[][] {
					{null},
					{""},
					{"    "},
					{"satSang"}
				});
			}
			
			public InvalidSectionServesErrorPage(String section) {
				super(section);
			}
			
			@Test
			public void requestToAdvertiseInvalidSectionServesErrorPage() {
				PageToServe pageToServe = Advertisement.handleRequestToAdvertise(section);
				PageToServe expectedPageToServe = new PageToServe("error.html");
				assertEquals(expectedPageToServe, pageToServe);
			}
		}
		
		@RunWith(Parameterized.class)
		public static class ValidSectionServesPageToAssistIt extends RequestToAdvertiseASection {
			
			@Parameters
			public static Iterable<Object[]> data() {
				return Arrays.asList(new Object[][] {
					{"satsang"}
				});
			}
			
			public ValidSectionServesPageToAssistIt(String section) {
				super(section);
			}
			
			@Test
			public void requestToAdvertiseInvalidSectionServesErrorPage() {
				PageToServe pageToServe = Advertisement.handleRequestToAdvertise(section);
				PageToServe expectedPageToServe = new PageToServe(MessageFormat.format("{0}.adassist", section));
				assertEquals(expectedPageToServe, pageToServe);
			}
		}
	}
	
}
