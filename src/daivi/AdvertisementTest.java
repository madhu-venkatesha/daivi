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
		
		private static final Advertisement ADVERTISEMENT = new Advertisement();
		protected final String section;

		protected RequestToAdvertiseASection(String section) {
			this.section = section;
		}
		
		@Test
		public void test() {
			assertEquals(expectedPageToServe(), ADVERTISEMENT.handleRequestToAdvertise(section));
		}
		
		protected PageToServe expectedPageToServe() {
			return null;
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
			
			@Override
			protected PageToServe expectedPageToServe() {
				return new PageToServe("error.html");
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
			
			@Override
			protected PageToServe expectedPageToServe() {
				return new PageToServe(MessageFormat.format("{0}.adassist", section));
			}
		}
	}
	
}
