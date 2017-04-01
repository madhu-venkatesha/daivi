package daivi;

import java.text.MessageFormat;

public class Advertisement {

	private static String assistPageFor(Section section) {
		return MessageFormat.format("{0}.adassist", section.name().toLowerCase());
	}

	public static PageToServe handleRequestToAdvertise(Section section) {
		return new PageToServe(assistPageFor(section));
	}

}
