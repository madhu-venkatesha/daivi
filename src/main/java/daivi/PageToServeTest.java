package daivi;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageToServeTest {

	@Test
	public void testEqualsObject() {
		assertEquals(new PageToServe("x.html"), new PageToServe("x.html"));
		assertNotEquals(new PageToServe("x.html"), new PageToServe("y.html"));
		assertNotEquals(new PageToServe("x.html"), null);
	}

	@Test
	public void testToString() {
		assertEquals("x.html", new PageToServe("x.html").toString());
	}
}
