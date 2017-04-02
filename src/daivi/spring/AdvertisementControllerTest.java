package daivi.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.ui.Model;

public class AdvertisementControllerTest {

	@Test
	public void requestToAdvertiseSatsangServesPageToAssistIt() {
		Model model = mock(Model.class);
		
		String viewName = new AdvertisementController().handleRequestToAdvertise("satsang", model);

		assertEquals("satsang.adassist", viewName);
		verifyZeroInteractions(model);
	}

}
